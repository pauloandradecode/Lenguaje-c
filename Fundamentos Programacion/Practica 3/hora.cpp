/**********************************************
* Programa 1 - Practica 3
* Fecha: 24/04/2016
* Nombre: Andrade Gonzalez Paulo Cesar
* Nota: Al ingresar la hora se debe comprobar que no sea mayor a 23 y los minutos
*       que no sean mayor a 59, ademas, se debe mostrar la hora con AM o PM
**********************************************/

#include <cstdio>

int main()
{
    int hora, minuto, comprobacion;

    printf("Ingrese la hora en formato 24 horas (HH:mm): ");
    comprobacion = scanf("%i:%i", &hora, &minuto);

    if((hora >= 0 && hora < 24) && (minuto >= 0 && minuto < 60) && comprobacion == 2){
        if(hora >= 12){
            hora = (hora == 12) ? 12 : hora - 12;

            printf("\n%02i:%02i PM\n", hora, minuto);
        } else {
            hora = (hora == 0) ? 12 : hora;

            printf("\n%02i:%02i AM\n", hora, minuto);
        }
    } else {
        printf("\nError en la lectura de la hora\n");
    }

    return 0;
}
