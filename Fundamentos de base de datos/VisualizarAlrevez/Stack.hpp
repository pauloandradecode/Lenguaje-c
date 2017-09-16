#ifndef Stack_hpp
#define Stack_hpp

#include <cstdio>

class Stack
{
    class Node
    {
        char _data;
        Node *_next;

        public:
            Node(int);

            char data() const;
            Node *next() const;

            Node *next(Node *);
    };

    Node *start; // Nodo inicial
    int _n; // Capacidad de la pila
    int _s; // Tamaño de la pila

    public:
        Stack(int);
        ~Stack();

        // Funciones de utileria
        int capacity() const { return _n; } // Obtenemos capacidad
        int size() const { return _s; } // Obtenemos tamaño
        bool empty() { return _s == 0; } // Vacuidad
        bool full() { return _s == _n; } // Plenitud

        // Operaciones de la pila (LIFO)
        void push(char); // Insertamos
        char pop(); // Eliminamos dato y lo mostramos
        char top(); // Solo mostramos
        void print(); // Mostramos contenido
};

#endif /* Stack_hpp */
