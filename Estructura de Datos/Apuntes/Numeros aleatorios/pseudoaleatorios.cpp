/*
Fecha: 06/03/2017
Nota: Generacion de numeros pseudo aleatorio
*/

#include <cstdlib>
#include <cstdio>
#include <ctime>

int main()
{
    // Inicializamos la semilla
    srand((unsigned)time(NULL));

    // Generamos 10 numeros aleatorios
    for(int i = 0; i < 100; i++){
        // Generamos numeros aleatorios con el rango de 0 - 100
        // printf("%4i", rand()%101);

        // Generamos numeros entre -1000 a 1000
        // printf("%6i", rand() % (2 * 1000 + 1) - 1000);

        // Generamos numeros entre 100 y 200
        printf("%6i", rand() % (200 - (100 - 1)) + 100);
    }

    return 0;
}
