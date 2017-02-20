/*
Fecha: 20/02/2017
Nota: Ejemplo mediante indireccion
*/

#include <cstdio>

void ejemplo()
{
    int a = 75;
    // Inicializacion por referenciacion
    int *p = &a;

    printf("a: %i\n", a);
    // Indireccion
    printf("a: %i\n", *p);

    a += 5;

    printf("a: %i\n", a);
    // Indireccion
    printf("a: %i\n", *p);

    // Modificamos valor mediante indireccion
    *p += 5;

    printf("a: %i\n", a);
    // Indireccion
    printf("a: %i\n", *p);

    // Imprimos la direccion de memoria (base 10)
    printf("\np: %u\n", p);
    // Imprimos la direccion de memoria en hexadecimal
    printf("\np: %x\n", p);
}

int main()
{
    ejemplo();

    return 0;
}
