/*
Name: Paulo Cesar Andrade
Fecha: 17/05/2017
Notas: Implementación de grafos
*/

#include <cstdio>
#include "Queue.hpp"
#include "Stack.hpp"
#include "Set.hpp"

#ifndef GRAPH_HPP_INCLUDED
#define GRAPH_HPP_INCLUDED

// Clase grafo
class Graph
{
    static bool _x; // variable de contencion

    int _n; // N aristas del grafo
    int _m_max; // Maxima cantidad de aristas
    int _m; // Cuantas hay realmente - cantidad actual
    bool *_v; // areglo caracteristico
    int _f(int, int); // Funcion caracteristica

    friend void print(Graph &);

    public:
        Graph(int); // Constructor
        ~Graph(); // Destructor

        // Métodos de utileria
        int n() const { return _n; } // Obtenemos el numero de aristas
        int m() const { return _m; } // Obtenemos el maximo de vertices

        // Métodos
        bool &edge(int, int); // Regresa o pone arista
        Set vecindad(Set, int); // Obtenemos la vecindad
        Stack DFS(int, int); // Busqueda en profundidad
        bool BFS(int, int); // Busqueda en amplitud
        Stack SP(int, int); // Camino mas corto
};

// Funcion para imprimir
extern void print(Graph &g);

#endif // GRAPH_HPP_INCLUDED
