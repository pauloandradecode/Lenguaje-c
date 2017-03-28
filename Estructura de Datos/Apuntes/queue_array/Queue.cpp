#include <cstdio>
#include "Queue.hpp"

// Constructor
Queue::Queue(int n): _n(n), _s(0){
    // Creamos el array
    array = new int[n];
}
// Destructor
Queue::~Queue(){
    // Liberamos la memoria
    delete [] array;
}

// Metodos para colas
void Queue::enqueue(int x)
{
    // precondicion
    if(!full()){
        array[_s++] = x;
    } else {
        printf("Cola llena \n");
    }
}
int Queue::dequeue()
{
    // Precondicion
    if(!empty()){
        // El primer valor del array se guarda en x
        int x = array[0];
        // Inicializamos el contador a 0
        int i = 0;
        _s--;
        while(i < _s){
            array[i] = array[i + 1];
            i++;
        }

        return x;
    }
}
int Queue::read()
{
    if(!empty()){
        return array[0];
    } else {
        printf("Cola vacia\n");
        return 0;
    }
}
