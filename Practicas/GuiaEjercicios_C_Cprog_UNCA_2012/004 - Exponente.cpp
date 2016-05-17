/***********************************************
* Ejercicio 3
*
* Nombre: Exponente
* Descripcion: Escriba un programa que calcule el valor de e^x
* Pagina: 17
* Fecha: 13/05/2016
***********************************************/

#include <cstdio>

int main()
{
    int x, potencia, factorial;
    float e = 1.0;

    printf("Ingrese el valor de x: ");
    scanf("%i", &x);

    for(int i = 1; i <= 10; i++){
        potencia = 1;

        for(int j = 1; j <= i; j++){
            potencia *= x;
        }

        factorial = 1;

        for(int j = i; j > 0; j--){
            factorial *= j;
        }

        e += potencia / factorial;
    }

    printf("Valor de e elevado a x es: %.4f", e);

    return 0;
}
