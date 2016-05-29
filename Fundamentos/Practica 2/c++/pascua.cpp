/**********************************************
* Programa 6 - Practica 2
* Fecha: 18/04/2016
* Nombre: Andrade Gonzalez Paulo Cesar
**********************************************/

#include <iostream>

using namespace std;

int main()
{
    int annio, a, b, c , d, e, n;
    string year;

    cout << "--------------------------\n";
    cout << "Calcular domingo de pascua\n";
    cout << "--------------------------\n\n";

    cout << "Ingrese un a\244o: ";
    cin >> annio;

    // Calculamos la fecha
    a = annio % 19;
    b = annio % 4;
    c = annio % 7;
    d = (19 * a + 24) % 30;
    e = (2 * b + 4 * c + 6 * d + 5) % 7;
    n = 22 + d + e; // Numero del dia

    // Obtenemos el dia
    n = (n > 31) ? n - 31 : n;

    // Obtenemos el año
    year = (n > 31) ? "Marzo" : "Abril";

    cout << "\nEn " << annio << ", el domingo de Pascua es el d\241a " << n << " de " << year << "\n";

    return 0;
}
