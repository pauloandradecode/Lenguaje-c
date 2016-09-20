/****************************************************


Name: Andrade Gonzalez Paulo Cesar
Fecha: 20/09/2016
****************************************************/

import java.util.ArrayList;
import java.util.Scanner;

public class TestSeleccion
{
	// Creamos una instancia de la clase Entrenador
	public static Entrenador e = new Entrenador();
	// Creamos un array list de tipo Persona
	public static ArrayList<Persona> lista = new ArrayList<Persona>();

	public static void main(String[] args)
	{
		int opcion = 0; // Opciones para el menu
		Scanner lector = new Scanner(System.in); // Instancia para escaner

		do{
			// Menu
			System.out.println("\nSELECCION");
			System.out.println("1.- Agregar entrenador");
			System.out.println("2.- Mostrar entrenadores");
			System.out.println("0.- Salir");

			// Elegimos la opcion
			System.out.print("Opcion: ");
			opcion = lector.nextInt();

			// Seleccionamos la opcion
			switch(opcion){
				case 0:
					System.out.println("Fin del programa");
					break;
				case 1:
					// Agregar entrenador

					// Ingresamos los datos del entrenador
					System.out.print("Nombre: ");
					e.setNombre(lector.next());
					System.out.print("Domicilio: ");
					e.setDomicilio(lector.next());
					System.out.print("Telefono: ");
					e.setTelefono(lector.next());
					// Como leer la fecha de nacimiento
					e.setTelefono(lector.next());
					System.out.print("Historial: ");
					e.setHistorial(lector.next());
					System.out.print("Años de experiencia: ");
					e.setAniosExperiencia(lector.nextInt());
					System.out.print("Especialidad: ");
					e.setEspecialidad(lector.next());

					// Agregamos al array list
					lista.add(e);
					break;
				case 2:
					// Mostrar entrenadores

					// Recorremos el ArrayList
					for(Persona temp: lista){
						// Mostramos los datos
						System.out.println("Nombre: " + temp.getNombre());
						System.out.println("Domicilio: " + temp.getDomicilio());
						System.out.println(temp.concentrarse());
						temp.viajar();
					}
			}
		} while(opcion != 0);
	}
}

/*


import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Prueba {
    public static void main (String[]args) {

        System.out.println("Introduzca la fecha con formato dd/mm/yyyy");
        Scanner sc = new Scanner(System.in);
        String fecha = sc.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate = null;
        String date = fecha;
        try{
            testDate = df.parse(date);
            System.out.println("Ahora hemos creado un objeto date con la fecha indicada, "+testDate);
        } catch (Exception e){ System.out.println("invalid format");}

        if (!df.format(testDate).equals(date)){
            System.out.println("invalid date!!");
        } else {
            System.out.println("valid date");
        }

    }
}

*/