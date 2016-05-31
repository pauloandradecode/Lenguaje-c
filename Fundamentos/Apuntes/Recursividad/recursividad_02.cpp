/*
* Fecha: 30/05/2016
*
* Ejemplo de ejecucion recursiva (serie fibonacci) vamos a imprimirla
* Nota: La base para encontrar el numero fibonacci es.-
*       1               si n == 1
*       1               si n == 1
*       fn-1 + fn -2    si n > 2
*/

#include <cstdio>

// Prototipo de las funciones
int fibo(int);

int main()
{
    int limite;

    printf("Serie Fibonacci: ");
    scanf("%i", &limite);
    printf("\n");

    // Imprimimos la serie fibonacci
    for(int i = 1; i <= limite; i++){
        printf("f%i: %i\n", i, fibo(i));
    }

    return 0;
}

// Implementacion de las funciones
int fibo(int n)
{
    // Base
    if(n == 1 || n == 2) return 1;

    // Inducción
    return fibo(n - 1) + fibo(n - 2);
}
