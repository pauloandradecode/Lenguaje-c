#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

int main()
{
    unsigned long long int aux;

    vector<unsigned long long int> v(5);

    for(int i = 0; i < 5; i++){
        cin >> v[i];
    }

    // Ordenamos el array
    for(int j = 0; j < 5; j++){
        for(int k = 0; k < 5; k++){
            if(v[j] < v[k]){
                aux = v[j];
                v[j] = v[k];
                v[k] = aux;
            }
        }
    }

    cout << accumulate(v.begin(), v.end() - 1, static_cast<unsigned long long int>(0)) << " ";
    cout << accumulate(v.begin() + 1, v.end(), static_cast<unsigned long long int>(0)) << endl;

    return 0;
}
