/*
Fecha: 15/02/2017
Nota: En este ejemplo mostramos como utilizar una estructura por medio
    de indireccion de punteros utilizando memoria dinamica
*/

#include <cstdio>

// Definimos una estructura
typedef struct{
    int x;
    int y;
} punto;

int main()
{
    // Declaramos dos punteros a la estructura
    // Forma dinamica
    punto *p = new punto;
    punto *q = new punto;

    // almacenamos datos
    p->x = 5;
    p->y = 10;
    q->x = 2;
    q->y = 5;

    // Mostramos en pantalla
    printf("p->x: %i\n", p->x);
    printf("p->y: %i\n", p->y);
    printf("q->x: %i\n", q->x);
    printf("q->y: %i\n", q->y);

    // Destruimos las instancias por ser dinamicas
    delete p;
    delete q;

    return 0;
}
