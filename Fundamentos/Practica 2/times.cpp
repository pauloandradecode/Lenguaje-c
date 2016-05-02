/**********************************************
* Programa 3 - Practica 2
* Fecha: 18/04/2016
* Nombre: times
**********************************************/

#include <cstdio>

int main()
{
    int num1 = 0, num2 = 0;

    puts("Ingrese dos numeros enteros entre 0 y 9999 (separe con una coma): ");
    scanf("%i , %i", &num1, &num2);

    printf("\nEl producto de ambos numeros es:\n");

    printf("\n%8i", num1);
    printf("\n*%7i", num2);
    printf("\n--------");

    return 0;
}
