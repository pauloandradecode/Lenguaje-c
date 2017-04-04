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
#include "Process.hpp"
#include "Queue.hpp"

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
            break;
    }
}
