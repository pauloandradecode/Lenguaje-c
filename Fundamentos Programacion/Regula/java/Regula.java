/*
* Autor: Paulo Andrade
* Descripción: Programa para examen de regularización
*
* Nota: En este programa vamos a crear un nuevo tipo de dato (struct) para almacenar numero racionales,
*       es decir, un numero fraccionario, y apartir de hay crear funciones para realizar operaciones
*       basicas con estos.
*
* Nota 2: En java no existen las estructuras de control, sin embargo se puede utilizar una clase
*       en su luga
*/

import java.util.Scanner; //Importación del código de la clase Scanner desde la biblioteca Java

public class Regula
{
	public static void main(String args[])
	{
		// Declaramos las variables
		Racional x,y,z;

		// Inicializamos los objetos
		x = new Racional();
		y = new Racional();

		// Obtenemos los valores de X y Y
		System.out.print("Lee X: ");
		x = lee();
		System.out.print("Lee Y: ");
		y = lee();

		// Realizamos las operaciones
		System.out.print("Suma:           ");
		z = suma(x, y);
		imprime(z);

		System.out.print("Resta:          ");
		z = resta(x, y);
		imprime(z);

		System.out.print("Multiplicación: ");
		z = multiplica(x, y);
		imprime(z);

		System.out.print("División:       ");
		z = divide(x, y);
		imprime(z);
	}
	// Función que lee un numero racional
	private static Racional lee()
	{
		// Declaramos variables locales
		Racional x = new Racional();
		String data, temp[];

		// Leemos
		Scanner cin = new Scanner(System.in); //Creación de un objeto Scanner
        data = cin.nextLine(); //Invocamos un método sobre un objeto Scanner
        temp = data.split(":"); // Obtenemos cada uno de los datos
        x.p = Integer.parseInt(temp[0]); // Convertimos de String a int
        x.q = Integer.parseInt(temp[1]); // Convertimos de String a int

		return x;
	}
	// Función para imprimir numeros racionales
	private static void imprime(Racional x)
	{
		System.out.println("["+x.p+":"+x.q+"]");
	}
	// Funcion que suma racionales
	private static Racional suma(Racional x, Racional y)
	{
		// Declaramos los tipo de datos
	    Racional z = new Racional();

	    // Realizamos la suma de racionales
	    z.p = (x.p * y.q) + (x.q * y.p);
	    z.q = x.q * y.q;

	    // Retornamos el numero racional
	    return z;
	}
	// Funcion que resta racionales
	private static Racional resta(Racional x, Racional y)
	{
		// Declaramos los tipo de datos
	    Racional z = new Racional();

	    // Realizamos la suma de racionales
	    z.p = (x.p * y.q) - (x.q * y.p);
	    z.q = x.q * y.q;

	    // Retornamos el numero racional
	    return z;
	}
	// Función para multiplicar racionales
	private static Racional multiplica(Racional x, Racional y)
	{
	    // Declaramos los tipo de datos
	    Racional z = new Racional();

	    // Realizamos la suma de racionales
	    z.p = x.p * y.p;
	    z.q = x.q * y.q;

	    // Retornamos el numero racional
	    return z;
	}
	// Función que divide racionales
	private static Racional divide(Racional x, Racional y)
	{
	    // Declaramos los tipo de datos
	    Racional z = new Racional();

	    // Realizamos la suma de racionales
	    z.p = x.p * y.q;
	    z.q = x.q * y.p;

	    // Retornamos el numero racional
	    return z;
	}
}