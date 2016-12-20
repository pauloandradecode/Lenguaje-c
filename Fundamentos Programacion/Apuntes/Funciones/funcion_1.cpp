/*
* Fecha: 17/05/2016
*
* Funciones
* Ejemplo del uso de una funcion con prototipo e implementacion
* distancia: Z x Z -> Z
*/

#include <cstdio>

// Prototipo de la funcion
int distancia(int, int);

main()
{
    int m, n, len;

    scanf("%i,%i", &m, &n);

    // Uso o llamada de la funcion
    len = distancia(m, n);

    printf("La distancia entre %i y %i es %i\n", m, n, len);

    return 0;
}

// Implementacion de la fu¿ncion
int distancia(int a, int b)
{
    // Calculamos la distancia
    int dif = a - b;

    // Si el resultado es negativo lo convertimos a positivo
    return dif < 0 ? -dif: dif;
}
