/*
Autor: Paulo Andrade
Fecha: 26/04/2017
Nota: Implementacion de colas con estructuras dinamicas
    para uso con arboles binarios
*/

#include <cstdio>
#include "Queue.hpp"

/***********************************************
Clase Node
***********************************************/

// Constructor
Queue::Node::Node(int x): _data(x) {
    _left = NULL;
    _right = NULL;
}; // El apuntador left y right siempre apunta a NULL

// Destructor
Queue::Node::~Node() {
    delete _left;
    delete _right;
};

// Pedimos la informacion del objeto
// Se utiliza const por que no podemos modificar el objeto
int Queue::Node::data() const {
    return _data;
} // Nos devuelve el dato almacena

Queue::Node *Queue::Node::left() const
{
    return _left;
} // Nos devuelve el siguiente nodo (si no existe retorna NULL)

Queue::Node *Queue::Node::right() const
{
    return _right;
} // Nos devuelve el siguiente nodo (si no existe retorna NULL)

// Metodo que permite modificar el apuntador
// Asigno y me retorna el nuevo nodo
Queue::Node *Queue::Node::left(Queue::Node *p)
{
    return _left = p;
}

// Metodo que permite modificar el apuntador
// Asigno y me retorna el nuevo nodo
Queue::Node *Queue::Node::right(Queue::Node *p)
{
    return _right = p;
}

/***********************************************
Clase Queue
***********************************************/

// Constructor
Queue::Queue(int n): _n(n), _s(0), root(NULL) {}
// Destructor
Queue::~Queue() {
    delete root;
}

// Metodos para colas

// Metodo para insertar datos al arbol binario
bool Queue::ins(int x)
{
    // precondicion
    if(!full()){
        if(empty()){
            // Creamos la cola
            root = new Node(x);
        } else {
            Node *p = root;
            Node *q = NULL;

            // Recorremos el arbol
            while(p && p->data() != x){
                q = p;
                if(x < p->data()) p = p->left();
                else p = p->right();
            }

            // Insertamos el dato
            if(p == NULL){
                if(x < q->data()) q->left(new Node(x));
                else if(x > q->data()) q->right(new Node(x));
            }

            // Verificamos que el dato no este repetido
            if(p && p->data() == x){
                printf(" - Repetido");
                return false;
            }
        }

        // Incremento tamaño
        _s++;
        return true;
    } else {
        // Mostramos el mensaje en caso de que la cola este llena
        printf(" - Arbol lleno");
        return false;
    }
}
