/****************************************************
Superclase examen

Name: Andrade Gonzalez Paulo Cesar
Fecha: 22/09/2016
****************************************************/

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class Examen
{
	Examen()
	{

	}
	public String fecha(Date fecha){
    	Calendar calendar = Calendar.getInstance();
    	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    	String cadena = "Fecha hoy: "+df.format(fecha)+",";
    	
    	// Procesamos
    	calendar.setTime(fecha); // Configuramos la fecha que se recibe
    	calendar.add(Calendar.DAY_OF_YEAR, 1);  // numero de días a añadir, o restar en caso de días<0
    	fecha = calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

    	cadena += " fecha maniana: "+df.format(fecha)+".";

    	return cadena;
	}
	// Metodo que muestra el dia siguiente
	// @param dia Dia del mes
	// @param mes Mes del año
	// @param anio Año
	public String fecha(int dia, int mes, int anio)
	{
		String cadena = "\nFecha de hoy: "+dia+"/"+mes+"/"+anio+",";

		// Verificamos el ultimo dia del año
		if(dia == 31 && mes == 12){
			anio++;
			mes = 1;
			dia = 1;
		}
		// Verificamos el dia para los otros meses
		else if((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10) && dia == 31){
			mes++;
			dia = 1;
		} else {
			// Verificamos el dia para febrero
			if(mes == 2 && dia == 28){
				mes++;
				dia = 1;
			}
			// Verificamos meses de 30 dias
			else if(dia == 30){
				mes++;
				dia = 1;
			} else {
				// Si no solo aumentamos el dia
				dia++;
			}
		}

		// Completamos el string
		cadena += " fecha maniana: "+dia+"/"+mes+"/"+anio+".\n";

		return cadena;
	}
	// Metodo que indica si un numero es perfecto
	// @param n Numero a verificar
	public boolean numeroPerfecto(int n)
	{
		int suma = 0;

		for(int i = 1; i < n; i++){
			if(n % i == 0){
				suma += i;
			}
		}

		if(n == suma){
			return true;
		} else {
			return false;
		}
	}
	// Muestra una tabla
	// @param tabla Numero de la tabla a mostrar
	// @param limite Numero del limite para la tabla a mostrar
	public void tabla(int tabla, int limite)
	{
		System.out.println("\n===========");
		System.out.println("Tabla del " + tabla);
		System.out.println("===========\n");

		for(int i = 0; i <= limite; i++){
			System.out.println(tabla + " * " + i + " = " + tabla * i);
		}

		System.out.println("");
	}
}