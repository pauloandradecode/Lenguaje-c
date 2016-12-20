/**********************************************
* Programa 2 - Practica 1
* Fecha: 18/04/2016
* Nombre: I.V.A.
* Notas: Para usar presicion de decimales con cout, debemos incluir la cabecera iomanip
*        para poder utilizar setprecision(numero_decimales), tambien utilizamos el flag
*        fixed para usar la notacion de punto decimal.
**********************************************/

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
    float precio, iva, total;

    cout << "Precio del producto: ";
    cin >> precio;

    iva = precio * 0.16;
    total = precio * 1.16;

    cout << "I.V.A.: " << fixed << setprecision(2) << iva;
    cout << "\nTotal: " << total;

    return 0;
}
