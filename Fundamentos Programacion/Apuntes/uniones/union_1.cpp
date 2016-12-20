/*
* Fecha: 26/04/2016
*
* Ejemplo de union
* Mostramos un programa donde utilizamos 3 componentes diferentes
*/

#include <cstdio>

// Declaramos una enumeracion o, 1
enum tiponumero { entero, real };

// Declaramos una estructura que tiene dos componentes
struct numero{
    // Primer componente
    enum tiponumero tipo;

    // Segundo componente
    union {
        int i; // 2 bite
        float r; // 4 bite (Tamaño de la union)
    } dato;
};

int main()
{
    // Declaramos una variable del tipo de la estructura
    struct numero x;

    // Le asignamos un tipo de dato real
    x.tipo = real;
    // Le asignamos un valor flotante
    x.dato.r = 4.0 / 7.0;

    // Mostramos el dato segun su tipo
    switch(x.tipo){
        case entero: printf("Dato: %i\n", x.dato.i); break;
        case real: printf("Dato %.4f", x.dato.r);
    }

    return 0;
}
