/**********************************************
* Programa 5 - Practica 1
* Fecha: 18/04/2016
* Nombre: Circulo
**********************************************/

#include <cstdio>
#define PI 3.1416

int main()
{
    float radio, diametro, area, perimetro;

    printf("Ingrese el radio del circulo: ");
    scanf("%f", &radio);

    diametro = radio * 2;
    area = PI * (radio * radio);
    perimetro = 2 * PI * radio;

    printf("\nDiametro: %.4f", diametro);
    printf("\nPerimetro: %.4f", perimetro);
    printf("\nArea: %.4f\n", area);

    return 0;
}
