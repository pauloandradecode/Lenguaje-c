/*
Fecha; 27/03/2017
Nota: Implementacion de colas con array
*/

#include <cstdio>
#include <cstdlib>
#include <ctime>
#include "Queue.hpp"

int main()
{
    // Semilla para numeros aleatorios
    srand((unsigned) time(NULL));

    // Creamos una pila
    Queue cola(10);

    // Generamos numeros aleatorios con rango 1 - 20
    int n = rand() % 20 + 1;
    printf("%i datos: \n\n", n);

    // Insertamos los datos a la pila
    for(int i = 0; i < n; i++){
        int data = rand() % 100 + 1;
        printf("Push %i\n", data);
        cola.enqueue(data);
    }

    printf("\n\n Vaciando la cola \n\n");

    // Mostramos y vaciamos la pila
    while(!cola.empty()){
        printf("Pop %i\n", cola.dequeue());
    }

    return 0;
}
