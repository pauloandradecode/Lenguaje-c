#include <cstdio>
#include <cstdlib>
#include "Archivo.h"

int main()
{
    Archivo file;
    int option;

    while(true){
        fflush(stdin); // Limpiamos el buffer

        // Menu
        printf("***********************************\n");
        printf("              AGENDA");
        printf("\n***********************************\n\n");
        printf("[1] AGREGAR\n");
        printf("[2] MOSTRAR\n");
        printf("[3] BUSCAR\n");
        printf("[0] SALIR\n");
        printf("Opcion: ");

        scanf("%i", &option);

        switch(option){
            case 1:
                file.save();
                break;
            case 2:
                // Limpiamos la pantalla
                system("clear");

                file.read();
                break;
            case 3:
                file.search();
                break;
            case 0:
                puts("Salio del programa");
                break;
        }
    }

    return 0;
}
