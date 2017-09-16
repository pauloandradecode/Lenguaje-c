#include <cstdio>
#include <cstdlib>
#include "Stack.hpp"

void useFile();
void useStack();

// Creamos un objeto de tipo FILE
FILE *fp;

int main()
{
    //useFile();
    useStack();

    return 0;
}

// Utilizamos el modo file
void useFile()
{
    // Abrimos el archivo
    fp = fopen("Ejemplo.txt", "a+");

    // Comprobamos que exista el archivo
    if(fp == NULL) puts("El archivo no existe");
    else {
        // Posicionamos al final del archivo
        fseek(fp, 0, SEEK_END);
        // Obtenemos la posicion
        int pos = (ftell(fp)) - 1;

        // Comprobamos que no estemos al inicio del archivo
        while(pos >= 0){
            // Obtenemos el caracter en la posicion dada
            fseek(fp, pos, SEEK_SET);
            char c = fgetc(fp);
            printf("%c", c);
            pos--; // Disminuimos la posicion
        }

        // Cerramos el archivo
        fclose(fp);
    }
}

// Usando pilas
void useStack()
{
    // Inicializamos la pila
    Stack s(1000);

    // Abrimos el archivo
    fp = fopen("Ejemplo.txt", "a+");

    // Comprobamos que exista el archivo
    if(fp == NULL) puts("El archivo no existe");
    else {
        while(feof(fp) == 0){
            // Guardamos en la pila
            s.push(fgetc(fp));
        }

        // Cerramos el archivo
        fclose(fp);

        // Imprimimos la pila
        s.print();
    }
}
