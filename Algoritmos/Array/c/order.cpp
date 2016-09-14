/************************************************************
Ordena vectores en orden ascendente o descendente

Fecha 13/09/2016
Nombre: Paulo Andrade
Email: source.compu@gmail.com
Nota: Al pasar array a una funcion en C, estos siempre se pasan por referencia
    (no es necesario utilizar & ya que siempre se pasan por referencia), es decir
    se pasa un apuntador a la memoria del primer elemento.
Nota 2: Para obtener el tamaño de un array, utilizamos sizeof() + 1.
************************************************************/

#include <cstdio>

// Prototipo de funciones
void asd(int []);
void des(int []);
void combined(int [], bool);

int main()
{
    int length = 5; // Tamaño del vector
    int vector[length]; // vector

    // Capturamos los valores del array
    puts("Ingrese los 5 valores del vector");
    for(int i = 0; i < length; i++){
        scanf("%i", &vector[i]);
    }

    // Acomodamos en forma ascendente
    asd(vector);

    // Imprimimos
    for(int i = 0;i < length; i++){
        printf("%i ", vector[i]);
    }

    return 0;
}

// Metodo para ordenar un vector de forma ascendente
// @param x vector a ordenar
void asd(int x[])
{
    int auxiliar; // Para el intercambio de valores
    int length = sizeof(x) + 1; // Obtenemos el tamaño del array

    // Recorremos el vector dos veces para el reacomodo de elementos
    for(int i = 0; i < length - 1; i++){
        for(int j = i + 1; j < length; j++){
            // Comprobamos si el valor actual es menor al que le sigue
            if(x[i] > x[j]){
                //Intercambiamos valores
                auxiliar = x[i];
                x[i] = x[j];
                x[j] = auxiliar;
            }
        }
    }
}
// Metodo para ordenar un vector de forma descendente
// @param x vector a ordenar
void des(int x[])
{
    int auxiliar; // Para el intercambio de valores
    int length = sizeof(x) + 1; // Obtenemos el tamaño del array

    // Recorremos el vector dos veces para el reacomodo de elementos
    for(int i = 0; i < length - 1; i++){
        for(int j = i + 1; j < length; j++){
            // Comprobamos si el valor actual es menor al que le sigue
            if(x[i] > x[j]){
                //Intercambiamos valores
                auxiliar = x[i];
                x[i] = x[j];
                x[j] = auxiliar;
            }
        }
    }
}
void combined(int x[], bool type)
{
    int auxiliar; // Para el intercambio de valores
    int length = sizeof(x) + 1; // Obtenemos el tamaño del array

    // Verificamos si el acomodo es en forma ascendente
    if(type){
        // Recorremos el vector dos veces para el reacomodo de elementos
        for(int i = 0; i < length - 1; i++){
            for(int j = i + 1; j < length; j++){
                // Comprobamos si el valor actual es menor al que le sigue
                if(x[i] > x[j]){
                    //Intercambiamos valores
                    auxiliar = x[i];
                    x[i] = x[j];
                    x[j] = auxiliar;
                }
            }
        }
    } else {
        // Recorremos el vector dos veces para el reacomodo de elementos
        for(int i = 0; i < length - 1; i++){
            for(int j = i + 1; j < length; j++){
                // Comprobamos si el valor actual es mayor al que le sigue
                if(x[i] < x[j]){
                    //Intercambiamos valores
                    auxiliar = x[i];
                    x[i] = x[j];
                    x[j] = auxiliar;
                }
            }
        }
    }
}
