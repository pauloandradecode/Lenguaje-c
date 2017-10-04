#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 29 22:32:25 2017

@author: paulo
Metodo de la regla falsa:
    
   Este método, como en el método de la bisección, parte de
   dos puntos que rodean a la raíz f(x) = 0, es decir, dos
   puntos x0 y x1 tales que f(x0)f(x1) < 0.
   
   La siguiente aproximación, x2, se calcula como la intersección
   con el eje X de la recta que une ambos puntos (empleando la
   ecuación (35) del método de la secante).
"""

import sympy as sp
import cmath as cm

class ReglaFalsa:
    def __init__(self, xi = 0, xd = 0,
                 ecuacion="x**3 + x**2 + 10", err = 0.001,
                 treeView=None):
        """
        Constructor de la clase
        """
        
        self.xi = sp.sympify(sp.Float(xi)) # limite inferior
        self.xd = sp.sympify(sp.Float(xd)) # limite superior
        self.xdRes = sp.sympify(sp.Float(xd)) # respaldo limite inferior
        self.xiRes = sp.sympify(sp.Float(xi)) # limite temporal
        self.err = sp.sympify(sp.Float(err)) # margen de error
        self.ec = str(ecuacion).lower() # ecuacion
        self.root = 0 # raices racionales
        self.complex = [] # raices complejas
        self.tree = treeView
        
    def roots(self):
        """
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
    
    def xm(self, xi, xd):
        """
        Formula para obtener la aproximacion de la raiz
        """
        
        return (xd)-(((xd - xi)*self.f(xd)) / (self.f(xd)-self.f(xi)))
    
    def intervalo(self):
        """
        A partir de los valores dados, calculamos un intervalo inicial
        """
        
        xr = (self.xi + self.xd) / 2 # Obtenemos el punto medio
        fxi = self.f(self.xi) # funcion de xi
        fxr = self.f(xr) # funcion de xr
        
        # Verificamos que el intervalo este bien definido
        if self.xi < self.xd :
            # Verificamos si hay cambio de signo
            if fxi * fxr < 0:
                # Si hay cambio de signo, la raiz se encuentra en este rango
                self.xd = xr
            elif fxi * fxr > 0:
                # si no hay cambio de signo, recalculamos el intervalo
                self.xi = xr
                self.intervalo()
            elif fxi * fxr == 0:
                # Si es igual a 0, la raiz es 0
                return 2
        else :
            # No tiene raices en ese intervalo
            return 3
        
        return 1
    
    def estimate(self, count):
        fxi = self.f(self.xi) # funcion de xi
        fxd = self.f(self.xd) # funcion de xd
        xm = self.xm(self.xi, self.xd) # obtenemos xm
        fxm = self.f(xm) # funcion de xm
        
        # Colocamos un separador si el contador es uno
        if count == 1:
            item = self.tree.insert("", 0, text="--", values=("------",
                "------", "------", "------", "------"))
        
        # Mostramos la informacion
        item = self.tree.insert("" , (count - 1), text=str(count), values=(
                "["+str(sp.Float(self.xi, 5))+", "+str(sp.Float(self.xd, 5))+"]",
                "f(" + str(sp.Float(self.xi, 8)) + ") = " + str(sp.Float(fxi, 8)),
                "f(" + str(sp.Float(self.xd, 8)) + ") = " + str(sp.Float(fxd, 8)),
                str(sp.Float(xm, 4)),
                "f(" + str(sp.Float(xm, 8)) + ") = " + str(sp.Float(fxm, 8))
            ))
        
        # Obtenemos el nuevo intervalo
        if fxi < 0 :
            self.xi = xm
        if fxd < 0 :
            self.xd = xm
        
        # Verificamos la raiz con el error estimado
        count += 1 # Aumentamos el contador
        self.tree.selection_set(item) # Seleccionamos la ultima fila
        
        # verificamos el error
        if abs(fxm) > self.err : return self.estimate(count)
        else: return xm