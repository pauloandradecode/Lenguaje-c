#include <iostream>

using namespace std;

int main()
{
    int n, count;

    cin >> n;

    for(int i = 0; i < n; i++){
        count = n - 1;
        for(int j = 0; j < n; j++){
            if(i < count) cout << " ";
            else cout << "#";
            count--;
        }
        cout << endl;
    }

    return 0;
}
