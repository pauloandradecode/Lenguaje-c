/**********************************************
* Programa 1 - Practica 2
* Fecha: 18/04/2016
* Nombre: Andrade Gonzalez Paulo Cesar
**********************************************/

#include <iostream>

using namespace std;

int main()
{
    int num1, num2, mayor, menor;

    cout << "Ingrese dos numeros enteros (separados por una coma): ";
    cin >> num1 >> num2;

    mayor = (num1 > num2) ? num1 : num2;
    menor = (num1 < num2) ? num1 : num2;

    cout << "\nMayor: " << mayor << "\n";
    cout << "Menor: " << menor << "\n";

    return 0;
}
