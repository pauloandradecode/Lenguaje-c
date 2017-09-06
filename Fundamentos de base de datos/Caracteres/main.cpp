/*
Nota.- La palabra se conidera al tener minimo dos simbolos
*/

#include <cstdio>
#include <cstdlib>

// Creamos un objeto de tipo FILE
FILE *fp;

int main()
{
    int total = 0, letras = 0, numeros = 0, simbolos = 0, espacio = 0;
    int mayuscula = 0, minuscula = 0, vocales = 0, consonantes = 0, saltos = 0;
    int palabras = 0, controlPalabras = 0;

    // Abrimos el archivo
    fp = fopen("Ejemplo.txt", "a+");

    // Comprobamos que exista el archivo
    if(fp == NULL) puts("El archivo no existe");
    else {
        // Comprobamos que no estemos al final del archivo
        while(feof(fp) == 0){
            char c = fgetc(fp);

            // Comprobamos los tipos de caracteres

            // Comprobamos si es letra
            if(c >= 65 && c <= 90 || c >= 97 && c <= 122){
                letras++; // Incrementamos letras

                // Verificamos si es minuscula
                if(c >= 97 && c <= 122) minuscula++;
                // Verificamos si es mayuscula
                if(c >= 65 && c <= 90) mayuscula++;
                // Verificamos si es vocal
                if(c==65 || c==69 || c==73 || c==79 || c==85 || c==97 || c==101 || c==105 || c==111 || c==117) vocales++;
                else consonantes++;
            }
            if(c == 32) {
                espacio++;
                // Verificamos la palabras
                if(controlPalabras >= 2) palabras++;
                // Reseteamos el control
                controlPalabras = 0;
            }
            if (c == 10) {
                saltos++;
                // Verificamos la palabras
                if(controlPalabras >= 2) palabras++;
                // Reseteamos el control
                controlPalabras = 0;
            }
            if ( c >= 48 && c <= 57) numeros++;
            if (c >= 33 && c <= 254) {
                controlPalabras++;
                simbolos++;
            }

            total++; // Incrementamos el total
        }

        // Cerramos el archivo
        fclose(fp);

        // Mostramos los resultados
        printf("En total: %i\n", total);
        printf("Letras: %i\n", letras);
        printf("Numeros: %i\n", numeros);
        printf("Simbolos: %i\n", simbolos);
        printf("Espacios en blanco: %i\n", espacio);
        printf("Mayusculas: %i\n", mayuscula);
        printf("Minuscula: %i\n", minuscula);
        printf("Vocales: %i\n", vocales);
        printf("Consonantes: %i\n", consonantes);
        printf("Palabras: %i\n", palabras);
        printf("Saltos de linea: %i\n", saltos);
    }

    return 0;
}
