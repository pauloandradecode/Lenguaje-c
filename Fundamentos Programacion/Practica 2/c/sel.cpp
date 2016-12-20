/**********************************************
* Programa 4 - Practica 2
* Fecha: 18/04/2016
* Nombre: Andrade Gonzalez Paulo Cesar
**********************************************/

#include <cstdio>

int main()
{
    float a, b, c, d, e, f, x , y;

    printf("------------------------------\n");
    printf("Sistema de ecuaciones lineales\n");
    printf("------------------------------\n\n");

    printf("Ingrese los valores de la primer ecuaci\242n separados por comas: ");
    scanf("%f,%f,%f", &a, &b, &c);

    printf("Ingrese los valores de la segunda ecuaci\242n separados por comas: ");
    scanf("%f,%f,%f", &d, &e, &f);

    // Encontramos el valor de X
    x = (c*e - e*f) / (a*e - b*d);

    // Encontramos el valor de Y
    y = (a*f - c*d) / (a*e - b*d);

    printf("\nResultado de X: %.2f", x);
    printf("\nResultado de Y: %.2f", y);

    return 0;
}
