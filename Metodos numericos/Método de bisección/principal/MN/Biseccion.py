#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Mon Aug 21 20:53:52 2017

@author: Paulo Andrade

Conocido también como de corte binario, de partición de intervalos o de
Bolzano, es un tipo de búsqueda incremental en el que el intervalo se
divide siempre a la mitad
"""

import sympy as sp

class Biseccion:
    def __init__(self, inicial = 0, final = 0,
                 ecuacion="x**3 + x**2 + 10", error = 0.001):
        """ Constructor de la clase """
        self.intervaloInicial = sp.sympify(inicial) # limite inferior
        self.intervaloFinal = sp.sympify(final) # limite superior
        self.error = sp.sympify(error) # margen de error
        self.ec = ecuacion # ecuacion
    
    def _f(self, n, ec):
        """ f(x) a resolver """
        x = sp.Symbol("x") # convertimos de variable a simbolo
        ec = str(ec) # Convertimos en cadena
        ec = sp.sympify(ec) # Convertimos a expresión
        return ec.subs(x, n) #resolvemos
    
    def intervalo(self):
        """ Obtenemos el subintervalo en el que se encuentra la raiz """
        
        # Verificamos el grado del polinomio
        x = sp.Symbol("x")
        res = sp.solve(sp.sympify(self.ec), x)
        grade = len(res)
        if grade % 2 == 0 :
            # verificamos el valor del intervalo inicial
            if self.intervaloInicial < 0:
                # Intercambiamos los intervalos
                aux = self.intervaloInicial
                self.intervaloInicial = self.intervaloFinal
                self.intervaloFinal = aux
    
    def _estimate(self, treeView, count):
        """
        Con el subintervalo ya definido, estimamos la raiz de f(x)
        hasta cierto margen de error
        """
        
        # Estimacion inicial de la raiz
        r = (self.intervaloInicial + self.intervaloFinal) / 2.0
        
        # Mostramos la informacion
        item = treeView.insert("" , (count - 1), text=str(count), values=(
                "["+str(sp.Float(self.intervaloInicial, 8))+", "+str(sp.Float(self.intervaloFinal, 8))+"]",
                "f(" + str(sp.Float(r, 8)) + ") = " + str(self._f(r, self.ec)),
                str(r)))
        
        # Verificamos el resultado de f(x) y ajustamos el intervalo
        if self._f(r, self.ec) > 0 : self.intervaloFinal = r
        else: self.intervaloInicial = r
            
        # Verificamos la raiz con el error estimado
        count += 1 # Aumentamos el contador
        treeView.selection_set(item) # Seleccionamos la ultima fila
        if abs(self._f(r, self.ec)) > self.error : return self._estimate(treeView, count)
        else : return r