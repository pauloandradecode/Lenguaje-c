/*
Fecha: 07/04/2016
Nota:
*/

#include <cstdio>

int main()
{
    // Numero de sensores, coordenada x, coordenada y, radio
    int unsigned n, x, y, r;
    int count = 0; // contador

    while(true){
        // Ingresamos el numero de sensores
        do{
            scanf("%d", &n);
        } while (n > 200); // Pide el numero miestras sea mayor a 200

        // Recorremos todos los sensores
        for(int i = 0; i < n; i++){
            // Ingresamos las coordenadas y el radio
            scanf("%d %d %d", &x, &y, &r);

            // Calculamos para x y y mayor a la media
            if(x > 100 && (x + r) <= 200){
                if((y > 150 && (y + r) <= 300) || (y <= 150 && r <= y)){
                    count++;
                }
            }

            // Calculamos para x y y menor a la media
            if(x <= 100 && r <= x){
                if((y <= 150 && r <= y) || (y > 150 && (y + r) <= 300)){
                    count++;
                }
            }
        }

        // Mostramos el resultado
        printf("%d\n\n", count);
    }

    return 0;
}
