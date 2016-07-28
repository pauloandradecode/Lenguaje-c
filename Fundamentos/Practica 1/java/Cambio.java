/**********************************************
* Programa 1 - Practica 1
* Fecha: 18/04/2016
* Nombre: Cambio
**********************************************/

import java.util.Scanner; //Importación del código de la clase Scanner desde la biblioteca Java
import java.text.DecimalFormat; // Para limitar el numero de decimales

public class Cambio
{
	private static double dinero;
	private static double total;
	private static double cambio;

	public static void main(String[] args)
	{
		System.out.print("Ingrese el total de la venta: ");
		total = lee();

		System.out.print("Ingrese el dinero recibido: ");
		dinero = lee();

		// Calculamos el cambio
		cambio = dinero - total;

		// Imprimimos el resultado
		imprime(cambio);
	}

	// Función que lee un numero
	private static double lee()
	{
		// Declaramos variables locales
		Double x;
		String data;

		// Leemos
		Scanner cin = new Scanner(System.in); //Creación de un objeto Scanner
        data = cin.nextLine(); //Invocamos un método sobre un objeto Scanner
        x = Double.parseDouble(data); // Convertimos de String a int

		return x;
	}

	// Función imprime el resultado
	private static void imprime(Double cambio)
	{
		// Instanciamos un objeto de DecimalFormat y le asignamos 2 decimales
		DecimalFormat df = new DecimalFormat("0.00");
		
		// Imprimos el resultado con solo dos decimales
		System.out.println("Su cambio es: "+df.format(cambio));
	}
}