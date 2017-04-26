/*
Autor: Paulo Andrade
Fecha: 26/04/2017
Nota: Implementacion de colas con estructuras dinamicas
    para uso con arboles binarios
*/

#ifndef QUEUE_HPP_INCLUDED
#define QUEUE_HPP_INCLUDED

class Queue
{
    // Clase para crear un objeto nodo de la lista
    class Node
    {
        // Contenido de un nodo
        int _data; // Datos del nodo
        Node *_left; // Apuntador al siguiente nodo por izquierda
        Node *_right; // Apuntador al siguiente nodo por derecha

        public:
            // Constructor
            Node(int); // El apuntador siguiente siempre apunta a NULL
            ~Node(); // Destructor

            // Pedimos la informacion del objeto
            // Se utiliza const por que no podemos modificar el objeto
            int data() const; // Nos devuelve el dato almacena
            Node *left() const; // Nos devuelve el siguiente nodo (si no existe retorna NULL)
            Node *right() const; // Nos devuelve el siguiente nodo (si no existe retorna NULL)

            // Metodo que permite modificar el apuntador
            // Asigno y me retorna el nuevo nodo
            Node *left(Node *);
            Node *right(Node *);
    };

    Node *root; // Nodo inicial
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
        bool ins(int); // Ingresa un elemento al arbol
};

#endif // QUEUE_HPP_INCLUDED


