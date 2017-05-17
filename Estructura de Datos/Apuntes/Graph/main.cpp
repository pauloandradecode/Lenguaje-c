/*
Fecha: 16/05/2017
Nombre: Paulo Cesar Andrade Gonzalez
Notas: Implementación de grafos
*/

#include <cstdio>
#include <cstdlib>
#include <ctime>
#include "Graph.hpp"

int main()
{
    // Numeros aleatorios
    srand((unsigned) time(NULL));

    // Creamos un grafo con 10 vertices
    Graph g(10);

    // Imprimimos el grafo
    g.print();

    return 0;
}
