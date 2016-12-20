/**********************************************
* Programa 4 - Practica 2
* Fecha: 18/04/2016
* Nombre: Andrade Gonzalez Paulo Cesar
**********************************************/

#include <iostream>

using namespace std;

int main()
{
    float a, b, c, d, e, f, x , y;

    // Configuracion de los decimales
    cout.setf(ios::fixed);
    cout.setf(ios::showpoint);
    cout.precision(2);

    cout << "------------------------------\n";
    cout << "Sistema de ecuaciones lineales\n";
    cout << "------------------------------\n\n";

    cout << "Ingrese los valores de la primer ecuaci\242n separados por comas: ";
    cin >> a >> b >> c;

    cout << "Ingrese los valores de la segunda ecuaci\242n separados por comas: ";
    cin >> d >> e >> f;

    // Encontramos el valor de X
    x = (c*e - e*f) / (a*e - b*d);

    // Encontramos el valor de Y
    y = (a*f - c*d) / (a*e - b*d);

    cout << "\nResultado de X: " << x << "\n";
    cout << "Resultado de Y: " << y << "\n";

    return 0;
}
