/*
Fecha: 15/02/2017
Nota: En este ejemplo mostramos como utilizar una estructura por medio
    de indireccion utilizando memoria dinamica.

    Para crear utilizando memoria dinamica utilizamos el operador new (c++)
    y malloc (c), y al crear de esta forma es necesario destruir mediante
    el operador delete (c++) y la función free() (c).
*/

#include <cstdio>

// Definimos una estructura
typedef struct{
    int x;
    int y;
} punto;

// Pendiente - inclinacion
// a es un alias de la indireccion de p
float slope(punto &a, punto &b)
{
    // Accedemos como estructuras por que ya les dimos nombre
    return (b.y - a.y) / (b.x - a.x);
}

int main()
{
    // Declaramos dos punteros a la estructura
    // Forma dinamica
    punto *p = new punto;
    punto *q = new punto;

    // almacenamos datos
    // Solo podemos acceder mediante indireccion por que
    // las estructuras no tienen nombre
    p->x = 5;
    p->y = 4;
    q->x = 3;
    q->y = -2;

    // Mostramos en pantalla
    printf("p->x: %i\n", p->x);
    printf("p->y: %i\n", p->y);
    printf("q->x: %i\n", q->x);
    printf("q->y: %i\n\n", q->y);

    // Pasamos las estructuras completas contenidas en los punteros p y q
    float m = slope(*p, *q);

    printf("Slope: %f\n", m);

    // Destruimos las instancias por ser dinamicas
    delete p;
    delete q;

    return 0;
}
