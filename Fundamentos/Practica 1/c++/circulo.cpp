/**********************************************
* Programa 5 - Practica 1
* Fecha: 18/04/2016
* Nombre: Circulo
**********************************************/

#include <iostream>
#include <iomanip>
#define PI 3.1416

using namespace std;

int main()
{
    float radio, diametro, area, perimetro;

    cout << "Ingrese el radio del circulo: ";
    cin >> radio;

    diametro = radio * 2;
    area = PI * (radio * radio);
    perimetro = 2 * PI * radio;

    cout << fixed << setprecision(4);
    cout << "Diametro: " << diametro;
    cout << "\nPerimetro: " << perimetro;
    cout << "\nArea: " << area;

    return 0;
}
