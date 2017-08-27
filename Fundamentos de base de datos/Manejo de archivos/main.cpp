#include <cstdio>
#include <cstdlib>

// Creamos un objeto de tipo FILE
FILE *fp;

int main()
{
    // Abrimos el archivo
    fp = fopen("Ejemplo.txt", "a+");

    // Comprobamos que exista el archivo
    if(fp == NULL) puts("El archivo no existe");
    else {
        // Comprobamos que no estemos al final del archivo
        while(feof(fp) == 0){
            char c = fgetc(fp);
            printf("%c", c);
        }

        // Cerramos el archivo
        fclose(fp);
    }

    return 0;
}
