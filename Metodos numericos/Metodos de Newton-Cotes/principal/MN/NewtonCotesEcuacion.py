#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Wed Oct 11 07:08:21 2017

@author: paulo
"""

import sympy as sp

class NewtonCotesEcuacion:
    def __init__(self, ec="", inicial=0, final=0):
        """
        Constructor de la clase
        """
        
        self.ec = str(ec).lower() # Ecuacion
        self.inicial = int(inicial) # Intervalo inicial
        self.final = int(final) # Intervalo final
        self.res = "" # Cadena para mostrar resultados
        
        
    def f(self, n):
        """
        f(x) a resolver
        """
        
        x = sp.Symbol("x") # convertimos de variable a simbolo
        ec = str(self.ec) # Convertimos en cadena
        ec = sp.sympify(ec) # Convertimos a expresión
        return ec.subs(x, n) #resolvemos
        
        
    def process(self):
        """
        Metodo para armar la cadena de resultado
        """
        
        self.trapezoidal()
        self.simpson13()
        self.simpson()
        
        
    def trapezoidal(self):
        """
        Metodo trapezoidal
        Este metodo lo utilizamos cuando n = 1 (1 intervalo)
        """
        
        # Obtenemos los valores de X0 y X1
        x0 = sp.Float(self.inicial)
        x1 = sp.Float(self.final)
        fx0 = self.f(x0)
        fx1 = self.f(x1)
        
        # Obtenemos h
        h = (x1 - x0) / 2
        
        # Obtenemos area
        a = h * (fx0 + fx1)
        
        # Armamos cadena
        self.res += "n=1 -> x0="+str(round(x0,2))+", x1="+str(round(x1,2))
        self.res += " -> a="+str(round(a,4))
        
        print self.res
        
        
    def simpson13(self):
        """
        Metodo de Simpson 1/3
        Este metodo se utiliza cuando n = 2
        """
                
        # Obtenemos los valores de X0 y X1
        x0 = sp.Float(self.inicial)
        x2 = sp.Float(self.final)
        fx0 = self.f(x0)
        fx2 = self.f(x2)
        
        # Obtenemos h
        h = (x2 - x0) / 2
        
        # Obtenemos x1
        x1 = x0 + h
        
        # Obtenemos f(x1)
        fx1 = self.f(x1)
        
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
        
        # Obtenemos los valores de X0 y X1
        x0 = sp.Float(self.inicial)
        x1 = sp.Float(self.final)
        fx0 = self.f(x0)
        fx1 = self.f(x1)
        
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
                fx = self.f(x)
                
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
            fxa = self.f(xa)
            fxb = self.f(xb)
            fxc = self.f(xc)
            
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