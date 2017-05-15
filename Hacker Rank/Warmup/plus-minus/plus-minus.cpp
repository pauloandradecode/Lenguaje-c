#include <vector>
#include <iostream>

using namespace std;

int main()
{
    int n, pos = 0, neg = 0, zer = 0;

    cin >> n;
    vector<int> v(n);

    for(int i = 0; i < n; i++){
        cin >> v[i];
    }

    for(int j = 0; j < n; j++){
        if(v[j] == 0) zer++;
        if(v[j] > 0) pos++;
        if(v[j] < 0) neg++;
    }

    cout << ((pos > 0) ? (float) pos / n : 0) << endl;
    cout << ((neg > 0) ? (float) neg / n : 0) << endl;
    cout << ((zer > 0) ? (float) zer / n : 0) << endl;

    return 0;
}
