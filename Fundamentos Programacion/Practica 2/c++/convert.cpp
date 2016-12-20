/**********************************************
* Programa 5 - Practica 2
* Fecha: 18/04/2016
* Nombre: Andrade Gonzalez Paulo Cesar
**********************************************/

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
    float pies, yardas, pulgadas, centimetros, metros;

    // Configuracion de los decimales
    cout.setf(ios::fixed);
    cout.setf(ios::showpoint);
    cout.precision(4);

    cout << "Ingrese el numero de pies a convertir: ";
    cin >> pies;

    // Obtenemos las conversiones
    yardas = pies / 3;
    pulgadas = pies * 12;
    centimetros = pulgadas * 2.54;
    metros = centimetros / 100;

    cout << setw(10) << "\n" << pies << " pie(s) equivale a:\n\n";
    cout << setw(10) << yardas << " yardas\n";
    cout << setw(10) << pulgadas << " pulgadas\n";
    cout << setw(10) << centimetros << " cent\241metros\n";
    cout << setw(10) << metros << " metros\n";

    return 0;
}
