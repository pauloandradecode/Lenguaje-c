#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 29 22:31:57 2017

@author: Paulo Andrade
"""

import tkinter as tk
from MN.GUI import GUI
        
# Entrada del programa
def main ():
    parent = tk.Tk()
    root = GUI(parent = parent)
    parent.destroy()
    
# Indicamos que se trata del modulo principal
if __name__ == "__main__":
    main()