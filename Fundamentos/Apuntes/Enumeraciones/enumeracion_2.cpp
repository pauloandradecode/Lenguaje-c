/*
* Fecha: 25/04/2016
*
* Ejemplo de sincronizador de tramas (maquina de estados)
*/

#include <cstdio>

// Declaramos una enumeracion con los estados de la maquina
enum estados {idle, sync, online};

int main (){
    // Declaramos la variable state y le asignamos el estado inicial de la maquina (idle)
    enum estados state = idle;
    int i = 0; // Contador

    // Mientras state sea diferente a online que siga corriendo
    while(state != online){
        int evento;

        // Imprimos el estado
        switch(state){
            case idle: printf("Idle "); break;
            case sync: printf("Sync "); break;
            case online: printf("Online ");
        }

        // Capturamos el evento
        scanf("%d", &evento);

        // Segun el evento capturado, actuamos
        switch(evento){
            case idle:
                if(evento == 0){
                    i = 0; // Reseteamos el contador
                    state = idle; // Se queda igual
                }
                else if(evento == 1){
                    i++; // Incrementamos
                    state = sync; // Cambiamos el estado
                }

                break;
            case sync:
                if(evento == 0){
                    i = 0;
                    state = idle;
                } else if(evento == 1) if(++i == 5) state = online; // Si el contador esta en 5 cambiamos a estado online
                else state = sync;

                break;
        }
    }

    printf("System online\n");

    return 0;
}
