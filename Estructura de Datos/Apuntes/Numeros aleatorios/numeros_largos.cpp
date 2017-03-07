/*
Fecha: 06/03/2017
Nota: Generacion de numeros largos
*/

#include <cstdlib>
#include <cstdio>
#include <ctime>
#include <string>
#include <iostream>

using namespace std;

// Generacion de numeros mayores a long signed
string randint(int k)
{
    string x;

    for(int i = 0; i < k; i++){
        x = x + (char) (rand() % 10 + '0');
    }

    return x;
}

// Generacion de numeros grandes
long randlen(int k)
{
    long x = 0;

    for(int i = 0; i < k; i++){
        x *= 10;
        x += rand() % 10;
    }

    return x;
}

int main()
{
    // Inicializamos la semilla
    srand((unsigned)time(NULL));

    // Numero de digitos del numeral
    long x = randlen(6);

    printf("%i\n", x);

    // Generamos un numero de 100 digitos
    string y = randint(100);
    cout << y << endl;

    return 0;
}
