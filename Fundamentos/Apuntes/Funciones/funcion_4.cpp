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
int round(float num)
{
    int entero = num;
    float decimal = num - entero;

    entero = (decimal <= 0.5) ? num : num + 1;

    return entero;
}
