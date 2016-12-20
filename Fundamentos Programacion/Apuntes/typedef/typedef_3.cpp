/*
* Fecha: 26/04/2016
*
* Ejemplo de definicion de un nuevo tipo de dato
*/

#include <cstdio>

// Delaramos un tipo de dato de estructura
typedef struct{
    float x, y;
} punto;

// Definimos los puntos de una linea
typedef struct{
    punto a;
    punto b;
} linea;

// Definimos los puntos para un circulo
typedef struct{
    punto origen;
    float radio;
} circulo;

int main()
{
    // Definimos una variable l (linea)
    linea l;
    // Definimos una variable c (circulo)
    circulo c;

    // Ingresamos los datos de los puntos para crear la linea
    l.a.x = -5;
    l.a.y = -10;
    l.b.x = 2;
    l.b.y = 5;

    // Ingresamos los datos para el circulo
    c.origen.x = 5;
    c.origen.y = -5;
    c.radio = 2;

    /*
    punto m;
    m.x = 4
    m.x = 2;

    punto n = m;
    */

    printf("Datos de la linea: \n");
    printf("Punto A.X = %.2f\n", l.a.x);
    printf("Punto A.Y = %.2f\n", l.a.y);
    printf("Punto B.X = %.2f\n", l.b.x);
    printf("Punto B.Y = %.2f\n\n", l.b.y);

    printf("Datos del circulo: \n");
    printf("Origen X: %.2f\n", c.origen.x);
    printf("Origen Y: %.2f\n", c.origen.y);
    printf("Radio: %.2f\n", c.radio);

    return 0;
}
