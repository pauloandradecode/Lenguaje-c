#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int n;

    cin >> n;

    vector<long> v(n);

    for(int i = 0; i < n; i++){
        cin >> v[i];
    }

    for(int j = (n - 1); j >= 0; j--){
        if(j == 0) cout << v[j] << endl;
        else cout << v[j] << " ";
    }

    return 0;
}
