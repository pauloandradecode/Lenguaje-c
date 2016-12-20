/**********************************************
* Programa 3 - Practica 3
* Fecha: 24/04/2016
* Nombre: Andrade Gonzalez Paulo Cesar
* Nota: Ingresar un año y mostrar su equivalente en numero romanos
**********************************************/

#include <cstdio>

int main()
{
    int annio, unidad, decena, centena, milesima;

    printf("Ingrese un a\244o entre 1 y 2016: ");
    scanf("%d", &annio);

    // Descomponemos el año
    unidad = annio % 10;
    decena = ((annio % 100) - unidad) / 10;
    centena = (((annio % 1000) - (decena * 10) - unidad)) / 100;
    milesima = (((annio % 10000) - (centena * 100) - (decena * 10)) - unidad) / 1000;

    printf("\nA\245O: ");

    if(milesima != 0){
        switch(milesima){
            case 1: printf("M"); break;
            case 2: printf("MM");
        }
    }

    if(centena != 0){
        switch(centena){
            case 1: printf("C"); break;
            case 2: printf("CC"); break;
            case 3: printf("CCC"); break;
            case 4: printf("CD"); break;
            case 5: printf("D"); break;
            case 6: printf("DC"); break;
            case 7: printf("DCC"); break;
            case 8: printf("DCCC"); break;
            case 9: printf("CM");
        }
    }

    if(decena != 0){
        switch(decena){
            case 1: printf("X"); break;
            case 2: printf("XX"); break;
            case 3: printf("XXX"); break;
            case 4: printf("XL"); break;
            case 5: printf("L"); break;
            case 6: printf("LX"); break;
            case 7: printf("LXX"); break;
            case 8: printf("LXXX"); break;
            case 9: printf("XC");
        }
    }

    if(unidad != 0){
        switch(unidad){
            case 1: printf("I"); break;
            case 2: printf("II"); break;
            case 3: printf("III"); break;
            case 4: printf("IV"); break;
            case 5: printf("V"); break;
            case 6: printf("VI"); break;
            case 7: printf("VII"); break;
            case 8: printf("VIII"); break;
            case 9: printf("IX");
        }
    }

    printf("\n");

    return 0;
}
