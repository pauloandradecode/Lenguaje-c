/*
Fecha: 09/05/2017
Nombre: Paulo Cesar Andrade Gonzalez
Nota: Implementacion de Irds con estructuras dinamicas
    con restricciones IRD (Input - restricted dequeue)
    (colas con doble terminación - double-endend)
*/

#include <cstdio>
#include <cstdlib>
#include <ctime>
#include "Ird.hpp"
#define procesos 50

int main()
{
    // Semilla para numeros aleatorios
    srand((unsigned) time(NULL));

    int n; // Procesadores

    // Ingresamos los procesadores
    scanf("%d", &n);

    // Creamos los procesadores
    Ird *cpus = new Ird[n];
    for(int i = 0; i < n; i++){
        Ird temp;
        cpus[i] = temp;
    }

    // Creamos 50 servivios aleatorios
    for(int j = 0; j < procesos; j++){
        int data = rand() % 100 + 1; // Generamos la etiqueta de forma aleatoria
        int cpu = rand() % n; // Elegimos la cpu a donde insertar
        cpus[cpu].enqueueRear(data);
    }

    // Obtenemos un servicio
    while(true){
        int x;

        // imprimimos
        for(int k = 0; k < n; k++){
            printf("CPU %i: ", (k + 1));
            cpus[k].print();
            printf("\n");
        }

        scanf("%i", &x);
        cpus[x - 1].dequeueFront(); // Obtenemos un servivio por el frente

        // En este punto se hace el balanceo de servicios
        int aux; // CPU auxiliar
        int aux_prev; // CPU auxiliar
        int aux_next; // CPU auxiliar
        int temp = 0; // Servicio a manipular

        // verificamos que existan mas de 1 CPU
        if(n > 1){
            // Obtenemos el CPU contiguo
            if(n == x){ // Balanceo ultima cola
                aux_prev = x - 1;

                if(cpus[x - 1].size() > cpus[aux_prev - 1].size()){
                    // Hacemos balanceo
                    int temp = cpus[x - 1].dequeueRear();
                    cpus[aux_prev - 1].enqueueRear(temp);
                } else if(cpus[aux_prev - 1].size() > 1 && cpus[aux_prev - 1].size() > cpus[x - 1].size()){
                    // Hacemos balanceo
                    int temp = cpus[aux_prev - 1].dequeueRear();
                    cpus[x - 1].enqueueRear(temp);
                }
            }else if(1 == x){ // Balanceo primer cola
                aux_next = x + 1;

                // Balanceo para CPUs siguientes
                if(cpus[x - 1].size() > cpus[aux_next - 1].size()){
                    // Hacemos balanceo
                    temp = cpus[x - 1].dequeueRear();
                    cpus[aux_next - 1].enqueueRear(temp);
                } else if(cpus[aux_next - 1].size() > 1 && cpus[aux_next - 1].size() > cpus[x - 1].size()){
                    // Hacemos balanceo
                    temp = cpus[aux_next - 1].dequeueRear();
                    cpus[x - 1].enqueueRear(temp);
                }
            } else { // Balanceo colas intermedias
                aux_prev = x - 1;
                aux_next = x + 1;

                // Obtenemos la cola mayor contigua
                if(cpus[aux_prev - 1].size() > cpus[aux_next - 1].size()) aux = aux_prev;
                else aux = aux_next;

                if(cpus[x - 1].size() > 1 && cpus[x - 1].size() > cpus[aux - 1].size()){
                    // Hacemos balanceo
                    temp = cpus[x - 1].dequeueRear();
                    cpus[aux - 1].enqueueRear(temp);
                } else if(cpus[aux - 1].size() > 1 && cpus[aux - 1].size() > cpus[x - 1].size()){
                    // Hacemos balanceo
                    temp = cpus[aux - 1].dequeueRear();
                    cpus[x - 1].enqueueRear(temp);
                }
            }

            // Balance cuando no hay colas contiguas
            if(cpus[x - 1].empty()){
                // Balanceo contiguo
                int cpuTemp = 0;
                int sizeTemp = 0;
                for(int z = 0; z < n; z++){
                    // Obtenemos el CPU con más procesos
                    if(cpus[z].size() > sizeTemp){
                        cpuTemp = z;
                        sizeTemp = cpus[z].size();
                    }
                }
                // Hacemos el balance
                int temp = cpus[cpuTemp].dequeueRear();
                if(temp != 0) cpus[x - 1].enqueueRear(temp);
            }
        }
    }

    return 0;
}
