/*
* Fecha: 17/05/2016
*
* Funciones
* Ejemplo del uso de una funcion succ con prototipo e implementacion
* succ: Z -> Z + 1
*/

#include <cstdio>

// Prototipo de la funcion
int succ(int);

int main()
{
    int i = 1;

    while(i <= 10){
        printf("Hola mundo\n");

        // Llamao a la funcion
        i = succ(i);
    }

    return 0;
}

// Implementacion de la funcion
int succ(int x)
{
    return x + 1;
}
