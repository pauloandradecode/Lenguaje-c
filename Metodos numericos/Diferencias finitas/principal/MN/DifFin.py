#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Tue Sep 26 15:41:56 2017

@author: paulo
"""

import sympy as sp

class DifFin:
    def __init__(self, dato1=[], dato2=[], pares=2, grado=1, inicial=0):
        self.dato1 = dato1
        self.dato2 = dato2
        self.pares = int(pares) # Datos pares
        self.grado = int(grado) # grado de la ecuacion
        self.init = int(inicial) # par inicial
        self.data = [] # datos por diferencias finitas
    
    
    def createExpr(self):
        """
        Procesamos los datos para crear la expresión
        con el método de aproximacion de Newton
        """
        
        # Obtenemos las diferencias finitas de los datos pares
        self.difFin()
        
        # retornamos
        return self.expr
        
    def difFin(self):
        """
        Obtenemos a1, a2, ..., an medinate
        el metodo de diferencias finitas
        """
        
        controlInicial = self.pares - 1 # Control de primeros ciclos
        data = [] # Guardamos los datos obtenidos
        expr = ""; # resultados a mostrar
        
        # Empezamos a llenar la información
        expr += "D. F. 1: ";
            
        # Obtenemos primeras finitas
        for i in range(0, controlInicial) :
            # Obtenemos el f(x) de la dif finita
            expr += "f[" + str(i) + "] = "
            
            # Obtenemos el valor
            val = sp.Float(self.dato1[i + 2].get()) - sp.Float(self.dato1[i + 1].get())
            
            # Agregamos el valor a la expresion
            expr += str(round(val,4))+", ";
            
            # Almacenamos el valor
            data.append(val)
            
        
        control = 0 # Controla el acceso a data
        controlPares = self.pares # control para datos pares
        # Obtenemos las segundas finitas en delante
        for j in range(2, self.pares) :
            # Obtenemos el rango de finitas
            expr += "\nD. F. "+str(j)+": ";
            ctr = 0 # control para finitas de un solo rango
            
            # Recorremos el rango de pares de un rango de finitas
            for i in range(j, self.pares) :
                # Obtenemos el f(x) de la dif finitas
                expr += "f[" + str(ctr) + "] = "
                
                # Obtenemos el valor
                val = sp.Float(data[control + i - 1]) - sp.Float(data[control + i - 2])

                ctr += 1 # Aumentamos el control de rango de finitas
                data.append(val) # Almacenamos el dato
                expr += str(round(val,4))+", "; # Agregamos el valor a la expresion
                
            
            controlPares = controlPares - 1
            control += controlPares - 1
            
        # guardamos los datos
        self.data = data
        self.expr = expr;
