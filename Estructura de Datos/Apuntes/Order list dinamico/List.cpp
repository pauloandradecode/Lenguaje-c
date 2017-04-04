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
List::List(int n): _n(n), _s(0), start(NULL) {}
// Destructor
List::~List() {}

// Metodos para la lista ordenada

// Metodo para inserccion de datos
// Algoritmo de inserccion
bool List::ins(int x)
{
    // Verificamos que la lista no este llena
    if(!full()){
        // Verificamos si la lista es igual a NULL
        if(start == NULL){
            // Si esta vacia, creamos el primer nodo
            start = new Node(x);
        } else {
            // p es igual al inicio de la lista
            Node *p = start;
            Node *q = NULL;

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
        }

        // Incrementamos tamaño de la lista
        _s++;
        return true;
    }

    // Mostramos el mensaje en caso de que la lista este llena
    printf("Lista llena ");
    return false;
}

// Funcion para extraccion de datos
int List::ext()
{
    // Precondicion
    if(!empty()){
        // Respaldamos el dato
        int data = start->data();

        // Buscamos y eliminamos el nodo
        if(supr(data)){
            // Decrementamos el tamaño
            _s--;

            // Regresamos el dato
            return data;
        }
        return 0;
    }

    // Imprime un mensaje si la lista esta vacia
    printf("Lista vacia\n");
    return 0;
}

// Metodo para busqueda de nodos
// Adaptado para retornar un nodo anteriro al que se busca
List::Node *List::search(int x)
{
    if(!empty()){
        // Inicializamos el puntero p
        Node *p = start;
        Node *q = NULL;

        // Recorremos en busca del nodo
        while(p && p->data() < x){
            q = p;
            p = p->next();
        }

        // Verificamos si el dato buscado es igual al del nodo
        if(p && p->data() == x) return q; // Retornamos el nodo
        else return NULL; // Retornamos null, al no encontrar el dato
    }

    return NULL;
}

// Metodo para la eliminacion de nodos
bool List::supr(int x)
{
    // Precondicion
    if(!empty()){
        // Inicializamos el puntero p
        Node *p = start;
        Node *q = NULL;

        // Buscamos el item
        if(q = search(x)) p = q->next();

        // Verificamos si encontramos el item
        if(p && p->data() == x){
            if(p == start){
                // Eliminamos por el frente
                start = p->next();
            } else {
                // Eliminamos por en medio
                q->next(p->next());
            }

            // Eliminamos p
            delete p;

            // Retornamos true por eliminar el nodo
            return true;
        }
    }
    // Retornamos false por no eliminar ningun nodo
    return false;
}

// Imprimimos una lista externa
void print(List &l)
{
    // Los datos privados se pueden acceder por que es una funcion amiga
    // l es un dato concretro por eso se utiliza (.) para acceder a sus propiedades y metodos
    printf("[%i]: ", l.size());

    for(List::Node *p = l.start; p; p = p->next()){
        // Imprimimos el dato a eliminar
        printf("%4i", l.ext());
    }

    printf("\n");
}
