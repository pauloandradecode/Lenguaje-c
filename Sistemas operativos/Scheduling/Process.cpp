/*
Fecha: 03/04/2017
Integrantes:
    Andrade Gonzlez Paulo Cesar
    Lazo Godinez Maria Ines
    Lopez Gacia Romina Arantxa
    Sanchez Gutierrez Alejandra Amaranta
Nota: Implementacion de la clase Process
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

// Metodo que muestra el menu principal del programa
void Process::menu()
{
    // Corremos el ciclo infinitamente
    while(true){
        // Inicializamos option para elegir opcion del menu
        char *option = new char;

        do{
            // Limpiamos la pantalla
            system("clear");

            // Nombre del programa y opciones
            puts("*****************************************");
            puts("                SHEDULING");
            puts("*****************************************");
            puts("\n1.- FIFO");
            puts("2.- SJF");
            puts("3.- Round Robin");
            puts("4.- Prioridad");
            printf("\nElija una opcion: ");

            // Capturamos el valor de option
            cin >> option;

            // Verificamos si es un numero
        } while(*option < 48 || *option > 52);

        // Elegimos un algoritbo con base a option
        switch(*option){
            case '1': // FIFO
                fifo();
                break;
            case '2': // SJF
                sjf();
                break;
            case '3': // Round Robin
                roundrobin();
                break;
            case '4': // Prioridad
                priority();
                break;
        }
    }
}

// Metodo para ingresar datos
// @param type Tipo de ordenamiento [NULL-normal, true-prioridad, false-tiempo]
Queue *Process::push(bool type)
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
    puts("\nIngrese el proceso, ej.- A 5 10 [ID Time Prioridad]:");
    for(int i = 0; i < n; i++){
        cin >> x >> y >> z;
        // Decidimos el ordenamiento de la cola
        if(type == (bool) NULL) q->enqueue(x, y, z);
        else if(type) q->orderbypriority(x, y, z);
        else q->orderbytime(x, y, z);
    }

    return q;
}

// Metodo con el algoritmo de fifo
void Process::fifo()
{
    // Limpiamos la pantalla
    system("clear");

    puts("\nInes, haber a que hora terminas :)");

    cin.ignore(256,'\n'); // Limpiamos el buffer
    puts("\n\nPresione cualquier tecla para continuar");
    getchar();
}

// Metodo con el algoritmo de sjf
void Process::sjf()
{
    // Limpiamos la pantalla
    system("clear");

    puts("\nHay tenias que ser Amaranta, por favor por una ves en tu vida, terminalo :(");

    cin.ignore(256,'\n'); // Limpiamos el buffer
    puts("\n\nPresione cualquier tecla para continuar");
    getchar();
}

// Metodo con el algoritmo de round robin
void Process::roundrobin()
{
    // Limpiamos la pantalla
    system("clear");

    Queue *q = push(NULL);

    int quantum = q->quantum();

    q->processroundrobin(quantum);

    cin.ignore(256,'\n'); // Limpiamos el buffer
    puts("\n\nPresione cualquier tecla para continuar");
    getchar();
}

// Metodo con el algoritmo de prioridad
void Process::priority()
{
    // Limpiamos la pantalla
    system("clear");

    // Ingresamos los datos a la cola
    Queue *q = push(true);

    // Obtenemos el quantum
    int quantum = q->quantum();

    // Relizamos el proceso
    q->processpriority(quantum);

    // Limpiamos el buffer
    cin.ignore(256,'\n');
    puts("\n\nPresione cualquier tecla para continuar");
    getchar();
}
