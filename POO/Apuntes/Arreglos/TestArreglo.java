/************************************************************
Clase TestArreglo - Clase para ejecutar operaciones

Practica: 2
Nombre: Paulo Andrade
Email: source.compu@gmail.com
************************************************************/

import java.util.Scanner; //Importación del código de la clase Scanner desde la biblioteca Java

class TestArreglo
{
	// Propiedades
	public static int opcion;
	public static int indice; // Almacenamos el total de indices para un vector
	public static int indice2;
	public static int renglones;
	public static int renglones2;
	public static int columnas;
	public static int columnas2;
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
					m1 = capturaMatriz(indice, indice);

					System.out.println("Ingrese los valores de la matriz 2:");
					m2 = capturaMatriz(indice, indice);

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
					m1 = capturaMatriz(indice, indice);

					System.out.println("Ingrese los valores de la matriz 2:");
					m2 = capturaMatriz(indice, indice);

					// Mandamos los datos
					arreglo.setM2(m2);

					// Sumamos las matrices
					arreglo.restarMatriz(m1);

					break;
				case 5:
					// Multiplicar matrices
					System.out.print("Ingrese el numero de filas de la primer matriz: ");
					renglones = lector.nextInt();
					System.out.print("Ingrese el numero de columnas de la primer matriz: ");
					columnas = lector.nextInt();
					m1 = new int[renglones][columnas];
					arreglo.setRenglones(renglones);
					arreglo.setColumnas(columnas);

					System.out.println("Ingrese los valores de la matriz 1:");
					m1 = capturaMatriz(renglones, columnas);

					// Pasamos los datos
					arreglo.setM1(m1);

					System.out.print("Ingrese el numero de filas de la segunda matriz matriz: ");
					renglones2 = lector.nextInt();
					System.out.print("Ingrese el numero de columnas de la segunda matriz matriz: ");
					columnas2 = lector.nextInt();
					m2 = new int[renglones2][columnas2];
					arreglo.setRenglones2(renglones2);
					arreglo.setColumnas2(columnas2);

					System.out.println("Ingrese los valores de la matriz 2:");
					m2 = capturaMatriz(renglones2, columnas2);

					// Pasamos los datos
					arreglo.setM2(m2);

					// Realizamos la operación
					mRes = arreglo.multiplicarMatriz();

					// Verificamos que la matriz no este vacia
					if(mRes != null){
						// Mostramos el resultado
						for(int i = 0; i < mRes.length; i++){
							System.out.println("");
							for(int j = 0; j < mRes[0].length; j++){
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
	private static int[][] capturaMatriz(int renglon, int columna)
	{
		// Inicializamos la clase para obtener datos desde el teclado
		Scanner lector = new Scanner(System.in);
		int[][] m2 = new int[renglon][columna];

		for(int i = 1; i <= renglon; i++){
			for(int j = 1; j <= columna; j++){
				System.out.print(i + "," + j + ": ");
				m2[i - 1][j - 1] = lector.nextInt();
			}
		}

		return m2;
	}
}