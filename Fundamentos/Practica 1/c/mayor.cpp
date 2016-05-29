/**********************************************
* Programa 7 - Practica 1
* Fecha: 18/04/2016
* Nombre: Mayor
**********************************************/

#include <cstdio>

int main()
{
    int num1, num2, mayor;

    printf("Ingrese dos numeros: ");
    scanf("%i %i", &num1, &num2);

    mayor = (num1 > num2) ? num1 : num2;

    printf("\nEl numero mayor es: %i\n", mayor);

    return 0;
}
