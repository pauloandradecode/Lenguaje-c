#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Mon Sep 18 22:10:42 2017

@author: paulo
"""

import sympy as sp

class Lagrange:
    def __init__(self, dato1=[], dato2=[], grado=1, inicial=0):
        self.dato1 = dato1
        self.dato2 = dato2
        self.grado = int(grado)
        self.init = int(inicial)
        self.ec = "" # Expresion
        
    def f(self, ec, n):
        """
        f(x) a resolver
        """
        
        x = sp.Symbol("x") # convertimos de variable a simbolo
        ec = str(ec) # Convertimos en cadena
        ec = sp.sympify(ec) # Convertimos a expresión
        return ec.subs(x, n) #resolvemos
    
    def createExpr(self):
        """
        Procesamos los datos para crear la expresión
        """
        
        expr = "" # Expresion
        
        # Obtenemos todas las L
        for i in range(0, self.grado + 1) :
            if i < self.grado :
                expr += str(self.l(i)) + " + "
            else :
                expr += str(self.l(i))
        
        self.ec = sp.expand(sp.simplify(sp.sympify(expr)))
        return sp.expand(sp.simplify(sp.sympify(expr)))
        
    def l(self, xi):
        """
        Obtenemos un trazo de la expresión
        """
        
        num = "" # Numerador
        den = "" # denominador
        expr = "" # Expresion
        
        # Obtenemos el valor de L
        for i in range(0, (self.grado + 1)) :
            if i != xi :
                if i < self.grado :
                    num += "(x - "+str(self.dato2[i + 1].get())+") *"
                    den += "("+str(self.dato2[xi + 1].get())+" - "+str(self.dato2[i + 1].get())+") *"
                else :
                    num += "(x - "+str(self.dato2[i + 1].get())+")"
                    den += "("+str(self.dato2[xi + 1].get())+" - "+str(self.dato2[i + 1].get())+")"
        
        # verificamos las cadenas
        if num[len(num) - 1] == "*" :
            num = num[0:(len(num) - 2)]
        if den[len(den) - 1] == "*" :
            den = den[0:(len(den) - 2)]
        
        # Retornamos el resultado
        expr +=  "(("+str(num)+") * "+str(self.dato1[xi + 1].get())+") / ("+str(den)+")"
        
        return sp.expand(sp.simplify(sp.sympify(expr)))