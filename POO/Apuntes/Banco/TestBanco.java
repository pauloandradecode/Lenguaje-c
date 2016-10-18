/****************************************************
Clase para testear

Name: Andrade Gonzalez Paulo Cesar
Fecha: 04/10/2016
****************************************************/

import java.util.ArrayList;
import java.util.Date;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class TestBanco
{
	public static Scanner lector = new Scanner(System.in);
	public static ArrayList<CuentaBancaria> lista = new ArrayList<CuentaBancaria>();
	public static DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args)
	{
		int opcion = 0;

		do{
			// Menu
			System.out.println("\n*********");
			System.out.println("  BANCO");
			System.out.println("*********\n");
			System.out.println("1.- ALTA DE CUENTA DE NOMINA");
			System.out.println("2.- ALTA DE CUENTA DE AHORRO");
			System.out.println("3.- DEPOSTAR");
			System.out.println("4.- RETIRAR");
			System.out.println("5.- RENDIMIENTO DE LA INVERSION");
			System.out.println("6.- LISTAR CUENTAS");
			System.out.println("0.- SALIR");

			// Elegimos la opcion
			System.out.print("Opcion: ");
			opcion = lector.nextInt();

			// Seleccionamos la opcion
			switch(opcion){
				case 0:
					System.out.println("\nFin del programa\n");
					break;
				case 1: // Alta de cuenta de nomina
					CuentaNomina cn = new CuentaNomina();

					System.out.println("\n----------------------");
					System.out.println("Apertura cuenta nomina");
					System.out.println("----------------------");
					System.out.print("\nNombre del cuentahabiente: ");
					lector.nextLine(); // Limpiamos el bufer
					cn.setNombreCliente(lector.nextLine());
					System.out.print("Empresa o patron: ");
					cn.setEmpresa(lector.nextLine());
					System.out.print("Numero de cuenta: ");
					
					int control = 1;
					long numCuentaNomina = 0;
					do{
						numCuentaNomina = readLong();

						if(!lista.isEmpty()){
							for(CuentaBancaria temp: lista){
								if(numCuentaNomina == temp.getNumeroCuenta()){
									System.out.println("Numero de cuenta ya existe, intente de nuevo...");
									break;
								}
								control = 0;
							}
						} else {
							control = 0;
						}
					} while(control == 1);

					cn.setNumeroCuenta(numCuentaNomina);

					System.out.print("NIP: ");
					cn.setNip(readInt());
					System.out.print("Fecha de alta: ");
					cn.setFechaAlta(nowDate());
					System.out.println(formatDate(nowDate()));
					System.out.println("*** Su cuenta de nomina se creo con exito ***");

					lista.add(cn);

					break;
				case 2: // Alta de cuenta de ahorra
					CuentaAhorro ca = new CuentaAhorro();

					System.out.println("\n----------------------");
					System.out.println("Apertura cuenta ahorro");
					System.out.println("----------------------");
					System.out.print("\nNombre del cuentahabiente: ");
					lector.nextLine(); // Limpiamos el bufer
					ca.setNombreCliente(lector.nextLine());
					System.out.print("Numero de cuenta: ");

					int control_1 = 1;
					long numCuentaAhorro = 0;
					do{
						numCuentaAhorro = readLong();

						if(!lista.isEmpty()){
							for(CuentaBancaria temp: lista){
								if(numCuentaAhorro == temp.getNumeroCuenta()){
									System.out.println("Numero de cuenta ya existe, intente de nuevo...");
									break;
								}
								control_1 = 0;
							}
						} else {
							control_1 = 0;
						}
					} while(control_1 == 1);

					ca.setNumeroCuenta(numCuentaAhorro);

					System.out.print("NIP: ");
					ca.setNip(readInt());
					System.out.print("Ingrese el saldo inicial: ");
					ca.setSaldo(readDouble());
					System.out.print("Fecha de alta: ");
					ca.setFechaAlta(nowDate());
					System.out.println(formatDate(nowDate()));
					System.out.println("*** Su cuenta de ahorro se creo con exito ***");

					lista.add(ca);

					break;
				case 3: // Depositar

					// Verificamos que existan cuentas bancarias
					if(lista.isEmpty()){
						System.out.println("\nNo existen cuentas bancarias\n");
					} else {
						System.out.println("\n----------------------");
						System.out.println("   Deposito bancario");
						System.out.println("----------------------");
						int count = 1;

						do{
							if(count == 4){
								break;
							}
							// Obtenemos el numero de cuenta
							System.out.print("\nIngrese el numero de cuenta: ");
							long cuenta = readLong();
							int verificador = 1;

							for(CuentaBancaria temp: lista){
								// Verificamos si existe el numero de cuenta
								if(temp.getNumeroCuenta() == cuenta){
									// Verificamos que la cuenta sea de nomina
									if(temp instanceof CuentaNomina){
										int intentos = 1;
										verificador = 0;

										do{
											System.out.print("Ingrese el nip: ");
											int nip = readInt();

											// Verificamos el nip
											if(nip == temp.getNip()){
												System.out.print("Cantidad a depositar: ");
												temp.depositar(readDouble());
												break;
											} else {
												System.out.println("NIP incorrecto, intente de nuevo...");
											}

											intentos++;
										} while(intentos != 4);

										if(intentos == 4){
											System.out.println("\nIntentos excedidos...");
										} else {
											System.out.println("\nDeposito exitoso, su saldo es: $" + df.format(temp.consultar()));
										}
										count = 4;
										break;
									} else {
										System.out.println("Lo sentimos, su cuenta no es de nomina...");
										verificador = 0;
										count = 4;
										break;
									}
								}
							}
							if(verificador == 1){
								System.out.println("No existe el numero de cuenta intente de nuevo...");
							}
						} while(true);
					}

					break;
				case 4: // Retirar
					// Verificamos que existan cuentas bancarias
					if(lista.isEmpty()){
						System.out.println("\nNo existen cuentas bancarias\n");
					} else {
						System.out.println("\n----------------------");
						System.out.println("   Retiro bancario");
						System.out.println("----------------------");
						int count = 1;

						do{
							if(count == 4){
								break;
							}
							// Obtenemos el numero de cuenta
							System.out.print("\nIngrese el numero de cuenta: ");
							long cuenta = readLong();
							int verificador1 = 1;

							for(CuentaBancaria temp: lista){
								// Verificamos si existe el numero de cuenta
								if(temp.getNumeroCuenta() == cuenta){
									// Verificamos que la cuenta sea de nomina
									if(temp instanceof CuentaNomina){
										int intentos = 1;
										verificador1 = 0;

										do{
											System.out.print("Ingrese el nip: ");
											int nip = readInt();

											// Verificamos el nip
											if(nip == temp.getNip()){
												System.out.print("Cantidad a retirar: ");
												double retiro = readDouble();

												// Verificamos que la cuenta tenga saldo
												if(temp.getSaldo() >= retiro){
													temp.retirar(retiro);
													System.out.println("\nRetiro exitoso, su saldo es: $" + df.format(temp.consultar()));
												} else {
													System.out.println("\nLo sentimos, saldo excedido...");
												}
												break;
											} else {
												System.out.println("NIP incorrecto, intente de nuevo...");
											}

											intentos++;
										} while(intentos != 4);

										if(intentos == 4){
											System.out.println("\nIntentos excedidos...");
										}
										count = 4;
										break;
									} else {
										System.out.println("Lo sentimos, su cuenta no es de nomina...");
										verificador1 = 0;
										count = 4;
										break;
									}
								}
							}
							if(verificador1 == 1){
								System.out.println("No existe el numero de cuenta intente de nuevo...");
							}
						} while(true);
					}

					break;
				case 5: // Rendimiento de la inversión
					if(lista.isEmpty()){
						System.out.println("\nNo existen cuentas bancarias\n");
					} else {
						System.out.println("\n----------------------");
						System.out.println("  Simulador Rendimiento");
						System.out.println("----------------------");

						int count = 1;

						do{
							if(count == 4){
								break;
							}
							// Obtenemos el numero de cuenta
							System.out.print("\nIngrese el numero de cuenta: ");
							long cuenta = readLong();
							int verificador2 = 1;

							for(CuentaBancaria temp: lista){
								// Verificamos si existe el numero de cuenta
								if(temp.getNumeroCuenta() == cuenta){
									// Verificamos que sea una cuenta de ahorro
									if(temp instanceof CuentaAhorro){
										int intentos = 1;
										verificador2 = 0;

										do{
											System.out.print("Ingrese el nip: ");
											int nip = readInt();

											// Verificamos el nip
											if(nip == temp.getNip()){
												// Verificamos el saldo
												if(temp.getSaldo() > 0.0){
													System.out.println("Cantidad disponible: " + df.format(temp.getSaldo()));
													double inversion = 0.0;

													do{
														System.out.print("Cantidad a invertir: ");
														inversion = readDouble();

														// Verificamos el saldo
														if(inversion > temp.getSaldo()){
															System.out.println("Cantidad insuficiente, intente de nuevo...");	
														}
													} while(inversion > temp.getSaldo());

													System.out.print("Tiempo de la inversion: ");
													int time = readInt();
													System.out.print("Tasa de interes: ");
													int interes = readInt();

													// Procesamos
													double plazo = time / 30.0;
													System.out.println("Su rendimiento es: $" + df.format(((inversion / 100) * interes) * plazo));

													break;
												} else {
													System.out.println("Su cuenta no tiene saldo...");
													break;
												}
											} else {
												System.out.println("NIP incorrecto, intente de nuevo...");
											}

											intentos++;
										} while(intentos != 4);

										if(intentos == 4){
											System.out.println("\nIntentos excedidos...");
										}
										count = 4;
										break;
									} else {
										System.out.println("Lo sentimos, su cuenta no es de ahorro...");
										verificador2 = 0;
										count = 4;
										break;
									}
								}
							}
							if(verificador2 == 1){
								System.out.println("No existe el numero de cuenta intente de nuevo...");
							}
						} while(true);
					}

					break;
				case 6: // Listamos cuentas
					// Verificamos si hay cuentas
					if(lista.isEmpty()){
						System.out.println("\nNo existen cuentas bancarias\n");
					} else {
						System.out.println("\n----------------------");
						System.out.println("    Cuentas bancarias");
						System.out.println("----------------------");

						for(CuentaBancaria temp: lista){
							if(temp instanceof CuentaNomina){
								System.out.println("*** Cuenta nomina ***");
							} else if(temp instanceof CuentaAhorro){
								System.out.println("*** Cuenta ahorro ***");
							}

							System.out.println("Nombre: " + temp.getNombreCliente());
							if(temp instanceof CuentaNomina){
								System.out.println("Empresa: " + ((CuentaNomina) temp).getEmpresa());
							}
							System.out.println("Numero de cuenta: " + temp.getNumeroCuenta() + "\n");
						}
					}

					break;
			}
		} while(opcion != 0);
	}
	// Método para darle formato a la fecha
	// @param fecha fecha a transformar en un string con formato
	public static String formatDate(Date fecha)
	{
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // Creamos un formato para la fecha

		// Retornamos la fecha en un string
		return df.format(fecha);
	}
	// Método para obtener la cuenta actual
	public static Date nowDate()
	{
		return new Date();
	}
	// Método para leer la fecha
	public static Date readDate ()
    {
    	Scanner lector = new Scanner(System.in); // Instanciamos un lector
    	Date temp = new Date();

        System.out.println("Introduzca su fecha de nacimiento [dd/mm/yyyy]");
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

        // Verificamos que la fecha este en rango (no mayor a la fecha actual)
        if(testDate.compareTo(temp) > 0){
        	// Volvemos a llamar a la funcion
        	return readDate();
        }

    	// Si es correcto la retornamos
        return testDate;
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
    // Metodo para leer numero enteros
    public static long readLong()
    {
    	Scanner lector = new Scanner(System.in); // Instanciamos el lector
    	long number = 0;

    	// Obtenemos el numero desde el teclado
    	try{
			number = lector.nextLong();
		} catch(Exception e) {
			System.out.print("Esto no es un numero, ingrese de nuevo: ");
			return readLong();
		}

		// Retornamos el numero
		return number;
    }
}