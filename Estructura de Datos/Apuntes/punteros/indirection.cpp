/*
Fecha: 15/02/2017
Nota: La indireccion es la forma de acceder al dato almacenado
    en una variable por medio de un puntero

    *P (direccion de memoria)
    p (dato almacenado)
*/

#include <cstdio>

int main()
{
    // Aplicamos indireccion
    int num = 10;
    // Inicializacion por referenciacion
    int *p = &num;

    printf("%i", *p); // Accedemos a traves del puntero

    return 0;
}
