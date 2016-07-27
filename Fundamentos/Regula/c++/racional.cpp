#include <iostream>

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
    printf("\nSuma:           ");
    z = suma(x, y);
    imprime(z);

    printf("\nResta:          ");
    z = resta(x, y);
    imprime(z);

    printf("\nMultiplicacion: ");
    z = multiplica(x, y);
    imprime(z);

    printf("\nDivision:       ");
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
    printf("[%i:%i]\n", x.p, x.q);
}