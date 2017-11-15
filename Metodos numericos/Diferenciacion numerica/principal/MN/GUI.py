#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Wed Aug 30 00:43:06 2017

@author: paulo
"""

import tkinter as tk
import ttk
import tkMessageBox
from MN.DifNumericaPares import DifNumericaPares
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
        self.parent.title("Direferenciacion numerica")
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
                lblTemp = tk.Label(self.parent, text="Grado de la ecuación:",
                              anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=80, width=240, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                self.comboGrado = ttk.Combobox(self.parent , state="readonly")
                self.comboGrado.place(x=260, y=80, width=100, height=20)
                self.comboGrado["values"] = range(1, int(grado))
                self.comboGrado.bind("<<ComboboxSelected>>", self.selection_changed)
            elif int(grado) == 0 :
                lblTemp = tk.Label(self.parent, text="Ingrese la ecuación:",
                              anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=10, width=280, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
        
                self.txtEcuacion = tk.Entry(self.parent)
                self.txtEcuacion.place(x=290, y=10, width=380, height=20)
                self.txtEcuacion.focus()
                
                # Para borrar contenido
                lblTemp = tk.Label(self.parent, text="",
                              anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=40, width=780, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                lblTemp = tk.Label(self.parent, text="valor de h: ",
                              anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=40, width=160, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                self.txtH = tk.Entry(self.parent)
                self.txtH.place(x=150, y=40, width=70, height=20)
                
                lblTemp = tk.Label(self.parent, text="Datos Inicial: ",
                              anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=230, y=40, width=180, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                self.txtInicio = tk.Entry(self.parent)
                self.txtInicio.place(x=420, y=40, width=100, height=20)
                
                lblTemp = tk.Label(self.parent, text="Datos pares: ",
                              anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=530, y=40, width=180, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                self.comboPares = ttk.Combobox(self.parent , state="readonly")
                self.comboPares.place(x=690, y=40, width=100, height=20)
                self.comboPares["values"] = range(2, 5)
                self.comboPares.bind("<<ComboboxSelected>>", self.selection_changed_ec)
                
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
        Cambio al seleccionar en el combo box de seleccion de grado
        """
        
        # Obtenemos los valores en X
        x = self.dato2
        
        # verificamos que esten completos los datos
        if self.isEmpty() :
            # Mensaje de error
            text = "Por favor ingrese todos los datos solicitados"
            tkMessageBox.showerror(title="Error", message=text)
        else :
            # verificamos si se realiza por diferencias finitas o divididas
            h = (int(x[len(x) - 1].get()) - int(x[1].get())) / (len(x) - 2)
            self.control = True
            for i in range(1, len(x) - 2) :
                if (int(x[i + 1].get()) - int(x[i].get())) != h :
                    self.control = False
            
            if self.control :
                # Mostramos por diferencias finitas
                lblTemp = tk.Label(self.parent, text="Resolvemos por diferencias finitas: ",
                              anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=110, width=780, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
            else :
                # Mostramos por diferencias divididas
                lblTemp = tk.Label(self.parent, text="Resolvemos por diferencias divididas: ",
                              anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=110, width=780, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
            
            btnCalcular = tk.Button(self.parent, text="Procesar",
                                   command=lambda: self.processPuntos())
            btnCalcular.place(x=10, y=140, width=150, height=20)
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
            # Obtenemos los datos
            grado = self.comboGrado.get()
            pares = self.txtPares.get()
            print grado
            dato1 = self.dato1
            dato2 = self.dato2
            
            if len(grado) > 0 :
                # desabilitamos el combo
                self.comboGrado.config(state="disabled")
                
                # Inicializamos un objeto
                dn = DifNumericaPares(dato1, dato2, pares, grado)
                
                # Obtenemos los primeros resultados
                dn.processDiferencias()
                
                # Mostramos las diferencias
                diferencias = dn.diferencias
                areaExpr = tk.Text(self.parent)
                areaExpr.place(
                        x=10, y=140, width=780, height=120)
                areaExpr.insert(tk.END, diferencias)
                areaExpr.config(font=self.font, bg=self.bg)
                areaExpr.config(state="disabled")
                
                # Mostramos eiqueta
                lblTemp = tk.Label(self.parent, text="Ingrese el valor a interpolar:",
                              anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=270, width=780, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                # Capturamos el dato
                self.txtValor = tk.Entry(self.parent)
                self.txtValor.place(x=10, y=300, width=120, height=20)
                self.txtValor.focus()
                
                # Procesamos
                btnValor = tk.Button(self.parent, text="Calcular",
                               command=lambda: self.processValuePares(dn))
                btnValor.place(x=140, y=300, width=150, height=20)
                btnValor.config(font=self.font)        
            else :
                # Mensaje de error
                text = "Seleccione el grado del polinomio a interpolar"
                tkMessageBox.showerror(title="Error", message=text)
                
                
    def processValuePares(self, dif):
        """
        Procesamos el valor, recivimos clase de diferencias
        """
        
        # Obtenemos N pares
        val = self.txtValor.get()
        
        if len(val) > 0 :
            # verificamos con que diferencias trabajar
            if self.control :
                # Mostramos por diferencias finitas
                
                # volvemos a procesar los valores
                dif.processValueFinitas(val)
                
                # Obtenemos valores
                ec = dif.ecRed
                valor = dif.value
                res = dif.res
                # Mostramos la ecuacion
                areaExpr = tk.Text(self.parent)
                areaExpr.place(
                        x=10, y=330, width=780, height=80)
                areaExpr.insert(tk.END, ec)
                areaExpr.config(font=self.font, bg=self.bg)
                areaExpr.config(state="disabled")
                
                # Mostramos los resultados
                lblTemp = tk.Label(self.parent, text="Valor interpolado: ",
                                  anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=420, width=280, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                v = tk.StringVar(self.parent, value=valor)
                txtValor = tk.Entry(self.parent, textvariable=v)
                txtValor.place(x=300, y=420, width=400, height=20)
                txtValor.focus()
                
                lblTemp = tk.Label(self.parent, text="Valor R"+str(len(res) - 1)+"("+str(val)+"): ",
                                  anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=450, width=280, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                v = tk.StringVar(self.parent, value=res[0])
                txtValor = tk.Entry(self.parent, textvariable=v)
                txtValor.place(x=300, y=450, width=400, height=20)
                txtValor.focus()
                
                lblTemp = tk.Label(self.parent, text="Valor d"+str(len(res) - 1)+"R"+str(len(res) - 1)+"("+str(val)+")/dx: ",
                                  anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=480, width=280, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                v = tk.StringVar(self.parent, value=res[len(res) - 1])
                txtValor = tk.Entry(self.parent, textvariable=v)
                txtValor.place(x=300, y=480, width=400, height=20)
                txtValor.focus()
            else :
                # Mostramos por diferencias divididas
                
                # volvemos a procesar los valores
                dif.processValueDivididas(val)
                
                # Obtenemos valores
                ec = dif.ecRed
                valor = dif.value
                res = dif.res
                # Mostramos la ecuacion
                areaExpr = tk.Text(self.parent)
                areaExpr.place(
                        x=10, y=330, width=780, height=80)
                areaExpr.insert(tk.END, ec)
                areaExpr.config(font=self.font, bg=self.bg)
                areaExpr.config(state="disabled")
                
                # Mostramos los resultados
                lblTemp = tk.Label(self.parent, text="Valor interpolado: ",
                                  anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=420, width=280, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                v = tk.StringVar(self.parent, value=valor)
                txtValor = tk.Entry(self.parent, textvariable=v)
                txtValor.place(x=300, y=420, width=400, height=20)
                txtValor.focus()
                
                lblTemp = tk.Label(self.parent, text="Valor R"+str(len(res) - 1)+"("+str(val)+"): ",
                                  anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=450, width=280, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                v = tk.StringVar(self.parent, value=res[0])
                txtValor = tk.Entry(self.parent, textvariable=v)
                txtValor.place(x=300, y=450, width=400, height=20)
                txtValor.focus()
                
                lblTemp = tk.Label(self.parent, text="Valor d"+str(len(res) - 1)+"R"+str(len(res) - 1)+"("+str(val)+")/dx: ",
                                  anchor=tk.W, justify=tk.LEFT)
                lblTemp.place(x=10, y=480, width=280, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                v = tk.StringVar(self.parent, value=res[len(res) - 1])
                txtValor = tk.Entry(self.parent, textvariable=v)
                txtValor.place(x=300, y=480, width=400, height=20)
                txtValor.focus()
            
            
            btnGraph = tk.Button(self.parent, text="Graficar",
                           command=lambda: self.graficar(dif))
            btnGraph.place(x=380, y=570, width=200, height=20)
            btnGraph.config(font=self.font)
        else :
            # Mensaje de error
            text = "Ingrese el valor a interpolar"
            tkMessageBox.showerror(title="Error", message=text)
                

    def selection_changed_ec(self, event):
        """
        Funcion lanzada cuando se selecciona un item del combobox
        pares de la ecuacion
        """
        
        btnCalcular = tk.Button(self.parent, text="Crear tabla",
                               command=lambda: self.processEcuacion())
        btnCalcular.place(x=10, y=70, width=200, height=20)
        btnCalcular.config(font=self.font)

            
    def processEcuacion(self):
        """
        Procesamos los datos de la ecuacion
        """
        
        ec = self.txtEcuacion.get()
        h = self.txtH.get()
        inicio = self.txtInicio.get()
        pares = self.comboPares.get()
        
        # verificamos que los input esten llenos
        if len(ec) > 0 and len(h) > 0 and len(pares) > 0 and len(inicio) > 0:
            # creamos la rejilla            
            width = 780 / (int(pares) + 1)
            dato1 = []
            dato2 = []
                
            # desactivamos el boton y campo de entrada
            self.txtEcuacion.config(state="disabled")
            self.txtInicio.config(state="disabled")
            self.txtH.config(state="disabled")
            self.comboPares.config(state="disabled")
                
            # Campos por default                
            lblTemp = tk.Label(self.parent, text="Puntos",
                          anchor=tk.W, justify=tk.CENTER)
            lblTemp.place(x=10, y=70,
                          width=width, height=20)
            lblTemp.config(font=self.font, bg=self.bg)
                
            lblTemp1 = tk.Label(self.parent, text="F(x)")
            lblTemp1.place(
                    x=10, y=90, width=width, height=20)
            lblTemp1.config(font=self.font, bg=self.bg)
                
            lblTemp2 = tk.Label(self.parent, text="X")
            lblTemp2.place(
                    x=10, y=110, width=width, height=20)
            lblTemp2.config(font=self.font, bg=self.bg)
                
            dato1.append(lblTemp1)
            dato2.append(lblTemp2)
            
            inicio = int(inicio)
                
            for i in range(0, int(pares)):
                # Etiqueta de puntos
                lblTemp = tk.Label(self.parent, text=""+str(i),
                          anchor=tk.W, justify=tk.CENTER)
                lblTemp.place(x=(10 + (width*(i+1))), y=70,
                              width=width, height=20)
                lblTemp.config(font=self.font, bg=self.bg)
                
                # datos 1
                val = self.f(ec, inicio)
                v = tk.StringVar(self.parent, value=val)
                txtTemp1 = tk.Entry(self.parent, textvariable=v)
                txtTemp1.place(x=(10 + (width*(i+1))), y=90,
                                     width=width, height=20)
                
                # datos 2
                v = tk.StringVar(self.parent, value=inicio)
                txtTemp2 = tk.Entry(self.parent, textvariable=v)
                txtTemp2.place(x=(10 + (width*(i+1))), y=110,
                                     width=width, height=20)
                inicio += int(h)
                
                dato1.append(txtTemp1)
                dato2.append(txtTemp2)
            #guardamos los datos
            self.dato1 = dato1
            self.dato2 = dato2
            
            btnCalcular = tk.Button(self.parent, text="Procesar",
                               command=lambda: self.processEcuacionTable())
            btnCalcular.place(x=10, y=140, width=150, height=20)
            btnCalcular.config(font=self.font)
        else :
            # Mensaje de error
            text = "Por favor llene todos los campos"
            tkMessageBox.showerror(title="Error", message=text)    
            
            
    def processEcuacionTable(self):
        """
        Procesamos los datos de la tabla creada a partir de la ecuacion
        """
        
        # Obtenemos los datos
        ec = self.txtEcuacion.get()
        pares = self.comboPares.get()
        grado = int(pares) - 1
        dato1 = self.dato1
        dato2 = self.dato2
        
        # Inicializamos un objeto
        dn = DifNumericaPares(dato1, dato2, pares, grado)
                
        # Obtenemos los primeros resultados
        dn.processDiferencias()
                
        # Mostramos las diferencias
        diferencias = dn.diferencias
        areaExpr = tk.Text(self.parent)
        areaExpr.place(
                x=10, y=140, width=780, height=120)
        areaExpr.insert(tk.END, diferencias)
        areaExpr.config(font=self.font, bg=self.bg)
        areaExpr.config(state="disabled")
                
        # Mostramos eiqueta
        lblTemp = tk.Label(self.parent, text="Ingrese el valor a interpolar:",
                          anchor=tk.W, justify=tk.LEFT)
        lblTemp.place(x=10, y=270, width=780, height=20)
        lblTemp.config(font=self.font, bg=self.bg)
        
        # Capturamos el dato
        self.txtValor = tk.Entry(self.parent)
        self.txtValor.place(x=10, y=300, width=120, height=20)
        self.txtValor.focus()
        
        # Procesamos por diferencias divididas
        self.control = True
        btnValor = tk.Button(self.parent, text="Calcular",
                       command=lambda: self.processValuePares(dn))
        btnValor.place(x=140, y=300, width=150, height=20)
        btnValor.config(font=self.font)
        
    
    
    def f(self, ec, n):
        """
        f(x) a resolver
        """
        
        x = sp.Symbol("x") # convertimos de variable a simbolo
        ec = str(ec) # Convertimos en cadena
        ec = sp.sympify(ec) # Convertimos a expresión
        return ec.subs(x, n) #resolvemos
    
    
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
        #for widget in self.parent.winfo_children():
        #   widget.destroy()
        lblTemp = tk.Label(self.parent, text="",
                              anchor=tk.W, justify=tk.LEFT)
        lblTemp.place(x=10, y=10, width=780, height=580)
        lblTemp.config(font=self.font, bg=self.bg)
            
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
        
        
    def graficar(self, lg):
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
        # Graficar la funcion
        for ec in lg.ecuaciones :
            a.plot(_x, [lg.f(ec, i) for i in _x], label="f(x)="+str(ec))
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