//07:05:45PM
#include <iostream>
#include <string>

using namespace std;

int main()
{
    string str, meridian, h, m, s;
    string convert = "";
    int hour;

    cin >> str;

    // Obtenemos los ultimos dos caracteres
    meridian = str.substr(str.size() - 2, str.size());
    h = str.substr(0, 2); // hora
    m = str.substr(3, 2); // minutos
    s = str.substr(6, 2); // segundos

    // verificamos
    if(meridian == "PM"){
        hour = stoi(h.c_str());
        hour = (hour == 12) ? 12 : hour + 12;
        // Obtenemos la hora
        h = (hour == 0) ? "00" : to_string(hour);
    } else {
        hour = stoi(h.c_str());
        h = (hour == 12) ? "00" : h;
    }

    convert.append(h+":"+m+":"+s);

    cout << convert << endl;

    return 0;
}
