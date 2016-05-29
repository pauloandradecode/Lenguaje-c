/**********************************************
* Programa 2 - Practica 1
* Fecha: 18/04/2016
* Nombre: I.V.A.
* Notas: Para usar presicion de decimales con cout, debemos incluir la cabecera iomanip
*        para poder utilizar setprecision(numero_decimales), tambien utilizamos el flag
*        fixed para usar la notacion de punto decimal.
**********************************************/

#include <cstdio>

int main()
{
    float precio, iva, total;

    printf("Precio del producto: ");
    scanf("%f", &precio);

    iva = precio * 0.16;
    total = precio * 1.16;

    printf("\nI.V.A.: %.2f", iva);
    printf("\nTotal: %.2f\n", total);

    return 0;
}
