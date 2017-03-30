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
    Node *p; // Apuntador
    Node *q; // Apuntador
    int _n; // Capacidad de la pila
    int _s; // Tamaño de la pila

    public:
        // Constructor
        List(int);
        // Destructor
        ~List();

        // Funciones de utileria
        int capacity() const { return _n; } // Obtenemos capacidad
        int size() const { return _s; } // Obtenemos tamaño
        bool empty() { return _s == 0; } // Vacuidad
        bool full() { return _s == _n; } // Plenitud

        // Funciones para listas ordenadas
        bool ins(int); // Funcion para inserccion de datos
        int ext(); // Funcion para extraccion de datos
        int read(); // Funcion para lectura de datos
};

#endif // LIST_HPP_INCLUDED

