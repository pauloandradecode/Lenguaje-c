/*
* Fecha: 30/05/2016
*
* Ejemplo de parametros con inicializacion por defecto con sobrecarga de funciones
* (es mejor utilizar la inicializacion por defecto)
*/

#include <cstdio>

// Declaramos un tipo de dato para variables de tipo racional
typedef struct{
    int num; // Numerador
    int den; // Denominador
} racional;

// Prototipos de las funciones
racional construir();
racional construir(int);
racional construir(int, int);
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
racional construir()
{
    // Declaramos un tipo de dato racional
    racional r;

    // Asignamos valores
    r.num = 0;
    r.den = 1;

    return r;
}

racional construir(int a)
{
    // Declaramos un tipo de dato racional
    racional r;

    // Asignamos valores
    r.num = a;
    r.den = 1;

    return r;
}

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
