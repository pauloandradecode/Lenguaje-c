#include <vector>
#include <iostream>
#include <numeric>

using namespace std;

int main()
{
    int n;

    cin >> n;
    vector<long long> v(n);

    for(int i = 0; i < n; i++){
        cin >> v[i];
    }

    cout << accumulate(v.begin(), v.end(), static_cast<long long>(0)) << endl;

    return 0;
}
