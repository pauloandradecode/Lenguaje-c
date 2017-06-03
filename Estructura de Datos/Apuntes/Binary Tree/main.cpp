/*
Autor: Paulo Andrade
Fecha: 26/04/2017
Nota: Implementacion de colas con estructuras dinamicas
    para uso con arboles binarios
*/

#include <cstdio>
#include <cstdlib>
#include <ctime>
#include "Queue.hpp"

int main()
{
    // Semilla para numeros aleatorios
    srand((unsigned) time(NULL));

    // Creamos un arbol
    Queue tree(10);

    // Generamos numeros aleatorios con rango 1 - 20
    int n = rand() % 20 + 1;
    printf("%i datos: \n", n);

    // Insertamos los datos al arbol
    for(int i = 0; i < n; i++){
        int data = rand() % 100 + 1;
        printf("\nPush %i", data);
        if(tree.ins(data)) printf(" - Insertado");
    }

    printf("\n\nContenido del arbol: ");
    tree.print();

    printf("\n\n Eliminando datos aleatorios \n\n");

    /*
    int z;
    while(true){
        scanf("%i", &z);
        if(tree.sup(z)){
            printf(" - Eliminado");
            printf("\nContenido del arbol: ");
            tree.print();
        } else printf(" - No encontrado");
    }
    */

    for(int i = 0; i < n; i++){
        int data = rand() % 100 + 1;
        printf("\nPop %i", data);
        if(tree.sup(data)){
            printf(" - Eliminado");
            printf("\nContenido del arbol: ");
            tree.print();
        } else printf(" - No encontrado");
    }

    printf("\n\n");

    return 0;
}
