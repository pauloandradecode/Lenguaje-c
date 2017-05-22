#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int n; // Numero de juegos
    long long highest, lowest; // Mayor y menor record
    int count_h = 0, count_l = 0; // Contador de las veces que rompio los records

    cin >> n;

    vector<long long> scores(n);

    for(int i = 0; i < n; i++){
        cin >> scores[i];

        if(i == 0){
            highest = scores[i];
            lowest = scores[i];
        } else {
            if(highest < scores[i]){
                highest = scores[i];
                count_h++;
            }
            if(lowest > scores[i]){
                lowest = scores[i];
                count_l++;
            }
        }
    }

    cout << count_h << " " << count_l << endl;

    return 0;
}
