/**********************************************
* Programa 9 - Practica 1
* Fecha: 18/04/2016
* Nombre: Rotacion
**********************************************/

#include <iostream>

using namespace std;

int main()
{
    int a, b, c, temp;

    cout << "Ingrese tres numeros: ";
    cin >> a >> b >> c;

    temp = a;
    a = b;
    b = c;
    c = temp;

    cout << "\nEl valor de A es: " << a;
    cout << "\nEl valor de B es: " << b;
    cout << "\nEl valor de C es: " << c;

    return 0;
}
