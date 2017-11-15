#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Tue Oct 10 21:03:03 2017

@author: paulo
"""

from MN.DifFin import DifFin
import sympy as sp

class NewtonCotesPares:
    def __init__(self, dato1=None, dato2=None, pares=2, inicial=0, final=0):
        """
        Constructor de la clase
        """
        
        self.dato1 = dato1 # f(x)
        self.dato2 = dato2 # x
        self.inicial = int(inicial) + 1 # Intervalo inicial
        self.final = int(final) + 1 # Intervalo final
        self.pares = int(pares) # pares de datos dados
        self.res = "" # Cadena para mostrar resultados
        
    def process(self):
        """
        Metodo para armar la cadena de resultado
        """
        
        self.trapezoidal()
        self.simpson13()
        self.simpson(3)
        
    def trapezoidal(self):
        """
        Metodo trapezoidal
        Este metodo lo utilizamos cuando n = 1 (1 intervalo)
        """
        
        # Obtenemos los valores de X0 y X1
        x0 = sp.Float(self.dato2[self.inicial].get())
        x1 = sp.Float(self.dato2[self.final].get())
        fx0 = sp.Float(self.dato1[self.inicial].get())
        fx1 = sp.Float(self.dato1[self.final].get())
        
        # Obtenemos h
        h = (x1 - x0) / 2
        
        # Obtenemos area
        a = h * (fx0 + fx1)
        
        # Armamos cadena
        self.res += "n=1 -> x0="+str(round(x0,2))+", x1="+str(round(x1,2))
        self.res += " -> a="+str(round(a,4))
        
    def simpson13(self):
        """
        Metodo de Simpson 1/3
        Este metodo se utiliza cuando n = 2
        """
        
        # Inicializamos un objeto de Newton para diferentas finitas
        # Se inicializa para grado 2
        df = DifFin(self.dato1, self.dato2, self.pares, 1)
        
        # Obtenemos los valores de X0 y X1
        x0 = sp.Float(self.dato2[self.inicial].get())
        x2 = sp.Float(self.dato2[self.final].get())
        fx0 = sp.Float(self.dato1[self.inicial].get())
        fx2 = sp.Float(self.dato1[self.final].get())
        
        # Obtenemos h
        h = (x2 - x0) / 2
        
        # Obtenemos x1
        x1 = x0 + h
        
        # Obtenemos la ecuacion de grado 2 por diferencias finitas
        df.difFin() # Obtenemos las diferencias finitas
        df.initComponent(x1) # preparamos los valores
        fx1 = df.calculate() # Obtenemos el valor
        
        # Obtenemos el area
        a = (h/3) * (fx0 + (4*fx1) + fx2)
        
        # Armamos cadena
        self.res += "\nn=2 -> x0="+str(round(x0,2))+", x1="+str(round(x1,2))
        self.res += ", x2="+str(round(x2,2))
        self.res += " f(x1)="+str(round(fx1,2))+" -> a="+str(round(a,4))
        
        
    def simpson(self, n=3):
        """
        Metodo de Simpson 3/8
        Este metodo se utiliza cuando n = 3
        O se utiliza para el metodo compuesto cuando 3 < n < 11
        """
        
        # Inicializamos un objeto de Newton para diferentas finitas
        # Se inicializa para grado 2
        df = DifFin(self.dato1, self.dato2, self.pares, 1)
        
        # Obtenemos la ecuacion de grado 2 por diferencias finitas
        df.difFin() # Obtenemos las diferencias finitas
        
        # Obtenemos los valores de X0 y X1
        x0 = sp.Float(self.dato2[self.inicial].get())
        x1 = sp.Float(self.dato2[self.final].get())
        fx0 = sp.Float(self.dato1[self.inicial].get())
        fx1 = sp.Float(self.dato1[self.final].get())
        
        # Obtenemos h
        h = (x1 - x0) / n
        
        # Obtenemos los valores de los subintervalos
        valx = [] # valores de x
        valfx = [] # valores de fx
        for i in range(0, n+1):
            if i == 0 :
                # valor inicial
                valx.append(x0)
                valfx.append(fx0)
            elif i == n :
                # valor final
                valx.append(x1)
                valfx.append(fx1)
            else :
                # Calculamos el valor xi
                x = valx[i - 1] + h
                
                # Calculamos el valor de fxi
                df.initComponent(x) # preparamos los valores
                fx = df.calculate() # Obtenemos el valor
                
                # Agregamos el valor
                valx.append(x)
                valfx.append(fx)
                
        # Calculamos la formula
        sum = 0
        for i in range(0, n) :
            # Obtenemos los valores de x
            xa = x0 + (i*h) 
            xb = x0 + (i*h) + (h/2)
            xc = x0 + ((i + 1)*h)
            
            # Obtenemos las fx
            df.initComponent(xa) # preparamos los valores
            fxa = df.calculate() # Obtenemos el valor
            df.initComponent(xb) # preparamos los valores
            fxb = df.calculate() # Obtenemos el valor
            df.initComponent(xc) # preparamos los valores
            fxc = df.calculate() # Obtenemos el valor
            
            # Obtenemos el numerador
            num = fxa + (4*fxb) + fxc
            
            # Obtenemos la sumatoria
            sum += (num / 6) * h
            
        
        # Obtenemos el area
        a = sum
        
        # Armamos cadena
        self.resCompuesta = "n="+str(n)+" -> x0="+str(round(x0,2))
        for i in range(1, n) :
            self.resCompuesta += ", x"+str(i)+"="+str(round(valx[i],2))
        self.resCompuesta += ", x"+str(n)+"="+str(round(x1,2))
        for i in range(1, n) :
            self.resCompuesta += " f(x"+str(i)+")="+str(round(valfx[i],2))
        self.resCompuesta += " -> a="+str(round(a,4))