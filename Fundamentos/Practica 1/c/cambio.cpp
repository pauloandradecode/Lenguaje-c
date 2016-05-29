/**********************************************
* Programa 1 - Practica 1
* Fecha: 18/04/2016
* Nombre: Cambio
**********************************************/

#include <cstdio>

int main()
{
    float dinero, total, cambio;

    printf("Ingrese el total de la venta: ");
    scanf("%f", &total);
    printf("Ingrese el dinero recibido: ");
    scanf("%f", &dinero);

    cambio = dinero - total;

    printf("\nSu cambio: %.2f\n", cambio);

    return 0;
}
