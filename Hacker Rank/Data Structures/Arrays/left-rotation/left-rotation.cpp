#include <iostream>
#include <vector>

using namespace std;

int main()
{
    long n; // Elementos del array
    long d; // Rotacion del array

    cin >> n >> d;

    vector<long> v(n);

    // Llenamos el array
    for(long i = 0; i < n; i++){
        cin >> v[i];
    }

    // Rotamos a la izquierda n lugares
    for(long j = 0; j < d; j++){
        long aux = v.front(); // Obtenemos el primer elemento
        v.erase(v.begin()); // Eliminamos el primer elemento
        v.push_back(aux); // Agregamos el dato al final
    }

    for(int k = 0; k < n; k++){
        if(k == (n - 1)) cout << v[k] << endl;
        else cout << v[k] << " ";
    }

    return 0;
}
