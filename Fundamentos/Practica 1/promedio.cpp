/**********************************************
* Programa 6 - Practica 1
* Fecha: 18/04/2016
* Nombre: Promedio
**********************************************/

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
    float a,b,c,d,e, promedio = 0.0;

    cout << "Ingrese la edad de la persona 1: ";
    cin >> a;
    cout << "\nIngrese la edad de la persona 2: ";
    cin >> b;
    cout << "\nIngrese la edad de la persona 3: ";
    cin >> c;
    cout << "\nIngrese la edad de la persona 4: ";
    cin >> d;
    cout << "\nIngrese la edad de la persona 5: ";
    cin >> e;

    promedio = (a + b + c + d + e) / 5;

    cout << fixed << setprecision(1);
    cout << "\nEl promedio de las edades es: " << promedio;

    return 0;
}
