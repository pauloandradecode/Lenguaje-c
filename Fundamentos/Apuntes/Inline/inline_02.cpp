/*
* Fecha: 31/05/2016
*
* Ejemplo de funciones en linea (inline), es decir, podemos escribir el cuerpo de una funcion
* en una sola linea de codigo.
* Nota: Para poder utilizar el mofificador inline, se requiere que el cuerpo de la funcion sea
*       de una o maximo dos lineas (el compilador hace una sustitucion del llamado a la funcion
        por el cuerpo de la funcion, ahorrando memoria y recursos [más eficiente]).
*/

#include <cstdio>

// Prototipo de las funciones
inline int select(int, int);

int main()
{
    // Utilizamos la funcion inline
    printf("%i", select(45,78));

    return 0;
}

// Implementacion de las funciones
inline int select(int a, int b)
{
    return a > b ? a : b;
}
