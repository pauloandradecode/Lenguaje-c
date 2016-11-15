/********************************************************
Clase principal - Archivos

Autor: Paulo Andrade
Fecha: 15/11/2016
********************************************************/

import java.io.FileInputStream;
import java.util.Scanner;

public class Archivo
{
	public static void main(String[] args) throws Exception
	{
		// Leemos el archivo
		FileInputStream fis = new FileInputStream("demo.txt");
		// Inicializamos el lector
		Scanner lector = new Scanner(fis);

		// Leemos los datos
		int i = lector.nextInt();
		String n = lector.next();

		// Recorremos el archivo
		while(!n.equals("Fin")){
			// Mostramos los datos en pantalla
			System.out.println(i + " " + n);

			// Leemos los datos
			i = lector.nextInt();
			n = lector.next();			
		}

		// Cerramos el archivo
		fis.close();
	}
}