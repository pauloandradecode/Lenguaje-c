#include <iostream>
#include <vector>

using namespace std;

vector <int> solve(int a0, int a1, int a2){
    // Complete this function
    vector<int> v = {a0, a1, a2};
    return v;
}

int main() {
    int a0, a1, a2, b0, b1, b2;
    int prom_a = 0, prom_b = 0;

    cin >> a0 >> a1 >> a2;
    cin >> b0 >> b1 >> b2;

    vector<int> a = solve(a0, a1, a2);
    vector<int> b = solve(b0, b1, b2);

    for(int i = 0; i < a.size(); i++){
        if(a[i] > b[i]) prom_a++;
        else if(a[i] < b[i]) prom_b++;
    }

    cout << prom_a << " " << prom_b << endl;

    return 0;
}
