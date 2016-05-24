/*
* Fecha: 24/05/2016
*
* Ejemplo de parametros con inicializacion por defecto
*/

#include <cstdio>

// Declaramos un tipo de dato
typedef struct{
    int num; // Numerador
    int den; // Denominador
} racional;

// Prototipos de las funciones
racional construir(int, int);
void imprime(racional);

int main()
{
    // Llamamos a las funciones
    racional x = construir(4, 5);
    racional y = construir(3);

    imprime(x);
    imprime(y);

    return 0;
}

// Implementacion de las funciones
racional construir(int a, int b = 1)
{
    racional r;
    r.num = a;
    r.den = b;

    return r;
}

void imprime(racional r)
{
    printf("[%i,%i]\n", r.num, r.den);
}
