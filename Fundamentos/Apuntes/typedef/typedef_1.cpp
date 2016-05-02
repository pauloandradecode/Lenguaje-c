/*
* Fecha: 26/04/2016
*
* Ejemplo de definicion de un nuevo tipo de dato
* El ejemplo no es funcional
*/

#include <cstdio>

// Declaramos un tipo de dato de estructura
typedef struct {
    float x, y;
} punto;

int main()
{
    // Utilizamos el nuevo tipo de dato
    punto origen;
    punto p;
    origen.x = 0;
    origen.y = 0;
    p = origen;

    // ....
    printf("X = %i\n", p.x);
    printf("Y = %i\n", p.y);

    return 0;
}
