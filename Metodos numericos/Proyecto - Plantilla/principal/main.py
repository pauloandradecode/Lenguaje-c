# -*- coding: utf-8 -*-
import os, sys

# Determinamos la ruta principal
def determine_path ():
    try:
        root = __file__
        if os.path.islink (root):
            root = os.path.realpath (root)
        return os.path.dirname (os.path.abspath (root))
    except:
        print "I'm sorry, but something is wrong."
        sys.exit ()
        
# Entrada del programa
def main ():
    print "module is running"
    print determine_path ()
    
# Indicamos que se trata del modulo principal
if __name__ == "__main__":
    print "Decide que hacer"
