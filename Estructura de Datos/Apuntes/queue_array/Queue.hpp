#ifndef QUEUE_HPP_INCLUDED
#define QUEUE_HPP_INCLUDED

class Queue
{
    int *array; // Implementacion de la pila (array)
    int _n; // Capacidad de la pila
    int _s; // Tamaño de la pila

    public:
        // Constructor
        Queue(int);
        // Destructor
        ~Queue();

        // Funciones de utileria
        int capacity() const { return _n; } // Obtenemos capacidad
        int size() const { return _s; } // Obtenemos tamaño
        bool empty() { return _s == 0; } // Vacuidad
        bool full() { return _s == _n; } // Plenitud

        // Metodos para colas
        void enqueue(int);
        int dequeue();
        int read();
};

#endif // QUEUE_HPP_INCLUDED
