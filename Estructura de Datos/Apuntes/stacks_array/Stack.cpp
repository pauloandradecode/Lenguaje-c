/*
Fecha: 21/03/2017
Nota: Pilas con arrays - Estructura lineal
*/

#include <cstdio>
#include "Stack.hpp"

// Implementaciones

Stack::Stack(int s) : _n(s), _s(0)
{
    // Creamos el arreglo
    array = new int[_n];
}

Stack::~Stack()
{
    // Liberamos la memoria
    delete [] array;
}

void Stack::push(int data)
{
    // Precondicion
    if(!full()){
        // Agregamos el dato
        array[_s++] = data;
    }
}
int Stack::pop()
{
    // Precondicion
    if(!empty()){
        // Restamos 1 a s y retornamos su valor
        return array[--_s];
    } else {
        // Valor centinela solo para que no marque un error
        printf("Pila vacia \n");
        return 0;
    }
}
int Stack::top()
{
    // Precondicion
    if(!empty()){
        // Retornamos un dato
        return array[_s-1];
    }
}

