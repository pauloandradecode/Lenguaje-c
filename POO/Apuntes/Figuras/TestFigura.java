/*****************************************************
Clase

Name: Paulo Andrade
Date: 18/10/2016
*****************************************************/

import java.util.Scanner;

public class TestFigura
{
	public static Scanner lector = new Scanner(System.in);
	public static Triangulo triangulo = new Triangulo();
	public static Cuadrado cuadrado = new Cuadrado();

	public static void main(String[] args){
		int opcion = 0; // Opciones para el menu

		do{
			// Menu
			System.out.println("\n***********");
			System.out.println("  FIGURAS");
			System.out.println("***********\n");
			System.out.println("1.- TRIANGULO");
			System.out.println("2.- CUADRADO");
			System.out.println("0.- SALIR");

			// Elegimos la opcion
			System.out.print("Opcion: ");
			opcion = readInt();

			// Seleccionamos la opcion
			switch(opcion){
				case 0:
					System.out.println("\nFin del programa\n");
					break;
				case 1: // Opcion - Triangulos
					int opcion1 = 0;

					do{
						System.out.println("\n----------------");
						System.out.println("Elija una opcion");
						System.out.println("----------------\n");
						System.out.println("1.- PERIMETRO");
						System.out.println("2.- AREA");
						System.out.println("0.- VOLVER");

						// Elegimos la opcion
						System.out.print("Opcion: ");
						opcion1 = readInt();

						switch(opcion1){
							case 0:
								break;
							case 1: // Perimetro
								int opcion11 = 0;

								do{
									System.out.println("\n-------------------");
									System.out.println("Elija una triangulo");
									System.out.println("-------------------\n");
									System.out.println("1.- EQUILATERO");
									System.out.println("2.- ISOSELES");
									System.out.println("3.- ESCALENO");
									System.out.println("0.- VOLVER");

									// Elegimos la opcion
									System.out.print("Opcion: ");
									opcion11 = readInt();

									switch(opcion11){
										case 0:
											break;
										case 1: // Equiatero
											System.out.print("Ingrese uno de los lados: ");
											triangulo.setL1(readDouble());
											triangulo.setTipo("equilatero");
											System.out.println("\nEl perimetro es: " + triangulo.perimetro() + " u^2");
											break;
										case 2: // Isoseles
											System.out.print("Ingrese uno de los lados: ");
											triangulo.setL1(readDouble());
											System.out.print("Ingrese la base: ");
											triangulo.setBase(readDouble());
											triangulo.setTipo("isoseles");
											System.out.println("\nEl perimetro es: " + triangulo.perimetro() + " u^2");
											break;
										case 3: // Escaleno
											System.out.print("Ingrese lado 1: ");
											triangulo.setL1(readDouble());
											System.out.print("Ingrese lado 2: ");
											triangulo.setL2(readDouble());
											System.out.print("Ingrese lado 3: ");
											triangulo.setL3(readDouble());
											triangulo.setTipo("escaleno");
											System.out.println("\nEl perimetro es: " + triangulo.perimetro() + " u^2");
											break;
									}
								} while(opcion11 != 0);

								break;
							case 2: // Area
								System.out.print("Ingrese la altura: ");
								triangulo.setAltura(readDouble());
								System.out.print("Ingrese la base: ");
								triangulo.setBase(readDouble());
								// Procesamos
								System.out.println("\nEl area es: " + triangulo.areas() + " u^2");
								break;
						}
					} while(opcion1 != 0);
					break;
				case 2: // Cuadrado
					int opcion2 = 0;

					do{
						System.out.println("\n----------------");
						System.out.println("Elija una opcion");
						System.out.println("----------------\n");
						System.out.println("1.- PERIMETRO");
						System.out.println("2.- AREA");
						System.out.println("0.- VOLVER");

						// Elegimos la opcion
						System.out.print("Opcion: ");
						opcion2 = readInt();

						switch(opcion2){
							case 0:
								break;
							case 1: // Perimetro
								System.out.print("lado: ");
								cuadrado.setLado(readDouble());
								System.out.println("\nPerimetro: " + cuadrado.perimetro() + " u^2");

								break;
							case 2: // Area
								System.out.print("lado: ");
								cuadrado.setLado(readDouble());
								System.out.println("\nPerimetro: " + cuadrado.areas() + " u^2");
								break;
						}
					} while(opcion2 != 0);

					break;
			}
		} while(opcion != 0);
	}
	// Metodo para leer numero flotantes
    public static double readDouble()
    {
    	Scanner lector = new Scanner(System.in); // Instanciamos el lector
    	double number = 0;

    	// Obtenemos el numero desde el teclado
    	try{
			number = lector.nextDouble();
			if(number <= 0.0){
				return readDouble();
			}
		} catch(Exception e) {
			System.out.print("Esto no es un numero, ingrese de nuevo: ");
			return readDouble();
		}

		// Retornamos el numero
		return number;
    }
	// Metodo para leer numero enteros
    public static int readInt()
    {
    	Scanner lector = new Scanner(System.in); // Instanciamos el lector
    	int number = 0;

    	// Obtenemos el numero desde el teclado
    	try{
			number = lector.nextInt();
		} catch(Exception e) {
			System.out.print("Esto no es un numero, ingrese de nuevo: ");
			return readInt();
		}

		// Retornamos el numero
		return number;
    }
}