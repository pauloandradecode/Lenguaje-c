/*
* Fecha: 11/04/2016
*
* Ejemplo de array de una dimencion
*/

#include <cstdio>

using namespace std;

int main()
{
	float num[6];

	puts("Ingresa dos numeros: ");
	scanf("%f%f", &num[0], &num[1]);

	num[2] = num[0] + num[1];
	num[3] = num[0] - num[1];
	num[4] = num[0] * num[1];
	num[5] = num[0] / num[1];

	printf("\nLa suma es: %.2f\n", num[2]);
	printf("La resta es: %.2f\n", num[3]);
	printf("La multiplicacion es: %.2f\n", num[4]);
	printf("La division es: %.2f\n", num[5]);

	return 0;
}
