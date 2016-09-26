/****************************************************
Clase de prueba

Name: Andrade Gonzalez Paulo Cesar
Fecha: 20/09/2016
****************************************************/

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

class TestExamen
{
	// Propiedades
	public static Scanner lector = new Scanner(System.in);

	// Atributos

	public static void main(String[] args)
	{
		int opcion = 0;
		Examen e = new Examen();

		do{
			// Menu
			System.out.println("\n*********");
			System.out.println(" EXAMEN");
			System.out.println("*********\n");
			System.out.println("1.- TABLA");
			System.out.println("2.- FECHA (manual)");
			System.out.println("3.- FECHA (auto)");
			System.out.println("4.- NUMERO PERFECTO");
			System.out.println("0.- SALIR");

			// Elegimos la opcion
			System.out.print("\nOpcion: ");
			opcion = lector.nextInt();

			switch(opcion){
				case 0:
					System.out.println("\nFin del programa\n");
					break;
				case 1:
					System.out.print("\nIngrese el numero de tabla a mostrar: ");
					int tabla = readInt();
					System.out.print("Ingrese el limite de la tabla: ");
					int limite = readInt();

					// Procesamos
					e.tabla(tabla, limite);

					break;
				case 2:
					System.out.print("\nIngrese el dia: ");
					int dia = readInt();
					System.out.print("Ingrese el mes: ");
					int mes = readInt();
					System.out.print("Ingrese el anio: ");
					int anio = readInt();

					// Procesamos
					System.out.println(e.fecha(dia, mes, anio));

					break;
				case 3:
					lector.nextLine(); // Limpiamos el buffer
					System.out.println(e.fecha(readDate()));
					break;
				case 4:
					System.out.print("\nIngrese el numero a verificar: ");
					int numero = readInt();

					// Procesamos
					if(e.numeroPerfecto(numero)){
						System.out.print("El numero es perfecto\n");
					} else {
						System.out.print("El numero no es perfecto\n");
					}

					break;
			}
		} while(opcion != 0);
	}
	// Método para leer la fecha
	public static Date readDate ()
    {
    	Scanner lector = new Scanner(System.in); // Instanciamos un lector

        System.out.println("Introduzca la fecha [dd/mm/yyyy]");
        String fecha = lector.nextLine(); // Capturamos la fecha
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // Creamos un formato para la fecha
        Date testDate = null; // declaramos testDate como tipo Date

        // Convertimos el string en tipo Date
        // Nota: Para usar el metodo parse() hay que hacerlo utilizando excepciones
        try {
            testDate = df.parse(fecha);
        } catch (Exception e){
        	// Si es incorrecto volvemos a pedir la fecha
        	System.out.println("Formato incorrecto, ingrese de nuevo:");
        	return readDate();
        }

    	// Si es correcto la retornamos
        return testDate;
    }
	// Metodo para leer numero enteros
    public static int readInt()
    {
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