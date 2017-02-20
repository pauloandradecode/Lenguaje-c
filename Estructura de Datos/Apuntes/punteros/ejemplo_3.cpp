/*
Fecha: 20/02/2017
Nota: Recorremos el arreglo recorriendo en unidades de desplazamiento
*/

#include <cstdio>

// Recibimos los areglos como un apuntador
void print(int *lista, int size)
{
    // Imprimimos los valores del arreglo
    for(int i = 0; i < size; i++){
        // Accedemos por indireccion
        printf("%2i %u %4i\n", i, lista, *lista);

        // Recorremos una unidad de desplazamiento al arreglo
        lista++;
    }

    printf("\n\n");
}

void ejemplo()
{
    // Declaramos un arreglo
    int lista[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    // Inicializacion por referenciacion
    // int *p = &lista[0];

    printf("Unidad de desplazamiento de int: %u\n", sizeof(int));

    // Imprimimos los valores del arreglo
    print(lista, 10);
}

int main()
{
    ejemplo();

    return 0;
}
