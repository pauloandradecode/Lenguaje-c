/*
* Fecha: 26/05/2016
* Nombre:
* Nota: Un laboratorio de investigación del gobierno concluyó que un endulzante artificial de uso común en gaseosas
* dietéticas provocó la muerte en ratones de laboratorio. Un amigo suyo está desesperado por perder peso
* pero no puede renunciar a dicho refresco. Su amigo quiere saber cuánta gaseosa dietética puede beber sin
* morir a consecuencia de ello. Escriba un programa que dé la respuesta. La entrada del programa es la
* cantidad de endulzante artificial necesaria para matar a un ratón, el peso del ratón y el peso del sujeto a
* dieta. Para que su amigo esté fuera de peligro, asegúrese de que el programa pida el peso en el que el sujeto
* a dieta termina con ella, en lugar del peso actual del sujeto. Asuma que la gaseosa dietética contiene 1/10
* del 1% de endulzante artificial. Utilice una declaración de variable con el modificador const para darle
* nombre a esa fracción. Podría expresar el porcentaje como el valor double 0.001. Su programa debe permitir
* la repetición del cálculo las veces que desee.
*/

#include <iostream>

using namespace std;

int main()
{
    // Cantidad de enduzalte artifical
    const double endulzante = 0.001; // 1/10 1%

    int total;
    double cantidadEndulzante, pesoRaton, pesoSujeto, limiteRaton, limiteSujeto;

    while(true){
        cout << "Ingrese la cantidad de endulzante artifical para matar a un raton: ";
        cin >> cantidadEndulzante;
        cout << "Ingrese el peso del raton: ";
        cin >> pesoRaton;
        cout << "Ingrese el peso en el que el sujeto termina la dieta: ";
        cin >> pesoSujeto;

        // Calculamos relacion endulzate - peso raton
        limiteRaton = (pesoRaton / cantidadEndulzante) * 100;

        // Calculamos relacion contra peso del sujeto
        limiteSujeto = (pesoSujeto / limiteRaton) * 100;

        // Calculamos maximo de gaseosa a tomar
        total = limiteSujeto / endulzante;

        cout << "\n\nEl total de gaseosas a tomar es: " << total << "\n\n";
    }

    return 0;
}
