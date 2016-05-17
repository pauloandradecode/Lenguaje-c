/*
* Fecha: 17/05/2016
*
* Funciones (casting)
* La funcion de casting se utiliza para transformar un tipo de dato en otro
* Esto es anteceder a una variable con un tipo de dato entre parentesis
* En C, el casting es algo que ya esta predefinido
*/

#include <cstdio>

int main()
{
    float pi = 3.14159;
    // Uso de la funcion casting
    int int_pi = (int) pi;
    // int int_pi = pi; // Casting automatico

    printf("%i\n", int_pi);

    return 0;
}
