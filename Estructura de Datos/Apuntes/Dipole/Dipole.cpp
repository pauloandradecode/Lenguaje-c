/*
Fecha: 08/05/2017
Nombre: Paulo Cesar Andrade Gonzalez
Nota: Implementacion de dipoles con estructuras dinamicas
    sin restricciones
    (colas con doble terminación - double-endend)
*/

#include <cstdio>
#include "Dipole.hpp"

/***********************************************
Clase Node
***********************************************/

// Constructor
Dipole::Node::Node(int x): _data(x) {
    _next = NULL;
    _prev = NULL;
}; // El apuntador next y prev siempre apunta a NULL

// Pedimos la informacion del objeto
// Se utiliza const por que no podemos modificar el objeto
int Dipole::Node::data() const {
    return _data;
} // Nos devuelve el dato almacena

// Nos devuelve el siguiente nodo (si no existe retorna NULL)
Dipole::Node *Dipole::Node::next() const
{
    return _next;
}

// Nos devuelve el nodo anterior (si no existe retorna NULL)
Dipole::Node *Dipole::Node::prev() const
{
    return _prev;
}

// Metodo que permite modificar el apuntador
// Asigno y me retorna el nuevo nodo
Dipole::Node *Dipole::Node::next(Dipole::Node *p)
{
    return _next = p;
}

// Metodo que permite modificar el apuntador
// Asigno y me retorna el nuevo nodo
Dipole::Node *Dipole::Node::prev(Dipole::Node *p)
{
    return _prev = p;
}

/***********************************************
Clase Dipole
***********************************************/

// Constructor
Dipole::Dipole(int n): _n(n), _s(0), start(NULL), final(NULL) {}
// Destructor
Dipole::~Dipole() {
    delete start;
    delete final;
}

// Metodos para dipoles

// Insertamos nodo por el frente
void Dipole::enqueueFront(int x)
{
    // precondicion
    if(full()){
        // Mostramos el mensaje en caso de que la cola este llena
        printf("Cola llena \n");
        return;
    }

    // Verificamos si esta vacio
    if(empty()){
        // Creamos nodo inicial
        start = new Node(x);
        final = new Node(x);
    } else {
        // Agregamos un nuevo nodo
        Node *aux = new Node(x);
        // Acomodamos el nodo nuevo al frente
        aux->next(start);
        start->prev(aux);
        start = aux;

        // Buscamos el apuntador final
        Node *p = start;
        Node *q = NULL;
        while(p){
            q = p;
            p = p->next();
        }
        final = q;
    }

    // Incremento tamaño
    _s++;
}

// Insertamos nodo por detras
void Dipole::enqueueRear(int x)
{
    // precondicion
    if(full()){
        // Mostramos el mensaje en caso de que la cola este llena
        printf("Cola llena \n");
        return;
    }

    // Verificamos si esta vacio
    if(empty()){
        // Creamos nodo inicial
        start = new Node(x);
        final = new Node(x);
    } else {
        // Agregamos un nuevo nodo
        Node *aux = new Node(x);
        // Acomodamos el nodo nuevo
        aux->prev(final); // Apunta a null
        final->next(aux);
        final = aux;

        // Buscamos el apuntador inicial
        Node *p = final;
        Node *q = NULL;
        while(p){
            q = p;
            p = p->prev();
        }
        start = q;
    }

    // Incremento tamaño
    _s++;
}

// Obtiene nodo y lo eliminamos por el frente
int Dipole::dequeueFront()
{
    // Precondicion
    if(empty()){
        // Imprime un mensaje si la cola esta vacia
        printf("Cola vacia\n");
        return 0;
    }

    // Creamos un nodo auxiliar
    Node *aux = start;
    // Respaldamos el dato
    int data = start->data();
    // Apuntamos al siguiente nodo
    start = start->next();
    // Eliminamos el auxiliar
    delete aux;
    // Verificamos si no hay mas nodos
    if(start == NULL) final = NULL; // Si no hay, final apunta a NULL
    else start->prev(NULL);
    // Decrementamos el tamaño
    _s--;

    // Regresamos el dato
    return data;
}

// Obtiene nodo y lo elimina por detras
int Dipole::dequeueRear()
{
    // Precondicion
    if(empty()){
        // Imprime un mensaje si la cola esta vacia
        printf("Cola vacia\n");
        return 0;
    }

    // Creamos un nodo auxiliar
    Node *aux = final;
    // Respaldamos el dato
    int data = final->data();
    // Reacomodamos el ultimo nodo de la cola
    final = final->prev();
    // Eliminamos el auxiliar
    delete aux;
    // Verificamos si no hay mas nodos
    if(final == NULL) start = NULL; // Si no hay, start tambien apunta a NULL
    else final->next(NULL); // siguiente del nodo final apunta a null
    // Decrementamos el tamaño
    _s--;

    // Regresamos el dato
    return data;
}

// Obtiene el dato por el frente
int Dipole::front()
{
    if(empty()){
        // Mostramos mensaje en caso de cola vacia
        printf("Cola vacia\n");
        return 0;
    }

    // Retornamos el dato
    return start->data();
}

// Obtiene el dato por detras
int Dipole::rear()
{
    if(empty()){
        // Mostramos mensaje en caso de cola vacia
        printf("Cola vacia\n");
        return 0;
    }

    // Retornamos el dato
    return final->data();
}
