/*
Fecha: 28/02/2017
Nota: Objetivo - transferir n discos desde A a C

    Estrategia:
        1.- Transferir n - 1 disc desde A hacia B
        2.- Transferir el ultimo disco desde A hacia C
        3.- Transferir n - 1 discos desde B hacia C

    La base va ser el ultimo disco.

    n     2^n-1
    3     7
    4     15
    5     31
    6     63
    7     127
*/

#include <cstdio>

int count = 0;

void hanoi(int n, char source, char target, char aux)
{
    // Si no hay discos terminamos
    if(n == 0) return;

    // Incrementamos el contador
    count++;

    // Empezamos a mover los discos (paso 1)
    hanoi(n - 1, source, aux, target);

    // Mostramos mensajes
    printf("%c -> %c\n", source, target);

    // Movemos los discos (paso 3)
    hanoi(n - 1, aux, target, source);
}

int main()
{
    // Cantidad de discos
    int n;

    scanf("%i", &n);

    // Llamamos a la funcion
    // discos - varilla origen - varilla destino - varilla intermedio
    hanoi(n, 'A', 'C', 'B');

    printf("Movimientos realizados: %i", count);

    return 0;
}
