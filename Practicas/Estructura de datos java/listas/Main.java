/*
* Clase principal
*/

public class Main
{
	public static void main(String[] args)
	{
		// Creamos una lista enlazada de tipo int
		ListaEnlazada<Integer> lista = new ListaEnlazada<>();

		// Agregamos 10 numeros a nuestra lista
		for(int i = 0; i < 10; i++){
			lista.insertLast(i);
		}

		// Mostramos el contenido de la lista
		lista.print();

		// Mostramos el total de elemento de la lista
		System.out.println("\nTotal de elementos: "+lista.length());

		// Eliminamos el nodo 3 de la lista
		lista.deletePos(3);
		System.out.println("\nEliminamos el elemento 3 de la lista...\n");
		System.out.println("Total de elementos: "+lista.length());		
		lista.print();

		// Agregamos el numero 20 al elemento 5
		System.out.println("\nAgregamos el elemento 5 de la lista...\n");
		lista.insertPos(5, 10);
		System.out.println("|Total de elementos: "+lista.length());
		lista.print();
	}
}