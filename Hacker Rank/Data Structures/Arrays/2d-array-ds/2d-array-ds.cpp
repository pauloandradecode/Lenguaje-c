#include <iostream>
#include <vector>
#define n 6

using namespace std;

// Creamos la matriz
vector< vector<int> > v(n, vector<int>(n));

int suma(int, int);

int main()
{
    int sum = -1000; // Mayor suma

    // Capturamos la matriz
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> v[i][j];
        }
    }

    // Obtenemos las sumas
    for(int k = 0; k < (n - 2); k++){
        for(int l = 0; l < (n - 2); l++){
            if(suma(l, k) > sum) sum = suma(l, k);
        }
    }

    cout << sum << endl;

    return 0;
}

// Obtenemos la suma del hourglass
int suma(int x, int z)
{
    int total = 0;

    for(int i = x; i < (x + 3); i++){
        for(int j = z; j < (z + 3); j++){
            if(i == (x + 1)){
                if(j == (z + 1)){
                    total += v[i][j];
                }
            } else {
                total += v[i][j];
            }
        }
    }

    return total;
}
