/*
Fecha: 07/03/2017
Nota: Numeros decimales aleatorios
    Genera numeros decimales entre 0 y 1
    0 < x <
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
    cin >> n;

    // Configuracion de los decimales
    cout.setf(ios::fixed);
    cout.setf(ios::showpoint);
    cout.precision(n);

    cout << randFloat(n) << endl;
    // cout << randF(n) << endl;

    return 0;
}

// Codigo para crear numeros decimales sin desbordamiento
double randFloat(int p)
{
    double x = 0.0;

    for(int i = 0; i < p; i++){
        // Obtenemos numeros pseudoaleatorios del 0-9
        x += rand() % 10;
        // Lo acomodamos hacia la derecha con 10^-n
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
