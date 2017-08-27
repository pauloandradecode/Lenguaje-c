#include <cstdio>
#include <cstdio>
#include <fstream>
#include "Archivo.h"

using namespace std;

/******************************************
Constructor
******************************************/

Archivo::Archivo()
{
    // Creamos el archivo en caso de que no exista
    ofstream fp("database.bin", ios::out | ios::binary);

    // cerramos el archivo
    fp.close();
}

/******************************************
Métodos
******************************************/

// Lee un registro
void Archivo::read()
{
}

// Guarda un registro
void Archivo::save()
{
}

// Elimina un registro
void Archivo::del()
{
}

// busca un registro
void Archivo::search()
{
}
