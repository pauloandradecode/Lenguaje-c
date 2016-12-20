#ifndef __tipos
#define __tipos

/* Las dos primeras lineas de un archivo de cabecera siempre deben ser estas con alguna
variable, en este caso "__tipos" (Todo nuestro codigo deben estar entre estas marcas)
para evitar errores*/

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

/* Al final del archivo siempre debe tener un endif */
#endif
