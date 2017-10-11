#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Wed Aug 30 00:43:06 2017

@author: paulo
"""

import tkinter as tk
import ttk
import tkMessageBox
from MN.NewtonCotesPares import NewtonCotesPares
from MN.NewtonCotesEcuacion import NewtonCotesEcuacion
import matplotlib
matplotlib.use("TkAgg")
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg, NavigationToolbar2TkAgg
from matplotlib.figure import Figure
from matplotlib import collections as mc
import sympy as sp

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
        self.parent.title("Metodos de Newton-Cotes")
        self.parent.resizable(0, 0)
        self.parent.config(bg="white")
        self.renderingWindow(self.parent)
        
        # Opciones
        self.font = ('Verdana', 14)
        self.bg = "white"
        self.vcmd = (self.parent.register(self.validate),
                '%d', '%i', '%P', '%s', '%S', '%v', '%V', '%W')
        
        # Objetos
        lblEcuacion = tk.Label(self.parent, text="(Para trabajar con una ecuación ingrese 0)",
                              anchor=tk.W, justify=tk.LEFT)
        lblEcuacion.place(x=10, y=10, width=700, height=20)
        lblEcuacion.config(font=self.font, bg=self.bg)
        
        lblInstruccion = tk.Label(self.parent, text="Datos pares a ingresar (2 - 10):",
                              anchor=tk.W, justify=tk.LEFT)
        lblInstruccion.place(x=10, y=40, width=400, height=20)
        lblInstruccion.config(font=self.font, bg=self.bg)
        
        self.txtPares = tk.Entry(self.parent, validate='key',
                                 validatecommand = self.vcmd)
        self.txtPares.place(x=410, y=40, width=100, height=20)
        self.txtPares.focus()
        
        self.btnPares = tk.Button(self.parent, text="Crear tabla",
                               command=lambda: self.crearPares())
        self.btnPares.place(x=520, y=40, width=150, height=20)
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
                
                lblTemp = tk.Label(self.parent, text="Puntos",
                              anchor=tk.W, justify=tk.CENTER)
                lblTemp.place(x=10, y=10,
                              width=width, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                txtTemp1 = tk.Entry(self.parent)
                txtTemp1.place(
                        x=10, y=30, width=width, height=20)
                txtTemp1.focus()
                    
                txtTemp2 = tk.Entry(self.parent)
                txtTemp2.place(
                        x=10, y=50, width=width, height=20)
                
                dato1.append(txtTemp1)
                dato2.append(txtTemp2)
                
                for i in range(0, int(grado)):
                    # Etiqueta de puntos
                    lblTemp = tk.Label(self.parent, text=""+str(i),
                              anchor=tk.W, justify=tk.CENTER)
                    lblTemp.place(x=(10 + (width*(i+1))), y=10,
                                  width=width, height=20)
                    lblTemp.config(font=self.font, bg=self.bg)
                    
                    # datos 1
                    txtTemp1 = tk.Entry(self.parent)
                    txtTemp1.place(x=(10 + (width*(i+1))), y=30,
                                         width=width, height=20)
                    
                    # datos 2
                    txtTemp2 = tk.Entry(self.parent)
                    txtTemp2.place(x=(10 + (width*(i+1))), y=50,
                                         width=width, height=20)
                    
                    dato1.append(txtTemp1)
                    dato2.append(txtTemp2)
                #guardamos los datos
                self.dato1 = dato1
                self.dato2 = dato2
                
                # Seleccion del intervalo
                lblTemp = tk.Label(self.parent, text="Intervalo inicial:",
                              anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=80, width=240, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                self.comboInicial = ttk.Combobox(self.parent , state="readonly")
                self.comboInicial.place(x=260, y=80, width=100, height=20)
                self.comboInicial["values"] = range(0, int(grado) - 1)
                self.comboInicial.bind("<<ComboboxSelected>>", self.selection_changed)
            elif int(grado) == 0 :
                lblTemp = tk.Label(self.parent, text="Ingrese la ecuación:",
                              anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=10, width=280, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
        
                self.txtEcuacion = tk.Entry(self.parent)
                self.txtEcuacion.place(x=290, y=10, width=380, height=20)
                self.txtEcuacion.focus()
                
                lblTemp = tk.Label(self.parent, text="Intervalo: [",
                              anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=40, width=160, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                self.txtIntInf = tk.Entry(self.parent)
                self.txtIntInf.place(x=170, y=40, width=50, height=20)
                
                lblTemp = tk.Label(self.parent, text=",",
                              anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=220, y=40, width=20, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                self.txtIntSup = tk.Entry(self.parent)
                self.txtIntSup.place(x=240, y=40, width=50, height=20)
                
                lblTemp = tk.Label(self.parent, text="]",
                              anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=290, y=40, width=230, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                btnCalcular = tk.Button(self.parent, text="Procesar",
                               command=lambda: self.processEcuacion())
                btnCalcular.place(x=520, y=40, width=150, height=20)
                btnCalcular.config(font=self.font)
                
                btnReset = tk.Button(self.parent, text="Limpiar",
                               command=lambda: self.reset())
                btnReset.place(x=640, y=570, width=150, height=20)
                btnReset.config(font=self.font)
            else :
                # Mensaje de error
                text = "Ingrese un número entre 2 y 10."
                tkMessageBox.showerror(title="Error", message=text)
        else:
            # Mensaje de error
            text = "Por favor ingrese la cantidad de datos pares"
            tkMessageBox.showerror(title="Error", message=text)


    def selection_changed(self, event):
        """
        Cambio al seleccionar en el combo box de intervalo inicial
        """
        
        grado = self.txtPares.get()
        value = self.comboInicial.get()
        
        # Seleccion del intervalo
        lblTemp = tk.Label(self.parent, text="Intervalo final:",
                      anchor=tk.W, justify=tk.LEFT)
        lblTemp.place(x=370, y=80, width=240, height=20)
        lblTemp.config(font=self.font, bg=self.bg)
        
        self.comboFinal = ttk.Combobox(self.parent , state="readonly")
        self.comboFinal.place(x=610, y=80, width=100, height=20)
        self.comboFinal["values"] = range(int(value) + 1, int(grado))
        self.comboFinal.bind("<<ComboboxSelected>>", self.selection_changed_par)
        
        
    def selection_changed_par(self, event):
        """
        Funcion lanzada cuando se selecciona un item del combobox de I.Final
        """
        
        btnCalcular = tk.Button(self.parent, text="Procesar",
                               command=lambda: self.processPuntos())
        btnCalcular.place(x=10, y=110, width=150, height=20)
        btnCalcular.config(font=self.font)
        
        
    def selection_changed_n(self, event):
        """
        Funcion lanzada cuando se selecciona un item del combobox de n
        """
        
        btnCalcular = tk.Button(self.parent, text="Calcular",
                               command=lambda: self.processNPares())
        btnCalcular.place(x=10, y=330, width=150, height=20)
        btnCalcular.config(font=self.font)
        
        
    def selection_changed_n_ec(self, event):
        """
        Funcion lanzada cuando se selecciona un item del combobox de n
        """
        
        btnCalcular = tk.Button(self.parent, text="Calcular",
                               command=lambda: self.processNEcuacion())
        btnCalcular.place(x=10, y=340, width=150, height=20)
        btnCalcular.config(font=self.font)
            
        
    def processPuntos(self):
        """
        Procesamos los datos de la tabla
        """
        
        # verificamos que todos los campos esten llenos
        if self.isEmpty() :
            # Mensaje de error
            text = "Por favor llene todos los campos"
            tkMessageBox.showerror(title="Error", message=text)
        else :
            inicial = self.comboInicial.get()
            final = self.comboFinal.get()
            pares = self.txtPares.get()
            dato1 = self.dato1
            dato2 = self.dato2
            
            if len(inicial) > 0 and len(final) > 0 :
                # Inicializamos un objeto
                nc = NewtonCotesPares(dato1, dato2, pares, inicial, final)
                
                # Obtenemos los primeros resultados
                nc.process()
                
                # Obtenemos la cadena
                result = nc.res
                result += "\n" + nc.resCompuesta
                
                # Mostramos los resultados
                areaExpr = tk.Text(self.parent)
                areaExpr.place(
                        x=10, y=140, width=780, height=120)
                areaExpr.insert(tk.END, result)
                areaExpr.config(font=self.font, bg=self.bg)
                areaExpr.config(state="disabled")
                
                # Procesamos n segmentos
                lblTemp = tk.Label(self.parent, text="Seleccione el numero de segmentos para trabajar:",
                              anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=270, width=780, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                self.comboN = ttk.Combobox(self.parent , state="readonly")
                self.comboN.place(x=10, y=300, width=100, height=20)
                self.comboN["values"] = range(4, 11)
                self.comboN.bind("<<ComboboxSelected>>", self.selection_changed_n)
            else :
                # Mensaje de error
                text = "Seleccione el intervalo"
                tkMessageBox.showerror(title="Error", message=text)
                
                
    def processNPares(self): 
        """
        Procesamos para N segmentos - metodo de simpson 3/8
        """
        
        # Obtenemos N pares
        n = int(self.comboN.get())
        
        # Obtenemos el resultado
        inicial = self.comboInicial.get()
        final = self.comboFinal.get()
        pares = self.txtPares.get()
        dato1 = self.dato1
        dato2 = self.dato2
        
        if len(inicial) > 0 and len(final) > 0 :
            # Inicializamos un objeto
            nc = NewtonCotesPares(dato1, dato2, pares, inicial, final)
            
            # Procesamos
            nc.simpson(n)
            
            # Obtenemos el resultado
            result = nc.resCompuesta
            
            # Mostramos el resultado
            areaExprN = tk.Text(self.parent)
            areaExprN.place(
                    x=10, y=360, width=780, height=200)
            areaExprN.insert(tk.END, result)
            areaExprN.config(font=self.font, bg=self.bg)
            areaExprN.config(state="disabled")
        else :
            # Mensaje de error
            text = "Verifique que todos los campos esten seleccionados"
            tkMessageBox.showerror(title="Error", message=text)
                
            
    def processEcuacion(self):
        """
        Procesamos los datos de la ecuacion
        """
        
        ec = self.txtEcuacion.get()
        inicial = self.txtIntInf.get()
        final = self.txtIntSup.get()
        
        # verificamos que los input esten llenos
        if len(ec) > 0 and len(inicial) > 0 and len(final) > 0 :
            # Inicializamos un objeto
            nc = NewtonCotesEcuacion(ec, inicial, final)
            
            # Procesamos
            nc.process()
            
            # Obtenemos el resultado
            result = nc.res
            result += "\n" + nc.resCompuesta
            
            # Mostramos el resultado
            areaExpr = tk.Text(self.parent)
            areaExpr.place(x=10, y=70, width=780, height=200)
            areaExpr.insert(tk.END, result)
            areaExpr.config(font=self.font, bg=self.bg)
            areaExpr.config(state="disabled")
            
            # Procesamos n segmentos
            lblTemp = tk.Label(self.parent, text="Seleccione el numero de segmentos para trabajar:",
                          anchor=tk.W, justify=tk.LEFT)
            lblTemp.place(x=10, y=280, width=780, height=20)
            lblTemp.config(font=self.font, bg=self.bg)
            
            self.comboN = ttk.Combobox(self.parent , state="readonly")
            self.comboN.place(x=10, y=310, width=100, height=20)
            self.comboN["values"] = range(4, 11)
            self.comboN.bind("<<ComboboxSelected>>", self.selection_changed_n_ec)
        else :
            # Mensaje de error
            text = "Por favor llene todos los campos"
            tkMessageBox.showerror(title="Error", message=text)
    
    
    def processNEcuacion(self): 
        """
        Procesamos para N segmentos - metodo de simpson 3/8
        """
        
        # Obtenemos N pares
        n = int(self.comboN.get())
        
        ec = self.txtEcuacion.get()
        inicial = self.txtIntInf.get()
        final = self.txtIntSup.get()
        
        # verificamos que los input esten llenos
        if len(ec) > 0 and len(inicial) > 0 and len(final) > 0 :
            # Inicializamos un objeto
            nc = NewtonCotesEcuacion(ec, inicial, final)
            
            # Procesamos
            nc.simpson(n)
            
            # Obtenemos el resultado
            result = nc.resCompuesta
            
            # Mostramos el resultado
            areaExprN = tk.Text(self.parent)
            areaExprN.place(
                    x=10, y=370, width=780, height=190)
            areaExprN.insert(tk.END, result)
            areaExprN.config(font=self.font, bg=self.bg)
            areaExprN.config(state="disabled")
        else :
            # Mensaje de error
            text = "Verifique que todos los campos esten seleccionados"
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
            
            
        #for widget in self.graph.winfo_children():
        #    widget.destroy()
            
        # creamos los componentes
        lblEcuacion = tk.Label(self.parent, text="(Para trabajar con una ecuación ingrese 0)",
                              anchor=tk.W, justify=tk.LEFT)
        lblEcuacion.place(x=10, y=10, width=700, height=20)
        lblEcuacion.config(font=self.font, bg=self.bg)
        
        lblInstruccion = tk.Label(self.parent, text="Datos pares a ingresar (2 - 10):",
                              anchor=tk.W, justify=tk.LEFT)
        lblInstruccion.place(x=10, y=40, width=400, height=20)
        lblInstruccion.config(font=self.font, bg=self.bg)
        
        self.txtPares = tk.Entry(self.parent, validate='key',
                                 validatecommand = self.vcmd)
        self.txtPares.place(x=410, y=40, width=100, height=20)
        self.txtPares.focus()
        
        self.btnPares = tk.Button(self.parent, text="Crear tabla",
                               command=lambda: self.crearPares())
        self.btnPares.place(x=520, y=40, width=150, height=20)
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
        
            
    def close(self):
        self.graph.withdraw();