/*
* Fecha: 26/04/2016
*
* Ejemplo de definicion de un nuevo tipo de dato
*/

#include <cstdio>

// Declaramos un tipo de dato
typedef enum {
    lun = 1, mar, mie, jue, vie, sab, dom
} dia;

int main()
{
    // Declaramos una variable  y empezamos desde lunes
    dia d = lun;

    // Verificamos si no es domingo
    if(d != dom){
        // Mostramos mensajes
        printf("No es domingo\n");
        printf("A trabajar!!\n");
    }

    return 0;
}

