#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Tue Sep  5 17:47:38 2017

@author: Paulo Andrade
x**3 + 2*x**2 + 10*x - 20
"""

import numpy as np
import sympy as sp
import cmath as cm

class NewtonRapson:
    def __init__(self, inicial, ecuacion, err=0.001, treeView=None):
        """
        Constructor de la clase
        """
        
        self.inicial = sp.sympify(sp.Float(inicial)) # valor inicial
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
        #return ec.subs(x, n) #resolvemos
        return ec.evalf(subs={x: n})
    
    def fdx(self, n):
        """
        f'(x) a resolver
        """
        
        x = sp.Symbol("x") # convertimos de variable a simbolo
        ec = str(self.ec) # Convertimos en cadena
        ec = sp.sympify(self.ec) # Convertimos a expresión
        dx = sp.diff(ec, x) # Obtenemos la derivada
        #return dx.subs(x, n) #resolvemos
        return dx.evalf(subs={x: n})
    
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
        Realizamos los calculos de la raiz real
        """
        
        xi = self.inicial # Obtenemos valor inicial
        fxi = self.f(xi) # f(xi)
        fdxi = self.fdx(xi) # f'(xi)
        g = self.g(xi) # Obtenemos g(x)
        
        # Colocamos un separador si el contador es uno
        if count == 1:
            item = self.tree.insert("", 0, text="--", values=("------",
                "------", "------", "------", "------"))
        
        # Mostramos la informacion
        item = self.tree.insert("" , (count - 1), text=str(count), values=(
                str(sp.Float(xi, 6)),
                "f(" + str(sp.Float(xi, 8)) + ") = " + str(sp.Float(fxi, 8)),
                "f'(" + str(sp.Float(xi, 8)) + ") = " + str(sp.Float(fdxi, 8)),
                "g(x) = " + str(sp.Float(g, 8))
            ))
        
        # Verificamos la raiz con el error estimado
        count += 1 # Aumentamos el contador
        self.tree.selection_set(item) # Seleccionamos la ultima fila
        
        # verificamos el error
        if abs(g - xi) > self.err :
            self.inicial = g # Cambiamos el valor inicial
            return self.estimate(count)
        else: return g