/*
Nota: Obtenemos el minimo comun multiplo apartir de la distancia de salto del canguro 1
    por la posicin de inicio del canguro dos, y al resultado le sacamos modulo de la
    distancia de salto del canguro 2.
*/

#include <iostream>

using namespace std;

int main(){
    int x1, x2; // Ubicacion de los canguros
    int v1, v2; // Distancia de cada salto de los canguros

    // Capturamos los valores
    cin >> x1 >> v1 >> x2 >> v2;

    if(v1 != v2){
        if(v2 < v1){
            // Calculamos si despues de cierto numeros de saltos se encuentran
            // en la misma posicion
            if((x1 - x2) % (v2 - v1) == 0) cout << "YES" << endl;
            else cout << "NO" << endl;
        } else cout << "NO" << endl;
    } else cout << "NO" << endl;

    return 0;
}
