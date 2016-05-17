/*
* Fecha: 17/05/2016
*
* Funciones
* round: R -> E
*/

#include <cstdio>

// Prototipo de la funcion
int round(float);

int main()
{
    int aux;
    float num;

    scanf("%f", &num);

    // Llamado a la funcion
    aux = round(num);

    printf("%i", aux);

    return 0;
}

// Implementacion de la funcion
int round(float x)
{
    int y = x;
    // int y = () ? x : x + 1;

    return y;
}
