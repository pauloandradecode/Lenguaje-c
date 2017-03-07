/*
Fecha: 28/02/2017
Nota: log base 10 (1 + 1/D)
    donde D es el numero a buscar
*/

#include <cstdio>
#include <math.h>

double benfort(int n)
{
    if(n == 0) return 0.0;
    else return log10(1 + 1/n);
}

int main()
{
    // Numero a buscar probabilidad
    int n;
    double b;

    scanf("%i", &n);

    printf("Probabilidad: %f", benfort(n));

    return 0;
}
