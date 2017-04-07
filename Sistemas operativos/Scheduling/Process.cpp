/*
Fecha: 03/04/2017
Integrantes:
    Andrade Gonzlez Paulo Cesar
    Lazo Godinez Maria Ines
    Lopez Gacia Romina Arantxa
    Sanchez Gutierrez Alejandra Amaranta
Nota: Implementacion del programa
*/

#include <cstdio>
#include <cstdlib>
#include <iostream>
#include "Process.hpp"
#include "Queue.hpp"

using namespace std;

/***********************************************
Clase Process
***********************************************/

// Constructor
Process::Process() {}

// Metodo que muestra el menu
void Process::menu()
{
    int option = 0;

    do{
        // Limpiamos la pantalla
        system("clear");
        // Nombre del programa
        puts("*****************************************");
        puts("                SHEDULING");
        puts("*****************************************");
        puts("\n1.- FIFO");
        puts("2.- SJF");
        puts("3.- Round Robin");
        puts("4.- Prioridad");
        printf("\nElija una opcion: ");

        scanf("%i", &option);

        // Verificamos si es un numero

    } while(option < 1 || option > 4);

    switch(option){
        case 1: // FIFO
            break;
        case 2: // SJF
            break;
        case 3: // Round Robin
            break;
        case 4: // Prioridad
            priority();
            break;
    }
}

// Metodo con el algoritmo de prioridad
void Process::priority()
{
    // Ingresamos los datos
    Queue *q = push();

    // Obtenemos el quantum
    int quantum = q->quantum();

    // Imprimimos
    q->print();
}

// Metodo para ingresar datos
Queue *Process::push()
{
    char x; // ID del proceso
    int n; // Capacidad
    int y; // Tiempo del proceso
    int z; // Prioridad del proceso

    // Obtenemos la capacidad
    printf("\nIngrese el total de procesos: ");
    cin >> n;

    // Inicializamos una cola
    Queue *q = new Queue(n);

    // Ingresamos los datos
    puts("Ingrese el proceso, ej.- A 5 10 [ID Time Prioridad]:");
    for(int i = 0; i < n; i++){
        cin >> x >> y >> z;
        q->orderbypriority(x, y, z);
    }

    return q;
}
