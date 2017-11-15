#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Mon Nov 13 18:44:13 2017

@author: paulo
"""

import sympy as sp

class EDO:
    def __init__(self, ecuacion, y, x):
        """
        Constructor de la clase
        """
        
        self.y = int(y) # valor de Y(x)
        self.x = int(x) # valor de X
        self.ec = str(ecuacion).lower() # ecuacion
        
    def process(self):
        """
        Procesamos la ecuacion y obtenemos los resultados
        """
        
        # Guardamos expresion
        expr = ""
        
        # Obtenemos los symbolos
        x = sp.Symbol("x")
        y = sp.Function("y")
        
        # Obtenemos la expresion
        ec = sp.sympify(self.ec)
        
        # Valor inicial (PVI)
        pvi = { y(self.x): self.y }
        
        # preparamos la EDO
        edo = sp.Eq(y(x).diff(x), ec)
        expr += "EDO:\n\t"+str(edo)
        
        # Despejamos Y
        res = sp.dsolve(y(x).diff(x) - ec)
        # Obtenemos y(x) = f(x)
        expr += "\nEDO resuelta:\n\t"+str(res)
        
        # reemplazamos PVI
        c_eq = sp.Eq(res.lhs.subs(x, 0).subs(pvi), res.rhs.subs(x, 0))
        expr += "\nRemplazamos PVI:\n\t"+str(c_eq)
        
        # Obtenemos el valor de la constante
        c = sp.solve(c_eq)
        expr += "\nValor de C1:\n\t"+str(c[0])
        
        # almacenamos los valores de interes
        self.c = c[0] # valor de C1
        self.res = res # ecuacion resuelta
        
        # retornamos el resultado
        return expr
    
    
    def f(self, xi, yi):
        """
        Obtenemos la primer derivada de la EDO
        """
        
        # symbolos
        x = sp.Symbol("x")
        y = sp.Function("y")
        
        # obtenemos la ecuacion
        ec = self.ec
        
        # convertimos en expresion
        ec = sp.sympify(ec)
        
        # remplazamos
        res = ec.subs({x:xi, y(x):yi})
        
        # retornamos el resultado
        return res
    
    def solve(self, val):
        """
        Resolvemos valor inicial
        """
        
        # hacemos casting
        val = float(val)
        c = int(self.c)
        
        # Obtenemos los symbolos
        x = sp.Symbol("x")
        y = sp.Function("y")
        C1 = sp.Symbol("C1")
        
        # resolvemos
        ec = self.res
        ec = ec.subs({ x:val, C1:c })
        
        # obtenemos el valor de y
        res = sp.solve(ec)
        
        # retornamos el valor
        return res[0][y(val)]
    
    
    def euler(self, inicial, final, n):
        """
        Resolvemos por metodo de euler
        """
        
        # expresion
        expr = ""
        
        # hacemos casting
        inicial = int(inicial)
        final = int(final)
        
        # Obtenemos h
        h = (final - inicial) / float(n)
        
        # Obtenemos los puntos en x
        x = []
        for i in range(0, int(n) + 1):
            # Obtenemos xi
            xi = inicial + i*h
            # almacenamos xi
            x.append(xi)
        
        
        # Obtenemos los puntos en y
        y = []
        ec = []
        y.append(self.solve(x[0])) # valor de y0
        ec.append(self.solve(x[0]))
        for i in range(0, int(n)) :
            # obtenemos la derivada
            diff = self.f(x[i], y[i])
            # Obtenemos xi
            yi = y[i] + (h*diff)
            eci = self.solve(x[i + 1])
            # armamos la expresion
            expr += "x("+str(x[i])+")     y("+str(y[i])+")\n"
            # almacenamos xi
            y.append(yi)
            ec.append(eci)
            
        
        # agregamos los ultimos resultados
        expr += "x("+str(x[int(n)])+")     y("+str(y[int(n)])+")\n"
        
        # almacenamos
        self.px = x
        self.py = y
        self.pec = ec
        self.exprPoints = expr
        self.inicial = inicial
        self.final = final
        
    def taylor(self, inicial, final, n):
        """
        Resolvemos por metodo de taylor
        """
        
        # expresion
        expr = ""
        
        # hacemos casting
        inicial = int(inicial)
        final = int(final)
        
        # Obtenemos h
        h = (final - inicial) / float(n)
        
        # Obtenemos x y y
        x = self.px # puntos en x
        py = self.py
        
        # Obtenemos los puntos en y
        y = []
        y.append(self.solve(x[0])) # valor de y0
        for i in range(0, int(n)) :
            # obtenemos la derivada
            diff = self.f(x[i], y[i])
            # Obtenemos xi
            yi = y[i] + (h*diff) + ((h*h)/self.factorial(2))*(1 - x[i] + y[i])
            # expresion
            expr += "x("+str(x[i])+")     y("+str(py[i])+")  (taylor)y("+str(y[i])+")\n"
            # almacenamos xi
            y.append(yi)
            
        
        # agregamos los ultimos resultados
        expr += "x("+str(x[int(n)])+")     y("+str(py[int(n)])+")  (taylor)y("+str(y[int(n)])+")\n"
        
        self.pt = y
        self.exprPoints = expr
            
            
    def factorial(self, n):
        """
        Obtenemos el factorial de n
        """
        
        res = 1
        
        for i in range(1, n +1) :
            res *= i
            
        return res