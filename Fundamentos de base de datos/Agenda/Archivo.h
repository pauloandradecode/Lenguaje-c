#ifndef ARCHIVO_H_INCLUDED
#define ARCHIVO_H_INCLUDED

#include <cstdio>
#include <cstdlib>
#include <fstream>

using namespace std;

struct nodo {
    char nombre[20];
    char apellido[20];
    char telefono[15];
    char fecha[15];
};

typedef struct nodo contacto;

class Archivo
{
    contacto _contacto;

    public:
        Archivo();

        void read(); // Lee un registro
        void edit(int); // Edita un contacto
        void save(); // Guarda un registro
        void del(int); // Elimina un registro
        void search(); // busca un registro
};

#endif // ARCHIVO_H_INCLUDED
