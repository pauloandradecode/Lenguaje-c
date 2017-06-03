/*
Name: Paulo Cesar Andrade
Fecha: 17/05/2017
Notas: Implementación de grafos (ejemplo profe Aguilar)
*/

#include <cstdio>
#include "Graph.hpp"
#include "Stack.hpp"
#include "Queue.hpp"

/*********************************************
Implementación elementos estaticos
*********************************************/

bool Graph::_x = false;

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
// Obtenemos el indice del array para acceder a el
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

// Regresa un valor almacenado en al array caracteristico
// Se le conoce como asignacion de funciones
bool &Graph::edge(int i, int j)
{
    // Validamos i , j
    if(i < 1 || i > _n || j < 1 || j > _n || i == j){
        // mensaje de error
        printf("[Graph]: bad index\n");

        // Retornamos una referencia (obligatoria)
        return _x; // Retornamos un variable de contecion
    }

    // Retornamos la variable, por eso podemos asignar valores cuando la retornamos
    return _v[_f(i, j)]; // Retornamos la referencia a la variable
}

// Imprimimos un grafo (función amiga)
void print(Graph &g)
{
    for(int i = 2; i <= g._n; i++){ // Corremos de 2 hasta n
        for(int j = 1; j < i; j++){ // corremos de 1 hasta (i - 1)
            // printf("[%i:%i] %i\n", i, j, g._v[g._f(i, j)]);
            printf("[%i:%i] %i\n", i, j, g.edge(i, j)); // Imprimimos el valor
        }
    }
}
