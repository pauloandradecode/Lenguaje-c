/**********************************************
* Programa 4 - Practica 1
* Fecha: 18/04/2016
* Nombre: Divisas
**********************************************/

import java.util.Scanner; //Importación del código de la clase Scanner desde la biblioteca Java
import java.text.DecimalFormat; // Para limitar el numero de decimales

public class Divisa
{
	private static double dolares;
	private static double pesos;
	private static double tasaCambio = 13.1803;

	public static void main(String[] args)
	{
		System.out.print("Ingrese la cantidad en dolares: ");
	    dolares = lee();

	    // Procesamos
	    pesos = dolares * tasaCambio;

	    // Imprimimos el resultado
	    imprimir(pesos);
	}
	// Funcion para leer numeros tipo double
	public static double lee()
    {
        // Declaramos variables locales
        double x;
        String data;

        // Leemos
        Scanner cin = new Scanner(System.in); //Creación de un objeto Scanner
        data = cin.nextLine(); //Invocamos un método sobre un objeto Scanner
        x = Double.parseDouble(data); // Convertimos de String a int

        return x;
    }
    // Funcion para imprimir el resultado
    public static void imprimir(double x)
    {
    	// Instanciamos un objeto de DecimalFormat y le asignamos 2 decimales
		DecimalFormat df = new DecimalFormat("0.0000");

		System.out.println("Total en pesos: "+df.format(x));
    }
}