/*
* Fecha: 24/05/2016
*
* Ejemplo de utilizar un alias de una variable
*/

#include <cstdio>

int main()
{
    int x = 0;
    // declaramos un alias de la variabe X
    int &a = x;

    printf("%i\n", a);

    x++;

    printf("%i\n", a);

    return 0;
}
