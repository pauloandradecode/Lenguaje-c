/*
Fecha: 08/05/2017
Nombre: Paulo Cesar Andrade Gonzalez
Nota: Implementacion de dipoles con estructuras dinamicas
    restricciones
    (colas con doble terminación - double-endend)
*/

#ifndef DIPOLE_HPP_INCLUDED
#define DIPOLE_HPP_INCLUDED

// Clase para crear un dipole
class Dipole
{
    // Clase para crear un objeto nodo de la lista
    class Node
    {
        // Contenido de un nodo
        int _data; // Datos del nodo
        Node *_next; // Apuntador al siguiente nodo
        Node *_prev; // Apuntador al nodo anterior

        public:
            // Constructor
            Node(int); // El apuntador siguiente siempre apunta a NULL

            // Pedimos la informacion del objeto
            // Se utiliza const por que no podemos modificar el objeto
            int data() const; // Nos devuelve el dato almacena
            Node *next() const; // Nos devuelve el siguiente nodo (si no existe retorna NULL)
            Node *prev() const; // Nos devuelve el nodo anterior (si no existe retorna NULL)

            // Metodo que permite modificar el apuntador
            // Asigno y me retorna el nuevo nodo
            Node *next(Node *);
            Node *prev(Node *);
    };

    Node *start; // Nodo Front
    Node *final; // Nodo Rear
    int _n; // Capacidad del dipole
    int _s; // Tamaño del dipole

    public:
        // Constructor
        Dipole(int);
        // Destructor
        ~Dipole();

        // Funciones de utileria
        int capacity() const { return _n; } // Obtenemos capacidad
        int size() const { return _s; } // Obtenemos tamaño
        bool empty() { return _s == 0; } // Vacuidad
        bool full() { return _s == _n; } // Plenitud

        // Metodos para dipoles
        void enqueueFront(int); // Insertamos nodo por el frente
        void enqueueRear(int); // Insertamos nodo por detras
        int dequeueFront(); // Obtiene nodo y lo eliminamos por el frente
        int dequeueRear(); // Obtiene nodo y lo elimina por detras
        int front(); // Obtiene el dato por el frente
        int rear(); // Obtiene el dato por detras
};

#endif // DIPOLE_HPP_INCLUDED
