/***********************************************
* Ejercicio 2
*
* Nombre: Divisor
* Descripcion: Programe un algoritmo que, dados dos números enteros que entran como datos,
*     indique si uno es divisor del otro.
* Pagina: 15
* Fecha: 06/05/2016
***********************************************/

#include <cstdio>

int main()
{
    int num1, num2;

    printf("Proporcione el primer numero: ");
    scanf("%i", &num1);

    printf("Proporcione el segundo numero: ");
    scanf("%i", &num2);

    if(num1 >= num2){
        if((num1 % num2) == 0) printf("\nEs divisor");
        else printf("\nNo es divisor");
    } else printf("\nNo es divisor por que es mayor");

    return 0;
}
