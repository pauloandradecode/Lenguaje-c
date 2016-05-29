/**********************************************
* Programa 6 - Practica 1
* Fecha: 18/04/2016
* Nombre: Promedio
**********************************************/

#include <cstdio>

int main()
{
    float a,b,c,d,e, promedio = 0.0;

    printf("Ingrese la edad de la persona 1: ");
    scanf("%f", &a);
    printf("Ingrese la edad de la persona 2: ");
    scanf("%f", &b);
    printf("Ingrese la edad de la persona 3: ");
    scanf("%f", &c);
    printf("Ingrese la edad de la persona 4: ");
    scanf("%f", &d);
    printf("Ingrese la edad de la persona 5: ");
    scanf("%f", &e);

    promedio = (a + b + c + d + e) / 5;

    printf("\nEl promedio de las edades es: %.1f\n", promedio);

    return 0;
}
