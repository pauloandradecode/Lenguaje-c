/*
* Fecha: 12/04/2016
*
* Ejemplo de estructuras, calculamos la pendiente de dos puntos en el plano cartesiano
*/

#include <cstdio>

using namespace std;

struct punto{
    float x,y;
};

int main()
{
    struct punto a, b;

    printf("Punto a: ");
    scanf("%f , %f", &a.x, &a.y);
    printf("Punto b: ");
    scanf("%f , %f", &b.x, &b.y);

    if(a.y == b.y) printf("Pendiente nula \n");
    else if(a.x == b.x) printf("Pendiente infinita \n");
    else {
        // Formula para calcular la pendiente
        float pendiente = (a.y - b.y) / (a.x - b.x);

        printf("Pendiente de la l\241nea ab: %.4f", pendiente);
    }

    return 0;
}
