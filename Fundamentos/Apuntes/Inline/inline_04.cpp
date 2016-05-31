/*
* Fecha: 31/05/2016
*
* Ejemplo de funciones en linea (inline), es decir, podemos escribir el cuerpo de una funcion
* en una sola linea de codigo.
* Nota: Para poder utilizar el mofificador inline, se requiere que el cuerpo de la funcion sea
*       de una o maximo dos lineas (el compilador hace una sustitucion del llamado a la funcion
        por el cuerpo de la funcion, ahorrando memoria y recursos [más eficiente]).
*
* Nota 2: Evaluamos expresiones logicas e imprimimos la tabla de verdad para la tercer expresion
*       logica.
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

    // Imprimir la tabla de verdad  para el ejemplo 3 (nos va a imprimir las combinaciones posibles)
    printf("\nTabla de verdad p <->(q ^ r) = (!p v (q ^ r)) ^ (!(q ^ r) v p\n\n");

    // i = p, j = q, k = r
    for(int i = 0; i <= 1; i++){
        for(int j = 0; j <= 1; j++){
            for(int k = 0; k <= 1; k++){
                printf("%s %s %s | ", bname(i), bname(j), bname(k));

                printf("%s | ", bname(j && k));
                printf("%s | ", bname(!(j && k)));
                printf("%s | ", bname(imply(j && k, i)));
                printf("%s | ", bname(!i));
                printf("%s | ", bname(imply(i, j && k)));
                printf("%s \n", bname(biimmp(i, j && k)));
            }
        }
    }

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
    // return p ? "true" : "false";
    return p ? "V" : "F";
}
