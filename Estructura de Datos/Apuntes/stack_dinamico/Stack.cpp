/*
Implementaciones

Fecha: 27/03/2017
Nota: Pilas con arrays - Estructura lineal
*/

#include <cstdio>
#include "Stack.hpp"

/***********************************************
Clase Node
***********************************************/

// Constructor
Stack::Node::Node(int x): _data(x) {
    _next = NULL;
}; // El apuntador siguiente siempre apunta a NULL

// Pedimos la informacion del objeto
// Se utiliza const por que no podemos modificar el objeto
int Stack::Node::data() const {
    return _data;
} // Nos devuelve el dato almacena

Stack::Node *Stack::Node::next() const
{
    return _next;
} // Nos devuelve el siguiente nodo (si no existe retorna NULL)

// Metodo que permite modificar el apuntador
// Asigno y me retorna el nuevo nodo
Stack::Node *Stack::Node::next(Stack::Node *p)
{
    return _next = p;
}

/***********************************************
Clase Stack
***********************************************/

// Constructor
Stack::Stack(int cap) : _n(cap), _s(0), start(NULL) {}

// Destructor
Stack::~Stack(){}

// Método para insertar un dato al final del array
// @param data entero a almacenar
void Stack::push(int data)
{
    // Precondicion
    if(!full()){
        // Verificamos si la pila esta vacia
        if(empty()){
            // Si esta vacia creamos un nuevo nodo al inicio de la pila
            start = new Node(data);
        } else {
            // Si no esta vacio
            // Creamos un nuevo nodo auxiliar
            Node *aux = new Node(data);
            // Colocamos el nuevo nodo al inicio de la pila
            aux->next(start);
            // Remplazamos la pila aux con la original
            start = aux;

            // Liberamos memoria
            // delete aux;
        }

        // Incrementamos el tamaño de la pila
        _s++;
    } else {
        printf("Pila llena \n");
    }
}

// Metodo para obtener el ultimo dato del array y borrarlo
int Stack::pop()
{
    // Precondicion
    if(!empty()){
        // Almacenamos nuestra pila original en una pila auxiliar
        Node *aux = start;
        // Sobrescribimos la pila original con el nodo siguiente
        // del auxiliar para eliminar el primer nodo
        start = aux->next();
        // Obtenemos el dato del nodo eliminado
        int x = aux->data();
        // Liberamos memoria
        delete aux;

        // Disminuimos el tamaño
        _s--;

        return x;
    } else {
        // Valor centinela solo para que no marque un error
        printf("Pila vacia \n");
        return 0;
    }
}

// Metodo para mostrar el ultimo dato del arreglo sin borrarlo
int Stack::top()
{
    // Precondicion
    if(!empty()){
        // Retornamos un dato
        return start->data();
    }
}
