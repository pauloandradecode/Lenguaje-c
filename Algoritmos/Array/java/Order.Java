/************************************************************
Ordena vectores en orden ascendente o descendente

Fecha 13/09/2016
Nombre: Paulo Andrade
Email: source.compu@gmail.com
************************************************************/

//Importación del código de la clase Scanner desde la biblioteca Java
import java.util.Scanner;

class Order
{
	// Método principal
	public static void main (String[] args)
	{
		// Instanciamos clases
		Scanner read = new Scanner(System.in);
		// Instanciamos el vector predeterminado
		int[] vector = new int[5];

		// Obtenemos los valores para el vector
		System.out.println("Ingrese los 5 valores del vector");
		for(int i = 0; i < 5; i++){
			vector[i] = read.nextInt();
		}

		// Ordenamos
		vector = asd(vector);

		// Imprimimos
		for(int i = 0; i < 5; i++){
			System.out.print(vector[i] + " ");
		}
	}
	// Método para ordenar de forma ascendente
	// @param x vector a ordenar
	public static int[] asd (int[] x)
	{
		int auxiliar; // Para el intercambio de valores

		// Recorremos el vector dos veces para el reacomodo de elementos
		for(int i = 0; i < x.length - 1; i++){
        	for(int j = i + 1; j < x.length; j++){
        		// Comprobamos si el valor actual es menor al que le sigue
            	if(x[i] > x[j]){
                    //Intercambiamos valores
                    auxiliar = x[i];
                    x[i] = x[j];
                    x[j] = auxiliar;
            	}
        	}
		}

		return x;
	}
	// Método para ordenar de forma descendente
	// @param x vector a ordenar
	public static int[] des (int[] x)
	{
		int auxiliar; // Para el intercambio de valores

		// Recorremos el vector dos veces para el reacomodo de elementos
		for(int i = 0; i < x.length - 1; i++){
        	for(int j = i + 1; j < x.length; j++){
        		// Comprobamos si el valor actual es mayor al que le sigue
            	if(x[i] < x[j]){
                    //Intercambiamos valores
                    auxiliar = x[i];
                    x[i] = x[j];
                    x[j] = auxiliar;
            	}
        	}
		}

		return x;
	}
	// Método para ordenar de forma ascendente o descendente
	// @param x vector a ordenar
	// @param type indica la forma de ordenar el vector [true = asc, false = des]
	public static int[] combined (int[] x, boolean type)
	{
		int auxiliar; // Para el intercambio de valores

		// Verificamos si el acomodo es en forma ascendente
		if(type){
			// Recorremos el vector dos veces para el reacomodo de elementos
			for(int i = 0; i < x.length - 1; i++){
	        	for(int j = i + 1; j < x.length; j++){
	        		// Comprobamos si el valor actual es menor al que le sigue
	            	if(x[i] > x[j]){
	                    //Intercambiamos valores
	                    auxiliar = x[i];
	                    x[i] = x[j];
	                    x[j] = auxiliar;
	            	}
	        	}
			}
		} else {
			// Recorremos el vector dos veces para el reacomodo de elementos
			for(int i = 0; i < x.length - 1; i++){
	        	for(int j = i + 1; j < x.length; j++){
	        		// Comprobamos si el valor actual es mayor al que le sigue
	            	if(x[i] < x[j]){
	                    //Intercambiamos valores
	                    auxiliar = x[i];
	                    x[i] = x[j];
	                    x[j] = auxiliar;
	            	}
	        	}
			}
		}

		return x;
	}
}