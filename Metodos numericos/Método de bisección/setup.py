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

# python setup.py install