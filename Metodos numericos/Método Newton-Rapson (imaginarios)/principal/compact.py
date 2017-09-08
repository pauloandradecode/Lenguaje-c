#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 29 22:31:57 2017

@author: paulo
"""

import Tkinter as tk
import ttk
import tkMessageBox
import matplotlib
matplotlib.use("TkAgg")
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg, NavigationToolbar2TkAgg
from matplotlib.figure import Figure
import sympy as sp
import cmath as cm
import numpy as np

#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Tue Sep  5 17:47:38 2017

@author: Paulo Andrade
"""

class NewtonRapson:
    def __init__(self, inicial, ecuacion, err=0.001, treeView=None):
        """
        Constructor de la clase
        """
        
        self.inicial = inicial # valor inicial
        self.err = sp.sympify(sp.Float(err)) # margen de error
        self.ec = str(ecuacion).lower() # ecuacion
        self.root = 0 # raices racionales
        self.real = [] # raices reales
        self.complex = [] # raices complejas
        self.tree = treeView # Arbol de resultados
    
    def roots(self):
        """
        x**3 + 2*x**2 + 10*x - 20
        Obtenemos el total de raices de la ecuacion
        """
        
        # Verificamos el grado del polinomio
        x = sp.Symbol("x") # Declaramos x como simbolo
        res = sp.solve(sp.sympify(self.ec), x) # obtenemos las raices

        for i in res:
            total = i.count("I")
            temp = cm.polar(sp.sympify(i)) # Obtenemos raiz en forma polar
            
            # Comprobamos si es compleja
            if total == 0 :
                self.root += 1
                self.real.append(sp.sympify(i)) # Sumamos las raices reales
            else :
                self.complex.append(cm.rect(sp.sympify(temp[0]), sp.sympify(temp[1])))
                
    def f(self, n):
        """
        f(x) a resolver
        """
        
        x = sp.Symbol("x") # convertimos de variable a simbolo
        ec = str(self.ec) # Convertimos en cadena
        ec = sp.sympify(self.ec) # Convertimos a expresión
        return ec.subs(x, n) #resolvemos
    
    def fdx(self, n):
        """
        f'(x) a resolver
        """
        
        x = sp.Symbol("x") # convertimos de variable a simbolo
        ec = str(self.ec) # Convertimos en cadena
        ec = sp.sympify(self.ec) # Convertimos a expresión
        dx = sp.diff(ec, x) # Obtenemos la derivada
        return dx.subs(x, n) #resolvemos
    
    def g(self, xi):
        """
        Calculamos el valor siguiente
        Xi + 1 = g(x)
        """
        
        return xi - (self.f(xi) / self.fdx(xi))
    
    def vertex(self):
        """
        Obtenemos el vertice de una ecuacion cuadratica
        """
        
        # comprobamos si es una funcion cuadratica
        if self.root == 2 :
            x = self.real / 2
        
            # devolvemos el vertice
            return [x, self.f(x)]
        else :
            return None
        
    def estimate(self, count):
        """
        Realizamos los calculos de la raiz imaginaria
        """
        
        xi = self.inicial # Obtenemos valor inicial
        fxi = self.f(xi) # f(xi)
        fdxi = self.fdx(xi) # f'(xi)
        
        com = xi - ((fxi*(cm.sqrt(-1))) / (fdxi*(cm.sqrt(-1))))
        tempInicial = cm.polar(sp.sympify(xi))
        tempInicial = cm.rect(sp.sympify(tempInicial[0]), sp.sympify(tempInicial[1]))
        tempFxi = cm.polar(sp.sympify(fxi))
        tempFxi = cm.rect(sp.sympify(tempFxi[0]), sp.sympify(tempFxi[1]))
        tempFdxi = cm.polar(sp.sympify(fdxi))
        tempFdxi = cm.rect(sp.sympify(tempFdxi[0]), sp.sympify(tempFdxi[1]))
        tempCom = cm.polar(sp.sympify(com))
        tempCom = cm.rect(sp.sympify(tempCom[0]), sp.sympify(tempCom[1]))
        e = abs(tempInicial - tempCom)
        
        # Colocamos un separador si el contador es uno
        if count == 1:
            item = self.tree.insert("", 0, text="--", values=("------",
                "------", "------", "------"))
        
        # Mostramos la informacion
        item = self.tree.insert("" , (count - 1), text=str(count), values=(
                str(tempInicial), str(tempFxi), str(tempFdxi), str(tempCom)
            ))
        
        # Verificamos la raiz con el error estimado
        count += 1 # Aumentamos el contador
        self.tree.selection_set(item) # Seleccionamos la ultima fila
        
        # verificamos el error
        if e > self.err :
            self.inicial = tempCom # Cambiamos el valor inicial
            return self.estimate(count)
        else: return com
        

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
        self.parent.title("Método de Newton-Rapson (raices imaginarias)")
        self.parent.resizable(0, 0)
        self.parent.config(bg="white")
        self.renderingWindow(self.parent)
        
        # Opciones
        font = ('Verdana', 14)
        bg = "white"
        vcmd = (self.parent.register(self.validate),
                '%d', '%i', '%P', '%s', '%S', '%v', '%V', '%W')
        
        # Objetos
        lblEcuacion = tk.Label(self.parent, text="Ingrese la ecuación:",
                               anchor=tk.W, justify=tk.LEFT)
        lblEcuacion.place(x=10, y=10, width=300, height=20)
        lblEcuacion.config(font=font, bg=bg)
        
        txtInstruccion = "Ingrese un valor inicial para calcular la raiz:"
        lblInstruccion = tk.Label(self.parent, text=txtInstruccion,
                                  anchor=tk.W, justify=tk.LEFT)
        lblInstruccion.place(x=10, y=50, width=700, height=20)
        lblInstruccion.config(font=font, bg=bg)
        
        lblInferior = tk.Label(self.parent, text="V. Inicial:",
                                  anchor=tk.W, justify=tk.LEFT)
        lblInferior.place(x=10, y=90, width=140, height=20)
        lblInferior.config(font=font, bg=bg)
        
        lblError = tk.Label(self.parent, text="Error:",
                                  anchor=tk.W, justify=tk.LEFT)
        lblError.place(x=540, y=90, width=110, height=20)
        lblError.config(font=font, bg=bg)
        
        lblRes = tk.Label(self.parent, text="Resultados:",
                                  anchor=tk.W, justify=tk.LEFT)
        lblRes.place(x=10, y=170, width=700, height=20)
        lblRes.config(font=font, bg=bg)
        
        self.txtEcuacion = tk.Entry(self.parent)
        self.txtEcuacion.place(x=320, y=10, width=200, height=20)
        self.txtEcuacion.focus()
        
        v = tk.StringVar(self.parent, value='0')
        self.txtInferior = tk.Entry(self.parent, state='disabled',
                                    textvariable=v)
        self.txtInferior.place(x=160, y=90, width=130, height=20)
        
        self.txtError = tk.Entry(self.parent, validate = 'key',
                                 validatecommand = vcmd)
        self.txtError.place(x=660, y=90, width=130, height=20)
        
        btnGrafica = tk.Button(self.parent, text="Graficar",
                               command=lambda: self.graficar())
        btnGrafica.place(x=670, y=10, width=120, height=20)
        btnGrafica.config(font=font)
        
        btnRaiz = tk.Button(self.parent, text="Obtener raices",
                            command=lambda: self.raiz())
        btnRaiz.place(x=10, y=130, width=200, height=20)
        btnRaiz.config(font=font)
        
        self.tree = ttk.Treeview(self.parent)
        vsb = ttk.Scrollbar(self.parent, orient="vertical",
                            command=self.tree.yview)
        vsb.place(x=775, y=210, height=380)
        self.tree.configure(yscrollcommand=vsb.set)
        self.tree["columns"]=("Xi", "f(Xi)", "f'(Xi)", "g(x)")
        self.tree.column("#0", width=50)
        self.tree.column("Xi", width=170)
        self.tree.column("f(Xi)", width=180)
        self.tree.column("f'(Xi)", width=180)
        self.tree.column("g(x)", width=185)
        self.tree.heading("Xi", text="Xi")
        self.tree.heading("f(Xi)", text="f(Xi)")
        self.tree.heading("f'(Xi)", text="F'(Xi)")
        self.tree.heading("g(x)", text="g(x)")
        self.tree.place(x=10, y=210, width=765, height=380)
        self.tree.insert("" , 0, text="1", values=("","","",""))
        
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
        
    def raiz(self):
        # Obtenemos los valores
        ec = self.txtEcuacion.get()
        inicial = cm.sqrt(-1)
        err = self.txtError.get()
        text = "f(x) = "+str(ec)+"\n\n"
        
        # verificamos que todos los campos esten llenos
        if len(ec)!=0 and len(err)!=0 :
            # Limpiamos el treeView
            self.tree.delete(*self.tree.get_children())
            
            # Creamos un objeto de la clase Regla Falsa
            nr = NewtonRapson(inicial, ec, err, self.tree)
            
            # Obtenemos el total de raices
            nr.roots()
            
            # comprobamos el numero de raices
            if (nr.root + len(nr.complex)) == 0 :
                # Mensaje a mostrar
                text = "La función dada no tiene raices"
                
                # Mostramos el mensaje
                tkMessageBox.showerror(title="Error", message=text)
            else :
                textTemp = "f(x) = "+str(ec)+"\n\n"
                textTemp += "Tiene "+str(len(nr.complex))+" raices imaginarias\n"
                textTemp += "El valor inicial se calculara automaticamente"
                tkMessageBox.showwarning(title="Atención", message=textTemp)
                # Contador de raices
                count = 1
                
                # verificamos si tiene raices complejas
                if len(nr.complex) > 0:
                    nr.inicial = (nr.complex[0] - 1j)
                    raiz = nr.estimate(1)
                    
                    control = 2
                    
                    while len(nr.complex) >= control:
                        nr.inicial = (nr.complex[control-1] - 1j)
                        raiz = nr.estimate(1)
                    
                        control += 1
                
                # Obtenemos las raices reales
                for r in nr.real:
                    text += "Raiz "+str(count)+": "+str(r)+"\n"
                    count += 1
                
                # Obtenemos las raices imaginarias
                for r in nr.complex:
                    text += "Raiz "+str(count)+": "+str(r)+"\n"
                    count += 1
                    
                # Mostramos el mensaje
                tkMessageBox.showinfo(title="Resultados", message=text)
        else :
            # Mensaje de error
            text = "Por favor llene todos los campos"
            # Mostramos el mensaje
            tkMessageBox.showerror(title="Error", message=text)
            
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
        
    def graficar(self):
        """
        Graficamos la funcion con ayuda de matplotlib
        """
        
        font = ('Verdana', 14)
        ec = self.txtEcuacion.get().lower()
        
        # verificamos que todos los campos esten llenos
        if len(ec) != 0 :
            # Limpiamos la ventana
            for widget in self.graph.winfo_children():
                widget.destroy()
    
            self.graph.deiconify()
            nr = NewtonRapson(0,ec)
            
            f = Figure(figsize=(5,5), dpi=100)
            a = f.add_subplot(111)
            # Valores del eje X que toma el gráfico.
            _x = range(-10, 15)
            # Graficar ambas funciones.
            a.plot(_x, [nr.f(i) for i in _x])
            # Establecer el color de los ejes.
            a.axhline(0, color="black")
            a.axvline(0, color="black")
            # Limitar los valores de los ejes.
            a.set_xlim(-10, 10)
            a.set_ylim(-50, 50)
            # Etiquetas de los ejes
            a.set_xlabel('X')
            a.set_ylabel('Y')
            a.set_title('f(x) = '+str(ec))
            a.grid(True)
    
            canvas = FigureCanvasTkAgg(f, self.graph)
            canvas.show()
            canvas.get_tk_widget().pack(side=tk.TOP, fill=tk.X,
                                expand=True)
    
            btnClose = tk.Button(self.graph, text="Cerrar",
                            command=lambda: self.close())
            btnClose.config(font=font)
            btnClose.pack(side=tk.BOTTOM, fill=tk.X)
    
            toolbar = NavigationToolbar2TkAgg(canvas, self.graph)
            toolbar.update()
            canvas._tkcanvas.pack(side=tk.TOP)
        else:
            # Mensaje de error
            text = "Por favor ingrese la ecuacion"
            tkMessageBox.showerror(title="Error", message=text)
            
    def close(self):
        self.graph.withdraw();
        
        
# Entrada del programa
def main ():
    parent = tk.Tk()
    root = GUI(parent = parent)
    parent.destroy()
    

    
# Indicamos que se trata del modulo principal
if __name__ == "__main__":
    main()