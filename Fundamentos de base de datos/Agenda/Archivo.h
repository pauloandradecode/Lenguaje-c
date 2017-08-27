#ifndef ARCHIVO_H_INCLUDED
#define ARCHIVO_H_INCLUDED

#include <cstdio>
#include <cstdlib>
#include <fstream>

using namespace std;

class Archivo
{
    public:
        Archivo();

        void read(); // Lee un registro
        void save(); // Guarda un registro
        void del(); // Elimina un registro
        void search(); // busca un registro
};


#endif // ARCHIVO_H_INCLUDED
