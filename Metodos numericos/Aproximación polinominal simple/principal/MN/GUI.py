#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Wed Aug 30 00:43:06 2017

@author: paulo
"""

import tkinter as tk
import ttk
import tkMessageBox
from MN.Interpolacion import Interpolacion
import matplotlib
matplotlib.use("TkAgg")
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg, NavigationToolbar2TkAgg
from matplotlib.figure import Figure
from matplotlib import collections as mc
import sympy as sp
import numpy as np

class GUI(tk.Frame):
    """ Interfaz grafica de usuario """

    def __init__(self, parent=None):
        tk.Frame.__init__(self, parent)
        self.parent = parent
        self.graph = tk.Toplevel(self.parent)
        self.initComponent()
        self.initGraph()
        self.graph.withdraw()
        self.parent.mainloop()
        
        self.dato1 = [] # datos pares de ingreso
        self.dato2 = [] # datos pares de ingreso
        self.pares = 0;

    def initComponent(self):
        """ Componentes de la aplicación """
        self.parent.title("Aproximación polinominal simple e interpolación")
        self.parent.resizable(0, 0)
        self.parent.config(bg="white")
        self.renderingWindow(self.parent)
        
        # Opciones
        self.font = ('Verdana', 14)
        self.bg = "white"
        self.vcmd = (self.parent.register(self.validate),
                '%d', '%i', '%P', '%s', '%S', '%v', '%V', '%W')
        
        # Objetos
        lblInstruccion = tk.Label(self.parent, text="Datos pares a ingresar (2 - 10):",
                              anchor=tk.W, justify=tk.LEFT)
        lblInstruccion.place(x=10, y=10, width=400, height=20)
        lblInstruccion.config(font=self.font, bg=self.bg)
        
        self.txtPares = tk.Entry(self.parent, validate='key',
                                 validatecommand = self.vcmd)
        self.txtPares.place(x=410, y=10, width=100, height=20)
        self.txtPares.focus()
        
        self.btnPares = tk.Button(self.parent, text="Crear tabla",
                               command=lambda: self.crearPares())
        self.btnPares.place(x=520, y=10, width=150, height=20)
        self.btnPares.config(font=self.font)
        
    def crearPares(self):
        """
        Creamos la tabla para el ingreso de datos pares
        """
        grado = self.txtPares.get()
        
        # verificamos que todos los campos esten llenos
        if len(grado) != 0 :
            if int(grado) >= 2 and int(grado) <= 10 :
                width = 780 / (int(grado) + 1)
                dato1 = []
                dato2 = []
                
                # desactivamos el boton y campo de entrada
                self.txtPares.config(state="disabled")
                self.btnPares.config(state="disabled")
                
                # Campos por default
                btnReset = tk.Button(self.parent, text="Limpiar",
                               command=lambda: self.reset())
                btnReset.place(x=640, y=570, width=150, height=20)
                btnReset.config(font=self.font)
                
                lblTemp = tk.Label(self.parent, text="Punto",
                              anchor=tk.W, justify=tk.CENTER)
                lblTemp.place(x=10, y=40,
                              width=width, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                txtTemp1 = tk.Entry(self.parent)
                txtTemp1.place(
                        x=10, y=60, width=width, height=20)
                txtTemp1.focus()
                    
                txtTemp2 = tk.Entry(self.parent)
                txtTemp2.place(
                        x=10, y=80, width=width, height=20)
                
                dato1.append(txtTemp1)
                dato2.append(txtTemp2)
                
                for i in range(0, int(grado)):
                    # Etiqueta de puntos
                    lblTemp = tk.Label(self.parent, text=""+str(i),
                              anchor=tk.W, justify=tk.CENTER)
                    lblTemp.place(x=(10 + (width*(i+1))), y=40,
                                  width=width, height=20)
                    lblTemp.config(font=self.font, bg=self.bg)
                    
                    # datos 1
                    txtTemp1 = tk.Entry(self.parent, validate='key',
                                 validatecommand = self.vcmd)
                    txtTemp1.place(x=(10 + (width*(i+1))), y=60,
                                         width=width, height=20)
                    
                    # datos 2
                    txtTemp2 = tk.Entry(self.parent, validate='key',
                                 validatecommand = self.vcmd)
                    txtTemp2.place(x=(10 + (width*(i+1))), y=80,
                                         width=width, height=20)
                    
                    dato1.append(txtTemp1)
                    dato2.append(txtTemp2)
                #guardamos los datos
                self.dato1 = dato1
                self.dato2 = dato2
                    
                # Preguntamos el grado de la ecución
                lblTemp = tk.Label(self.parent, text="Seleccione el grado de la ecuación para la solución: ",
                              anchor=tk.W, justify=tk.CENTER)
                lblTemp.place(x=10, y=110, width=700, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                self.comboGrado = ttk.Combobox(self.parent , state="readonly")
                self.comboGrado.place(x=10, y=140, width=200, height=20)
                self.comboGrado["values"] = range(1, int(grado))
                self.comboGrado.bind("<<ComboboxSelected>>", self.selection_changed)
            else:
                # Mensaje de error
                text = "Ingrese un número entre 2 y 10."
                tkMessageBox.showerror(title="Error", message=text)
        else:
            # Mensaje de error
            text = "Por favor ingrese la cantidad de datos pares"
            tkMessageBox.showerror(title="Error", message=text)
            
    def selection_changed(self, event):
        """
        Funcion lanzada cuando se selecciona un item del combobox de grado
        """
        
        grado = int(self.comboGrado.get()) # Obtenemos el grado
        pares = int(self.txtPares.get())
        
        # Preguntamos desde que dato par trabajar
        lblTemp = tk.Label(self.parent, text="Seleccione desde que dato par trabajar: ",
                      anchor=tk.W, justify=tk.CENTER)
        lblTemp.place(x=10, y=170, width=700, height=20)
        lblTemp.config(font=self.font, bg=self.bg)
        
        self.comboPar = ttk.Combobox(self.parent , state="readonly")
        self.comboPar.place(x=10, y=200, width=200, height=20)
        self.comboPar["values"] = range(0, pares - grado)
        self.comboPar.bind("<<ComboboxSelected>>", self.selection_changed_par)
        
    def selection_changed_par(self, event):
        """
        Funcion lanzada cuando se selecciona un item del combobox de pares
        """
        
        btnCalcular = tk.Button(self.parent, text="Procesar",
                               command=lambda: self.process())
        btnCalcular.place(x=10, y=230, width=150, height=20)
        btnCalcular.config(font=self.font)
        
    def process(self):
        """
        Procesamos los datos de la tabla
        """
        
        # verificamos que todos los campos esten llenos
        if self.isEmpty() :
            # Mensaje de error
            text = "Por favor llene todos los campos"
            tkMessageBox.showerror(title="Error", message=text)
        else :
            # Inicializamos
            inter = Interpolacion(self.dato1, self.dato2,
                                  self.comboGrado.get(), self.comboPar.get())
            # Creamos las matrices para procesar
            #if inter.crammer() :
            if inter.createMatrix() :
                grado = self.comboGrado.get()
                width = 780 / (int(grado) + 1)
                
                # Obtenemos la expresión
                #expr = inter.createExprCrammer()
                expr = inter.createExpr()
                
                # creamos una etiqutea
                lblExpr = tk.Label(self.parent, text="Ecuación formada: ",
                      anchor=tk.W, justify=tk.CENTER)
                lblExpr.place(x=10, y=260, width=700, height=20)
                lblExpr.config(font=self.font, bg=self.bg)
                
                # Mostramos los datos de a0, a1,.., an                
                for i in range(0, int(grado) + 1):
                    # Etiqueta de puntos
                    lblTemp = tk.Label(self.parent, text="a"+str(i),
                              anchor=tk.W, justify=tk.CENTER)
                    lblTemp.place(x=(10 + (width*i)), y=290,
                                  width=width, height=20)
                    lblTemp.config(font=self.font, bg=self.bg)
                    
                    # datos
                    v = tk.StringVar(self.parent, value=""+str(sp.Float(inter.values[i], 4)))
                    txtTemp = tk.Entry(self.parent, textvariable=v)
                    txtTemp.place(x=(10 + (width*i)), y=310,
                                         width=width, height=20)
                    txtTemp.config(font=self.font, bg=self.bg)
                    txtTemp.config(state="disabled")
                
                # Mostramos la expresión
                areaExpr = tk.Text(self.parent)
                areaExpr.place(
                        x=10, y=340, width=780, height=60)
                areaExpr.insert(tk.END, expr)
                areaExpr.config(font=self.font, bg=self.bg)
                areaExpr.config(state="disabled")
                
                # Mostramos mensaje para resolver
                lblEc = tk.Label(self.parent, text="Encontrar datos a partir de la ecuación: ",
                      anchor=tk.W, justify=tk.CENTER)
                lblEc.place(x=10, y=410, width=700, height=20)
                lblEc.config(font=self.font, bg=self.bg)
                
                lblTipo = tk.Label(self.parent, text="Ingrese el dato: ",
                      anchor=tk.W, justify=tk.CENTER)
                lblTipo.place(x=10, y=440, width=290, height=20)
                lblTipo.config(font=self.font, bg=self.bg)
                
                self.txtDato = tk.Entry(self.parent)
                self.txtDato.place(x=300, y=440, width=100, height=20)
                self.txtDato.config(font=self.font, bg=self.bg)
                
                btnEc = tk.Button(self.parent, text="Calcular",
                               command=lambda: self.calcular(inter))
                btnEc.place(x=410, y=440, width=180, height=20)
                btnEc.config(font=self.font)
                
                # mostramos graficar
                lblGraph = tk.Label(self.parent, text="Puede graficar las ecuaciones: ",
                      anchor=tk.W, justify=tk.CENTER)
                lblGraph.place(x=10, y=470, width=700, height=20)
                lblGraph.config(font=self.font, bg=self.bg)
                
                btnGraph = tk.Button(self.parent, text="Graficar",
                               command=lambda: self.graficar(inter))
                btnGraph.place(x=10, y=500, width=200, height=20)
                btnGraph.config(font=self.font)
            else :
                # Mensaje de error
                text = "El sistema de ecuaciones no tiene solución"
                tkMessageBox.showerror(title="Error", message=text)
                
    def calcular(self, inter):
        """
        Calculamos un dato a partir de la ecuacion dada
        """
        
        dato = self.txtDato.get()
        
        # comprobamos que esten llenos los campos
        if len(dato) > 0:
            val = inter.f(inter.ec, sp.Float(dato))
            
            text = "El dato calculado es:\n\n"
            text += str(val)
            
            tkMessageBox.showinfo(title="Dato calculado", message=text)
        else :
            # Mensaje de error
            text = "Ingrese el dato a calcular"
            tkMessageBox.showerror(title="Error", message=text)
        
    def isEmpty(self):
        """
        Verificamos que esten todos los campos llenos
        """
        
        pares = int(self.txtPares.get()) + 1
        
        for i in range(0, pares):
            if len(self.dato1[i].get()) == 0 :
                return True
            
        
        for i in range(0, pares):
            if len(self.dato2[i].get()) == 0 :
                return True
            
        
        return False
        
    def reset(self):
        """
        Reseteamos el layout principal
        """
        
        # destruimos todos los componentes
        for widget in self.parent.winfo_children():
            widget.destroy()
            
        # creamos los componentes
        lblInstruccion = tk.Label(self.parent, text="Datos pares a ingresar (2 - 10):",
                              anchor=tk.W, justify=tk.LEFT)
        lblInstruccion.place(x=10, y=10, width=400, height=20)
        lblInstruccion.config(font=self.font, bg=self.bg)
        
        self.txtPares = tk.Entry(self.parent, validate='key',
                                 validatecommand = self.vcmd)
        self.txtPares.place(x=410, y=10, width=100, height=20)
        self.txtPares.focus()
        
        self.btnPares = tk.Button(self.parent, text="Crear tabla",
                               command=lambda: self.crearPares())
        self.btnPares.place(x=520, y=10, width=150, height=20)
        self.btnPares.config(font=self.font)
        
    def initGraph(self):
        """ Componentes de la aplicación """
        self.graph.title("Grafica")
        self.graph.resizable(0, 0)
        self.graph.config(bg="white")
        self.renderingWindow(self.graph)
        #self.graph.focus_set() # Focus
        self.graph.protocol("WM_DELETE_WINDOW", "onexit") # quitamos cerrar
        
    def renderingWindow(self, frame):
        """ Le da tamaño a la ventana y la centra en pantall """
        w = 800
        h = 600
        ws = self.parent.winfo_screenwidth()
        hs = self.parent.winfo_screenheight()
        x = (ws/2) - (w/2)
        y = (hs/2) - (h/2)
        frame.geometry('%dx%d+%d+%d' % (w, h, x, y))
            
    def validate(self, action, index, value_if_allowed,
                       prior_value, text, validation_type, trigger_type, widget_name):
        if action == "1":
            if text in '0123456789.\-\+':
                try:
                    float(value_if_allowed)
                    return True
                except ValueError:
                    return False
            else:
                return False
        else:
            return True
        
    def graficar(self, inter):
        """
        Graficamos la funcion con ayuda de matplotlib
        """
        
        # Limpiamos la ventana
        for widget in self.graph.winfo_children():
            widget.destroy()

        self.graph.deiconify()
        
        f = Figure(figsize=(5,5), dpi=100)
        a = f.add_subplot(111)
        # Valores del eje X que toma el gráfico.
        _x = range(-100, 100)
        # Graficar ambas funciones
        count = 0
        for ec in inter.ecuaciones :
            a.plot(_x, [inter.f(ec, i) for i in _x], label=str('f(x)='+inter.ecuacionesRed[count]))
            count += 1
        # graficamos la linea de tendencia np.finfo(float).eps
        #print str(inter.ec) +"+"+ str(np.finfo(float).eps)
        #a.plot(_x, [inter.f(str(inter.ec) +"+"+ str(np.finfo(float).eps), i) for i in _x], label='Tendencia')
        # Graficamos los puntos
        lines = []
        for i in range(1, len(self.dato1)) :
            a.scatter(self.dato2[i].get(), self.dato1[i].get(), marker='o')
            p = [(self.dato2[i].get(), self.dato1[i].get()),
                 (self.dato2[i].get(), 0)]
            lines.append(p)
            p = [(self.dato2[i].get(), self.dato1[i].get()),
                 (0, self.dato1[i].get())]
            lines.append(p)

        lc = mc.LineCollection(lines, colors='red', linewidths=1,
                               linestyle='dotted')
        a.add_collection(lc)
        # Colocamos las legendas
        a.legend(loc="upper left")
        # Establecer el color de los ejes.
        a.axhline(0, color="black")
        a.axvline(0, color="black")
        # Limitar los valores de los ejes.
        a.set_xlim(-10, 10)
        a.set_ylim(-50, 50)
        # Etiquetas de los ejes
        a.set_xlabel('X')
        a.set_ylabel('Y')
        a.set_title('Graficacion de funciones')
        a.grid(True)

        canvas = FigureCanvasTkAgg(f, self.graph)
        canvas.show()
        canvas.get_tk_widget().pack(side=tk.TOP, fill=tk.X,
                            expand=True)

        btnClose = tk.Button(self.graph, text="Cerrar",
                        command=lambda: self.close())
        btnClose.config(font=self.font)
        btnClose.pack(side=tk.BOTTOM, fill=tk.X)

        toolbar = NavigationToolbar2TkAgg(canvas, self.graph)
        toolbar.update()
        canvas._tkcanvas.pack(side=tk.TOP)

            
    def close(self):
        self.graph.withdraw();