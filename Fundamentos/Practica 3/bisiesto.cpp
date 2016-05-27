/**********************************************
* Programa 2 - Practica 3
* Fecha: 24/04/2016
* Nombre: Andrade Gonzalez Paulo Cesar
* Nota: Para que un año se bisisto este debe ser multipo de 4 pero no de 100
*       salvo aquellos que sean multiplos de 400
**********************************************/

#include <cstdio>

int main()
{
    int annio;

    printf("Ingrese un a\244o para determinar si es bisiesto: ");
    scanf("%d", &annio);

    if((annio % 4 == 0) && (annio % 100 != 0) || (annio % 400 == 0)){
        printf("\n%d es a\244o bisiesto\n", annio);
    } else {
        printf("\n%d no es a\244o bisiesto\n", annio);
    }

    return 0;
}
