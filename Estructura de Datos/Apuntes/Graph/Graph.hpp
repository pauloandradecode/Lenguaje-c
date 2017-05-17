/*
Fecha: 16/05/2017
Nombre: Paulo Cesar Andrade Gonzalez
Notas: Implementación de grafos
*/

#ifndef GRAPH_HPP_INCLUDED
#define GRAPH_HPP_INCLUDED

// Clase grafo
class Graph
{
    int _n; // N aristas del grafo
    int _m; // Maxima cantidad de aristas
    bool *E; // areglo caracteristico

    public:
        Graph(int); // Constructor
        ~Graph(); // Destructor

        // Métodos de utileria
        int n() const { return _n; } // Obtenemos el numero de aristas
        int m() const { return _m; } // Obtenemos el maximo de vertices

        // Métodos
        int f(int, int); // Funcion caracteristica
        void print(); // Imprimimos el array caracteristico
};

#endif // GRAPH_HPP_INCLUDED
