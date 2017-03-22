/*
Declaración

Fecha: 21/03/2017
Nota: Pilas con arrays - Estructura lineal
*/

#ifndef Stack_hpp
#define Stack_hpp

#include <cstdio>

class Stack
{
    int *array; // Implementacion de la pila (array)
    int _n; // Capacidad de la pila
    int _s; // Tamaño de la pila

    public:
        // Constructor
        Stack(int);
        // Destructor
        ~Stack();

        // Funciones de utileria
        int capacity() const { return _n; } // Obtenemos capacidad
        int size() const { return _s; } // Obtenemos tamaño
        bool empty() { return _s == 0; } // Vacuidad
        bool full() { return _s == _n; } // Plenitud

        // Operaciones de la pila (LIFO)
        void push(int);
        int pop();
        int top();
};

#endif /* Stack_hpp */

