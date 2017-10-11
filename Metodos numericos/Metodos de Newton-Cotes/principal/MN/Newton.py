# -*- coding: utf-8 -*-
"""
Created on Tue Sep 19 17:15:51 2017

@author: plalex
"""

#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Mon Sep 18 22:10:42 2017

@author: paulo
"""

import sympy as sp

class Newton:
    def __init__(self, dato1=[], dato2=[], pares=2):
        self.dato1 = dato1
        self.dato2 = dato2
        self.pares = int(pares) # Datos pares
        self.ec = "" # Expresion
        self.ecRed = "" # Expresion reducida
        self.ecuaciones = [] # ecuaciones
        self.grado = 0 # Grado de la ecuacion
        self.data = [] # datos por diferencias dividisionales
        
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

        expr = str(self.dato1[1].get()) # Expresion
        exprRed = str(round(sp.Float(self.dato1[1].get()),4)) # Expresion
        
        # Obtenemos los valores para a0, a1,..., an
        # y el grado de la ecuacion
        self.difDiv()
        
        # control de acceso a data
        controlPares = self.pares
        control = 0
        
        # formamos la expresion
        for i in range(1, self.grado + 1) :
            for j in range(0, i) :
                if j == 0 :
                    if self.data[control] > 0 :
                        expr += "+"
                        exprRed += "+"
                    expr += str(self.data[control])
                    exprRed += str(round(sp.Float(self.data[control]), 4))
                
                expr += "* (x -"+str(self.dato2[j + 1].get())+")"
                exprRed += "* (x -"+str(round(sp.Float(self.dato2[j + 1].get()), 4))+")"
                
            # actualizamos el control de acceso a data
            controlPares = controlPares - 1
            control += controlPares
            
            # Guardamos las ecuaciones
            self.ecuaciones.append(sp.expand(sp.simplify(sp.sympify(exprRed))))
                
        # Guardamos la info
        self.ec = expr
        self.ecRed = sp.expand(sp.simplify(sp.sympify(exprRed)))
        
        # retornamos
        return exprRed
        
    def difDiv(self):
        """
        Obtenemos a1, a2, ..., an medinate
        el metodo de diferencias divididas
        """
        
        controlInicial = self.pares - 1 # Control de primeros ciclos
        data = [] # Guardamos los datos obtenidos
        suma = 0; # Suma de datos
            
        # Obtenemos primeras divididas
        for i in range(0, controlInicial) :
            val = self.fdx(sp.Float(self.dato2[i + 1].get()),
                     sp.Float(self.dato2[i + 2].get()),
                     sp.Float(self.dato1[i + 1].get()),
                     sp.Float(self.dato1[i + 2].get()))
            
            suma += val
            data.append(val)
            
        # Verificamos el grado de la ecuacion
        if suma != 0.0 :
            self.grado += 1
        
        control = 0 # Controla el acceso a data
        controlPares = self.pares # control pares
        # Obtenemos las segundas divididas en delante
        for j in range(2, self.pares) :
            indice = 1
            suma = 0 # Reseteamos la suma
            for i in range(j, self.pares) :
                val = self.fdx(sp.Float(self.dato2[indice].get()),
                     sp.Float(self.dato2[i + 1].get()),
                     sp.Float(data[control + i - 2]),
                     sp.Float(data[control + i - 1]))

                indice += 1
                suma += val
                data.append(val)
                
            # verificamos el grado de la ecuacion
            if suma != 0.0 :
                self.grado += 1
            
            controlPares = controlPares - 1
            control += controlPares - 1
            
        # guardamos los datos
        self.data = data
