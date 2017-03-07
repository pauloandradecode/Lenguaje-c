/*
Fecha: 27/02/2017
Nota: Serie fibonacci lineal (gasta menos recursos)
*/

#include <cstdio>

// Contador para procesos
long count;

long fibo(int i)
{
    long a = 1;
    long b = 1;
    long resultado = 0;

    if(i == 0 || i == 1) return 1;

    for(int j = 2; j <= i; j++){
        count++;
        resultado = a + b;
        a = b;
        b = resultado;
    }

    return resultado;
}

int main()
{
    int i;
    scanf("%i", &i);

    for(int j = 0; j <= i; j++){
        //count = 0;
        long f = fibo(j);

        // Imprimimos
        printf("%4i: %4i     proceso: %7i\n", j+1, f, count);
    }

    return 0;
}
