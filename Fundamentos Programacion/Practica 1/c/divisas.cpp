/**********************************************
* Programa 4 - Practica 1
* Fecha: 18/04/2016
* Nombre: Divisas
**********************************************/

#include <cstdio>

int main()
{
    float dolares, pesos, tasaCambio = 13.1803;

    printf("Ingrese la cantidad en dolares: ");
    scanf("%f", &dolares);

    pesos = dolares * tasaCambio;

    printf("\nTotal en pesos: %.2f\n", pesos);

    return 0;
}

