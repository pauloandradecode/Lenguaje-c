#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int n, round;

    // Capturamos el numero de alumnos
    cin >> n;

    // Creamos un array
    vector<int> v(n);

    // Capturamos cada uno de los grados de los alumnos
    for(int i = 0; i < n; i++){
        cin >> v[i];

        // Verificamos que el grado sea mayor a 35 para por ser redondeado
        if(v[i] > 35){
            // Calculamos el redondeo
            round = (v[i] % 5 > 2) ? 5 - (v[i] % 5) : 0 ;
            v[i] += round;
        }

        // Imprimimos el resultado
        cout << v[i] << endl;
    }

    return 0;
}
