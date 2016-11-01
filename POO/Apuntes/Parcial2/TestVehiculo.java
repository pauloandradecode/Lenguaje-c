/********************************************************
Clase de pruebas

Autor: Paulo Andrade
Fecha: 31/10/2016
********************************************************/

import java.util.ArrayList;
import java.util.Scanner;

public class TestVehiculo
{
	public static Autobus autobus;
	public static Bicicleta bicicleta;
	public static Avion avion;
	public static Planeador planeador;
	public static Scanner lector = new Scanner(System.in);
	public static ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();

	public static void main(String[] args)
	{
		int opcion = 0; // Opciones para el menu

		do{
			// Menu
			System.out.println("\n*************");
			System.out.println("  VEHICULOS");
			System.out.println("*************\n");
			System.out.println("1.- AGREGAR AUTOBUS");
			System.out.println("2.- AGREGAR BICICLETA");
			System.out.println("3.- AGREGAR PLANEADOR");
			System.out.println("4.- AGREGAR AVION");
			System.out.println("5.- MOSTRAR VEHICULOS");
			System.out.println("0.- SALIR");

			// Elegimos la opcion
			System.out.print("Opcion: ");
			opcion = readInt();

			// Seleccionamos la opcion
			switch(opcion){
				case 0:
					System.out.println("\nFin del programa\n");
					break;
				case 1: // Agregar autobus
					autobus = new Autobus();

					System.out.println("\n-----------------");
					System.out.println("Agregar autobus");
					System.out.println("-------------------\n");
					System.out.print("Color: ");
					autobus.setColor(lector.nextLine());
					System.out.print("Tamanio: ");
					autobus.setTamanio(lector.nextLine());
					System.out.print("Llantas: ");
					autobus.setLlantas(readInt());
					System.out.print("Pistones: ");
					autobus.setPistones(readInt());
					System.out.print("Asientos: ");
					autobus.setAsientos(readInt());
					System.out.print("Caballos de fuerza: ");
					autobus.setCdf(readInt());
					System.out.print("\n** Autobus se creo con exito **\n");

					lista.add(autobus);

					break;
				case 2: // Agregar bicicleta
					bicicleta = new Bicicleta();

					System.out.println("\n-----------------");
					System.out.println("Agregar bicicleta");
					System.out.println("-------------------\n");
					System.out.print("Color: ");
					bicicleta.setColor(lector.nextLine());
					System.out.print("Tamanio: ");
					bicicleta.setTamanio(lector.nextLine());
					System.out.print("Llantas: ");
					bicicleta.setLlantas(readInt());
					System.out.print("Pistones: ");
					bicicleta.setPistones(readInt());
					System.out.print("Frenos: ");
					bicicleta.setFrenos(readInt());
					System.out.print("Velocidades: ");
					bicicleta.setVelocidades(readInt());
					System.out.print("\n** Autobus se creo con exito **\n");

					lista.add(bicicleta);

					break;
				case 3: // Agregar planeador
					planeador = new Planeador();

					System.out.println("\n-----------------");
					System.out.println("Agregar planeador");
					System.out.println("-------------------\n");
					System.out.print("Color: ");
					planeador.setColor(lector.nextLine());
					System.out.print("Tamanio: ");
					planeador.setTamanio(lector.nextLine());
					System.out.print("Puertas: ");
					planeador.setPuertas(readInt());
					System.out.print("Alas: ");
					planeador.setAlas(readInt());
					System.out.print("Asientos: ");
					planeador.setAsientos(readInt());
					System.out.print("Llantas: ");
					planeador.setLlantas(readInt());
					System.out.print("\n** Autobus se creo con exito **\n");

					lista.add(planeador);

					break;
				case 4: // Agregar avion
					avion = new Avion();

					System.out.println("\n-----------------");
					System.out.println("Agregar Avion");
					System.out.println("-------------------\n");
					System.out.print("Color: ");
					avion.setColor(lector.nextLine());
					System.out.print("Tamanio: ");
					avion.setTamanio(lector.nextLine());
					System.out.print("Puertas: ");
					avion.setPuertas(readInt());
					System.out.print("Alas: ");
					avion.setAlas(readInt());
					System.out.print("Turbinas: ");
					avion.setTurbinas(readInt());
					System.out.print("Banios: ");
					avion.setBanios(readInt());
					System.out.print("\n** Autobus se creo con exito **\n");

					lista.add(avion);

					break;
				case 5: // Mostrar todo
					// Verificamos si esta vacio
					if(lista.isEmpty()){
						System.out.println("\nNo hay datos guardados\n");
					} else {
						for(Vehiculo temp: lista){
							// Mostramos el tipo de vehiculo
							if(temp instanceof Autobus){
								System.out.println("\n----------------------");
								System.out.println("    Autobus");
								System.out.println("----------------------\n");
							} else if(temp instanceof Bicicleta){
								System.out.println("\n----------------------");
								System.out.println("    Bicicleta");
								System.out.println("----------------------\n");
							} else if(temp instanceof Avion){
								System.out.println("\n----------------------");
								System.out.println("    Avion");
								System.out.println("----------------------\n");
							} else {
								System.out.println("\n----------------------");
								System.out.println("    Planeador");
								System.out.println("----------------------\n");
							}

							// Mostramos los metodos generales
							temp.avanzar();
							temp.detener();
							System.out.println("Color: "+temp.getColor());
							System.out.println("Tamanio: "+temp.getTamanio());

							// Mostramos los metodos de terrestre y aereo
							if(temp instanceof Terrestre){
								((Terrestre) temp).darVuelta();
								((Terrestre) temp).reversa();
								System.out.println("Llantas: "+((Terrestre) temp).getLlantas());
								System.out.println("Pistones: "+((Terrestre) temp).getPistones());
							} else {
								((Aereo) temp).volar();
								((Aereo) temp).aterrizar();
								System.out.println("Alas: "+((Aereo) temp).getAlas());
								System.out.println("Puertas: "+((Aereo) temp).getPuertas());
							}

							// Mostramos los metodos individuales
							if(temp instanceof Autobus){
								((Autobus) temp).encender();
								((Autobus) temp).apagar();
								System.out.println("Asientos: "+((Autobus) temp).getAsientos());
								System.out.println("Caballos de fuerza: "+((Autobus) temp).getCdf());
							} else if(temp instanceof Bicicleta){
								((Bicicleta) temp).avanzarSinMotor();
								((Bicicleta) temp).detenerSinMotor();
								System.out.println("Frenos: "+((Bicicleta) temp).getFrenos());
								System.out.println("Velocidades: "+((Bicicleta) temp).getVelocidades());
							} else if(temp instanceof Avion){
								((Avion) temp).encender();
								((Avion) temp).apagar();
								System.out.println("Turbinas: "+((Avion) temp).getTurbinas());
								System.out.println("Banios: "+((Avion) temp).getBanios());
							} else {
								((Planeador) temp).avanzarSinMotor();
								((Planeador) temp).detenerSinMotor();
								System.out.println("Llantas: "+((Planeador) temp).getLlantas());
								System.out.println("Asientos: "+((Planeador) temp).getAsientos());
							}
						}
					}

					break;
			}
		} while(opcion != 0);
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