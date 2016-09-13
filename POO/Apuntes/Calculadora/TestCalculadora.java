/************************************************************
Clase TestCalculadora - Clase para ejecutar operaciones

Practica: 1
Nombre: Paulo Andrade
Email: source.compu@gmail.com
************************************************************/

import java.util.Scanner; //Importación del código de la clase Scanner desde la biblioteca Java
import java.text.DecimalFormat; // Para limitar el numero de decimales

class TestCalculadora
{
	// Propiedades
	static int opcion;
	static double n1, n2;

	// Metodo principal
	public static void main(String[] args)
	{
		// Inicializamos la clase calculadora
		Calculadora calc = new Calculadora();
		// Inicializamos la clase para obtener datos desde el teclado
		Scanner lector = new Scanner(System.in);
		// Instanciamos un objeto de DecimalFormat y le asignamos 2 decimales
		DecimalFormat df = new DecimalFormat("0.00");

		do{
			System.out.println("***********************************");
			System.out.println("              M E N U");
			System.out.println("***********************************\n");
			System.out.println("1.- SUMAR");
			System.out.println("2.- RESTAR");
			System.out.println("3.- MULTIPLICAR");
			System.out.println("4.- DIVISION");
			System.out.println("5.- PAR");
			System.out.println("6.- FACTORIAL");
			System.out.println("7.- PRIMO");
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
					// Suma
					System.out.print("Numero 1: ");
					n1 = lector.nextDouble();
					System.out.print("Numero 2: ");
					n2 = lector.nextDouble();

					System.out.println("La suma es " + df.format(calc.sumar(n1, n2)) + "\n");

					break;
				case 2:
					// Resta
					System.out.print("Numero 1: ");
					calc.setNum1(lector.nextDouble());
					System.out.print("Numero 2: ");
					calc.setNum2(lector.nextDouble());

					System.out.println("La resta es " + df.format(calc.restar()) + "\n");
					break;
				case 3:
					// Multiplicacion
					System.out.print("Numero 1: ");
					calc.setNum1(lector.nextDouble());
					System.out.print("Numero 2: ");
					calc.setNum2(lector.nextDouble());

					// Procesamos la multiplicacion
					calc.multiplicar();

					System.out.println("La multiplicacion es " + df.format(calc.getResultado()) + "\n");
					break;
				case 4:
					// Division
					System.out.print("Numero 1: ");
					n1 = lector.nextDouble();
					System.out.print("Numero 2: ");
					n2 = lector.nextDouble();

					System.out.println("La division es " + df.format(calc.division(n1, n2)) + "\n");
					break;
				case 5:
					// Par
					System.out.print("Numero: ");
					n1 = lector.nextDouble();

					if(calc.par(n1)){
						System.out.println("El numero es par\n");
					} else {
						System.out.println("El numero es impar\n");
					}

					break;
				case 6:
					// Factorial
					System.out.print("Numero: ");
					n1 = lector.nextDouble();

					calc.setNum1(n1);

					System.out.println("El factorial es: " + calc.factorial() + "\n");
					break;
				case 7:
					// Primo
					System.out.print("Numero: ");
					n1 = lector.nextDouble();

					calc.setNum1(n1);

					if(calc.primo()){
						System.out.println("El numero es primo\n");
					} else {
						System.out.println("El numero no es primo\n");
					}

					break;
			}
		} while (opcion != 0);
	}
}