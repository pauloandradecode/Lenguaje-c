/*
Fecha: 20/06/2017
Nombre: Paulo Cesar Andrade Gonzalez
Nota:
*/

#include <cstdio>
#include <cstring>
#include <iostream>
#include <string>
#include <stdlib.h>
#include <ctime>
#include "Dipole.hpp"

using namespace std;

/***********************************************
Clase Node
***********************************************/

// Constructor
Dipole::Node::Node(string author, string title): _author(author), _title(title) {
    _next = NULL;
    _prev = NULL;
}; // El apuntador next y prev siempre apunta a NULL

// Destrucor
Dipole::Node::~Node()
{
    delete _next;
    delete _prev;
}

// Pedimos la informacion del objeto
// Se utiliza const por que no podemos modificar el objeto
string Dipole::Node::author() const {
    return _author;
} // Nos devuelve el dato almacena

// Pedimos la informacion del objeto
// Se utiliza const por que no podemos modificar el objeto
string Dipole::Node::title() const {
    return _title;
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
Dipole::Dipole(int n): _n(n), _s(0), start(NULL), final(NULL) {
    active = NULL;
    _random = false;
    _status_random = false;
    _init = false;
    _length = 0;
}
// Destructor
Dipole::~Dipole() {
    /*
        No se necesita usar el operador delete para los punteros start, final y active
        debido a que no reservan memoria dinamica, si no la dirección a otro apuntador.
    */
    // delete start;
    // delete final;
    // delete active;
}

// Metodos para dipoles

// Insertamos nodo por el frente
bool Dipole::enqueueFront(string author, string title)
{
    // precondicion
    if(full()){
        printf(" Cola llena");
        return false;
    }

    // Verificamos la longitud
    if(author.size() > _length) _length = author.size();

    // Verificamos si esta vacio
    if(empty()){
        // Creamos nodo inicial
        Node *aux = new Node(author, title);
        active = final = start = aux;
    } else {
        // Buscamos por duplicados
        if(search(author, title)){
            printf(" duplicado");
            return false;
        }

        Node *aux = new Node(author, title);

        // Acomodamos el nodo nuevo al frente
        aux->next(start); // siguiente de nuevo nodo apunta a inicio
        aux->next()->prev(aux); // anterior de inicio apunta a nuevo nodo
        start = aux; // Inicio es igual a nuevo nodo
    }

    // Incremento tamaño
    _s++;
    return true;
}

// Insertamos nodo por detras
bool Dipole::enqueueRear(string author, string title)
{
    // precondicion
    if(full()){
        printf(" Cola llena");
        return false;
    }

    // Verificamos la longitud
    if(author.size() > _length) _length = author.size();

    // Verificamos si esta vacio
    if(empty()){
        // Creamos nodo inicial
        Node *aux = new Node(author, title);
        active= start = final = aux;
    } else {
        // Buscamos por duplicados
        if(search(author, title)){
            printf(" duplicado");
            return false;
        }

        Node *aux = new Node(author, title);

        // Acomodamos el nodo nuevo
        aux->prev(final); // anterior de nuevo nodo apunta a final
        final->next(aux); // siguiente de final apunta nuevo nodo
        final = aux; // Final a punta a nuevo nodo
    }

    // Incremento tamaño
    _s++;
    return true;
}

// Obtiene nodo y lo eliminamos por el frente
bool Dipole::dequeueFront()
{
    // Precondicion
    if(empty()){
        // Imprime un mensaje si la cola esta vacia
        printf("Cola vacia\n");
        return false;
    }

    // Apuntamos al siguiente nodo
    Node *aux = start;

    if(start == final){
        final = start = NULL;
    } else {
        start = start->next();
        start->prev(NULL);
        active = start;
    }

    // Decrementamos el tamaño
    _s--;

    // Regresamos el dato
    return true;
}

// Obtiene nodo y lo elimina por detras
bool Dipole::dequeueRear()
{
    // Precondicion
    if(empty()){
        // Imprime un mensaje si la cola esta vacia
        printf("Cola vacia\n");
        return false;
    }

    // Reacomodamos el ultimo nodo de la cola
    //Node *aux = final;

    if(start == final){
        final = start = NULL;
    } else {
        final = final->prev();
        final->next(NULL);
        active = start;
    }

    // Decrementamos el tamaño
    _s--;

    // Regresamos el dato
    return false;
}

// Metodo para busqueda de nodos
bool Dipole::search(string author, string title)
{
    if(!empty()){
        // Inicializamos el puntero p
        Node *p = start;

        // Recorremos en busca del nodo
        while(p){
            // Verificamos si el dato buscado es igual al del nodo
            if(p && p->author() == author && p->title() == title) return true; // Retornamos true

            p = p->next();
        }
    }

    return false;
}

// Metodo para imprimir la lista
void Dipole::print()
{
    string title;

    // Verificamos si la lista se inicializo
    if(!_init) {
        _init = true;
        active = start;
    }

    // Mensaje random
    if(_status_random){
        if(_random) printf("Random mode ON\n");
        else printf("Random mode OFF\n");
        _status_random = false;
    }

    if(!empty()){
        for(Node *p = start; p; p = p->next()){
            if(p == active) printf("* ");
            else printf("  ");

            title = p->title();
            cout << p->title();
            for(unsigned int i = 0; i < (_length - title.size()); i++) cout << " ";
            cout << p->author() << endl;
        }
        puts("");
    } else cout << "Lista de reproduccion vacia\n\n";
}

// Eliminamos una cancion
void Dipole::del()
{
    if(!empty()){
        if(start == active) dequeueFront(); // Eliminamos por el frente
        else if(final == active) dequeueRear(); // Eliminamos por atras
        else {
            // Buscamos el nodo a eliminar
            Node *p = start;
            Node *q = NULL;

            while(p && p != active){
                q = p->prev();
                p = p->next();
            }

            q = p->prev();
            p = p->next();
            q->next(p);
            p->prev(q);

            // Asignamos el nodo activo
            active = p;

            _s--; // Disminuimos la capacidad
        }
    }
}

// Modo random
void Dipole::random()
{
    _random = !_random;
    _status_random = true;
}

// Navegamos hacia atras
void Dipole::prev()
{
    if(!empty() && size() >= 2){
        if(_random){
            // Random activado
            des_rand();
        } else {
            // Random desactivado
            if(active != final) active = active->next();
            else active = start;
        }
    }
}

// Navegamos hacia adelante
void Dipole::next()
{
    if(!empty() && size() >= 2){
        if(_random){
            // Random activado
            des_rand();
        } else {
            // Random desactivado
            if(active != start) active = active->prev();
            else active = final;
        }
    }
}

// Desplazamiento random
void Dipole::des_rand()
{
    srand((unsigned) time(NULL));
    int num, pos = 0;

    num = rand() % size() + 1;
    num = (num == size()) ? num - 1 : num;

    // Buscamos la posicion
    for(Node *p = start; p && p != active; p = p->next()) pos++;

    // Obtenemos el desplazamiento
    num = (pos + num) % size();

    // Activamos la cancion
    Node *p = start;
    for(int i = 0; i <= num;i++){
        if(i == num) active = p;
        p = p->next();
    }
}

// Ordenamos por titulo
void Dipole::orderbytitle()
{
    if(!empty()){
        int pos = 0;
        char *qaux, *paux;
        string cq, cp;
        Node *x = NULL, *y = NULL;

        for(Node *p = start->next(); p; p = p->next()){
            // Recorremos el dipolo
            for(Node *q = start; q->next(); q = q->next()){
                pos = 0;
                cq = q->title();
                cp = q->next()->title();
                qaux = (char*)cq.c_str();
                paux = (char*)cp.c_str();

                // Convertimos ascii
                qaux[0] = ascii(qaux[0]);
                paux[0] = ascii(paux[0]);

                while(qaux[pos] == paux[pos]){
                    pos++;
                    qaux[pos] = ascii(qaux[pos]);
                    paux[pos] = ascii(paux[pos]);
                }

                // Comparamos los caracteres
                if(qaux[pos] > paux[pos]){
                    x = q->prev();
                    y = q->next();

                    // Quitamos el nodo de su posicion
                    if(q == start && size() >= 2) {
                        // Insertamos la cancion en su nueva posicion
                        start = y;
                        start->prev(NULL);
                        q->next(start->next());
                        q->prev(start);
                        start->next()->prev(q);
                        start->next(q);
                    } else if(y->next()){
                        // Eliminamos la cancion
                        x->next(y);
                        y->prev(x);
                        q->next(y->next());
                        y->next()->prev(q);
                        q->prev(y);
                        y->next(q);
                    } else if(q->next() == final){
                        if(qaux[pos] > paux[pos]){
                            final = x->next();
                            final->next(NULL);
                            x->next(y);
                            y->prev(x);
                            y->next(final);
                            final->prev(y);
                            q = y;
                        }
                    }
                }
            }
        }
    }
}

// Ordenamos por autor
void Dipole::orderbyauthor()
{
    if(!empty()){
        int pos = 0;
        char *qaux, *paux;
        string cp, cq;
        Node *x = NULL, *y = NULL;

        for(Node *p = start->next(); p; p = p->next()){
            // Recorremos el dipolo
            for(Node *q = start; q->next(); q = q->next()){
                pos = 0;
                cq = q->author();
                cp = q->next()->author();
                qaux = (char*)cq.c_str();
                paux = (char*)cp.c_str();

                // Convertimos ascii
                qaux[0] = ascii(qaux[0]);
                paux[0] = ascii(paux[0]);

                while(qaux[pos] == paux[pos]){
                    pos++;
                    qaux[pos] = ascii(qaux[pos]);
                    paux[pos] = ascii(paux[pos]);
                }

                // Comparamos los caracteres
                if(qaux[pos] > paux[pos]){
                    x = q->prev();
                    y = q->next();

                    // Quitamos el nodo de su posicion
                    if(q == start && size() >= 2) {
                        // Insertamos la cancion en su nueva posicion
                        start = y;
                        start->prev(NULL);
                        q->next(start->next());
                        q->prev(start);
                        start->next()->prev(q);
                        start->next(q);
                    } else if(y->next()){
                        // Eliminamos la cancion
                        x->next(y);
                        y->prev(x);
                        q->next(y->next());
                        y->next()->prev(q);
                        q->prev(y);
                        y->next(q);
                    } else if(q->next() == final){
                        if(qaux[pos] > paux[pos]){
                            final = x->next();
                            final->next(NULL);
                            x->next(y);
                            y->prev(x);
                            y->next(final);
                            final->prev(y);
                            q = y;
                        }
                    }
                }
            }
        }
    }
}

char Dipole::ascii(char x)
{
    switch(x){
        case 'A': x = 'a'; break; case 'B': x = 'b'; break; case 'C': x = 'c'; break;
        case 'D': x = 'd'; break; case 'E': x = 'e'; break; case 'F': x = 'f'; break;
        case 'G': x = 'g'; break; case 'H': x = 'h'; break; case 'I': x = 'i'; break;
        case 'J': x = 'j'; break; case 'K': x = 'k'; break; case 'L': x = 'l'; break;
        case 'M': x = 'm'; break; case 'N': x = 'n'; break; case 'O': x = 'o'; break;
        case 'P': x = 'p'; break; case 'Q': x = 'q'; break; case 'R': x = 'r'; break;
        case 'S': x = 's'; break; case 'T': x = 't'; break; case 'U': x = 'u'; break;
        case 'V': x = 'v'; break; case 'W': x = 'w'; break; case 'X': x = 'x'; break;
        case 'Y': x = 'y'; break; case 'Z': x = 'z'; break;
    }

    return x;
}
