/*
Fecha: 27/03/2017
Nota: Pilas con estructuras dinamicas - Estructura lineal
*/

#include <cstdio>
#include <cstdlib>
#include <ctime>
#include "Stack.hpp"

int main()
{
    // Semilla para numeros aleatorios
    srand((unsigned) time(NULL));

    // Creamos una pila
    Stack pila(10);

    // Generamos numeros aleatorios con rango 1 - 20
    int n = rand() % 20 + 1;
    printf("%i datos: \n\n", n);

    // Insertamos los datos a la pila
    for(int i = 0; i < n; i++){
        int data = rand() % 100 + 1;
        printf("Push %i\n", data);
        pila.push(data);
    }

    printf("\n\n Vaciando la pila \n\n");

    // Mostramos y vaciamos la pila
    while(!pila.empty()){
        printf("Pop %i\n", pila.pop());
    }

    return 0;
}
