/**********************************************
* Programa 2 - Practica 2
* Fecha: 18/04/2016
* Nombre: Swap
**********************************************/

#include <cstdio>

int main()
{
    int x, y, aux;

    puts("Ingres dos variables enteras X, Y: ");
    scanf("%i , %i", &x, &y);

    aux = x;
    x = y;
    y = aux;

    printf("\nX: %i", x);
    printf("\nY: %i", y);

    return 0;
}
