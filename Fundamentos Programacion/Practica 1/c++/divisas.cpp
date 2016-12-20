/**********************************************
* Programa 4 - Practica 1
* Fecha: 18/04/2016
* Nombre: Divisas
**********************************************/

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
    float dolares, pesos,
        tasaCambio = 13.1803;

    cout << "Ingrese la cantidad en dolares: ";
    cin >> dolares;

    pesos = dolares * tasaCambio;

    cout << "Total en pesos: " << fixed << setprecision(2) << pesos;

    return 0;
}

