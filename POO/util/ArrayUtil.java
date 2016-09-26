/**************************************************************
ArrayUtil - Utilidades para el manejo de vectores de tipo int

Name: Paulo Andrade
Email: source.compu@gmail.com
**************************************************************/

public class ArrayUtil
{
	// Constructor
	ArrayUtil()
	{

	}

	/*****************************************************
	Metodos
	*****************************************************/

	// Retorna el indice del elemento a buscar
	// @param x vector donde se realizara la busqueda
	// @param value elemento a buscar
	public int indexOf(int[] x, int value)
	{	
		// Recorremos el vector
		for(int i = 0; i < x.length; i++){
			// Buscamos el elemento
			if(x[i] == value){
				// Retornamos el indice
				return i;
			}
		}

		// Retornamos -1 si no lo encuentra
		return -1;
	}
	// Ordernar elementos del vector de forma ascendente
	// @param x vector a ordenar
	public int[] orderAsc (int[] x)
	{
		int auxiliar; // Auxiliar para guardar el valor anterior del vector

		// Recorremos el vector
		for(int i = 0; i < x.length - 1; i++){
        	for(int j = i + 1; j < x.length; j++){
        		// Verificamos si el valor anterior es mayor al actual
            	if(x[i] > x[j]){
                    // Si es asi, intercambiamos valores
                    auxiliar = x[i];
                    x[i] = x[j];
                    x[j] = auxiliar;
            	}
        	}
		}

		// Retornamos el vector ordenado
		return x;
	}
	// Ordernar elementos del vector de forma descendente
	// @param x vector a ordenar
	public int[] orderDes (int[] x)
	{
		int auxiliar; // Auxiliar para guardar el valor anterior del vector

		// Recorremos el vector
		for(int i = 0; i < x.length - 1; i++){
        	for(int j = i + 1; j < x.length; j++){
        		// Verificamos si el valor anterior es menor al actual
            	if(x[i] < x[j]){
                    // Si es asi, intercambiamos valores
                    auxiliar = x[i];
                    x[i] = x[j];
                    x[j] = auxiliar;
            	}
        	}
		}

		// Retornamos el vector ordenado
		return x;
	}
	// Busca un elemento en el array y retorna true (encontrado)
	// o false (no encontrado).
	// @param x vector donde se realizara la busqueda
	// @param value elemento a buscar
	public boolean search(int[] x, int value)
	{	
		// Recorremos el vector
		for(int i = 0; i < x.length; i++){
			// Buscamos el elemento
			if(x[i] == value){
				// Retorna verdadero si lo encuentra
				return true;
			}
		}

		// Retorna falso si no lo encuentra
		return false;
	}
}