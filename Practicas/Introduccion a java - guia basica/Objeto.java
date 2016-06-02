/*
* Fecha: 01/06/2016
* Nombre: Creacion de objetos (pagina 31)
* Nota: En este programa veremos como crear la instancia de la clase desde el contructor
*       de la misma, el contructor tiene el mismo nombre que la clase y este no puede tener
*       el modificador final, abstract o sinchronized.
*
* Nota 2: El programa va almacenar en un array el seno de los grados 0 al 359.
*/

public class Objeto
{
	// Declaración de propiedades
	static double tablaSeno[] = new double[360]; // Creamos un array

	// Constructor de la clase (es obligatorio crear el constructor, en caso de no hacerlo,
	// Java lo hara automaticamente)
	static
	{
		// Utilizamos un bucle para los grados del 0 al 359
		for(int i = 0; i < 360; i++){
			// Calculamos el seno del grado (i) y lo almacenamos en el array
			tablaSeno[i] = Math.sin(Math.PI * i / 180.0);
		}
	}

	// Metodo principal de la clase
	public static void main(String Args[])
	{
		// Utilizamos un bucle para mostrar el seno de cada grado en pantalla
		for(int i = 0; i < 360; i++){
			System.out.println("Angulo: "+i+" Seno = "+tablaSeno[i]);
		}
	}
}