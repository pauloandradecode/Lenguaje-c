#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Wed Aug 30 00:43:06 2017

@author: Paulo Andrade
"""

import tkinter as tk
import ttk
import tkMessageBox
from MN.EDO import EDO
import matplotlib
matplotlib.use("TkAgg")
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg, NavigationToolbar2TkAgg
from matplotlib.figure import Figure
from matplotlib import collections as mc
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

    def initComponent(self):
        """ Componentes de la aplicación """
        self.parent.title("Metodo de Euler Modificado")
        self.parent.resizable(0, 0)
        self.parent.config(bg="white")
        self.renderingWindow(self.parent)
        
        # Opciones
        font = ('Verdana', 14)
        bg = "white"
        self.font = ('Verdana', 14)
        self.bg = "white"
        vcmd = (self.parent.register(self.validate),
                '%d', '%i', '%P', '%s', '%S', '%v', '%V', '%W')
        
        # Ecuacion diferencial ordinaria
        lblEcuacion = tk.Label(self.parent, text="Ingrese la Ecuacion Diferencial Ordinaria:",
                               anchor=tk.W, justify=tk.LEFT)
        lblEcuacion.place(x=10, y=10, width=520, height=20)
        lblEcuacion.config(font=font, bg=bg)
        
        self.txtEcuacion = tk.Entry(self.parent)
        self.txtEcuacion.place(x=530, y=10, width=260, height=20)
        self.txtEcuacion.focus()
        
        # etiquetas para datos solicitados
        lblPVIY = tk.Label(self.parent, text="PVI - Y:",
                                  anchor=tk.W, justify=tk.LEFT)
        lblPVIY.place(x=10, y=40, width=110, height=20)
        lblPVIY.config(font=font, bg=bg)
        
        self.txtPVIY = tk.Entry(self.parent)
        self.txtPVIY.place(x=120, y=40, width=50, height=20)
        
        lblPVIX = tk.Label(self.parent, text="PVI - X:",
                                  anchor=tk.W, justify=tk.LEFT)
        lblPVIX.place(x=180, y=40, width=110, height=20)
        lblPVIX.config(font=font, bg=bg)
        
        self.txtPVIX = tk.Entry(self.parent)
        self.txtPVIX.place(x=290, y=40, width=50, height=20)
        
        btnRaiz = tk.Button(self.parent, text="Procesar",
                            command=lambda: self.procesar())
        btnRaiz.place(x=10, y=70, width=200, height=20)
        btnRaiz.config(font=font)
        
        btnReset = tk.Button(self.parent, text="Limpiar",
                               command=lambda: self.reset())
        btnReset.place(x=640, y=570, width=150, height=20)
        btnReset.config(font=font)
        
        
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
        
    def procesar(self):
        """
        Procesamos la ecuacion diferencial ordinaria
        obteniendo C1 y resolviendo
        """
        
        # Obtenemos los valores
        ec = self.txtEcuacion.get()
        y = self.txtPVIY.get()
        x = self.txtPVIX.get()
        
        # verificamos que todos los campos esten llenos
        if len(ec)!=0 and len(x)!=0 and len(y)!=0 :
            # Iniciamos un objeto
            edo = EDO(ec, y, x)
            
            # procesamos la EDO
            expr = edo.process()
            
            # Mostramos los resultados
            lblExpr = tk.Label(self.parent, text="Resultados:",
                                  anchor=tk.W, justify=tk.LEFT)
            lblExpr.place(x=10, y=70, width=780, height=20)
            lblExpr.config(font=self.font, bg=self.bg)
        
            areaExpr = tk.Text(self.parent)
            areaExpr.place(
                    x=10, y=100, width=780, height=160)
            areaExpr.insert(tk.END, expr)
            areaExpr.config(font=self.font, bg=self.bg)
            areaExpr.config(state="disabled")
            
            # Mostramos nuevas opciones
            lblMsg = tk.Label(self.parent, text="Resolver por método de Euler modificado:",
                                  anchor=tk.W, justify=tk.LEFT)
            lblMsg.place(x=10, y=270, width=780, height=20)
            lblMsg.config(font=self.font, bg=self.bg)
            
            lblInicial = tk.Label(self.parent, text="I. Inicial:",
                                  anchor=tk.W, justify=tk.LEFT)
            lblInicial.place(x=10, y=300, width=140, height=20)
            lblInicial.config(font=self.font, bg=self.bg)
            
            self.txtInicial = tk.Entry(self.parent)
            self.txtInicial.place(x=160, y=300, width=50, height=20)
            self.txtInicial.focus()
            
            lblFinal = tk.Label(self.parent, text="I. Final:",
                                  anchor=tk.W, justify=tk.LEFT)
            lblFinal.place(x=220, y=300, width=140, height=20)
            lblFinal.config(font=self.font, bg=self.bg)
            
            self.txtFinal = tk.Entry(self.parent)
            self.txtFinal.place(x=370, y=300, width=50, height=20)
            
            lblN = tk.Label(self.parent, text="n:",
                                  anchor=tk.W, justify=tk.LEFT)
            lblN.place(x=430, y=300, width=50, height=20)
            lblN.config(font=self.font, bg=self.bg)
            
            self.txtN = tk.Entry(self.parent)
            self.txtN.place(x=490, y=300, width=50, height=20)
            
            btnProcesar = tk.Button(self.parent, text="Resolver",
                            command=lambda: self.euler(edo))
            btnProcesar.place(x=10, y=330, width=200, height=20)
            btnProcesar.config(font=self.font)
        else :
            # Mensaje de error
            text = "Por favor llene todos los campos"
            # Mostramos el mensaje
            tkMessageBox.showerror(title="Error", message=text)
            
            
    def euler(self, edo):
        """
        Resolvemos por metodo de euler
        """
        
        # Obtenemos los valores
        inicial = self.txtInicial.get()
        final = self.txtFinal.get()
        n = self.txtN.get()
        
        # verificamos que todos los campos esten llenos
        if len(inicial)!=0 and len(final)!=0 and len(n)!=0 :
            # obtenemos los trazos de euler modificado
            edo.eulerModificado(inicial, final, n)
            # obtenemos los trazos de euler
            edo.euler(inicial, final, n)
            
            # Obtenemos los puntos
            expr = edo.exprPoints
            
            # mostramos la expresion
            lblExpr = tk.Label(self.parent, text="Resultados:",
                                  anchor=tk.W, justify=tk.LEFT)
            lblExpr.place(x=10, y=330, width=780, height=20)
            lblExpr.config(font=self.font, bg=self.bg)
        
            areaExpr = tk.Text(self.parent)
            areaExpr.place(
                    x=10, y=330, width=780, height=230)
            areaExpr.insert(tk.END, expr)
            areaExpr.config(font=self.font, bg=self.bg)
            areaExpr.config(state="disabled")
            
            btnGraph = tk.Button(self.parent, text="Graficar",
                           command=lambda: self.graficar(edo))
            btnGraph.place(x=400, y=570, width=200, height=20)
            btnGraph.config(font=self.font)
            
            # Mostramos el error
            err = edo.pec[len(edo.pec) - 1] - edo.py[len(edo.py) - 1]
            text = "Error Euler modificado:\n"+str(err)
            err = edo.pec[len(edo.pec) - 1] - edo.pt[len(edo.pt) - 1]
            text += "\n\nError Euler:\n"+str(err)
            tkMessageBox.showinfo(title="Resultados", message=text)
        else :
            # Mensaje de error
            text = "Por favor llene todos los campos"
            # Mostramos el mensaje
            tkMessageBox.showerror(title="Error", message=text)
            
            
    def reset(self):
        """
        Reseteamos el layout principal
        """
            
        # creamos los componentes
        # Opciones
        font = ('Verdana', 14)
        bg = "white"
        vcmd = (self.parent.register(self.validate),
                '%d', '%i', '%P', '%s', '%S', '%v', '%V', '%W')
        
        # destruimos todos los componentes
        #for widget in self.parent.winfo_children():
        #   widget.destroy()
        lblTemp = tk.Label(self.parent, text="",
                              anchor=tk.W, justify=tk.LEFT)
        lblTemp.place(x=10, y=10, width=780, height=580)
        lblTemp.config(font=font, bg=bg)
        
        # Ecuacion diferencial ordinaria
        lblEcuacion = tk.Label(self.parent, text="Ingrese la Ecuacion Diferencial Ordinaria:",
                               anchor=tk.W, justify=tk.LEFT)
        lblEcuacion.place(x=10, y=10, width=520, height=20)
        lblEcuacion.config(font=font, bg=bg)
        
        self.txtEcuacion = tk.Entry(self.parent)
        self.txtEcuacion.place(x=530, y=10, width=260, height=20)
        self.txtEcuacion.focus()
        
        # etiquetas para datos solicitados
        lblPVIY = tk.Label(self.parent, text="PVI - Y:",
                                  anchor=tk.W, justify=tk.LEFT)
        lblPVIY.place(x=10, y=40, width=110, height=20)
        lblPVIY.config(font=font, bg=bg)
        
        self.txtPVIY = tk.Entry(self.parent)
        self.txtPVIY.place(x=120, y=40, width=50, height=20)
        
        lblPVIX = tk.Label(self.parent, text="PVI - X:",
                                  anchor=tk.W, justify=tk.LEFT)
        lblPVIX.place(x=180, y=40, width=110, height=20)
        lblPVIX.config(font=font, bg=bg)
        
        self.txtPVIX = tk.Entry(self.parent)
        self.txtPVIX.place(x=290, y=40, width=50, height=20)
        
        btnProcesar = tk.Button(self.parent, text="Procesar",
                            command=lambda: self.procesar())
        btnProcesar.place(x=10, y=70, width=200, height=20)
        btnProcesar.config(font=font)
        
        btnReset = tk.Button(self.parent, text="Limpiar",
                               command=lambda: self.reset())
        btnReset.place(x=640, y=570, width=150, height=20)
        btnReset.config(font=font)
            
            
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
        
    
    def graficar(self, edo):
        """
        Graficamos la funcion con ayuda de matplotlib
        """
        
        # Limpiamos la ventana
        for widget in self.graph.winfo_children():
            widget.destroy()

        self.graph.deiconify()
        
        f = Figure(figsize=(5,5), dpi=100)
        a = f.add_subplot(111)
        
        # solucion analitica
        n = self.txtN.get()
        h = (edo.final - edo.inicial) / float(n)
        _x = np.arange(edo.inicial - edo.final, edo.final + edo.final, h)
        # Graficar la funcion
        a.plot(_x, [edo.solve(i) for i in _x], label="Solucion analitica")
            
        # Dibujamos las lineas a mostrar en la grafica
        lines = []
        for i in range(0, len(edo.px)) :
            # agregamos la marca para euler
            a.scatter(edo.px[i], edo.py[i], marker='o')
            # agregamos la marca para la EDO
            a.scatter(edo.px[i], edo.pec[i], marker='o')
            # agregamos marca para taylor
            a.scatter(edo.px[i], edo.pt[i], marker='o')
            # Unimos la marca al eje y (euler)
            p = [(edo.px[i], edo.py[i]),
                 (edo.px[i], 0)]
            lines.append(p)
            # Unimos la marca al eje x (euler)
            p = [(edo.px[i], edo.py[i]),
                 (0, edo.py[i])]
            lines.append(p)
            # Unimos de marca a marca
            if i > 0:
                # para euler
                p = [(edo.px[i], edo.py[i]),
                     (edo.px[i - 1], edo.py[i - 1])]
                lines.append(p)    
                # para EDO
                p = [(edo.px[i], edo.pec[i]),
                     (edo.px[i - 1], edo.pec[i - 1])]
                lines.append(p)
                # para Taylor
                p = [(edo.px[i], edo.pt[i]),
                     (edo.px[i - 1], edo.pt[i - 1])]
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
        a.set_xlim(int(edo.inicial - edo.final), int(edo.final + edo.final))
        a.set_ylim(-10, 10)
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