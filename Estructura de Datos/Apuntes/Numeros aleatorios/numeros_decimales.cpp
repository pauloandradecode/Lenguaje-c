/*
Fecha: 07/03/2017
Nota: Numeros decimales aleatorios
*/

#include <cstdio>
#include <cstdlib>
#include <ctime>
#include <string>
#include <iostream>

using namespace std;

// Declaracion de funciones
double randFloat(int);
string randF(int);

int main()
{
    srand(time(NULL));

    int n;
    cin >> n ;

    // double x = randFloat(8);

    // printf("%.14f", x);
    string x = randF(n);
    cout << x << endl;

    return 0;
}

// Codigo para crear numeros decimales sin desbordamiento
double randFloat(int p)
{
    double x = 0.0;

    for(int i = 0; i < p; i++){
        x += rand() % 10;
        x *= .1;
    }

    return x;
}

// Numeros decimales mas grandes que el limite
string randF(int p)
{
    string x = "0.";

    for(int i = 0; i < p; i++){
        x += (char) (rand() % 10 + '0');
    }

    return x;
}
