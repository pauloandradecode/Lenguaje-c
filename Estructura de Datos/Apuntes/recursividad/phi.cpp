/*
Fecha: 28/02/2017
Nota: Numero phi
    Funcion recursiva con dos parametros:

    1.- La cantidad de pasos de la recurrencia
    2.- El ultimo valor que se va a colocar
*/

#include <cstdio>

// Declaracion de funciones
double phi(int, int);

int main()
{
    int n, pasos;

    scanf("%i %i", &n, &pasos);

    printf("\nphi: %f\n", phi(n, pasos));

    return 0;
}

// Funcion para encontrar phi con cierto numero de pasas
double phi(int n, int x)
{
    // Limite de la recursividad
    if(x != 0) return 1 + 1 / phi(n, x-1);
    else return 1 + 1 / n;
}
