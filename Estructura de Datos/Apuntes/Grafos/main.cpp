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
    srand((unsigned) time(NULL));

    int n = 10;
    Graph g(n);

    printf("Extraemos datos: \n\n");
    for(int i = 0; i < n; i++){
        int u = rand() % 100 + 1;
        int v = rand() % 100 + 1;
        printf("[%i,%i] = %i ", u, v,g.edge(u, v));
    }

    printf("\n\nImprimimos: \n\n");
    print(g);

    return 0;
}
