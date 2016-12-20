/*
* Fecha: 24/05/2016
*
* Ejemplo de funcion con dominio vacio (void)
* con argumento por referencia
*
* Intercambiamos dos valores (swap)
*/

#include <cstdio>

// Prototipo de la funcion
void swap(int &, int &);

int main()
{
    int m, n;

    scanf("%i,%i", &m, &n);

    // Llamado a la funcion
    swap(m, n);

    printf("Primer valor: %i\n", m);
    printf("Segundo valor: %i\n", n);

    return 0;
}

// Implementacion de la funcion
void swap(int &a, int &b)
{
    int aux = a;
    a = b;
    b = aux;
}
