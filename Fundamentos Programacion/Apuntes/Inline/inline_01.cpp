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
inline void inc(int &);

int main()
{
    // Utilizamos la funcion inline
    for(int i = 0; i < 10; inc(i)){
        printf("Hola mundo\n");
    }

    return 0;
}

// Implementacion de las funciones
inline void inc(int &i)
{
    // Incrementamos i
    i++;
}
