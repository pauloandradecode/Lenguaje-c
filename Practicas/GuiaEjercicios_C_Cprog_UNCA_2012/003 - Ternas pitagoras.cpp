/***********************************************
* Ejercicio 3
*
* Nombre: Ternas de Pitagoras
* Descripcion: Un triangulo rectángulo puede tener lados que sean todos enteros. El conjunto de tres valores
*     enteros para los lados de un triángulo rectángulo se conoce como una terna pitagórica. Estos tres lados
*     deben satisfacer la relación de que la suma de los cuadrados de dos lados es igual al cuadrado de la
*     hipotenusa. Encuentre todas las ternas de Pitágoras para el cateto opuesto, cateto adyacente e hipotenusa,
*     todos ellos no mayores de 500.
* Pagina: 16
* Fecha: 06/05/2016
***********************************************/

#include <cstdio>

int main()
{
    int temp, sumCuadrados, op, ady, hip;

    // Ciclo para obtener la hipotenusa
    for(int i = 1; i < 500; i++){
        // Obtenemos hipotenusa al cuadrado
        hip = i * i;

        // Ciclo para optener el cateto opuesto
        for(int j = 1; j < 500; j++){
            // Obtenemos cateto opuesto al cuadrado
            op = j * j;

            for(int k = 1; k < 500; k++){
                // Obtenemos cateto adyasente al cuadrado
                ady = k * k;

                // Obtenemos la suma de los cuadrados
                sumCuadrados = op + ady;

                // Si la suma de cuadrados es igual al cuadrado de la hip, obtenemos una terna
                if(sumCuadrados == hip){
                    printf("Cateto Opuesto = %d\n", j);
                    printf("Cateto Adyasente = %d\n", k);
                    printf("Hipotenusa = %d\n", i);
                    printf("Comprobacion: \n");
                    printf("%6d + %6d = %6d\n\n", op, ady, hip);
                }
            }
        }
    }

    return 0;
}
