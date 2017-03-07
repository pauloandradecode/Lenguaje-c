/*
Fecha: 27/02/2017
Nota: serie fibonacci mediante recursividad
    "La recursividad no es lineal"
    Por lo tanto necesita mucho procesos
*/

#include <cstdio>

// contador de procesos
long count;

// Funcion recursiva de serie fibonacci
long fibo(int i)
{
    // Aumentamos el proceso
    count++;

    // Algoritmo de fibonacci
    if(i == 1 || i == 2) return 1;
    else return fibo(i - 1) + fibo(i - 2);
}

int main()
{
    int i;
    scanf("%i", &i);

    // Imprimimos la serie
    for(int j = 1; j <= i; j++){
        count = 0; // Inicializamos el contador

        long f = fibo(j);
        // Imprimimos - orden - numero de la serie - proceso
        printf("%3i: %7i %7i\n", j, f, count);
    }

    return 0;
}
