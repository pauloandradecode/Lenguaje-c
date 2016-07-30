/*
Nombre: Array lineal
Pagina: 5
*/

public class Lineal
{
	public static void main(String[] args)
	{
		// Declaramos un array de prueba
		int[] miArray = new int[10];

		// Llenamos 10 elementos del array
		for(byte i = 1; i <= 10; i++){
			miArray[i-1] = i*2;
		}

		// Imprimimos
		System.out.println("Array original:");
		imprime(miArray);

		// Eliminamos un elemento
		miArray = delete(miArray, 4);

		// Imprimimos
		System.out.println("Eliminamos un elemento:");
		imprime(miArray);

		// Ordenamos descendente
		miArray = order(miArray, true);

		// Imprimimos
		System.out.println("Ordenamos de forma ascendente");
		imprime(miArray);		
	}
	// Imprimimos el contenido del array
	private static void imprime(int[] x)
	{
		byte i; // Contador

		for(i = 0; i < x.length; i++){
			System.out.println("Elemento "+i+": "+x[i]);
		}
	}
	// Busca un elemento en el array
	private static boolean find(int[] x, int key)
	{
		// x = array, key = elemento a buscar
		byte i;
		
		// Recorremos el array
		for(i = 0; i < x.length; i++){
			// Buscamos el elemento
			if(x[i] == key){
				// Retorna verdadero si lo encuentra
				return true;
			}
		}

		// Retorna falso si no lo encuentra
		return false;
	}
	// Elimina un elemento
	private static int[] delete(int[] x, int key)
	{
		// x = array, key = elemento a buscar
		byte i, j;

		// Verificamos si existe el elemento
		if(find(x, key)){
			// Buscamos el elemento
			for(i = 0; i < x.length; i++){
				if(x[i] == key){
					break;
				}
			}

			// Reordenamos el array
			for(j = i; j < x.length; j++){
				// Evitamos no desbordar el array
				if(j != x.length - 1){
					x[j] = x[j+1];
				} else {
					// Destruimos el ultimo elemento
					// x[j] = null;
					// Declaramos un array auxiliar
					int[] auxiliar = new int[x.length - 1];

					// Recorremos el array original menos un indice
					for(byte k = 0; k < x.length - 1; k++){
						// Asignamos los valores
						auxiliar[k] = x[k];
					}

					// Asignamos auxiliar al array original
					x = auxiliar;
				}
			}
		}

		return x;
	}
	// Ordernar elementos del array
	private static int[] order(int[] x, boolean type)
	{
		// x = array, type = tipo de orden ascendente (false) o decendente true
		int i, j;
		int auxiliar;

		// Verificamos el tipo de orden
		if(type){
			// Orden descendente
			for(i = 0; i < x.length - 1; i++){
            	for(j = i + 1; j < x.length; j++){
                	if(x[i] < x[j]){
	                    //Intercambiamos valores
	                    auxiliar = x[i];
	                    x[i] = x[j];
	                    x[j] = auxiliar;
                	}
            	}
			}
		} else {
			// Orden ascendente
			for(i = 0; i < x.length - 1; i++){
            	for( j = ++i; j < x.length; j++){
                	if(x[i] > x[j]){
	                    //Intercambiamos valores
	                    auxiliar = x[i];
	                    x[i] = x[j];
	                    x[j] = auxiliar;
                	}
            	}
			}
		}

		return x;
	}
}