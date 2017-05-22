#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int n, m; // Elementos de los set A y B
    int count = 0; // Contador
    int multiplicables = 0;

    cin >> n >> m;

    vector<int> a(n), b(m);

    // Capturamos los valores de los sets
    for(int i = 0; i < n; i++) cin >> a[i];
    for(int j = 0; j < m; j++) cin >> b[j];

    // Comprobamos los valores divisibles
    for(int k = a.front() + 1; k <= b.front(); k++){
        count = 0;
        for(int l = 0; l < n; l++) {
            if(k % a[l] == 0) count ++;
        }

        if(count == n){
            count = 0;
            for(int x = 0; x < m; x++) {
                if(b[x] % k == 0) count++;
            }
            if(count == m) multiplicables++;
        }
    }

    cout << multiplicables << endl;

    return 0;
}
