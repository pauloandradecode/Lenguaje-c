/*
Conjunto de marcados

Nombre: Paulo Cesar Andrade Gonzalez
Fecha: 05/06/2017
Notas: Podemos crearlo con un array, y su lomgitud seria el mismo numero de vertices
    del grafo, el array sera caracteristico (0 y 1)

    STL (Stadart Template Library), plantillas preprogramadas para adaptar a los tipos
    de datos que necesitamos, perteneciente al STD.

    (::) Operador de resolucion de ambito
*/

#include <cstdio>
#include <set> // Libreria para conjuntos

// Se usa para asociar conceptos logicamente
//using namespace std;

/*
bool find(std::set<int> &s, int x){
    return s.find(x) != s.end();
}
*/

// Creamos una clase set que hereda de la clase set
class set: public std::set<int>
{
    public:
        bool find(int x)
        {
            std::set<int>::find(x) != end();
        }
};

int main()
{
    // Declaramos el conjunto y su iterador
    set M;

    M.insert(10);
    M.insert(15);
    M.insert(7);
    M.insert(8);
    M.insert(2);

    for(int i = 1; i <= 20; i++){
        if(M.find(i)) printf("%i\n", i);
    }

    return 0;
}
