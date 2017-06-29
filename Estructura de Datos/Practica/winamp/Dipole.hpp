/*
Fecha: 20/06/2017
Nombre: Paulo Cesar Andrade Gonzalez
Nota:
*/

#include <string>

#ifndef DIPOLE_HPP_INCLUDED
#define DIPOLE_HPP_INCLUDED

using namespace std;

// Clase para crear un dipole
class Dipole
{
    // Clase para crear un objeto nodo de la lista
    class Node
    {
        // Contenido de un nodo
        string _author; // Autor de la cancion
        string _title; // Titulo de la cancion
        Node *_next; // Apuntador al siguiente nodo
        Node *_prev; // Apuntador al nodo anterior

        public:
            // Constructor
            Node(string, string); // El apuntador siguiente siempre apunta a NULL
            ~Node(); // Destructor

            // Pedimos la informacion del objeto
            // Se utiliza const por que no podemos modificar el objeto
            string author() const; // Nos devuelve el dato almacena
            string title() const; // Nos devuelve el dato almacena
            Node *next() const; // Nos devuelve el siguiente nodo (si no existe retorna NULL)
            Node *prev() const; // Nos devuelve el nodo anterior (si no existe retorna NULL)

            // Metodo que permite modificar el apuntador
            // Asigno y me retorna el nuevo nodo
            Node *next(Node *);
            Node *prev(Node *);
    };

    int _n; // Capacidad del dipole
    int _s; // Tamaño del dipole
    unsigned int _length; // Longitud maxima de la cadena
    Node *start; // Nodo Front
    Node *final; // Nodo Rear
    Node *active; // Nodo activo
    bool _random; // Modo aleatorio
    bool _status_random; // Estado del random
    bool _init; // Verificamos si winamp se iniializo

    public:
        // Constructor
        Dipole(int);
        // Destructor
        ~Dipole();

        // Metodos de utileria
        int capacity() const { return _n; } // Obtenemos capacidad
        int size() const { return _s; } // Obtenemos tamaño
        bool empty() { return _s == 0; } // Vacuidad
        bool full() { return _s == _n; } // Plenitud

        // Metodos para dipoles
        bool enqueueFront(string, string); // Insertamos nodo por el frente
        bool enqueueRear(string, string); // Insertamos nodo por detras
        bool dequeueFront(); // Obtiene nodo y lo eliminamos por el frente
        bool dequeueRear(); // Obtiene nodo y lo elimina por detras
        bool search(string, string); // Busqueda de datos
        void print(); // Imprimimos la lista

        // Metodos winamp
        void random(); // Activamos/desactivamos modo random
        void next(); // Navegamos hacia adelante
        void prev(); // Navegamos hacia atras
        void del(); // Eliminamos una cancion
        void des_rand(); // Desplazamiento random
        void orderbytitle(); // Ordenamos por titulo
        void orderbyauthor(); // Ordenamos por autor
        char ascii(char);
};

#endif // DIPOLE_HPP_INCLUDED
