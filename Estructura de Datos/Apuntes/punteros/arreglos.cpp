/*
Fecha: 14/02/2017
Nota: Los arreglos en c/c++ son considerados punteros, pero 
    al utilizar punteros en dichos arreglos, estos apuntaran solo
    a la direccion de memoria del primer dato almacenado del arreglo
    es decir apuntara siempre a nombre_arrglo[0].
*/

#include <cstdio>

int main()
{
    // Declaramos un arreglo de numeros
    int list[10] = {2, 5, 8, 1, 4, 7, 9, 0, 2, 6};

    // Utilizamos un puntero para acceder al areglo
    int *p = &list[0];

    // Mostramos los datos del arreglo desde el puntero
    for(int j = 0;j < 10; j++){
        // Mostramos mediante indireccion
        printf("%i ", *(p + j));
    }

    return 0;
}
