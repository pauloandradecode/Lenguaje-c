/**********************************************
* Programa 3 - Practica 1
* Fecha: 18/04/2016
* Nombre: Descuento
**********************************************/

#include <cstdio>

int main()
{
    float precio, descuento, total;

    printf("Ingrese el precio del producto: ");
    scanf("%f", &precio);
    printf("Ingrese el descuento a aplicar (porcentaje): ");
    scanf("%f", &descuento);

    total = precio - (precio * descuento / 100);

    printf("\nTotal a pagar: %.2f\n", total);

    return 0;
}
