/*
Fecha: 14/02/2017
Nota: Para declara una cadena por medio de punteros lo indicamos al
    momento de declararla (char *identificador = "contenido";)

    *identificador (accede al dato almacenado)
    identificador (accede a la direccion de memoria)
*/

#include <cstdio>

int main()
{
    // Declaramos una cadena
    char *cadena = "Hola mundo";

    // Mostramos la cadena por medio de un ciclo for
    for(char *i = cadena; *i != '\0'; i++){
        printf("%c", *i);
    }
    printf("\n\n");

    // Imprimimos solo el primer caracter de la cadena
    putchar(*cadena);
    printf("\n\n");

    printf("%c", *cadena);

    return 0;
}
