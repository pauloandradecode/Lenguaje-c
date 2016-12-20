/*
* Fecha: 24/05/2016
*
* Ejemplo de parametros con inicializacion por defecto
*/

#include <cstdio>

// Declaramos un tipo de dato para variables de tipo racional
typedef struct{
    int num; // Numerador
    int den; // Denominador
} racional;

// Prototipos de las funciones
racional construir(int, int = 1);
void imprime(racional);

int main()
{
    // Llamamos a las funciones para construir los numeros racionales
    racional x = construir(4, 5);
    racional y = construir(3);

    // Llamamos a las funciones para imprimir el resultado
    imprime(x);
    imprime(y);

    return 0;
}

// Implementacion de las funciones
racional construir(int a, int b)
{
    // Declaramos un tipo de dato racional
    racional r;

    // Asignamos valores
    r.num = a;
    r.den = b;

    return r;
}

void imprime(racional r)
{
    printf("[%i,%i]\n", r.num, r.den);
}
