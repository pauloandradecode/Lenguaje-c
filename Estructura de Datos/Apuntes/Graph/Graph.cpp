/*
Fecha: 16/05/2017
Nombre: Paulo Cesar Andrade Gonzalez
Notas: Implementación de grafos
*/

#include <cstdio>
#include "Graph.hpp"

/*********************************************
Implementación clase Graph
*********************************************/

// Constructor
Graph::Graph(int n): _n(n)
{
    E = new bool[_n * (_n - 1) / 2]; // creamos el array caracteristico

    // llenamos el array
    for(int i = 0; i < (_n * (_n - 1) / 2); i++) E[i] = 0;

    // Obtenemos la maxima cantidad de aristas
    _m = _n * (_n + 1) / 2;
}

// Destructor
Graph::~Graph()
{
    delete E; // Eliminamos array caracteristico
}

// Funcion caracteristica
int Graph::f(int i, int j)
{
    // Verificamos
    if(i == j) return 0; // No existe el vertice
    if(i < j){
        // Intercambiamos ya que el vertice se encuentra en la triangular superior
        int aux = i;
        i = j;
        j = aux;
    }

    // Obtenemos el vertice
    return ((i - 1) + (i - 2)) / 2 + (j - 1);
}

// Imprimimos el grafo
void Graph::print()
{
    printf("E: [");

    for(int i = 0; i < (_n * (_n - 1) / 2); i++){
        printf("%3i", E[i]);
    }

    printf("]");
}
