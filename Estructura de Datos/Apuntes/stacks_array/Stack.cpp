/*
Implementaciones

Fecha: 21/03/2017
Nota: Pilas con arrays - Estructura lineal
*/

#include <cstdio>
#include "Stack.hpp"

// Constructor
Stack::Stack(int s) : _n(s), _s(0)
{
    // Creamos el arreglo
    array = new int[_n];
}
// Destructor
Stack::~Stack()
{
    // Liberamos la memoria
    delete [] array;
}
// Método para insertar un dato al final del array
// @param data entero a almacenar
void Stack::push(int data)
{
    // Precondicion
    if(!full()){
        // Agregamos el dato
        array[_s++] = data;
    } else {
        printf("Pila llena \n");
    }
}
// Metodo para obtener el ultimo dato del array y borrarlo
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
// Metodo para mostrar el ultimo dato del arreglo sin borrarlo
int Stack::top()
{
    // Precondicion
    if(!empty()){
        // Retornamos un dato
        return array[_s-1];
    }
}
