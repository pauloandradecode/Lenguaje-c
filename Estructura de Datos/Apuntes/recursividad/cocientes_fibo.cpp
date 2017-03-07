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

// Calcular los cocientes de los numeros de fibo
void cocientes(int i)
{
    long a = 0;
    long b = 0;

    for(int j = 1; j <= i; j++){
        if(j == 1) a = 1;

        b = fibo(j);

        printf("%i: %f\n", j,(float) b/a);

        a = b;
    }
}

int main()
{
    int i;
    scanf("%i", &i);

    // Imprimimos los cocientes
    cocientes(i);

    return 0;
}
