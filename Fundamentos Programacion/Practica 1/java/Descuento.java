/**********************************************
* Programa 3 - Practica 1
* Fecha: 18/04/2016
* Nombre: Descuento
**********************************************/

import java.util.Scanner; //Importación del código de la clase Scanner desde la biblioteca Java
import java.text.DecimalFormat; // Para limitar el numero de decimales

public class Descuento
{
	private static double precio;
	private static double descuento;
	private static double total;

	public static void main(String[] args)
	{
		System.out.print("Ingrese el precio del producto: ");
	    precio = lee();
	    System.out.print("Ingrese el descuento a aplicar (porcentaje): ");
	    descuento = lee();

	    // Procesamos
	    total = precio - (precio * descuento / 100);

	    // Imprimimos el resultado
	    imprimir(total);
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
        x = Double.parseDouble(data); // Convertimos de String a double

        return x;
    }
    // Funcion para imprimir el resultado
    public static void imprimir(double x)
    {
    	// Instanciamos un objeto de DecimalFormat y le asignamos 2 decimales
		DecimalFormat df = new DecimalFormat("0.00");

		System.out.println("Total a pagar: "+df.format(x));
    }
}