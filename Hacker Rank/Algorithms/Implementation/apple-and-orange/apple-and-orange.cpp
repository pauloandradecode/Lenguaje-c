#include <iostream>
#include <vector>

using namespace std;

int main()
{
    long s, t; // Denota la ubicacion de la casa de sam
    long a, b; // Denota ubicacion de arboles de manzanas y naranjas
    long m, n; // Cantidad de manzanas y naranjas caidas
    int apple = 0, orange = 0; // Cantidades caidas en la casa de sam

    // Capturamos los valores
    cin >> s >> t >> a >> b >> m >> n;

    // Creamos los arrays
    vector<long> vm(m), vn(n);

    // Capturamos las distancias de las manzanas caidas
    for(int i = 0; i < m; i++){
        cin >> vm[i];

        // Verificamos que caigan a la derecha del arbol
        if(vm[i] >= 0){
            apple += (a + vm[i] >= s && a + vm[i] <= t) ? 1 : 0;
        }
    }

    // Capturamos las distancias de las naranhas caidas
    for(int j = 0; j < n; j++){
        cin >> vn[j];

        // Verificamos que caigan a la izquierda del arbol
        if(vn[j] < 0){
            orange += (b + vn[j] <= t && b + vn[j] >= s) ? 1 : 0;
        }
    }

    // Imprmimos los resultados
    cout << apple << endl;
    cout << orange << endl;

    return 0;
}
