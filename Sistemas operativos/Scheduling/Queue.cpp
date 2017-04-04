/*
Fecha: 03/04/2017
Integrantes:
    Andrade Gonzlez Paulo Cesar
    Lazo Godinez Maria Ines
    Lopez Gacia Romina Arantxa
    Sanchez Gutierrez Alejandra Amaranta
Nota: Implementacion de colas con estructuras dinamicas
*/

#include <cstdio>
#include "Queue.hpp"

/***********************************************
Clase Node
***********************************************/

// Constructor
// @param x ID del proceso
// @param y Tiempo del proceso
// @param z Prioridad del proceso
Queue::Node::Node(char x, int y, int z): _id(x), _time(y), _priority(z) {
    _next = NULL;
}; // El apuntador siguiente siempre apunta a NULL

// Pedimos la informacion del objeto
// Se utiliza const por que no podemos modificar el objeto
// Nos devuelve el Id del proceso
char Queue::Node::id() const {
    return _id;
}

// Nos devuelve el tiempo de proceso
int Queue::Node::time() const {
    return _time;
}

// Nos devuelve la prioridad del proceso
int Queue::Node::priority() const {
    return _priority;
}

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
Queue::Queue(int n): _n(n), _s(0), start(NULL), eoq(NULL) {}
// Destructor
Queue::~Queue() {
    delete start;
    delete eoq;
}

// Metodos para colas

// Metodo para insertar nodos al final de la cola
// @param x ID del proceso
// @param y Tiempo del proceso
// @param z Prioridad del proceso
void Queue::enqueue(char x, int y, int z)
{
    // precondicion
    if(!full()){
        if(empty()){
            // Creamos la cola
            start = eoq = new Node(x, y, z);
        } else {
            // Agregamos un nuevo nodo a la cola
            eoq->next(new Node(x, y, z));
            eoq = eoq->next();
        }

        // Incremento tamaño
        _s++;
    } else {
        // Mostramos el mensaje en caso de que la cola este llena
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
        int time = start->time();
        // Apuntamos al siguiente nodo
        start = start->next();
        // Eliminamos el auxiliar
        delete aux;
        // Decrementamos el tamaño
        _s--;

        // Regresamos el dato
        return time;
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
        return start->time();
    }

    // Mostramos mensaje en caso de cola vacia
    printf("Cola vacia\n");
    return 0;
}
