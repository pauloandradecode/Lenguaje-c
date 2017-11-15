#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Tue Sep 12 13:08:52 2017

@author: Paulo Andrade
"""

from MN.GausJordan import GausJordan
import numpy as np
import sympy as sp
import math as mt

class Interpolacion:
    def __init__(self, dato1=[], dato2=[], grado=1, inicial=0):
        self.dato1 = dato1
        self.dato2 = dato2
        self.grado = int(grado)
        self.init = int(inicial)
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
    
    def createMatrix(self):
        """
        Creamos la matriz
        """
        
        # verificamos el grado
        if self.grado > 3 :
            # creamos la matriz vacia
            n = self.grado + 1
            A = [[0 for x in range(n)] for y in range(n)]
            b = []
            
            # Recorremos para llenar la matriz
            for k in range(0, self.grado + 1) :            
                # Llenamos la matriz
                for i in range(self.init + 1, self.init + self.grado + 2) :
                    # Creamos las n matrices                    
                    aux = []
                    # llenamos cada columna
                    for j in range(0, self.grado + 1):
                        aux.append(mt.pow(sp.Float(self.dato2[i].get()), j))
                            
                        
                    A[i - (self.init +1)] = aux
                b.append(sp.Float(self.dato1[k+1].get()))
            
            # Obtenemos los valores
            gj = GausJordan()
            self.sol = gj.solve(A, b)
            
            # verificamos el resultado
            if len(self.sol) > 0 : return True
            else : return False
        else :
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