/**********************************************
* Programa 1 - Practica 1
* Fecha: 18/04/2016
* Nombre: Cambio
**********************************************/

#include <iostream>

using namespace std;

int main()
{
    float dinero, total, cambio;

    cout << "Ingrese el total de la venta: ";
    cin >> total;
    cout << "\nIngrese el dinero recibido: ";
    cin >> dinero;

    cambio = dinero - total;

    cout << "\nSu cambio: " << cambio;

    return 0;
}
