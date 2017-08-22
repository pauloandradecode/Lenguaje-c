#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Mon Aug 21 20:43:27 2017

@author: Paulo Andrade
"""

from MN.Biseccion import Biseccion
        
# Entrada del programa
def main ():
    # Obtenemos el intervalo
    inicial = input("Inserte el intervalo inicial: ")
    final = input("Inserte el intervalo final: ")
    
    # Instanciamos
    bis = Biseccion(inicial, final)
    
    # Obtenemos el intervalo mas cercano a la raiz
    bis.intervalo()
    
    # calculamos e imprimimos la raiz
    print bis.estimate()
    
# Indicamos que se trata del modulo principal
if __name__ == "__main__":
    main()