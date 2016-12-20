/*
* Fecha: 24/05/2016
*
* Ejemplo de funcion con dominio vacio (void)
* con argumento por referencia
*
* Para utilizar un argumento por referencia utilizamos un amperson (&)
* anteponiendolo al nombre de la variable.
*/

#include <cstdio>

// Prototipo de la funcion
void inc(int &);

int main()
{
    int x = 5;

    // llamado a la funcion
    inc(x);

    printf("X: %i", x);

    return 0;
}

// Implementacion de la funcion
void inc(int &n)
{
    n += 1;
}
