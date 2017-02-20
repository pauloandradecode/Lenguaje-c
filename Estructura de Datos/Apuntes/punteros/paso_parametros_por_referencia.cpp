/*
Fecha: 20/02/2017
Nota:
*/

#include <cstdio>

void swap(int &a, int &b)
{
    int x = a;
    a = b;
    b = x;
}

void ejemplo()
{
    int x = 4;
    int y = 6;

    printf("x: %i y: %i\n", x, y);

    swap(x, y);

    printf("x: %i y: %i\n", x, y);
}

int main()
{
    ejemplo();

    return 0;
}
