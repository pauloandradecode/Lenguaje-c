#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Wed Aug 30 00:43:06 2017

@author: paulo
"""

import tkinter as tk
import ttk
import tkMessageBox
from MN.DifDiv import DifDiv
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
        self.parent.title("Diferencias divididas")
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
                
                lblTemp = tk.Label(self.parent, text="Puntos",
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
                    txtTemp1 = tk.Entry(self.parent)
                    txtTemp1.place(x=(10 + (width*(i+1))), y=60,
                                         width=width, height=20)
                    
                    # datos 2
                    txtTemp2 = tk.Entry(self.parent)
                    txtTemp2.place(x=(10 + (width*(i+1))), y=80,
                                         width=width, height=20)
                    
                    dato1.append(txtTemp1)
                    dato2.append(txtTemp2)
                #guardamos los datos
                self.dato1 = dato1
                self.dato2 = dato2
                
                btnCalcular = tk.Button(self.parent, text="Procesar",
                               command=lambda: self.process())
                btnCalcular.place(x=10, y=110, width=150, height=20)
                btnCalcular.config(font=self.font)
            else:
                # Mensaje de error
                text = "Ingrese un número entre 2 y 10."
                tkMessageBox.showerror(title="Error", message=text)
        else:
            # Mensaje de error
            text = "Por favor ingrese la cantidad de datos pares"
            tkMessageBox.showerror(title="Error", message=text)
        
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
            dd = DifDiv(self.dato1, self.dato2,
                                  self.txtPares.get())
            
            # obtenemos la expresion
            expr = dd.createExpr()
            
            lblExpr = tk.Label(self.parent, text="Resultados: ",
                      anchor=tk.W, justify=tk.CENTER)
            lblExpr.place(x=10, y=140, width=700, height=20)
            lblExpr.config(font=self.font, bg=self.bg)
            
            # Mostramos la expresión
            areaExpr = tk.Text(self.parent)
            areaExpr.place(
                    x=10, y=170, width=780, height=300)
            areaExpr.insert(tk.END, expr)
            areaExpr.config(font=self.font, bg=self.bg)
            areaExpr.config(state="disabled")
                            
        
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

            
    def close(self):
        self.graph.withdraw();