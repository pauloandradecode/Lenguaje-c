/*
Fecha:03/04/2017

Nombre: Paulo Cesar Andrade Gonzalez
Nota:
*/

#include <cstdio>
#include "olist.hpp"

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
List::List(int n): _n(n), _s(0), start(NULL) {}
// Destructor
List::~List() { delete start; }

// Metodos para la lista ordenada

// Funcion para inserccion de datos
// Algoritmo de inserccion
void List::ins(int x)
{
    // Verificamos que la lista no este llena
    if(full()){
        printf("Full list\n");
        return;
    }

    // Verificamos si la lista es igual a NULL
    if(empty()){
        // Si esta vacia, creamos el primer nodo
        start = new Node(x);
    } else {
        // p es igual al inicio de la lista
        Node *p = start;
        Node *q = NULL;

        // Recorremos la lista en busca del punto de inserccion
        while(p && p->data() < x){
            q = p;
            p = p->next();
        }

        // Creamos un nodo
        Node *aux = new Node(x);

        // Verificamos si p == NULL e insertamos al final
        if(!p) q->next(aux);
        else if(p == start) {
            // Insertamos al frente de la lista
            start = aux;
            aux->next(p);
        } else {
            // Insertamos a la mitad de la lista
            q->next(aux);
            aux->next(p);
        }
    }

    // Incrementamos tamaño de la lista
    _s++;
}

// Funcion para busqueda de un nodo
bool List::search()
{
    return true;
}
// Funcion para eliminar un nodo
int List::supr()
{

}

// Imprimimos una lista externa
void print(List &l)
{
    // Los datos privados se pueden acceder por que es una funcion amiga
    // l es un dato concretro por eso se utiliza (.) para acceder a sus propiedades y metodos
    printf("[%i]: ", l.size());

    for(List::Node *p = l.start; p; p = p->next())
        printf("%4i", p->data());

    printf("\n");
}
