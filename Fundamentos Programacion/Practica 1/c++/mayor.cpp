/**********************************************
* Programa 7 - Practica 1
* Fecha: 18/04/2016
* Nombre: Mayor
**********************************************/

#include <iostream>

using namespace std;

int main()
{
    int num1, num2, mayor;

    cout << "Ingrese dos numeros: ";
    cin >> num1 >> num2;

    mayor = (num1 > num2) ? num1 : num2;

    cout << "\nEl numero mayor es: " << mayor;

    return 0;
}
