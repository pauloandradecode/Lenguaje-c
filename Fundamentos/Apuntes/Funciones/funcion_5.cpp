/*
* Fecha: 24/05/2016
*
* Ejemplo de funcion con dominio vacio (void)
*/

#include <cstdio>

// Prototipo de la funcion
void linea(int);

int main()
{
    printf("T\241tulo del programa\n");
    // Llamado a la funcion
    linea(20);

    return 0;
}

// Implementacion de la funcion
void linea(int n)
{
    // Esta funcion genera saltos de linea
    for(int i = 0; i < 20; i++){
        // putchar('\n');
        putchar('-');
    }

    putchar('\n');
}
