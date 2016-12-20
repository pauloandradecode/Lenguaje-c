/*
* Fecha: 18/04/2016
*
* Ejemplo de una estructura
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

    printf("Fecha de nacimiento: %i/%i/%i", nacimiento.dia,
           nacimiento.mes,
           nacimiento.annio);

    return 0;
}
