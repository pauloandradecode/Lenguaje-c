/*
* Fecha: 12/04/2016
*
* Ejemplo de un array multidimencional (2 dimenciones)
*/

#include <cstdio>

using namespace std;

int main()
{
	float matriz[5][4];
	
	for(int i = 0; i < 5; i++){
		printf("Fila %i\n", i);
		
		for(int j = 0; j  < 4; j++){
			printf("    Elemento [%i][%i]: ", i, j);
			scanf("%f", &matriz[i][j]);
		}
	}
	
	puts("\nMatriz le\241da: ");
	
	for(int i = 0; i < 5; i++){
		for(int j = 0; j < 4; j++){
			printf("%6.2f", matriz[i][j]);
		}
		printf("\n");
	}
	
	return 0;
}
