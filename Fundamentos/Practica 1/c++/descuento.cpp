/**********************************************
* Programa 3 - Practica 1
* Fecha: 18/04/2016
* Nombre: Descuento
**********************************************/

#include <iostream>

using namespace std;

int main()
{
    float precio, descuento, total;

    // Configuracion de los decimales
    cout.setf(ios::fixed);
    cout.setf(ios::showpoint);
    cout.precision(2);

    cout << "Ingrese el precio del producto: ";
    cin >> precio;
    cout << "Ingrese el descuento a aplicar (porcentaje): ";
    cin >> descuento;

    total = precio - (precio * descuento / 100);

    cout << "Total a pagar: " total << "\n";

    return 0;
}
