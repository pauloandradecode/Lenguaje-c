/*
Fecha: 20/02/2017
Nota: Apuntadores con arreglos de caracteres
    En las cadenas de caracteres siempre el ultimo elemento es un
    caracter nulo (\0)
*/

#include <cstdio>

void ejemplo()
{
    char *saludo = "Hola mundo";

    // La condicion indica que mientras exista un dato distinto de 0
    // Sigue avanzando, equivale a *p != '\0'
    for(char *p = saludo; *p; p++){
        putchar(*p);
    }

    putchar("\n");
}

int main()
{
    ejemplo();

    return 0;
}
