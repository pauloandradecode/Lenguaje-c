/*
* Fecha: 30/05/2016
*
* Ejemplo de ejecucion recursiva (serie fibonacci)
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
    int i,f;

    scanf("%i", &i);

    f = fibo(i);

    printf("\nf%i: %i\n", i, f);

    return 0;
}

// Implementacion de las funciones
int fibo(int n)
{
    if(n > 1) return fibo(n - 1) + fibo(n - 2);
    if(n == 1) return 1;
    else return 0;
}
