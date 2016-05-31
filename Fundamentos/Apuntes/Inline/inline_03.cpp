/*
* Fecha: 31/05/2016
*
* Ejemplo de funciones en linea (inline), es decir, podemos escribir el cuerpo de una funcion
* en una sola linea de codigo.
* Nota: Para poder utilizar el mofificador inline, se requiere que el cuerpo de la funcion sea
*       de una o maximo dos lineas (el compilador hace una sustitucion del llamado a la funcion
        por el cuerpo de la funcion, ahorrando memoria y recursos [más eficiente]).
*
* Nota 2: Evaluamos expresiones logicas
*/

#include <cstdio>

// Prototipo de las funciones
inline bool imply(bool, bool); // Funcion para la implicacion
inline bool biimmp(bool, bool); // Funcion para la doble implicacion
inline bool exp1(bool, bool, bool);
inline bool exp2(bool, bool, bool);
inline bool exp3(bool, bool, bool);
inline const char *bname(bool); // Devuelve un string false o true

int main()
{
    bool p, q, r;

    scanf("%i%i%i", &p, &q, &r);

    // Utilizamos la funcion inline
    printf("\nExp 1: %s\n", bname(exp1(p, q, r)));
    printf("Exp 2: %s\n", bname(exp2(p, q, r)));
    printf("Exp 3: %s\n", bname(exp3(p, q, r)));

    return 0;
}

// Implementacion de las funciones
inline bool imply(bool a, bool b)
{   // Implicacion de a -> b
    return !a || b;
}

inline bool biimmp(bool a, bool b)
{
    return imply(a, b) && imply(b, a);
}

inline bool exp1(bool p, bool q, bool r)
{
    // (p->q) ^ r
    // return (!p || q) && r;
    return imply(p, q) && r;
}
inline bool exp2(bool p, bool q, bool r)
{
    // (p v q) -> r
    // return !(p || q) || r;
    return imply(p || q, r);
}
inline bool exp3(bool p, bool q, bool r)
{
    // p <->(q ^ r) = (!p v (q ^ r)) ^ (!(q ^ r) v p
    // return (!p || (q && r)) && (!(q && r) || p);
    // return imply(p, q && r) && imply(q && r, p);
    return biimmp(p, q && r);
}

// char * es para manejar cadenas
inline const char *bname(bool p)
{
    return p ? "true" : "false";
}
