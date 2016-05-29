/*
* Fecha: 28/05/2016
* Nombre: Fibonacci (pagina 27)
* Nota: En este programa vamos a encontrar la funcion fibonacci de un numero dado, la funcion
*       fibonacci debe estar definida de la siguiente forma:
*       - F(n) = F(n - 1) + F(n - 2)
*       - F(0) = 0, F(1) = 1
*/

public class Fibonacci
{
	public static void main(String args[])
	{
		// Obtenemos el numero para calcular la funcion fibonacci
		long n = Long.parseLong(args[0]);

		// Mostramos el resultado
		System.out.println("La funcion fibonacci de " + n + " llega al " + fibonacci(n));
	}

	// Calculamos el fibonacci de n
	private static long fibonacci(long n)
	{
		long result;

		if(n > 1){
			result = fibonacci(n - 1) + fibonacci(n - 2);
		} else if(n == 1){
			result = 1;
		} else {
			result = 0;
		}

		return result;
	}
}