/*
Fecha:29/03/2017

Nombre: Paulo Cesar Andrade Gonzalez
Nota: Implementacion de listas ordenadas con estructuras dinamicas
*/

#include <cstdio>
#include <cstdlib>
#include <ctime>
#include "List.hpp"

int main()
{
    // Semilla para numeros aleatorios
    srand((unsigned) time(NULL));

    // Creamos una lista
    List lista(10);

    // Generamos numeros aleatorios con rango 1 - 20
    int n = rand() % 20 + 1;
    printf("%i datos: \n\n", n);

    // Insertamos los datos a la pila
    for(int i = 0; i < n; i++){
        int data = rand() % 100 + 1;
        printf("Push %i ", data);
        if(lista.ins(data)) printf("insertado\n");
        else printf("no insertado\n");
    }

    printf("\n\n Vaciando la lista ordenada \n\n");

    // Mostramos y vaciamos la pila
    while(!lista.empty()){
        // Mostramos el tamaño de la cola y el valor obtenido
        printf("[%i]: Pop %i\n", lista.size(), lista.ext());
    }

    return 0;
}
