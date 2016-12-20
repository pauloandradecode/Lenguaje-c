/**********************************************
* Programa 8 - Practica 1
* Fecha: 18/04/2016
* Nombre: Salario
**********************************************/

#include <cstdio>

int main()
{
    float pago, horas, deducciones, porcentaje, total;

    printf("Pago por hora: ");
    scanf("%f", &pago);
    printf("Horas trabajadas: ");
    scanf("%f", &horas);
    printf("Porcentaje de deducciones: ");
    scanf("%f", &porcentaje);

    total = pago * horas;
    deducciones = total * porcentaje / 100;
    total -= deducciones;

    printf("\nTotal a pagar: %.2f\n", total);

    return 0;
}
