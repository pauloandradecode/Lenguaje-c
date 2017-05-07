/*
Fecha: 03/04/2017
Integrantes:
    Andrade Gonzalez Paulo Cesar
    Lazo Godinez Maria Ines
    Lopez Gacia Romina Arantxa
    Sanchez Gutierrez Alejandra Amaranta
Nota: Declaracion de la clase process, esta clase se encarga de manejar el flujo
    del programa.
*/

#ifndef PROCESS_HPP_INCLUDED
#define PROCESS_HPP_INCLUDED

#include <cstdio>
#include "Queue.hpp"

// Clase para los procesos del programa
class Process
{
    public:
        // Constructor
        Process();
        // Metodos de la clase
        void menu(); // Metodo que muestra el menu del programa
        void priority(); // Metodo con el algoritmo de prioridad
        void fifo(); // Metodo con el algoritmo de fifo
        void sjf(); // Metodo con el algoritmo de sjf
        void roundrobin(); // Metodo con el algoritmo de round robin
        Queue *push(int); // Metodo para insertar datos
};

#endif // QUEUE_HPP_INCLUDED
