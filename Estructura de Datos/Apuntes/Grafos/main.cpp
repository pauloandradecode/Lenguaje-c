/*
Name: Paulo Cesar Andrade
Fecha: 17/05/2017
Notas: Implementación de grafos
    true = 1 (numero distinto a 0) y false = 0
*/

#include <cstdio>
#include <cstdlib>
#include <ctime>
#include "Graph.hpp"
#include "Stack.hpp"

int main()
{
    // Creamos un grafo de 6 aristas
    Graph g(16);

    // Agregamos vertices
    g.edge(1, 14) = true;
    g.edge(2, 14) = true;
    g.edge(2, 12) = true;
    g.edge(3, 7) = true;
    g.edge(3, 9) = true;
    g.edge(3, 6) = true;
    g.edge(4, 7) = true;
    g.edge(5, 14) = true;
    g.edge(5, 8) = true;
    g.edge(6, 8) = true;
    g.edge(6, 15) = true;
    g.edge(7, 9) = true;
    g.edge(7, 16) = true;
    g.edge(8, 10) = true;
    g.edge(8, 9) = true;
    g.edge(11, 9) = true;
    g.edge(11, 15) = true;
    g.edge(11, 13) = true;
    g.edge(12, 15) = true;
    g.edge(13, 16) = true;
    g.edge(15, 16) = true;

    // Imprimimos el grafo
    print(g);

    // Probamos busqueda en profundidad
    Stack dfs = g.DFS(16, 2);
    printf("\n\nBusqueda DFS [16, 2]: ");
    dfs.print();

    // Probamos la busqueda en amplitud
    printf("Busqueda BFS [16, 2]: ");
    if(g.BFS(16, 2)) printf("True\n");
    else printf("False\n");

    // probamos camino mas corto
    printf("Busqueda SP [16, 2]: ");
    Stack sp = g.SP(16, 2);
    sp.print();

    return 0;
}
