/************************************************************
Clase TestArreglo - Clase para ejecutar operaciones

Practica: 2
Nombre: Paulo Andrade
Email: source.compu@gmail.com
************************************************************/

import java.util.Scanner; //Importación del código de la clase Scanner desde la biblioteca Java
import java.text.DecimalFormat; // Para limitar el numero de decimales

class TestArreglo
{
	// Propiedades
	public static int opcion;
	public static int indice; // Almacenamos el total de indices para un vector
	public static int indice2;
	public static int[] vector; // Vector
	public static int[][] m1; // Matriz 1
	public static int[][] m2; // Matriz 2
	public static int[][] mRes; // Matriz 2

	// Constructor
	TestArreglo()
	{

	}

	// Metodo principal
	public static void main(String[] args)
	{
		// Inicializamos la clase calculadora
		Arreglo arreglo = new Arreglo();
		// Inicializamos la clase para obtener datos desde el teclado
		Scanner lector = new Scanner(System.in);
		// Instanciamos un objeto de DecimalFormat y le asignamos 2 decimales
		DecimalFormat df = new DecimalFormat("0.00");

		do{
			System.out.println("***********************************");
			System.out.println("              M E N U");
			System.out.println("***********************************\n");
			System.out.println("1.- NUMERO MAYOR");
			System.out.println("2.- NUMERO MENOR");
			System.out.println("3.- SUMAR MATRIZ");
			System.out.println("4.- RESTAR MATRIZ");
			System.out.println("5.- MULTIPLICAR MATRIZ");
			System.out.println("0.- SALIR");
			System.out.print("\nOPCION: ");

			// Optenemos un entero
			opcion = lector.nextInt();

			switch(opcion){
				case 0:
					// Finalizacion del programa
					System.out.println("Programa finalizado\n");
					break;
				case 1:
					// Numero mayor
					System.out.print("Ingrese el numero de indices del vector: ");
					indice = lector.nextInt();

					vector = new int[indice]; // Creamos un vector con el indice seleccionado

					System.out.println("Ingrese los valores del vector (separados por un espacio): ");
					for(int i = 0; i < indice; i++){
						vector[i] = lector.nextInt();
					}

					System.out.print("\nEl numero mayor es: " + arreglo.numeroMayor(vector) + "\n\n");

					break;
				case 2:
					// Numero menor
					System.out.print("Ingrese el numero de indices del vector: ");
					indice = lector.nextInt();

					vector = new int[indice]; // Creamos un vector con el indice seleccionado

					System.out.println("Ingrese los valores del vector (separados por un espacio): ");
					for(int i = 0; i < indice; i++){
						vector[i] = lector.nextInt();
					}

					System.out.print("\nEl numero menor es: " + arreglo.numeroMenor(vector) + "\n\n");

					break;
				case 3:
					// Sumar matriz
					System.out.print("Ingrese el numero de indices de las matrices: ");
					indice = lector.nextInt();

					m1 = new int[indice][indice];
					m2 = new int[indice][indice];

					System.out.println("Ingrese los valores de la matriz 1:");
					m1 = capturaMatriz(indice);

					System.out.println("Ingrese los valores de la matriz 2:");
					m2 = capturaMatriz(indice);

					// Mandamos los datos
					arreglo.setM1(m1);
					arreglo.setM2(m2);

					// Sumamos las matrices
					arreglo.sumarMatriz();

					break;
				case 4:
					// Restar matriz
					System.out.print("Ingrese el numero de indices de las matrices: ");
					indice = lector.nextInt();

					m1 = new int[indice][indice];
					m2 = new int[indice][indice];

					System.out.println("Ingrese los valores de la matriz 1:");
					m1 = capturaMatriz(indice);

					System.out.println("Ingrese los valores de la matriz 2:");
					m2 = capturaMatriz(indice);

					// Mandamos los datos
					arreglo.setM2(m2);

					// Sumamos las matrices
					arreglo.restarMatriz(m1);

					break;
				case 5:
					// Multiplicar matrices
					System.out.print("Ingrese el numero de indices de la primer matriz: ");
					indice = lector.nextInt();
					m1 = new int[indice][indice];

					System.out.println("Ingrese los valores de la matriz 1:");
					m1 = capturaMatriz(indice);

					// Pasamos los datos
					arreglo.setM1(m1);

					System.out.print("Ingrese el numero de indices de la segunda matriz matriz: ");
					indice2 = lector.nextInt();
					m2 = new int[indice2][indice2];

					System.out.println("Ingrese los valores de la matriz 2:");
					m2 = capturaMatriz(indice2);

					// Pasamos los datos
					arreglo.setM2(m2);

					// Realizamos la operación
					mRes = arreglo.multiplicarMatriz();

					// Verificamos que la matriz no este vacia
					if(mRes != null){
						// Mostramos el resultado
						for(int i = 0; i < mRes.length; i++){
							System.out.println("");
							for(int j = 0; j < mRes.length; j++){
								System.out.print(mRes[i][j] + " ");
								//System.out.printf("%-4s\n", mRes[i][j]);
							}
						}
						System.out.println("\n");
					} else {
						System.out.println("\nLas matrices no se puedes multiplicar\n");
					}

					break;
			}
		} while (opcion != 0);
	}
	private static int[][] capturaMatriz(int indice)
	{
		// Inicializamos la clase para obtener datos desde el teclado
		Scanner lector = new Scanner(System.in);
		int[][] m2 = new int[indice][indice];

		for(int i = 1; i <= indice; i++){
			for(int j = 1; j <= indice; j++){
				System.out.print(i + "," + j + ": ");
				m2[i - 1][j - 1] = lector.nextInt();
			}
		}

		return m2;
	}
	private static boolean isEmpty(int[][] a)
	{
		boolean empty = true;

		for(int i = 0; i < a.length; i++){
			if(a[i] != null){
				empty = false;
			}
		}

		return empty;
	}
}