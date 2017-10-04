#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Tue Oct  3 18:24:05 2017

@author: Paulo Andrade
"""

from MN.GausJordan import GausJordan
import numpy as np
import sympy as sp
import math as mt

class MinCua:
    def __init__(self, dato1=[], dato2=[], grado=1, inicial=0):
        self.dato1 = dato1
        self.dato2 = dato2
        self.grado = int(grado)
        self.init = int(inicial)
        self.pares = len(dato1) - 1
        self.matrix = [] # Matrices
        self.determinant = [] # Determinantes
        self.values = [] # valores
        self.ec = "" # Expresion
        self.ecuaciones = [] # Ecuaciones
        self.ecuacionesRed = [] # Ecuaciones reducidas
        
        
    def f(self, ec, n):
        """
        f(x) a resolver
        """
        
        x = sp.Symbol("x") # convertimos de variable a simbolo
        ec = str(ec) # Convertimos en cadena
        ec = sp.sympify(ec) # Convertimos a expresión
        return ec.subs(x, n) #resolvemos


    def prepareMatrix(self):
        """
        Preparamos los valores para la matriz
        grado 1 - 2 ecuaciones de 2 - y
        grado 2 - 3 ecuaciones de 3 - y*x
        grado 3 - 4 ecuaciones de 4 - y*x^2
        """
        
        sumx = [] # sumatorias de x
        sumy = [] # sumatorias de y
        potencias = 0 # limite de potencias a obtener
        yx = self.grado # limite de f(x)*x
        
        # Obtenemos el limite de potencias
        if self.grado == 1:
            # si es grado uno
            potencias = 4
        else :
            # Si es grado mayor a uno
            potencias = (self.grado * 2) + 1
        
        # Obtenemos las sumatorias de x
        for i in range(1, potencias + 1):
            # suma
            sum = 0
            # recorremos todos los pares de datos para la sumatoria
            for j in range(1, self.pares + 1):
                # sumamos
                sum += mt.pow(sp.Float(self.dato2[j].get()), i)
                
            # Añadimos la sumatoria a la lista
            sumx.append(sum)
            
            
        # Obtenemos las sumatorias de y
        for i in range(0, yx + 1):
            # suma
            sum = 0
            # recorremos todos los pares de datos para la sumatoria
            for j in range(1, self.pares + 1):
                # sumamos
                if i == 0:
                    sum += sp.Float(self.dato1[j].get())
                else :
                    sum += sp.Float(self.dato1[j].get()) * mt.pow(sp.Float(self.dato2[j].get()), i)
                
            # Añadimos la sumatoria a la lista
            sumy.append(sum)
            
        
        # Almacenamos los datos
        self.sumx = sumx
        self.sumy = sumy

    
    def createMatrix(self):
        """
        Creamos la matriz para trabajar
        """
        
        # Preparamos las matrices
        self.prepareMatrix()
        
        # verificamos el grado
        if self.grado > 3 : # por gaus jordan
            # Obtenemos m
            m = sp.Float(self.pares)
            # creamos la matriz vacia
            n = self.grado + 1 # rango para la matriz
            # matriz identidad
            A = [[0 for x in range(n)] for y in range(n)]
            # matriz con resultados
            b = []
            
            # Llenamos la matriz
            ctrPrincipal = 0 # control para x
            for i in range(0, self.grado + 1) :
                # Creamos las n matrices                    
                aux = []
                ctr = ctrPrincipal
                # llenamos cada columna
                for j in range(0, self.grado + 1):
                    if i == 0 and j == 0:
                        aux.append(m)
                        ctr = -1
                    else :
                        aux.append(self.sumx[ctr])
                    ctr += 1
                
                
                # Aumentamos el ctr principal
                if i == 0 :
                    ctrPrincipal = 0
                else :
                    ctrPrincipal += 1
                    
                # Agregamos a la matriz identidad
                A[i] = aux
                # Agregamos a la matriz resultados
                b.append(self.sumy[i])
            
            # Obtenemos los valores
            print A
            print b
            gj = GausJordan()
            self.sol = gj.solve(A, b)
            
            # verificamos el resultado
            if len(self.sol) > 0 : return True
            else : return False
        else : # por crammer
            return self.crammer()
        
    def createExpr(self):
        """
        Creamos la expresión (función)
        """

        if self.grado > 3 :
            expr = "" # Expresión
            exprRed = "" # Expresión reducida
            
            # Obtenemos los resultados
            for k in range(0, self.grado + 1) :
                # Obtenemos el valor
                val = self.sol[k]
                # verificamos el signo
                if val > 0 and k != 0 :
                    expr += "+"
                    exprRed += "+"
                # agregamos a la expresion
                expr += str(val)+"*x**"+str(k)
                exprRed += str(sp.Float(val, 2))+"*x**"+str(k)
                
                # Almacenamos informacion
                self.values.append(val)
                if k != 0 :
                    self.ecuaciones.append(expr)
                    self.ecuacionesRed.append(expr)
                
            
            # almacenamos la informacion
            self.ec = expr
            
            return expr
        else :
            return self.createExprCrammer()
            
    def crammer(self):
        """
        Creamos las matrices para trabajar
        """
        
        matrix = [] # creamos una lista para matrices
        determinant = [] # creamos una lista para las determinantes
        
        # creamos la matriz de la determinante
        d = np.zeros(shape=(self.grado + 1, self.grado + 1))
        
        # Creamos las matrices (determinante + n matrices)
        for k in range(0, self.grado + 1) :
            # Creamos una matriz vacia
            a = np.zeros(shape=(self.grado + 1, self.grado + 1))
            
            if k == 0 :
                # Llenamos la matriz
                for i in range(self.init + 1, self.init + self.grado + 2) :
                    # Creamos las n matrices                    
                    aux = []
                    # llenamos cada columna
                    for j in range(0, self.grado + 1):
                        aux.append(mt.pow(sp.Float(self.dato2[i].get()), j))
                            
                        
                    d[i - (self.init +1)] = aux
                
                
                if np.linalg.det(d) == 0: return False
                
                #print d
                #print np.linalg.det(d)
                matrix.append(d) # Almacenamos la matriz
                determinant.append(np.linalg.det(d)) # Almacenamos la determinante
            
            # Llenamos la matriz
            for i in range(self.init + 1, self.init + self.grado + 2) :
                # Creamos las n matrices                    
                aux = []
                # llenamos cada columna
                for j in range(0, self.grado + 1):
                    if k == j :
                        aux.append(sp.Float(self.dato1[i].get()))
                    else :
                        aux.append(mt.pow(sp.Float(self.dato2[i].get()), j))
                        
                    
                a[i - (self.init +1)] = aux
            
            
            #print a
            #print np.linalg.det(a)
            matrix.append(a) # Almacenamos la matriz
            determinant.append(np.linalg.det(a)) # Almacenamos la determinante
        

        # Guardamos la informacion
        self.matrix = matrix
        self.determinant = determinant
        
        return True
            
    def createExprCrammer(self):
        """
        Creamos la expresión (función)
        """
        
        expr = "" # Expresión
        exprRed = "" # Expresion reducida
        
        # Obtenemos los resultados
        for k in range(1, self.grado + 2) :
            # Obtenemos el valor
            val = self.determinant[k] / self.determinant[0]
            # verificamos el signo
            if val > 0 and k != 1 :
                expr += "+"
                exprRed += "+"
            # agregamos a la expresion
            expr += str(val)+"*x**"+str(k - 1)
            exprRed += str(sp.Float(val, 2))+"*x**"+str(k - 1)
            
            # Almacenamos informacion
            self.values.append(val)
            if k != 1 :
                self.ecuaciones.append(expr)
                self.ecuacionesRed.append(exprRed)
            
        
        # almacenamos la informacion
        self.ec = expr
        
        return expr