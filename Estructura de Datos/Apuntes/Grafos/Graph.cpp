/*
Name: Paulo Cesar Andrade
Fecha: 17/05/2017
Notas: Implementación de grafos (ejemplo profe Aguilar)
*/

#include <cstdio>
#include "Graph.hpp"

/*********************************************
Implementación clase Graph
*********************************************/

// Constructor
Graph::Graph(int n): _n(n)
{
    // Obtenemos la maxima cantidad de aristas
    _m_max = _n * (_n - 1) / 2;

    // _v = new bool[_n = n];
    _v = new bool[_m_max]; // creamos el array caracteristico

    // llenamos el array
    for(int i = 0; i < _m_max; i++) _v[i] = 0;
}

// Destructor
Graph::~Graph()
{
    delete _v; // Eliminamos array caracteristico
}

// Funcion caracteristica
int Graph::_f(int u, int v)
{
    // Verificamos
    if(u == v) return 0; // No existe el vertice
    if(u < v){
        // Intercambiamos ya que el vertice se encuentra en la triangular superior
        int aux = u;
        u = v;
        v = aux;
    }

    // Obtenemos el vertice
    return ((u - 1) * (u - 2)) / 2 + (v - 1);
}

// Regresa o pone arista
bool &Graph::edge(int i, int j)
{
    return _v[_f(i, j)];
}

// Imprimimos un grafo (función amiga)
void print(Graph &g)
{
    printf("v[%i] = ", g._m_max);

    for(int i = 0; i < g._m_max; i++){
        printf("%2i", g._v[i]);
    }

    printf("\n");
}
