/*
* Fecha: 18/04/2016
*
* Ejemplo de una estructura con diferentes tipos de datos
*/

#include <cstdio>

using namespace std;

struct alumno{
    char nombre[20];
    int control;
    float nota;
};

int main()
{
    struct alumno ficha;

    printf("Nombre del alumno: ");
    gets(ficha.nombre);
    printf("Control: ");
    scanf("%i", &ficha.control);
    printf("Nota: ");
    scanf("%f", &ficha.nota);

    printf("\nNota del alumno:\n");

    printf("\nNombre: %s", ficha.nombre);
    printf("\nControl: %08d", ficha.control);
    printf("\nNota: %.2f", ficha.nota);

    return 0;
}
