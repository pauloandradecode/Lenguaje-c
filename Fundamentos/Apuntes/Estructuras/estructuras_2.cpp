/*
* Fecha: 18/04/2016
*
* Ejemplo declaracion de estructuras con un mismo tipo de estructuras
*/

#include <cstdio>

using namespace std;

struct fecha{
    unsigned dia;
    unsigned mes;
    unsigned annio;
};

int main()
{
    struct fecha nacimiento = {3, 5, 1997};
    struct fecha ingreso;

    printf("Fecha de ingreso: \n\n");
    printf("Dia: ");
    scanf("%i", &ingreso.dia);
    printf("Mes: ");
    scanf("%i", &ingreso.mes);
    printf("A\244o: ");
    scanf("%i", &ingreso.annio);

    printf("\nFecha de nacimiento: %i/%i/%i", nacimiento.dia,
           nacimiento.mes,
           nacimiento.annio);

    printf("\nFecha de ingreso: %i/%i/%i", ingreso.dia,
           ingreso.mes,
           ingreso.annio);

    return 0;
}
