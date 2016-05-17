/***********************************************
* Ejercicio 2 (Propuesto)
*
* Nombre: Determine el valor a pagar
* Descripcion: En un videoclub se ofrece la promocion de llevarse 3 peliculas por el precio de las
*              dos mas baratas, haga un programa que dado los tres precios de las peliculas,
*              determine la cantidad a pagar.
* Pagina: 18
* Fecha: 13/05/2016
***********************************************/

#include <cstdio>

int main()
{
    float precio[3], total;

    // Ingresamos los precios de las peliculas
    for(int i = 0; i < 3; i++){
        printf("Ingrese el precio de la pelicula %i: ", i + 1);
        scanf("%f", &precio[i]);
    }

    // Acomodamos los precios de las peliculas
    if(precio[0] >= precio[1]){
        total = precio[1];

        if(precio[0] >= precio[2]){
            total += precio[2];
        } else {
            total += precio[0];
        }
    } else {
        total = precio[0];

        if(precio[1] >= precio[2]){
            total += precio[2];
        } else {
            total += precio[1];
        }
    }

    printf("\nEl total a pagar es: %.2f", total);

    return 0;
}
