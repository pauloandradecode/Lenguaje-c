/**********************************************
* Programa 9 - Practica 1
* Fecha: 18/04/2016
* Nombre: Rotacion
**********************************************/

#include <cstdio>

int main()
{
    int a, b, c, temp;

    printf("Ingrese tres numeros: ");
    scanf("%i%i%i", &a, &b, &c);

    temp = a;
    a = b;
    b = c;
    c = temp;

    printf("\nEl valor de A es: %i", a);
    printf("\nEl valor de B es: %i", b);
    printf("\nEl valor de C es: %i\n", c);

    return 0;
}
