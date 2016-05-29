/*
* Fecha: 28/05/2016
* Nombre: Factorial (pagina 26)
* Nota: En este programa vamos a utilizar la recursividad para obtener el factorial de un numero, la
*       funcion factorial se define en los siguientes terminos:
*       - F(n) = n * F(n - 1)
*       - F(0) = 1
*/

public class Factorial
{
	public static void main(String args[])
	{
		// Obtenemos el numero de la shell y lo forzamos al tipo long
		long n = Long.parseLong(args[0]);

		// Mostramos el factorial del numero
		System.out.println("El factorial de " + n + " es: " + f(n));
	}

	// Calculamos el factorial
	private static long f(long n)
	{
		long result;

		if(n > 0){
			result = n - f(n - 1);
		} else {
			result = 1;
		}

		return result;
	}
}