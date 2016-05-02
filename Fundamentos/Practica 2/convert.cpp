/**********************************************
* Programa 5 - Practica 2
* Fecha: 18/04/2016
* Nombre: Andrade Gonzalez Paulo Cesar
**********************************************/

#include <cstdio>

int main()
{
    float pies, yardas, pulgadas, centimetros, metros;

    printf("Ingrese el numero de pies a convertir: ");
    scanf("%f", &pies);

    // Obtenemos las conversiones
    yardas = pies / 3;
    pulgadas = pies * 12;
    centimetros = pulgadas * 2.54;
    metros = centimetros / 100;

    printf("\n%10.4f pie(s) equivale a:\n\n", pies);
    printf("%10.4f yardas\n", yardas);
    printf("%10.4f pulgadas\n", pulgadas);
    printf("%10.4f cent\241metros\n", centimetros);
    printf("%10.4f metros\n", metros);

    return 0;
}
