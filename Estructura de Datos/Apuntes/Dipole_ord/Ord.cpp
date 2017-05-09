/*
Fecha: 08/05/2017
Nombre: Paulo Cesar Andrade Gonzalez
Nota: Implementacion de Ords con estructuras dinamicas
    con restricciones ORD (Output - restricted deque)
    (colas con doble terminación - double-endend)
*/

#include <cstdio>
#include "Ord.hpp"

/***********************************************
Clase Node
***********************************************/

// Constructor
Ord::Node::Node(int x): _data(x) {
    _next = NULL;
    _prev = NULL;
}; // El apuntador next y prev siempre apunta a NULL

// Pedimos la informacion del objeto
// Se utiliza const por que no podemos modificar el objeto
int Ord::Node::data() const {
    return _data;
} // Nos devuelve el dato almacena

// Nos devuelve el siguiente nodo (si no existe retorna NULL)
Ord::Node *Ord::Node::next() const
{
    return _next;
}

// Nos devuelve el nodo anterior (si no existe retorna NULL)
Ord::Node *Ord::Node::prev() const
{
    return _prev;
}

// Metodo que permite modificar el apuntador
// Asigno y me retorna el nuevo nodo
Ord::Node *Ord::Node::next(Ord::Node *p)
{
    return _next = p;
}

// Metodo que permite modificar el apuntador
// Asigno y me retorna el nuevo nodo
Ord::Node *Ord::Node::prev(Ord::Node *p)
{
    return _prev = p;
}

/***********************************************
Clase Ord
***********************************************/

// Constructor
Ord::Ord(int n): _n(n), _s(0), start(NULL), final(NULL) {}
// Destructor
Ord::~Ord() {
    delete start;
    delete final;
}

// Metodos para Ords

// Insertamos nodo por detras
bool Ord::enqueueFront(int x)
{
    // precondicion
    if(full()){
        printf(" Cola llena");
        return false;
    }

    // Verificamos si esta vacio
    if(empty()){
        // Creamos nodo inicial
        start = new Node(x);
        final = new Node(x);
    } else {
        // Buscamos por duplicados
        if(search(x)){
            printf(" duplicado");
            return false;
        }

        // Agregamos un nuevo nodo
        Node *aux = new Node(x);
        // Acomodamos el nodo nuevo
        aux->prev(final); // anterior de nuevo nodo apunta a final
        final->next(aux); // siguiente de final apunta a nuevo nodo
        final = aux; // final es igual a nuevo nodo

        // Buscamos el apuntador inicial
        Node *p = final;
        Node *q = NULL;
        // Recorremos la cola
        while(p){
            q = p;
            p = p->prev();
        }
        // Inicio apunta al primer nodo
        start = q;
    }

    // Incremento tamaño
    _s++;
    return true;
}

// Insertamos nodo por detras
bool Ord::enqueueRear(int x)
{
    // precondicion
    if(full()){
        printf(" Cola llena");
        return false;
    }

    // Verificamos si esta vacio
    if(empty()){
        // Creamos nodo inicial
        start = new Node(x);
        final = new Node(x);
    } else {
        // Buscamos por duplicados
        if(search(x)){
            printf(" duplicado");
            return false;
        }

        // Agregamos un nuevo nodo
        Node *aux = new Node(x);
        // Acomodamos el nodo nuevo
        aux->prev(final); // anterior de nuevo nodo apunta a final
        final->next(aux); // siguiente de final apunta nuevo nodo
        final = aux; // Final a punta a nuevo nodo

        // Buscamos el apuntador inicial
        Node *p = final;
        Node *q = NULL;
        // Recorremos la cola hasta el final
        while(p){
            q = p;
            p = p->prev();
        }
        // Inicio apunta al primer nodo
        start = q;
    }

    // Incremento tamaño
    _s++;
    return true;
}

// Obtiene nodo y lo eliminamos por el frente
int Ord::dequeueFront()
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

// Obtiene el dato por el frente
int Ord::front()
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
int Ord::rear()
{
    if(empty()){
        // Mostramos mensaje en caso de cola vacia
        printf("Cola vacia\n");
        return 0;
    }

    // Retornamos el dato
    return final->data();
}

// Metodo para busqueda de nodos
bool Ord::search(int x)
{
    if(!empty()){
        // Inicializamos el puntero p
        Node *p = start;

        // Recorremos en busca del nodo
        while(p){
            // Verificamos si el dato buscado es igual al del nodo
            if(p && p->data() == x) return true; // Retornamos true

            p = p->next();
        }
    }

    return false;
}
