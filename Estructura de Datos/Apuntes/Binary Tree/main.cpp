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

    return 0;
}
