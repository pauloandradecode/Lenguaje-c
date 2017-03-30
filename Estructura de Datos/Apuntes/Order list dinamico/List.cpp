/*
Fecha:29/03/2017

Nombre: Paulo Cesar Andrade Gonzalez
Nota: Implementacion de listas ordenadas con estructuras dinamicas
*/

#include <cstdio>
#include "List.hpp"

/***********************************************
Clase Node
***********************************************/

// Constructor
List::Node::Node(int x): _data(x) {
    _next = NULL;
}; // El apuntador siguiente siempre apunta a NULL

// Pedimos la informacion del objeto
// Se utiliza const por que no podemos modificar el objeto
int List::Node::data() const {
    return _data;
} // Nos devuelve el dato almacena

List::Node *List::Node::next() const
{
    return _next;
} // Nos devuelve el siguiente nodo (si no existe retorna NULL)

// Metodo que permite modificar el apuntador
// Asigno y me retorna el nuevo nodo
List::Node *List::Node::next(List::Node *p)
{
    return _next = p;
}

/***********************************************
Clase List
***********************************************/

// Constructor
List::List(int n): _n(n), _s(0), start(NULL), p(NULL), q(NULL) {}
// Destructor
List::~List() {}

// Metodos para la lista ordenada

// Funcion para inserccion de datos
// Algoritmo de inserccion
bool List::ins(int x)
{
    // Verificamos que la lista no este llena
    if(!full()){
        // Verificamos si la lista es igual a NULL
        if(start == NULL){
            // Si esta vacia, creamos el primer nodo
            start = new Node(x);
            // Incrementamos tamaño de la lista
            _s++;
            return true;
        } else {
            // p es igual al inicio de la lista
            p = start;

            // Recorremos la lista en busca del punto de inserccion
            while(p != NULL && p->data() < x){
                q = p;
                p = p->next();
            }

            // Verificamos que el elemento no este duplicado
            if(p != NULL && p->data() == x) return false;

            // Creamos un nodo
            Node *aux = new Node(x);

            // Verificamos si p == NULL e insertamos al final
            if(p == NULL) q->next(aux);
            else if(p == start) {
                // Insertamos al final de la lista
                aux->next(start);
                start = aux;
            } else {
                // Insertamos a la mitad de la lista
                q->next(aux);
                aux->next(p);
            }
            // Incrementamos tamaño de la lista
            _s++;
            return true;
        }
    } else {
        // Mostramos el mensaje en caso de que la cola este llena
        printf("Lista llena ");
        return false;
    }
}

// Funcion para extraccion de datos
int List::ext()
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
    printf("Lista vacia\n");
    return 0;
}

// Funcion para lectura de datos
int List::read()
{
    if(!empty()){
        // Retornamos el dato
        return start->data();
    }

    // Mostramos mensaje en caso de cola vacia
    printf("Lista vacia\n");
    return 0;
}
