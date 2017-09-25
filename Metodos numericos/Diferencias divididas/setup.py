"""
from distutils.core import setup

setup(name='Metodo de biseccion',
    version='1.0.0',
    description='Metodo iterativo de biseccion',
    author='Paulo Andrade',
    author_email='source.compu@gmail.com',
    license='GPL',
    packages=['principal'],
    scripts=[
    'bin/setup',
    ],
    )
"""

from cx_Freeze import setup, Executable
 
setup(
 name="Biseccion",
 version="0.0.1",
 description="Metodo iterativo de biseccion",
 executables = [Executable("principal/main.py")],
 )

# python setup.py install