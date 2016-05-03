/**********************************************
* Programa 3 - Practica 2
* Fecha: 18/04/2016
* Nombre: times
**********************************************/

#include <cstdio>

int main()
{
    int num1 = 0, num2 = 0;
    int unidad, decena, centena, milesima;

    puts("Ingrese dos numeros enteros entre 0 y 999 (separe con una coma): ");
    scanf("%i , %i", &num1, &num2);

    puts("\nEl producto de ambos numeros es:\n");

    printf("\n%8i", num1);
    printf("\n*%7i", num2);
    printf("\n--------");

    // Obtenemos los multiplicando
    unidad = num2 % 10;
    decena = ((num2 % 100) - unidad) / 10;
    centena = (((num2 % 1000) - (decena * 10) - unidad)) / 100;
    //milesima = (((num2 % 10000) - (centena * 100) - (decena * 10)) - unidad) / 1000;

    // Imprimimos los resultados
    if(unidad != 0 || decena != 0 || centena != 0) printf("\n%8i", unidad * num1);
    if(decena != 0 || centena != 0) printf("\n%7i ", decena * num1);
    if(centena != 0) printf("\n%6i  ", centena * num1);
    //if(milesima != 0) printf("\n%5i   ", milesima * num1);

    // Imprimimos el resultado solo si el multiplicador tiene dos o mas digitos
    if(decena != 0 || centena != 0){
        printf("\n--------");
        printf("\n%8i", num1 * num2);
    }

    return 0;
}
