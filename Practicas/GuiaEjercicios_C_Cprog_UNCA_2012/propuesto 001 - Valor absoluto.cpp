/***********************************************
* Ejercicio 1 (Propuesto)
*
* Nombre: Valor absoluto
* Descripcion: Escriba un programa que dado un numero real, encuentre su valor absoluto
* Pagina: 18
* Fecha: 13/05/2016
***********************************************/

#include <cstdio>

int main()
{
    float num, abs;

    printf("Ingrese un numero: ");
    scanf("%f", &num);

    // Encontramos su valor absoluto
    if(num <= 0){
        // Si es menor o igual a 0, invertimos el signo del numero
        abs = num + (-num * 2);
    } else {
        // Si es mayor a 0 el valor absoluto es igual a numero ingresado
        abs = num;
    }

    printf("\nEl valor absoluto de |%.2f| es: %.2f", num, abs);

    return 0;
}
