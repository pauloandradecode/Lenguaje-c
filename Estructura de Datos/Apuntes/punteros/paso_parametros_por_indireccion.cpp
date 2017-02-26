/*
Fecha: 20/02/2017
Nota: El paso de parametros por indirección se realiza de la misma forma
    en la que declaramos e inicializamos un puntero.-

    // Forma normal
    int num = 10;
    int *p = &num;

    // Se declara el puntero desde los parametros de la función
    void swap(int *a, int *b)

    // Se inicializa al momento de llamar a la función
    swap(&x, &y)
*/

#include <cstdio>

// Paso de variables por referencia
void swap(int *a, int *b)
{
    // Como a y b son apuntadores necesitamos indereccionar
    // para acceder a su valor

    int x = *a;
    *a = *b;
    *b = x;
}

void ejemplo()
{
    int x = 4;
    int y = 6;

    printf("x: %i y: %i\n", x, y);

    // Llamamos a la funcion
    swap(&x, &y);

    printf("x: %i y: %i\n", x, y);
}

int main()
{
    ejemplo();

    return 0;
}
