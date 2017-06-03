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
    if(full()){
        printf(" - Arbol lleno");
        return false;
    }

    if(!root) {
        root = new Node(x);
        _s++;
        return true;
    }
    else {
        Node *p = root;
        Node *q = NULL;

        while(p && p->data() != x){
            q = p;
            p = x < p->data() ? p->left() : p->right();
        }

        if(!p) {
            // Hago la inserccion
            if(x < q->data()) q->left(new Node(x));
            else q->right(new Node(x));

            _s++;

            return true;
        }
    }

    // no se hizo la inserccion
    return false;
}

void Queue::inorder(Queue::Node *p)
{
    if(!p) return;

    inorder(p->left());
    printf("%4i", p->data());
    inorder(p->right());
}

void Queue::preorder(Queue::Node *p)
{
    if(!p) return;

    printf("%4i", p->data());
    preorder(p->left());
    preorder(p->right());
}

void Queue::postorder(Queue::Node *p)
{
    if(!p) return;

    postorder(p->left());
    postorder(p->right());
    printf("%4i", p->data());
}

// Metodo para buscar
Queue::Node *Queue::search(int x)
{
    Node *p = root; // Apuntador de busqueda

    // Recorremos el arbol para buscar el dato
    while(p && p->data() != x){
        if(x < p->data()) p = p->left();
        else p = p->right();
    }

    // Verificamos si encontramos el dato
    if(p) return p;
    else return NULL;
}

// Metodo para eliminar un nodo
bool Queue::sup(int x)
{
    // Paso 1 - Verificamos si el arbol esta vacio
    if(empty()) return false;

    // Paso 2 - Buscamos el punto a remover
    bool qleft = false; // auxiliar para eliminación
    Node *p = root; // Nodo que apunta a la raiz del arbol
    Node *q = NULL; // Nodo auxiliar de busqueda

    // Recorremos el arbol en busca del dato a eliminar
    while(p && p->data() != x){
        q = p; // q apunta a p
        // Verificamos el camino a seguir
        if(x < p->data()){
            p = p->left();
            qleft = true;
        } else {
            p = p->right();
            qleft = false;
        }
    }

    if(p == NULL) return false; // No se encontro el dato

    // Paso 3(A) - Caso en donde es un nodo hoja
    if(p->left() == NULL && p->right() == NULL){
        if(p == root) root = NULL; // Verificamos si se trata de la raiz del arbol
        else {
            if(qleft) q->left(NULL); // Eliminamos nodo por izquierda
            else q->right(NULL); // Eliminamos nodo por derecha
        }

        delete p;
        return true;
    // Paso 3(B) - Caso nodo con un solo hijo
    } else if(p->left() == NULL && p->right() != NULL){
        // Eliminamos por derecha
        if(p == root) root = p->right(); // Verificamos si es la raiz del arbol
        else {
            if(qleft) q->left(p->right()); // Reordenamos por izquierda
            else q->right(p->right()); // Reordenamos por derecha
        }

        delete p;
        return true;
    } else if(p->right() == NULL && p->left() != NULL){
        // Eliminamos por izquierda
        if(p == root) root = p->left(); // Verificamos si es la raiz del arbol
        else {
            if(qleft) q->left(p->left()); // Reordenamos por izquierda
            else q->right(p->left()); // Reordenamos por derecha
        }

        delete p;
        return true;
    // Paso 3(C) - Reenlazamiento de nodos completos
    } else if(p->left() && p->right()){ // Verificamos que tengan nodos por ambos extremos
        // Se debe asignar en este punto para evitar desbordamiento de datos
        Node *lgp = p->right(); // Nodo auxiliar
        if(p == root) root = p->right(); // Verificamos si se trata de la raiz del arbol
        else {
            if(qleft) q->left(p->right()); // Reordenamos por izquierda
            else q->right(p->right()); // Reordenamos por derecha
        }

        // lgp = p->right(); // Nodo con elemento mas pequeño del subarbol derecho

        while(lgp->left() != NULL){
            lgp = lgp->left();
        }
        lgp->left(p->left()); // Reordenamos los nodos

        // Paso 4 - Eliminamos el nodo
        //delete p;
        return true;
    }

    return false;
}

// Imprimimos el arbol
void Queue::print()
{
    Node *p = root;

    inorder(p);
}
