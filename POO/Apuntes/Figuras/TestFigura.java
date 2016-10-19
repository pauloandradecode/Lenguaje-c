/*****************************************************
Clase

Name: Paulo Andrade
Date: 18/10/2016
*****************************************************/

import java.util.Scanner;
import java.text.DecimalFormat;

public class TestFigura
{
	public static Scanner lector = new Scanner(System.in);
	public static Triangulo triangulo = new Triangulo();
	public static Cuadrado cuadrado = new Cuadrado();
	public static Circulo circulo = new Circulo();
	public static Cubo cubo = new Cubo();
	public static Esfera esfera = new Esfera();
	public static DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args){
		int opcion = 0; // Opciones para el menu

		do{
			// Menu
			System.out.println("\n*****************");
			System.out.println("     FIGURAS");
			System.out.println("*****************\n");
			System.out.println("1.- TRIANGULO");
			System.out.println("2.- CUADRADO");
			System.out.println("3.- CIRCULO");
			System.out.println("4.- CUBO");
			System.out.println("5.- ESFERA");
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
						System.out.println("\n----------------------------");
						System.out.println("Triangulo - Elija una opcion");
						System.out.println("----------------------------\n");
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
											System.out.println("\nEl perimetro es: " + df.format(triangulo.perimetro()) + " u");
											break;
										case 2: // Isoseles
											System.out.print("Ingrese uno de los lados: ");
											triangulo.setL1(readDouble());
											System.out.print("Ingrese la base: ");
											triangulo.setBase(readDouble());
											triangulo.setTipo("isoseles");
											System.out.println("\nEl perimetro es: " + df.format(triangulo.perimetro()) + " u");
											break;
										case 3: // Escaleno
											System.out.print("Ingrese lado 1: ");
											triangulo.setL1(readDouble());
											System.out.print("Ingrese lado 2: ");
											triangulo.setL2(readDouble());
											System.out.print("Ingrese lado 3: ");
											triangulo.setL3(readDouble());
											triangulo.setTipo("escaleno");
											System.out.println("\nEl perimetro es: " + df.format(triangulo.perimetro()) + " u");
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
								System.out.println("\nEl area es: " + df.format(triangulo.areas()) + " u^2");
								break;
						}
					} while(opcion1 != 0);
					break;
				case 2: // Cuadrado
					int opcion2 = 0;

					do{
						System.out.println("\n---------------------------");
						System.out.println("Cuadrado - Elija una opcion");
						System.out.println("----------------------------\n");
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
								System.out.println("\nPerimetro: " + df.format(cuadrado.perimetro()) + " u");

								break;
							case 2: // Area
								System.out.print("lado: ");
								cuadrado.setLado(readDouble());
								System.out.println("\nArea: " + df.format(cuadrado.areas()) + " u^2");
								break;
						}
					} while(opcion2 != 0);

					break;
				case 3: // Circulo
					int opcion3 = 0;

					do{
						System.out.println("\n--------------------------");
						System.out.println("Circulo - Elija una opcion");
						System.out.println("--------------------------\n");
						System.out.println("1.- PERIMETRO");
						System.out.println("2.- AREA");
						System.out.println("0.- VOLVER");

						// Elegimos la opcion
						System.out.print("Opcion: ");
						opcion3 = readInt();

						switch(opcion3){
							case 0:
								break;
							case 1: // Perimetro
								System.out.print("Radio: ");
								circulo.setRadio(readDouble());
								System.out.println("\nPerimetro: " + df.format(circulo.perimetro()) + " u");

								break;
							case 2: // Area
								System.out.print("Radio: ");
								circulo.setRadio(readDouble());
								System.out.println("\nPerimetro: " + df.format(circulo.areas()) + " u^2");
								break;
						}
					} while(opcion3 != 0);

					break;
				case 4: // Cubo
					int opcion4 = 0;

					do{
						System.out.println("\n-----------------------");
						System.out.println("Cubo - Elija una opcion");
						System.out.println("-----------------------\n");
						System.out.println("1.- VOLUMEN");
						System.out.println("2.- AREA");
						System.out.println("0.- VOLVER");

						// Elegimos la opcion
						System.out.print("Opcion: ");
						opcion4 = readInt();

						switch(opcion4){
							case 0:
								break;
							case 1: // volumen
								System.out.print("lado: ");
								cubo.setLado(readDouble());
								System.out.println("\nVolumen: " + df.format(cubo.volumen()) + " u^3");

								break;
							case 2: // Area
								System.out.print("lado: ");
								cubo.setLado(readDouble());
								System.out.println("\nArea: " + df.format(cubo.areas()) + " u^2");
								break;
						}
					} while(opcion4 != 0);

					break;
				case 5: // Esfera
					int opcion5 = 0;

					do{
						System.out.println("\n-------------------------");
						System.out.println("Esfera - Elija una opcion");
						System.out.println("-------------------------\n");
						System.out.println("1.- VOLUMEN");
						System.out.println("2.- AREA");
						System.out.println("0.- VOLVER");

						// Elegimos la opcion
						System.out.print("Opcion: ");
						opcion5 = readInt();

						switch(opcion5){
							case 0:
								break;
							case 1: // volumen
								System.out.print("Radio: ");
								esfera.setRadio(readDouble());
								System.out.println("\nVolumen: " + df.format(esfera.volumen()) + " u^3");

								break;
							case 2: // Area
								System.out.print("Radio: ");
								esfera.setRadio(readDouble());
								System.out.println("\nArea: " + df.format(esfera.areas()) + " u^2");
								break;
						}
					} while(opcion5 != 0);

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
				System.out.print("Ingrese un numero mayor a 0: ");
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