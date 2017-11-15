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
        self.type = "" # tipo de diferencia finita
        self.expr = "" # expresion diferencias finitas
        self.ec = "" # ecuacion
        self.ecuaciones = [] # Ecuaciones para graficar
        
        
    def initComponent(self, xn) :
        """
        Obtenemos el grado y el par inicial para la ecuacion
        """
        
        inicio = 0;
        
        # Calculamos cual es valor mas cercano del pivote
        for i in range(1, self.pares + 1) :
            # Obtenemos el valor de f(x)
            fdx = sp.Float(self.dato2[i].get())
            # verificamos si es menor el pivote
            if fdx < xn :
                inicio = i
                
        grado = 0
                
        # calculamos el grado
        if inicio <= (self.pares / 2) :
            grado = (self.pares - 1) - inicio
            self.type = "adelante"
        else :
            # Si es igual al numero de datos pares disminuimos
            if inicio == self.pares :
                inicio -= 1
            grado = inicio
            self.type = "atras"
            
        # Comprobamos el grado
        #if grado < self.grado :
            #self.grado = grado
            
        # Calculamos el inicio
        self.init = inicio
        
        # Calculamos la expresion
        if self.type == "adelante" :
            self.fAdelante(xn)
        else :
            self.fAtras(xn)
        
        
    def fAdelante(self, xn):
        """
        Obtenemos la ecuacion para calculos
        """
        
        self.ecuaciones = [] # Limpiamos la lista
        
        # Obtenemos s
        s = self.s(xn)
        
        # control de acceso a data
        controlPares = self.pares
        control = 0 # control de acceso a datos
        expr = ""
        exprRed = ""
        ecuacion = "" # ecuacion para graficar
        h = sp.Float(self.dato2[2].get()) - sp.Float(self.dato2[1].get())
        
        # formamos la expresion - recorremos segun el grado
        for i in range(1, self.grado + 2) :
            for j in range(0, i) :
                # verificamos si es el primer ciclo
                if i == 1:
                    # Agregamos solo el f(x)
                    expr += str(self.dato1[self.init + 1].get())
                    exprRed += str(self.dato1[self.init + 1].get())
                    ecuacion += str(self.dato1[self.init + 1].get())
                else :
                    # Agregamos la diferencia finita a la expresion
                    if j == 0 :
                        # validamos el signo
                        if self.data[control + self.init] >= 0 :
                            expr += "+"
                            exprRed += "+"
                            ecuacion += "+"
                            
                        # Formamos la primera parte de la expresion
                        expr += str(self.data[control + self.init])
                        exprRed += str(round(self.data[control + self.init], 4))
                        ecuacion += str(round(self.data[control + self.init], 2))
                    
                    if i == 2 and j == 0:
                        # agregamos (s) si es de grado 1 
                        expr += "*"+str(s)
                        exprRed += "*"+str(round(s, 4))
                        ecuacion += "*"+"((x - "+str(round(sp.Float(self.dato2[self.init + 1].get()),4))+") / "+str(round(sp.Float(h), 4))+")"
            if i > 2 :
                expr += "*(("+str(s)
                exprRed += "*(("+str(round(s, 4))
                ecuacion += "*(("+"((x - "+str(round(sp.Float(self.dato2[self.init + 1].get()), 2))+") / "+str(round(sp.Float(h), 4))+")"
            
                # Agregamos la formula de s
                fac = 1
                for k in range(1, i - 1) :
                    expr += "*("+str(s)+"-"+str(k)+")"
                    exprRed += "*("+str(round(s, 4))+"-"+str(round(k, 4))+")"
                    ecuacion += "*("+"((x - "+str(round(sp.Float(self.dato2[self.init + 1].get()),2))+") / "+str(round(h,4))+")-"+str(k)+")"
                    fac += 1
                    
                expr += ") / "+str(self.factorial(fac))+")"
                exprRed += ") / "+str(round(self.factorial(fac), 4))+")"
                ecuacion += ") / "+str(round(self.factorial(fac), 4))+")"
            if i > 1 :
                # actualizamos el control de acceso a data
                controlPares = controlPares - 1
                control += controlPares
            
        # almacenamos la ecuacion
        self.ec = expr
        self.ecRed = exprRed
        # print ecuacion
        self.ecuaciones.append(sp.expand(sp.simplify(sp.sympify(ecuacion))))
    
    
    def fAtras(self, xn):
        """
        Obtenemos la ecuacion para calculos
        """
        
        # Obtenemos s
        s = self.s(xn)
        
        # control de acceso a data
        controlPares = self.pares
        control = 0 # control de acceso a datos
        controlInit = self.init
        expr = ""
        exprRed = ""
        
        # formamos la expresion - recorremos segun el grado
        for i in range(1, self.grado + 2) :
            for j in range(0, i) :
                # verificamos si es el primer ciclo
                if i == 1:
                    expr += str(self.dato1[self.init + 1].get())
                    exprRed += str(self.dato1[self.init + 1].get())
                else :
                    # Agregamos f(x) a la expresion
                    if j == 0 :
                        # validamos el signo
                        if self.data[control + controlInit] >= 0 :
                            expr += "+"
                            exprRed += "+"
                            
                        # Formamos la primera parte de la expresion
                        expr += str(self.data[control + controlInit])
                        exprRed += str(round(self.data[control + controlInit], 4))
                    
                    if i == 2 and j == 0:
                        expr += "*"+str(s)
                        exprRed += "*"+str(round(s, 4))
            if i > 2 :
                expr += "*(("+str(s)
                exprRed += "*(("+str(round(s, 4))
            
                # Agregamos la formula de s
                fac = 1
                for k in range(1, i - 1) :
                    expr += "*("+str(s)+"+"+str(k)+")"
                    exprRed += "*("+str(round(s, 4))+"+"+str(round(k, 4))+")"
                    fac += 1
                    
                expr += ") / "+str(self.factorial(fac))+")"
                exprRed += ") / "+str(round(self.factorial(fac), 4))+")"
            if i > 1 :
                # actualizamos el control de acceso a data
                controlPares = controlPares - 1
                control += controlPares
            
            # Disminuimos el control
            controlInit -= 1
            
        # almacenamos la ecuacion
        self.ec = expr
        self.ecRed = exprRed
    
        
    def factorial(self, n):
        """
        Obtenemos el factorial de n
        """
        
        res = 1
        
        for i in range(1, n +1) :
            res *= i
            
        return res
    
    
    def s(self, x):
        """
        Obtenemos el valor de s
        x = valor a buscar
        """
        
        # Obtenemos h
        h = sp.Float(self.dato2[2].get()) - sp.Float(self.dato2[1].get())
        
        return (x - sp.Float(self.dato2[self.init + 1].get())) / h
    
    
    def calculate(self):
        """
        calculamos el valor dado
        """
        
        return round(sp.sympify(self.ec), 4)
    
    
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
        expr = "" # resultados a mostrar
        
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
