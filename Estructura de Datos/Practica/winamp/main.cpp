/*
Fecha: 20/06/2017
Nombre: Paulo Cesar Andrade Gonzalez
Nota:
*/

#include <cstdio>
#include <cstdlib>
#include <iostream>
#include "Dipole.hpp"

using namespace std;

int main()
{
    char option;
    char author[100], title[100];
    bool control = true;
    Dipole *w = new Dipole(50);

    // Canciones por defecto
    w->enqueueFront("Maluma", "Felices los cuatro");
    w->enqueueFront("Katy Perry", "Dark horse");
    w->enqueueFront("Shakira Ft-> Carlos Vives", "La bicicleta");
    w->enqueueFront("Freddy Mercury", "We are the champions");
    w->enqueueFront("Daddy Yankie", "Despacito");
    w->enqueueFront("Enrique Iglesias", "Subeme la radio");
    w->enqueueFront("Ariana Grande", "Problem");
    w->enqueueFront("Shakira", "Chantaje");
    w->enqueueFront("Miley Cyrus", "Wrecking Ball");
    w->enqueueFront("Taylor Swift", "Shake it off");

    w->orderbytitle(); // Ordenamos mediante titulo

    while(control){
        // Limpiamos la pantalla
        system("clear");

        w->print(); // Imprimimos la lista

        // Menu
        printf("[R] Aleatorio\n");
        printf("[F] Siguiente\n");
        printf("[B] Anterior\n");
        printf("[A] Añadir\n");
        printf("[E] Eliminar\n");
        printf("[1] Titulos\n");
        printf("[2] Autores\n");
        printf("[X] Salir\n\n");
        printf("Opcion: ");

        cin >> option;
        option = w->ascii(option);

        switch(option){
            case 'r':
                w->random(); // Navegacion aleatoria
                break;
            case 'f':
                w->prev(); // Navegamos hacia atras
                break;
            case 'b':
                w->next(); // Navegamos hacia adelante
                break;
            case 'a':
                cout << "\nTitulo de la cancion: ";
                cin.ignore(256,'\n'); // Limpiamos el buffer
                cin.getline(title, 100);
                cout << "Autor de la cancion: ";
                //cin.ignore(256,'\n'); // Limpiamos el buffer
                cin.getline(author, 100);
                w->enqueueFront(author, title); // Insertamos nueva cancion
                puts("");
                break;
            case 'e':
                w->del(); // Eliminamos la cancion
                break;
            case '1':
                w->orderbytitle();
                break;
            case '2':
                w->orderbyauthor();
                break;
            case 'x':
                control = false;
                cout << "Exit" << endl;
                break;
        }
    }

    delete w;

    return 0;
}
