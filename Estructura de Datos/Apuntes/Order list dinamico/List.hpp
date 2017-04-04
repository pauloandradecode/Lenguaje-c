/*
Fecha:29/03/2017

Nombre: Paulo Cesar Andrade Gonzalez
Nota: Implementacion de listas ordenadas con estructuras dinamicas
*/

#ifndef LIST_HPP_INCLUDED
#define LIST_HPP_INCLUDED

class List
{
    // Clase para crear un objeto nodo de la lista
    class Node
    {
        // Contenido de un nodo
        int _data; // Datos del nodo
        Node *_next; // Apuntador al siguiente nodo

        public:
            // Constructor
            Node(int); // El apuntador siguiente siempre apunta a NULL

            // Pedimos la informacion del objeto
            // Se utiliza const por que no podemos modificar el objeto
            int data() const; // Nos devuelve el dato almacena
            Node *next() const; // Nos devuelve el siguiente nodo (si no existe retorna NULL)

            // Metodo que permite modificar el apuntador
            // Asigno y me retorna el nuevo nodo
            Node *next(Node *);
    };

    Node *start; // Nodo inicial
    int _n; // Capacidad de la pila
    int _s; // Tamaño de la pila
    friend void print(List &); // Funcion amiga para acceder a datos privados

    public:
        // Constructor
        List(int);
        // Destructor
        ~List();

        // Metodos de utileria
        int capacity() const { return _n; } // Obtenemos capacidad
        int size() const { return _s; } // Obtenemos tamaño
        bool empty() { return _s == 0; } // Vacuidad
        bool full() { return _s == _n; } // Plenitud

        // Metodos para listas ordenadas
        bool ins(int); // Metodo para inserccion de datos
        int ext(); // Metodo para extraccion de datos
        int read(); // Metodo para lectura de datos
        List::Node *search(int); // Metodo para busqueda
        bool supr(int); // Metodo para suprimir un nodo
};

// Funcion externa para imprimir
extern void print(List &l);

#endif // LIST_HPP_INCLUDED

