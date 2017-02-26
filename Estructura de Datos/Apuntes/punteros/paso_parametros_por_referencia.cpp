/*
Fecha: 20/02/2017
Nota:
*/

#include <cstdio>

// Paso de variables por referencia
void swap(int &a, int &b)
{
    // Se puede acceder al valor del parametro sin utilizar indireccion
    int x = a;
    a = b;
    b = x;
}

void ejemplo()
{
    int x = 4;
    int y = 6;

    printf("x: %i y: %i\n", x, y);

    // Llamamos a la funcion
    swap(x, y);

    printf("x: %i y: %i\n", x, y);
}

int main()
{
    ejemplo();

    return 0;
}
