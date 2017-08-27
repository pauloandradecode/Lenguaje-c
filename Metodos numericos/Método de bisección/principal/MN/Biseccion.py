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
        
        # Estimamos la raiz de f(x) con el intervalo dado
        r = (self.intervaloInicial + self.intervaloFinal) / 2.0
        
        # Comprobamos si hay cambio de signo entre el limite inferior y el
        # punto medio
        if self._f(self.intervaloInicial, self.ec) * self._f(r, self.ec) > 0:
            # Si no hay cambio asignamos punto medio como limite inferior
            self.intervaloInicial = r
            # Volvemos a estimar la raiz
            self.intervalo()
        else :
            # Si hay cambios, asignamos como limite superior el punto medio
            self.intervaloFinal = r
    
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