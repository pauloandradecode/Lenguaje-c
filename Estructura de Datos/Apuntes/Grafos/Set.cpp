/*
Name: Paulo Cesar Andrade
Fecha: 17/05/2017
Notas: Implementación de conjuntos de marcados
*/

#include "Set.hpp"

using namespace std;

/*********************************************
Implementación clase Graph
*********************************************/

// Constructor
Set::Set() {};

// Sobre carga del constructor
Set::Set(int n)
{
    insert(n); // Insertamos el primer elemento
}

// Metodo de busqueda
bool Set::find(int x)
{
    return std::set<int>::find(x) != end();
}

// Metodo para obtener el primer elemento
int Set::front()
{
    if(!empty()){
        set<int>::iterator it = begin(); // Obtenemos el primer elemento

        return *it;
    }

    return 0;
}
