/*
Fecha: 07/03/2017
Nota: Lista enlazada
    No require un destructor, ya que se genera de forma dinamica, y el apuntador next, apunta
    a null.

    En la clase lista se necesitan 3 metodos, dos para conocer el contenido del nodo y otro
    para saber a que nodo apunta.

********** Definicion **********
*/

#ifndef lista_hpp
#define lista_hpp

#include <cstdlib>

// Clase para listas simples o enlazadas
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
            Node(int d): _data(d) { _next = NULL; }; // El apuntador siguiente siempre apunta a NULL

            // Pedimos la informacion del objeto
            // Se utiliza const por que no podemos modificar el objeto
            int data() const { return _data; }; // Nos devuelve el dato almacena
            Node *next() const { return _next; }; // Nos devuelve el siguiente nodo (si no existe retorna NULL)

            // Metodo que permite modificar el apuntador
            // Asigno y me retorna el nuevo nodo
            Node *next(Node *p) { return _next = p; };
    };

    Node *start; // Apuntador inicial
    int _n; // Capacidad de la estructura
    int _size; // Contador para saber cuantos elementos hay en la lista

    public:
        // Constructor
        List(int capacity){
            start = NULL;
            _n = capacity;
            _size = 0;
        };
        // Prueba de vacuidad (verifica si la lista esta vacia)
        bool empty() { return _size == 0; };
        // Prueba de plenitud (verifica si la lista esta llena)
        bool full() { return _size == _n; };
};

#endif
