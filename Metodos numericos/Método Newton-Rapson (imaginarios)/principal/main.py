#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 29 22:31:57 2017

@author: paulo
"""

import tkinter as tk
from MN.GUI import GUI
from MN.NewtonRapson import NewtonRapson
import cmath as cm
import sympy as sp
        
# Entrada del programa
def main ():
    parent = tk.Tk()
    root = GUI(parent = parent)
    parent.destroy()
    
def console ():
    expr = raw_input("Ingrese la ecuacion: ")
    inicial = -cm.sqrt(-1)
    err = 0.001

    nr = NewtonRapson(0, expr, err)    
    raiz = cm.polar(compleja(nr, inicial, err))
    print cm.rect(raiz[0], raiz[1])
    
def compleja(nr, inicial, err):
    fxi = nr.f(inicial)
    fdxi = nr.fdx(inicial)
    
    com = inicial - ((fxi*(cm.sqrt(-1))) / (fdxi*(cm.sqrt(-1))))
    tempInicial = cm.polar(sp.sympify(inicial))
    tempInicial = cm.rect(sp.sympify(tempInicial[0]), sp.sympify(tempInicial[1]))
    tempCom = cm.polar(sp.sympify(com))
    tempCom = cm.rect(sp.sympify(tempCom[0]), sp.sympify(tempCom[1]))
    e = abs(tempInicial - tempCom)
    
    if e > err : return compleja(nr, com, err)
    else : return com
    
# Indicamos que se trata del modulo principal
if __name__ == "__main__":
    main()