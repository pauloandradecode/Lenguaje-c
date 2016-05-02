/**********************************************
* Programa 3 - Practica 1
* Fecha: 18/04/2016
* Nombre: Descuento
**********************************************/

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
    float precio, descuento, total;

    cout << "Ingrese el precio del producto: ";
    cin >> precio;
    cout << "Ingrese el descuento a aplicar (porcentaje): ";
    cin >> descuento;

    total = precio - (precio * descuento / 100);

    cout << "Total a pagar: " << fixed << setprecision(2) << total << "\n";

    return 0;
}
