#include <iostream>
#include <vector>

using namespace std;

int main()
{
    long long n, count = 0;
    long long aux = 0;

    cin >> n;
    vector<long long> v(n);

    for(long long i = 0; i < n; i++){
        cin >> v[i];

        if(v[i] > aux){
            aux = v[i];
            count = 0;
        }
        if(v[i] == aux) count++;
    }

    cout << count << endl;

    return 0;
}
