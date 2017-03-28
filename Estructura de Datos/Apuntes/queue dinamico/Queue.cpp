/*
Fecha; 28/03/2017
Nota: Implementacion de colas con estructuras dinamicas
*/

#include <cstdio>
#include "Queue.hpp"

/***********************************************
Clase Node
***********************************************/

// Constructor
Queue::Node::Node(int x): _data(x) {
    _next = NULL;
}; // El apuntador siguiente siempre apunta a NULL

// Pedimos la informacion del objeto
// Se utiliza const por que no podemos modificar el objeto
int Queue::Node::data() const {
    return _data;
} // Nos devuelve el dato almacena

Queue::Node *Queue::Node::next() const
{
    return _next;
} // Nos devuelve el siguiente nodo (si no existe retorna NULL)

// Metodo que permite modificar el apuntador
// Asigno y me retorna el nuevo nodo
Queue::Node *Queue::Node::next(Queue::Node *p)
{
    return _next = p;
}

/***********************************************
Clase Queue
***********************************************/

// Constructor
Queue::Queue(int n): _n(n), _s(0), start(NULL),eoq(NULL) {}
// Destructor
Queue::~Queue() {}

// Metodos para colas

// Metodo para insertar nodos al final de la cola
void Queue::enqueue(int x)
{
    // precondicion
    if(!full()){
        if(empty()){
            // Creamos la cola
            start = eoq = new Node(x);
        } else {
            // Agregamos un nuevo nodo a la cola
            eoq->next(new Node(x));
            eoq = eoq->next();
        }

        // Incremento tamaño
        _s++;
    } else {
        // Mostramos emensaje en caso de que la cola este llena
        printf("Cola llena \n");
    }
}

// Devolvemos el valor almacenado y eliminamos el nodo
int Queue::dequeue()
{
    // Precondicion
    if(!empty()){
        Node *aux = start;
        // Respaldamos el dato
        int data = start->data();
        // Apuntamos al siguiente nodo
        start = start->next();
        // Eliminamos el auxiliar
        delete aux;
        // Decrementamos el tamaño
        _s--;

        // Regresamos el dato
        return data;
    }

    // Imprime un mensaje si la cola esta vacia
    printf("Cola vacia\n");
    return 0;
}

// Obtenemos un dato del primer nodo
int Queue::front()
{
    if(!empty()){
        // Retornamos el dato
        return start->data();
    }

    // Mostramos mensaje en caso de cola vacia
    printf("Cola vacia\n");
    return 0;
}

