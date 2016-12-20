/*
* Fecha: 25/04/2016
*
* Ejemplo de enumeraciones
*/

#include <cstdio>

enum dias { lun = 1, mar, mie, jue, vie, sab, dom };

int main ()
{
    enum dias d;

    printf("D\241a de la semana: ");
    scanf("%d", &d);

    switch(d){
        case lun:
        case mar:
        case mie:
        case jue:
        case vie:
            printf("D\241a de trabajo\n");
            break;
        case sab:
        case dom:
            printf("D\241a de descanso\n");
            break;
        default:
            printf("D\241a de ir al psiquiatra\n");
    }

    return 0;
}
