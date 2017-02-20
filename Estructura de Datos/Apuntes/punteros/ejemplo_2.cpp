/*
Fecha: 20/02/2017
Nota: El nombre de un arreglo, en realidad es un apuntador, apunta
    al primer elemento del mismo
*/

#include <cstdio>

// Recibimos los areglos como un apuntador
void print(int *lista, int size)
{
    // Imprimimos los valores del arreglo
    for(int i = 0; i < size; i++){
        // Accedemos por indireccion
        // printf("%4i", *(p + i));

        // printf("%2i %u %4i\n", i, p+i, *(p+i));

        // printf("%2i %u %4i\n", i, lista+i, *(lista+i));

        printf("%2i %u %4i\n", i, lista+i, lista[i]);
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

#include <cstdio>

int main()
{
    ejemplo();

    return 0;
}
