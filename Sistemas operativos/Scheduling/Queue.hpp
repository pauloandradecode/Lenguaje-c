/*
Fecha: 03/04/2017
Integrantes:
    Andrade Gonzlez Paulo Cesar
    Lazo Godinez Maria Ines
    Lopez Gacia Romina Arantxa
    Sanchez Gutierrez Alejandra Amaranta
Nota: Implementacion de colas con estructuras dinamicas
*/

#ifndef QUEUE_HPP_INCLUDED
#define QUEUE_HPP_INCLUDED

// Clase para colas
class Queue
{
    // Clase para crear un objeto nodo de la lista
    class Node
    {
        // Contenido de un nodo
        char _id; // ID proceso
        int _time; // Tiempo
        int _priority; // Prioridad
        Node *_next; // Apuntador al siguiente nodo

        public:
            // Constructor
            Node(char, int, int); // El apuntador siguiente siempre apunta a NULL

            // Pedimos la informacion del objeto
            // Se utiliza const por que no podemos modificar el objeto
            char id() const; // Nos devuelve el ID del proceso
            int time() const; // Nos devuelve el tiempo del proceso
            int priority() const; // Nos devuelve la prioridad del proceso
            Node *next() const; // Nos devuelve el siguiente nodo (si no existe retorna NULL)

            // Metodo que permite modificar el apuntador
            // Asigno y me retorna el nuevo nodo
            Node *next(Node *);
    };

    Node *start; // Nodo inicial
    Node *eoq; // Apuntador
    int _n; // Capacidad de la cola
    int _s; // Tamaño de la cola

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
        Queue::Node *started() { return start; }

        // Metodos para colas
        void enqueue(char, int, int); // Ingresa nodo al final de la lista
        int dequeue(); // Obtiene el dato del frente de la lista y elimina el nodo
        int front(); // Obtiene el dato del frente de la lista
        int quantum(); // Obtenemos el quantum de los procesos
        void orderbypriority(char, int, int); // Ordenamos la cola por prioridad
        void orderbytime(char, int, int); // Ordenamos la cola por tiempo
        Queue::Node *search(char); // Buscamos un nodo
        bool supr(char); // Eliminamos un nodo
        void print(); // Metodo para imprimir los resultados
        void processpriority(int); // Metodo para procesar el algoritmo de prioridad
};

#endif // QUEUE_HPP_INCLUDED
