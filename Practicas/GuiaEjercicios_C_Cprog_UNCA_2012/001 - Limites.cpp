/***********************************************
* Ejercicio 1
*
* Nombre: Limites
* Descripcion: Diseñe un algoritmo que, dado un número real que entra como dato, nos indique si está
*     contenido dentro de los límites predeterminados. El límite inferior es de 100 y el superior de 200.
* Pagina: 14
* Fecha: 06/05/2016
***********************************************/

#include <cstdio>
#define INFERIOR 100
#define SUPERIOR 200

int main()
{
    int num = 0;

    puts("Introduzca un dato entero: ");
    scanf("%i", &num);

    if(num >= INFERIOR){
        if(num <= SUPERIOR){
            puts("\nSe encuentra dentro de los limites");
        } else {
            puts("\nSupera el limite inferior");
        }
    } else {
        puts("\nNo alcanza el limite inferior");
    }

    return 0;
}
