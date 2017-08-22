# -*- coding: utf-8 -*-
import os, sys

def determine_path ():
    """Borrowed from wxglade.py"""
    try:
        root = __file__
        if os.path.islink (root):
            root = os.path.realpath (root)
        return os.path.dirname (os.path.abspath (root))
    except:
        print "I'm sorry, but something is wrong."
        print "There is no __file__ variable. Please contact the author."
        sys.exit ()
        
def main ():
    print "module is running"
    print determine_path ()
    
if __name__ == "__main__":
    print "Decide what to do"
