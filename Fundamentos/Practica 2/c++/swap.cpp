/**********************************************
* Programa 2 - Practica 2
* Fecha: 18/04/2016
* Nombre: Swap
**********************************************/

#include <iostream>

using namespace std;

int main()
{
    int x, y, aux;

    cout << "Ingres dos variables enteras X, Y: ";
    cin >> x >> y;

    // Intercambiamos los valores
    aux = x;
    x = y;
    y = aux;

    cout << "\nX: " << x << "\n";
    cout << "Y: " << y << "\n";

    return 0;
}
