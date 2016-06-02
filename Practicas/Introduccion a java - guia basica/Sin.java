/*
* Fecha: 01/06/2016
* Nombre: Creacion de objetos (pagina 33)
* Nota: Modifica el ejemplo del programa Objeto.java declarando un método static al que se
*       le pase el valor de un ángulo en grados y nos devuelva el seno.
*/

public class Sin
{
	// Declaramos los atributos
	static long ang = 0;

	// Metodo principal de la clase
	public static void main(String args[])
	{
		// Recibimos el angulo
		ang = Long.parseLong(args[0]);

		// Calculamos su seno
		sin(ang);
	}

	// Metodo para obtener el valor de un angulo
	public static void sin(long a)
	{
		// Obtenemos el seno del angulo
		double seno = Math.sin(Math.PI * a / 180.0);

		// Imprimimos el valor del seno
		System.out.println("El angulo: "+a+" Seno = "+seno);
	}
}