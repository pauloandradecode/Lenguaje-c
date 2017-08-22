#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Mon Aug 21 20:53:52 2017

@author: Paulo Andrade

Conocido también como de corte binario, de partición de intervalos o de
Bolzano, es un tipo de búsqueda incremental en el que el intervalo se
divide siempre a la mitad
"""

class Biseccion:
    def __init__(self, inicial = 0, final = 0, error = 0.001):
        """ Constructor de la clase """
        self.intervaloInicial = inicial
        self.intervaloFinal = final
        self.error = error
        
    def f(self, x):
        """ f(x) a resolver """
        return x**3 + x**2 + 10;
    
    def intervalo(self):
        # Estimamos la raiz de la ecuación
        r = (self.intervaloInicial + self.intervaloFinal) / 2.0
        
        # Comprobamos si hay cambio de signo entre el limite inferior y el
        # punto medio
        if self.f(self.intervaloInicial) * self.f(r) > 0:
            self.intervaloInicial = r
            self.intervalo()
        else :
            self.intervaloFinal = r
            print "\n["+str(self.intervaloInicial)+","+str(r)+"]"
            
            
    
    def estimate(self):
        # Estimacion inicial de la raiz
        r = (self.intervaloInicial + self.intervaloFinal) / 2.0
        print "Xr = (" + str(self.intervaloInicial) + ") + (" + str(self.intervaloFinal) + ") / 2 = " + str(r)
        print "f(" + str(r) + ") = " + str(self.f(r)) + "\n"
        
        # Verificamos el resultado de f(x) y ajustamos el intervalo
        if self.f(r) > 0 : self.intervaloFinal = r
        else: self.intervaloInicial = r
            
        # Verificamos la raiz con el error estimado
        if abs(self.f(r)) > self.error : return self.estimate()
        else : return r