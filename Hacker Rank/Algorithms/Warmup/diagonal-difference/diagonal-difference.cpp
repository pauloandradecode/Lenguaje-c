#include <cmath>
#include <vector>
#include <iostream>

using namespace std;

int main()
{
    int n, diagonal1 = 0, diagonal2 = 0;

    cin >> n;
    vector<vector<int>> v(n, vector<int>(n));

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> v[i][j];
        }
    }

    // Obtenemos las diagonales
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(i == j) diagonal1 += v[i][j];
            if(i + j == (n - 1)) diagonal2 += v[i][j];
        }
    }

    cout << abs(diagonal1 - diagonal2) << endl;

    return 0;
}
