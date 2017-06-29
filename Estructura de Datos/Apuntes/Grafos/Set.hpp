/*
Name: Paulo Cesar Andrade
Fecha: 17/05/2017
Notas: Implementación de conjuntos de marcados
*/

#include <set> // Libreria para conjuntos
#include <cstdio>

#ifndef SET_HPP_INCLUDED
#define SET_HPP_INCLUDED

// Creamos una clase set que hereda de la clase set
class Set: public std::set<int>
{
    public:
        bool find(int); // Busqueda en el marcado
};

#endif // SET_HPP_INCLUDED
