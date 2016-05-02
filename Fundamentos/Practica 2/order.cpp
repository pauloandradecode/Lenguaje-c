/**********************************************
* Programa 1 - Practica 2
* Fecha: 18/04/2016
* Nombre: Andrade Gonzalez Paulo Cesar
**********************************************/

#include <cstdio>

int main()
{
    int num1, num2, mayor, menor;

    puts("Ingrese dos numeros enteros: ");
    scanf("%i , %i", &num1, &num2);

    mayor = (num1 > num2) ? num1 : num2;
    menor = (num1 < num2) ? num1 : num2;

    printf("\nMayor: %i", mayor);
    printf("\nMenor: %i", menor);

    return 0;
}
