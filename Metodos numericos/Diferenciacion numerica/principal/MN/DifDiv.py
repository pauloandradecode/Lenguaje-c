#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Mon Sep 18 22:10:42 2017

@author: paulo
"""

import sympy as sp

class DifDiv:
    def __init__(self, dato1=[], dato2=[], pares=2):
        self.dato1 = dato1
        self.dato2 = dato2
        self.pares = int(pares) # Datos pares
        self.grado = 0 # Grado de la ecuacion
        self.data = [] # datos por diferencias divididas
        self.expr = "";
        
    def f(self, ec, n):
        """
        f(x) a resolver
        """
        
        x = sp.Symbol("x") # convertimos de variable a simbolo
        ec = str(ec) # Convertimos en cadena
        ec = sp.sympify(ec) # Convertimos a expresión
        return ec.subs(x, n) #resolvemos
    
    def fdx(self, x0, x1, fx0, fx1):
        """
        Aproximacion de la derivada
        """
        
        return (fx1 - fx0) / (x1 - x0)
    
    def createExpr(self):
        """
        Procesamos los datos para crear la expresión
        con el método de aproximacion de Newton
        """
        
        # Obtenemos los valores para a0, a1,..., an
        # y el grado de la ecuacion
        self.difDiv()
        
        # retornamos
        return self.expr
        
    def difDiv(self):
        """
        Obtenemos a1, a2, ..., an medinate
        el metodo de diferencias divididas
        """
        
        controlInicial = self.pares - 1 # Control de primeros ciclos
        data = [] # Guardamos los datos obtenidos
        suma = 0; # Suma de datos
        expr = "";
            
        # Obtenemos primeras divididas
        expr += "DD 1: ";
        ctr = 0
        for i in range(0, controlInicial) :
            expr += "f["
            for k in range (ctr, ctr + 2):
                if k == (ctr + 1):
                    expr += str(k);
                else :
                    expr += str(k)+",";
            expr += "] = "
            val = self.fdx(sp.Float(self.dato2[i + 1].get()),
                     sp.Float(self.dato2[i + 2].get()),
                     sp.Float(self.dato1[i + 1].get()),
                     sp.Float(self.dato1[i + 2].get()))
            
            suma += val
            ctr += 1
            expr += str(round(val,4))+", ";
            data.append(val)
            
        # Verificamos el grado de la ecuacion
        if suma != 0.0 :
            self.grado += 1
        
        control = 0 # Controla el acceso a data
        controlPares = self.pares # control pares
        # Obtenemos las segundas divididas en delante
        for j in range(2, self.pares) :
            expr += "\nDD "+str(j)+": ";
            indice = 1
            suma = 0 # Reseteamos la suma
            ctr = 0
            for i in range(j, self.pares) :
                expr += "f["
                for k in range (ctr, j + 1 + ctr):
                    if k == (j + ctr):
                        expr += str(k);
                    else :
                        expr += str(k)+",";
                expr += "] = "
                val = self.fdx(sp.Float(self.dato2[indice].get()),
                     sp.Float(self.dato2[i + 1].get()),
                     sp.Float(data[control + i - 2]),
                     sp.Float(data[control + i - 1]))

                indice += 1
                suma += val
                ctr += 1
                data.append(val)
                expr += str(round(val,4))+", ";
                
            # verificamos el grado de la ecuacion
            if suma != 0.0 :
                self.grado += 1
            
            controlPares = controlPares - 1
            control += controlPares - 1
            
        # guardamos los datos
        self.data = data
        self.expr = expr;
