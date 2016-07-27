/*
* Autor: Paulo Andrade
* Descripción: Programa para examen de regularización
*
* Nota: En este programa vamos a crear un nuevo tipo de dato (struct) para almacenar numero racionales,
*       es decir, un numero fraccionario, y apartir de hay crear funciones para realizar operaciones
*       basicas con estos.
*/

#include <iostream>
#include <cstdio>

using namespace std;

// Creamos el nuevo tipo de dato
typedef struct{
    int p;
    int q;
} racional;

// Prototipado de las funciones
racional lee();
racional suma(racional x, racional y);
racional resta(racional x, racional y);
racional multiplica(racional x, racional y);
racional divide(racional x, racional y);
void imprime(racional x);

int main()
{
    // Declaramos los tipos de datos
    racional x, y, z;

    // Obtenemos los valores de x y y
    cout << "Lee X: ";
    x = lee();
    cout << "Lee Y: ";
    y = lee();

    // Operaciones con los numeros x y y
    cout << "\nSuma:           ";
    z = suma(x, y);
    imprime(z);

    cout << "\nResta:          ";
    z = resta(x, y);
    imprime(z);

    cout << "\nMultiplicacion: ";
    z = multiplica(x, y);
    imprime(z);

    cout << "\nDivision:       ";
    z = divide(x, y);
    imprime(z);

    return 0;
}

// Declaramos las funciones
racional lee()
{
    // Declaramos los tipo de datos
    int p,q;
    racional x;

    // Leemos el numero racional
    scanf("%i:%i", &p, &q);

    // Asignamos los valores al numero racional
    x.p = p;
    x.q = q;

    // Retornamos el numero racional
    return x;
}
racional suma(racional x, racional y)
{
    // Declaramos los tipo de datos
    racional z;

    // Realizamos la suma de racionales
    z.p = (x.p * y.q) + (x.q * y.p);
    z.q = x.q * y.q;

    // Retornamos el numero racional
    return z;
}
racional resta(racional x, racional y)
{
    // Declaramos los tipo de datos
    racional z;

    // Realizamos la suma de racionales
    z.p = (x.p * y.q) - (x.q * y.p);
    z.q = x.q * y.q;

    // Retornamos el numero racional
    return z;
}
racional multiplica(racional x, racional y)
{
    // Declaramos los tipo de datos
    racional z;

    // Realizamos la suma de racionales
    z.p = x.p * y.p;
    z.q = x.q * y.q;

    // Retornamos el numero racional
    return z;
}
racional divide(racional x, racional y)
{
    // Declaramos los tipo de datos
    racional z;

    // Realizamos la suma de racionales
    z.p = x.p * y.q;
    z.q = x.q * y.p;

    // Retornamos el numero racional
    return z;
}
void imprime(racional x)
{
    // Imprimimos el valor del numero racional
    cout << "[" << x.p << ":" << x.q << "]" << endl;
}
