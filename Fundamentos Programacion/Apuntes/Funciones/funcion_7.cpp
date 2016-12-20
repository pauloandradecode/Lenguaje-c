/*
* Fecha: 24/05/2016
*
* Ejemplo de sobrecarga de funciones
* (Escritura de varias funciones con un mismo nombre)
*/

#include <cstdio>

// Prototipos de las funciones
void tipo(int);
void tipo(float);

int main()
{
    int x = 0;
    float y = 0.0;

    // Llamado a las funciones
    tipo(x);
    tipo(y);

    return 0;
}

// Implementacion de las funciones
void tipo(int a)
{
    printf("Variable entera: %i\n", a);
}

void tipo(float b)
{
    printf("Variable flotante: %.2f\n", b);
}
