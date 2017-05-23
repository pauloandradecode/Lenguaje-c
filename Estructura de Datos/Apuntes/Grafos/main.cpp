/*
Name: Paulo Cesar Andrade
Fecha: 17/05/2017
Notas: Implementación de grafos (ejemplo profe Aguilar)
    true = 1 (numero distinto a 0) y false = 0
*/

#include <cstdio>
#include <cstdlib>
#include <ctime>
#include "Graph.hpp"

int main()
{
    // Creamos un grafo de 6 aristas
    Graph g(6);

    // Agregamos vertices
    g.edge(1, 3) = true;
    g.edge(1, 6) = true;
    g.edge(2, 3) = true;
    g.edge(2, 4) = true;
    g.edge(2, 5) = true;
    g.edge(5, 3) = true;
    g.edge(4, 5) = true;
    g.edge(4, 6) = true;
    g.edge(6, 5) = true;

    // Imprimimos el grafo
    print(g);

    return 0;
}
