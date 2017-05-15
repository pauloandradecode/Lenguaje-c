#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    int n; // n elements
    int sum = 0; // suma de los elementos
    int temp; // Dato capturado temporal
    cin >> n; // Capturamos n elementos
    vector<int> arr(n); // Creamos el array
    for(int i = 0;i < n;i++){ // Capturamos los elementos del array
       cin >> temp;
       arr.push_back(temp);
       sum += temp; // Obtenemos la suma
    }

    printf("%i", sum); // Imprimimos la suma
    return 0;
}
