/**********************************************
* Programa 4 - Practica 3
* Fecha: 24/04/2016
* Nombre: Andrade Gonzalez Paulo Cesar
* Nota: El programa debera capturar el monto de la compra y el pago, y desglosar
*       el cambio en las cantidades 500, 50, 20, 2
**********************************************/

#include <cstdio>

void denom(int, int &);

int main()
{
    int compra, pago, cambio;

    printf("Ingrese el monto de la compra: ");
    scanf("%d", &compra);

    printf("Ingrese el monto del pago: ");
    scanf("%d", &pago);

    cambio = pago - compra;

    printf("\nMonto de la compra: $%d\n", compra);
    printf("Pago: $%d\n", pago);
    printf("Cambio: $%d\n\n", cambio);
    printf("Conformacion del cambio:\n\n");
    printf(" Denom    n\n");

    if(cambio >= 500) denom(500, cambio);
    if(cambio >= 50) denom(50, cambio);
    if(cambio >= 20) denom(20, cambio);
    if(cambio >= 2) denom(2, cambio);

    return 0;
}

void denom(int num,int &cambio)
{
    printf("%6d%5d\n",num , cambio / num);
    cambio %= num;
}
