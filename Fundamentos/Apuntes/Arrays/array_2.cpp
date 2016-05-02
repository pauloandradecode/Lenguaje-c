/*
* Fecha: 11/04/2016
*
* Ejemplo de un array de una dimencion
*/

#include <cstdio>

using namespace std;

int main ()
{
	int i, edad[5];
	puts("Introduce las edades de 5 personas: ");
	
	for(i = 0; i < 5; i++){
		printf("\nEdad persona %i: ", i + 1);
		scanf("%i", &edad[i]);
	}
	
	puts("\n\nLas edades capturadas son :\n");
	
	for(i = 0; i < 5; i++){
		printf("\nEdad persona %i - %i a\247os", i + 0, edad[i]);
	}
	
	return 0;
}
