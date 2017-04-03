/*
Fecha:03/04/2017

Nombre: Paulo Cesar Andrade Gonzalez
Nota:
*/

#include <cstdio>
#include <cstdlib>
#include <ctime>
#include "olist.hpp"

int main()
{
    // Semilla para numeros aleatorios
    srand((unsigned) time(NULL));

    // Creamos una lista
    List l(10);

    // Generamos numeros aleatorios con rango 1 - 20
    int n = rand() % 19 + 1;
    // printf("%i datos: \n\n", n);

    // Insertamos los datos a la pila
    for(int i = 0; i < n; i++){
        // eneramos un dato aleatorio
        int x = rand() % 100 + 1;
        // Imprimimos el valor a insertar
        printf("Adding %i\n", x);
        // Insertamos el dato
        l.ins(x);
    }

    // Imprimimos la lista
    print(l);

    return 0;
}
