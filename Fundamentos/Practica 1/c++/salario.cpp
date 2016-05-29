/**********************************************
* Programa 8 - Practica 1
* Fecha: 18/04/2016
* Nombre: Salario
**********************************************/

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
    float pago, horas, deducciones, porcentaje, total;

    cout << "Pago por hora: ";
    cin >> pago;
    cout << "Horas trabajadas: ";
    cin >> horas;
    cout << "Porcentaje de deducciones: ";
    cin >> porcentaje;

    total = pago * horas;
    deducciones = total * porcentaje / 100;
    total -= deducciones;

    cout << fixed << setprecision(2);
    cout << "Total a pagar: " << total;

    return 0;
}
