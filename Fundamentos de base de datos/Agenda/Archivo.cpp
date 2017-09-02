/*
Notas: Tamaño del archivo 70
*/

#include <cstdio>
#include <cstdio>
#include <cstring>
#include <iostream>
#include <fstream>
#include "Archivo.h"

using namespace std;

/******************************************
Constructor
******************************************/

Archivo::Archivo()
{
    // Creamos el archivo en caso de que no exista
    fstream fp("database.bin", ios::app | ios::binary);

    // cerramos el archivo
    fp.close();
}

/******************************************
Métodos
******************************************/

// Lee y mostramos los registros
void Archivo::read()
{
    int count = 1;
    // Abrimos el archivo
    fstream fp("database.bin", ios::in | ios::binary);

    if(!fp.eof()){
        printf(" N |       Nombre       |      Apellido      |");
        printf("    Telefono   | F. Nacimiento \n");
    }

    // Leemos el archivo
    fp.read(reinterpret_cast<char *>(&_contacto), sizeof(_contacto));

    while(!fp.eof()){
        // Mostramos la informacion
        printf(" %i |", count);
        printf("%20s|", _contacto.nombre);
        printf("%20s|", _contacto.apellido);
        printf("%15s|", _contacto.telefono);
        printf("%15s\n", _contacto.fecha);

        // Leemos el archivo
        fp.read(reinterpret_cast<char *>(&_contacto), sizeof(_contacto));

        count++; // Aumentamos el contador
    }

    fp.close();

    printf("\n\n[ Eliminar: 1 - Editar: 2 - Salir: 0 ]\n");
    int control, con;

    do{
        cin.ignore(256,'\n'); // Limpiamos el buffer
        printf("Seleccione una opcion: ");
        scanf("%i", &control);

        switch(control){
            case 0:
                // Limpiamos la pantalla
                system("clear");
                break;
            case 1:
                cin.ignore(256,'\n'); // Limpiamos el buffer
                printf("Seleccione el contacto a eliminar: ");
                scanf("%i", &con);
                del(con);
                control = 0;
                break;
            case 2:
                cin.ignore(256,'\n'); // Limpiamos el buffer
                printf("Seleccione el contacto a editar: ");
                scanf("%i", &con);

                edit(con);
                control = 0;
                break;
        }
    } while(control != 0);
}

// Guarda un registro
void Archivo::save()
{
    // Ingresar datos
    cin.ignore(256,'\n'); // Limpiamos el buffer
    printf("Ingrese el nombre: ");
    cin.getline(_contacto.nombre, 20);
    printf("Ingrese el apellido: ");
    cin.getline(_contacto.apellido, 20);
    printf("Ingrese el telefono: ");
    cin.getline(_contacto.telefono, 15);
    printf("Ingrese fecha de nacimiento [dd/mm/aa]: ");
    cin.getline(_contacto.fecha, 15);

    // Abrimos el archivo
    fstream fp("database.bin", ios::app | ios::binary);

    // Verificamos si el archivo se abrio
    if(fp.is_open()){
        // Guardamos el archivo
        fp.write(reinterpret_cast<char *>(&_contacto), sizeof _contacto);

        // cerramos el archivo
        fp.close();
    }

    // Limpiamos la pantalla
    system("clear");

    printf("*** CONTACTO GUARDADO CON EXITO ***\n\n");
}

// Elimina un registro
void Archivo::del(int n)
{
    int count = 1; // Contador

    // Abrimos el archivo
    fstream fp("database.bin", ios::in | ios::binary);
    fstream fptemp("temp.bin", ios::app | ios::binary);

    // Leemos el archivo
    fp.read(reinterpret_cast<char *>(&_contacto), sizeof(_contacto));

    while(!fp.eof()){
        // Buscamos el contacto a editar
        if(count != n){
            // Escribimos en el archivo temporl
            fptemp.write(reinterpret_cast<char *>(&_contacto), sizeof _contacto);
        }

        // Leemos el archivo
        fp.read(reinterpret_cast<char *>(&_contacto), sizeof(_contacto));

        count++; // Aumentamos el contador
    }

    // Eliminamos el archivo
    remove("database.bin");
    rename("temp.bin", "database.bin");

    fp.close();
    fptemp.close();

    // Limpiamos la pantalla
    system("clear");

    printf("*** CONTACTO ELIMINADO CON EXITO ***\n\n");
}

// busca un registro
void Archivo::search()
{
    // Limpiamos la pantalla
    system("clear");

    char q[20];
    int count = 1, countTemp = 0;
    int control = 0;

    // Obtenemos el termino a buscar
    printf("Ingrese el contacto a buscar: ");
    cin.ignore(256,'\n'); // Limpiamos el buffer
    cin.getline(q, 20);

    // Abrimos el archivo
    fstream fp("database.bin", ios::in | ios::binary);

    // Leemos el archivo
    fp.read(reinterpret_cast<char *>(&_contacto), sizeof(_contacto));

    while(!fp.eof()){
        control = 0; // Restablecemos el control

        // Buscamos coincidencias
        if(strstr(_contacto.nombre, q)) control++;
        if(strstr(q, _contacto.apellido)) control++;
        if(strstr(q, _contacto.telefono)) control++;
        if(strstr(q, _contacto.fecha)) control++;

        if(control != 0){
            if(countTemp == 0){
                printf("*** CONTACTOS ENCONTRADOS ***\n\n");
                printf(" N |       Nombre       |      Apellido      |");
                printf("    Telefono   | F. Nacimiento \n");
            }

            // Mostramos la informacion
            printf(" %i |", count);
            printf("%20s|", _contacto.nombre);
            printf("%20s|", _contacto.apellido);
            printf("%15s|", _contacto.telefono);
            printf("%15s\n", _contacto.fecha);

            countTemp++; // Aumentamos el contador
        }

        // Leemos el archivo
        fp.read(reinterpret_cast<char *>(&_contacto), sizeof(_contacto));

        count++; // Aumentamos el contador
    }

    fp.close();

    // Verificamos si no hubo contactos
    if(count != 0) {
        printf("\n\n[ Eliminar: 1 - Editar: 2 - Salir: 0 ]\n");
        int opcion, con;

        do{
            printf("Seleccione una opcion: ");
            scanf("%i", &opcion);

            switch(opcion){
                case 0:
                    // Limpiamos la pantalla
                    system("clear");
                    break;
                case 1:
                    cin.ignore(256,'\n'); // Limpiamos el buffer
                    printf("Seleccione el contacto a eliminar: ");
                    scanf("%i", &con);
                    del(con);
                    control = 0;
                    break;
                case 2:
                    cin.ignore(256,'\n'); // Limpiamos el buffer
                    printf("Seleccione el contacto a editar: ");
                    scanf("%i", &con);

                    edit(con);
                    control = 0;
                    break;
            }
        } while(control != 0);
    } else {
        // Limpiamos la pantalla
        system("clear");

        printf("*** NO SE ENCONTRO NINGUN CONTACTO ***\n\n");
    }
}

// Edita un contacto
void Archivo::edit(int n)
{
    int count = 1; // Contador

    // Abrimos el archivo
    fstream fp("database.bin", ios::in | ios::binary);
    fstream fptemp("temp.bin", ios::app | ios::binary);

    // Leemos el archivo
    fp.read(reinterpret_cast<char *>(&_contacto), sizeof(_contacto));

    while(!fp.eof()){
        // Buscamos el contacto a editar
        if(count == n){
            // Ingresar datos
            cin.ignore(256,'\n'); // Limpiamos el buffer
            printf("Nombre anterior: %s\n", _contacto.nombre);
            printf("Ingrese el nuevo nombre: ");
            cin.getline(_contacto.nombre, 20);
            printf("Apellido anterior: %s\n", _contacto.apellido);
            printf("Ingrese el nuevo apellido: ");
            cin.getline(_contacto.apellido, 20);
            printf("Telefono anterior: %s\n", _contacto.telefono);
            printf("Ingrese el nuevo telefono: ");
            cin.getline(_contacto.telefono, 15);
            printf("Fecha anterior: %s\n", _contacto.fecha);
            printf("Ingrese nueva fecha de nacimiento [dd/mm/aa]: ");
            cin.getline(_contacto.fecha, 15);
        }

        // Escribimos en el archivo temporl
        fptemp.write(reinterpret_cast<char *>(&_contacto), sizeof _contacto);

        // Leemos el archivo
        fp.read(reinterpret_cast<char *>(&_contacto), sizeof(_contacto));

        count++; // Aumentamos el contador
    }

    // Eliminamos el archivo
    remove("database.bin");
    rename("temp.bin", "database.bin");

    fp.close();
    fptemp.close();

    // Limpiamos la pantalla
    system("clear");

    printf("*** CONTACTO EDITADO CON EXITO ***\n\n");
}
