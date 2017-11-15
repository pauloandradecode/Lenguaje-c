#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Fri Nov 10 09:49:03 2017

@author: paulo
"""

from MN.DifFin import DifFin
from MN.DifDiv import DifDiv
from MN.Newton import Newton
import sympy as sp

class DifNumericaPares:
    def __init__(self, dato1=None, dato2=None, pares=2, grado=2):
        """
        Constructor de la clase
        """
        
        self.dato1 = dato1 # f(x)
        self.dato2 = dato2 # x
        self.pares = int(pares) # pares de datos dados
        self.grado = int(grado) # grado ecuacion a interpolar
        self.diferencias = "" # Cadena para mostrar resultados de difrencias
        self.res = [] # valores para r (error)
        
    def processDiferencias(self):
        """
        Obtenemos las diferencias [infinitas / divididas]
        """
        
        # obtenemos las diferencias a utilizar
        control = self.defineDiferencias()
        
        # resolvemos
        if control :
            # diferencias finitas
            self.df = DifFin(self.dato1, self.dato2, self.pares, self.grado)
            
            # Obtenemos las diferencias finitas
            self.df.difFin()
            self.diferencias = self.df.expr # cadena
            #self.data = self.df.data # diferencias finitas
        else :
            # diferencias dividas
            self.dd = DifDiv(self.dato1, self.dato2, self.pares)
            
            # obtenemos las diferencias divididas
            self.dd.difDiv()
            self.diferencias = self.dd.expr
            
            
    def processValueFinitas(self, x):
        """
        Obtenemos la ecuacion y el valor a interpolar por d finitas
        """
        
        # Obtenemos la ecuacion
        self.df.fAdelante(int(x))
        self.ec = self.df.ec
        self.ecRed = self.df.ecRed
        self.ecuaciones = self.df.ecuaciones
        
        # Obtenemos el valor
        self.value = self.df.calculate()
        
        # obtenemos los valores de r
        self.r(x)
        
        
    def processValueDivididas(self, x):
        """
        Obtenemos la ecuacion y el valor a interpolar por d divididas
        """
        
        # procesamos las diferencias divididas
        self.dd.difDiv()
        
        # Newton
        # diferencias finitas
        nw = Newton(self.dato1, self.dato2, self.pares, self.grado)
        
        expr = nw.createExpr()
        self.ec = nw.ec
        self.ecRed = nw.ecRed
        
        # Obtenemos el valor
        self.value = self.dd.f(self.ec, x)
        self.ecuaciones = nw.ecuaciones
        
        # obtenemos los valores de r
        self.r(x)
        
        
    def defineDiferencias(self):
        """
        Verificamos que tipo de diferencias utilizar
        """
        
        # obtenemos la h
        x = self.dato2
        h = (int(x[len(x) - 1].get()) - int(x[1].get())) / (len(x) - 2)
        # control para las diferencias (true - finitas/false - divididas)
        control = True
        
        # comprobamos que diferencias utilizar
        for i in range(1, len(self.dato2) - 2) :
            if (int(self.dato2[i + 1].get()) - int(self.dato2[i].get())) != h :
                control = False
                
        
        # retornamos el resultado
        return control
    
    
    def r(self, n):
        """
        Obtenemos el valor del error
        """
        
        self.res = []
        
        dd = DifDiv(self.dato1, self.dato2, self.pares)
        # obtenemos las diferencias divididas
        dd.difDiv()
        data = dd.data
        
        ec = ""; # ecuacion
        derivate = [] # derivadas
        
        # verificamos la ecuacion con la que vamos a trabajar
        if self.grado == 1 :
            ec += "(x - x0)*(x - x1)"
        elif self.grado == 2 :
            ec += "(x - x0)*(x - x1)*(x - x2)"
        elif self.grado >= 3 :
            ec += "(x - x0)*(x - x1)*(x - x2)*(x - x3)"
            
        # simbolos
        x = sp.Symbol("x")
        x0 = sp.Symbol("x0")
        x1 = sp.Symbol("x1")
        x2 = sp.Symbol("x2")
        x3 = sp.Symbol("x3")
        
        # control de acceso a divididas
        control = 0
        controlSecundario = 0
        
        # Obtenemos el grado de la ecuacion
        grado = 3
        if self.grado <= 3 :
            grado = self.grado
        
        # Obtenemos el f[x0, x1, x2, ..., xn]
        for i in range(0, grado) :
            # actualizamos el control
            control = controlSecundario
            controlSecundario += self.grado - i
            
        # Agregamos la ecuacion
        derivate.append(ec+"*"+str(data[control]))
        
        # Obtenemos las derivadas
        for i in range(0, grado) :
            # Obtenemos la derivada
            temp = sp.diff(ec, x, i + 1)
            cad = str(temp)+"*"+str(data[control])
            
            # almacenamos
            derivate.append(cad)
            
        # Obtenemos los resultados
        for i in range(0, len(derivate)) :
            ec = str(derivate[i]) # convertimos a cadena
            ec = sp.sympify(ec) # convertimos a expresion
            
            # resolvemos
            if grado == 3 :
                self.res.append(ec.subs([(x,n),(x0, self.dato2[1].get()),
                                   (x1, self.dato2[2].get()),
                                   (x2, self.dato2[3].get()),
                                   (x3, self.dato2[4].get())]))
            elif grado == 2 :
                self.res.append(ec.subs([(x,n),(x0, self.dato2[1].get()),
                                   (x1, self.dato2[2].get()),
                                   (x2, self.dato2[3].get())]))
            elif grado == 1 :
                self.res.append(ec.subs([(x,n),(x0, self.dato2[1].get()),
                                   (x1, self.dato2[2].get())]))
    

    def f(self, ec, n):
        """
        f(x) a resolver
        """
        
        x = sp.Symbol("x") # convertimos de variable a simbolo
        ec = str(ec) # Convertimos en cadena
        ec = sp.sympify(ec) # Convertimos a expresión
        return ec.subs(x, n) #resolvemos