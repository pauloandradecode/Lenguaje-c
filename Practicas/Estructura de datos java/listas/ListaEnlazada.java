/*
* Prototipo para lista enlazada
* Descripción: Creamos una lista enlazada a partir de la estructura NodoDeLista
*
* Métodos de la clase.-
	clean() - Vacia la lista actual
	deleteFirst() - Elimina el primer nodo de la lista
	deleteLast() - Elimina el ultimo nodo de la lista
	deletePos(int pos) - Elimina un nodo en la posicion requerida
	getDataLast() - Obtiene el ultimo dato de la lista
	getDataFirst() -Obtiene el primer dato de la lista
	getDataPos(int pos) - Obtiene un dato de la lista en la posicion requerida
	getNodoPos(int pos) - Obtiene un nodo de la lista en la posicion requerida
    insertFirst(String data) - Inserta un nodo al final de la lista
	insertLast(String data) - Inserta un nodo al Final de la lista
	insertPos(int pos, String data) - Inserta un nodo en la posicion requerida
	isEmpty() - Verifica si una lista esta vacia
	length() - Obtiene el numero de nodos de la lista
	print() - Imprime el contenido de la lista
	updateDataPos(int pos, String data) - Actualiza un dato en la posicion dada
*/

public class ListaEnlazada<T>
{
	// Creamos un objeto para contener al primer elemento de la lista
	private NodoDeLista<T> primero;

	// Constructor por defecto
	public ListaEnlazada()
	{
		// Creamos una lista vacia
		clean();
	}

	/*
	* Métodos para la lista enlazada
	*/

	// Creamos una lista vacia
	public void clean()
	{
		primero = null;
	}
	// Eliminamos el primer elemento de la lista
	public void deleteFirst()
	{
		// Creamos un nodo auxiliar para almacenar la lista actual
        NodoDeLista<T> aux;

        // Verificamos si la lista esta vacia
        if(!isEmpty()){
        	// Si no esta vacia procedemos

        	// Asignamos al auxiliar nuestra lista
            aux = primero;
            // Sobreescribimos la lista con el siguiente nodo
            primero = primero.getNext();
            //Lo marcamos para el recolector de basura
            aux = null;
        }
	}
	// Eliminamos el ultimo elemento de la lista
	public void deleteLast()
	{
		// Creamos un nodo auxiliar para almacenar la lista actual
        NodoDeLista<T> aux = primero;

        // Verificamos si la lista tiene un solo elemento
        if(aux.getNext() == null){
           // Si es asi la vaciamos
           clean();
        }

        // Verificamos si la lista esta vacia
        if(!isEmpty()){
        	// Si no esta vacia

        	// Volvemos a asignar primero al auxiliar
            aux = primero;
             
            // Recorremos la lista
            while(aux.getNext().getNext() != null){
            	// Buscamos el penultimo nodo, por eso hay dos métodos getNext()
                aux = aux.getNext();
            }
             
            // Marcamos el siguiente del antepenultimo nodo como nulo, eliminando el ultimo
            aux.setNext(null);
        }
	}
	// Eliminamos un nodo en la posicion indicada
	public void deletePos(int pos)
	{
		// Creamos un nodo auxiliar para almacenar la lista actual
        NodoDeLista<T> aux = primero;
        // Creamos otro nodo auxiliar
        NodoDeLista<T> before = null;
        // Contador para nodos
        int count = 0;
 
        // Verificamos que la posicion se encuentre dentro del rango
        if(pos <0 || pos >= length()){
        	// Si es asi mostramos mensaje de error
            System.out.println("La posicion insertada no es correcta");
        } else {
        	// Recorremos la lista
            while(aux!=null){
            	// Verificamos que la posicion sea igual que el contador
                if (pos == count){
                	// Si es asi verificamos que el nodo before este vacio
                    if(before == null){
                        primero = primero.getNext();
                    } else {
                        // Actualizamos el nodo before
                        before.setNext(aux.getNext());
                    }

                    // Eliminamos aux (recolector de basura)
                    aux = null;
                } else {
                	// Actualizamos before
                    before = aux;
                    // Pasamos al siguiente nodo
                    aux = aux.getNext();
                    // Actualizamos el contador
                    count++;
                }
            }
        }
	}
	// Devuelve el ultimo elemento de la lista
	public T getDataLast()
	{
		T elem = null;
		// Creamos un nodo para almacenar la lista actual y poder recorrerla
        NodoDeLista<T> aux;

        // Verificamos si la lista esta vacia
        if(!isEmpty()){
        	// Si no esta vacia la lista

        	// Asignamos al auxiliar la lista actual
            aux = primero;
             
            // Recorremos la lista
            while(aux.getNext() != null){
            	// Obtenemos el ultimo nodo de la lista
                aux = aux.getNext();
            }

            // Obtenemos el valor del elemento
            elem = aux.getData();
        }

        // Retornamos el dato
        return elem;
	}
	// Devuelve el primer elemento de la lista
	public T getDataFirst()
	{
		T elem = null;

		// Verificamos si la lista esta vacia
        if(!isEmpty()){
        	// Si no esta vacia retornamos el primer dato
            elem = primero.getData();
        }

        // Retornamos el dato
        return elem;
	}
	// Devuelve un dato en la posicion indicada
	public T getDataPos(int pos){
        // Creamos un nodo para almacenar la lista actual y poder recorrerla
        NodoDeLista<T> aux = primero;
        // Variable contador
        int count = 0;
        T data = null;
        
        // Verificamos que la posicion se encuentre en entre el rango de nodos de la lista
        if(pos < 0 || pos >= length()){
        	// Mostramos mensaje de error en caso de no estar dentro del rango
            System.out.println("La posicion insertada no es correcta");
        } else {
            // Recorremos la lista
            while(aux != null){
            	// Verificamos que la posicion sea igual que el contador
                if(pos == count){
                    // Obtenemos el dato
                    data = aux.getData();
                }
                
                // Pasamos al siguiente nodo
                aux=aux.getNext();
                // Incrementamos contador
                count++;
                 
            }
        }
         
        // Retornamos el dato
        return data;
         
    }
    // Devuelve un nodo en la posicion indicada
    public NodoDeLista getNodoPos(int pos)
    {
    	// Creamos un nodo para almacenar la lista actual y poder recorrerla
        NodoDeLista<T> aux = primero;
        // Contador para nodos
        int count = 0;
        
        // Verificar si la posición esta dentro del rango de nodos de la lista
        if(pos < 0 || pos >= length()){
        	// Si no es asi mostramos mensaje de error
            System.out.println("La posicion insertada no es correcta");
        } else {
            // Recorremos el array
            while(aux!=null){
            	// Verificamos que la posicion sea igual que el numero de nodo
                if(pos == count){
                    // Si es asi retornamos el nodo
                    return aux; 
                }
                 
                // Pasamos al siguiente nodo
                aux = aux.getNext();
                // Incrementamos el contador
                count++;
            }
        }
        
        // Retornamos el nodo por defecto (por estar fuera del rango)
        return aux;
    }
    // Imprime el contenido de la lista
    public void print()
    {
    	// Creamos un nodo para almacenar la lista actual y poder recorrerla
        NodoDeLista<T> aux = primero;
        // Contador para nodos
        int count = 0;

        System.out.println("Contenido de la lista");
        System.out.println("-----------------------");

        // Recorremos la lista
        while(aux != null){
        	System.out.println("Elemento "+count+": "+aux.getData());

        	// Incrementamos el contador
        	count++;
        	// Pasamos al siguiente nodo
        	aux = aux.getNext();
        }
    }
	// Insertar al principio de la lista
	public void insertFirst(T data)
	{
		// Creamos un nuevo nodo para la lista
		NodoDeLista<T> nuevo = new NodoDeLista<>(data);

		// Verificamos si la lista esta vacia
        if(!isEmpty()){
            // Si no esta vacia, el primero actual pasa a ser
            // el siguiente de nuestro nuevo nodo
            nuevo.setNext(primero);
        }
         
        // El primero apunta al nodo nuevo
        primero = nuevo;
	}
	// Insertamos al final de la lista
	public void insertLast(T data)
	{
		// Creamos un nuevo nodo para la lista
		NodoDeLista<T> nuevo = new NodoDeLista<>(data);
		// Creamos un nodo para almacenar la lista actual y poder recorrerla
        NodoDeLista<T> aux;
 
        // Verificamos si la lista esta vacia
        if(isEmpty()){
        	// Si esta vacia lo insertamos al inicio
            insertFirst(data);
        } else {
        	// Si no esta vacio recorremos la lista para insertarlo al final
            aux = primero;
             
            // Recorremos la lista
            while(aux.getNext() != null){
            	// Buscamos el ultimo nodo
                aux = aux.getNext();
            } 
                 
            // Insertamos el nuevo nodo al final de la lista
            aux.setNext(nuevo);
        }
	}
	// Inserta un nodo en la posicion indicada
	public void insertPos(int pos, T data)
	{
		// Creamos un nodo para almacenar la lista actual y poder recorrerla
        NodoDeLista<T> aux = primero;
        // Creamos un nodo auxiliar
        NodoDeLista<T> auxData = null;
        // Creamos otro nodo auxiliar
        NodoDeLista<T> before = primero;
        // Contador para nodos
        int count = 0;
        
        // Verificamos que la posicion se encuentre dentro del rango
        if(pos <0 || pos > length()){
        	// Si no es asi mostramos mensaje de error
            System.out.println("La posicion insertada no es correcta");
        } else {
            // Verificamos si la posicion es 0
            if(pos == 0){
            	// Si es asi lo insertamos al inicio
                insertFirst(data);
            // Verificamos si la posición es la ultima
            } else if(pos == length()){
            	// Si es asi lo insertamos al final
                insertLast(data);
            } else {
                // Recorremos la lista
                while(aux!=null){
                	// Verificamos que la posicion sea igual al contador
                    if(pos == count){
                        // Si es asi creamos un nuevo nodo y pasamos
                        // el nodo actual como referencia para la inserccion
                        auxData = new NodoDeLista<>(data, aux);

                        // El siguiente del anterior a aux es auxDato
                        before.setNext(auxData);
                    }
                     
                    // Actualizo el nodo before
                    before = aux;
                    // Actualizamos el contador
                    count++;
                    // Pasamos al siguiente nodo
                    aux = aux.getNext();
                }
            }
        }
	}
	// Verifica si la lista esta vacia
	public boolean isEmpty()
	{
		// Verificamos el nodo
		if(primero == null){
			// Regresamos true si esta vacia
			return true;
		} else {
			// Regresamos false si no esta vacia
			return false;
		}
	}
	// Contamos los elementos de la lista
	public int length()
	{
		// Creamos un nodo para almacenar la lista actual y poder recorrerla
        NodoDeLista<T> aux;
        // Contador para los nodos de la lista
        int count = 0;
        // Asignamos la lista a auxiliar
        aux = primero;
 
        // Recorremos la lista
        while(aux != null){
        	// Incrementamos el contador
            count++;
            // Pasamos al siguiente nodo de la lista
            aux = aux.getNext();
        }

        // Retornamos el numero de elementos
        return count;
	}
	// Actualiza un dato en la posicion dad
	public void updateDataPos(int pos, T data)
	{
		// Creamos un nodo para almacenar la lista actual y poder recorrerla
        NodoDeLista<T> aux = primero;
        // Contador para nodos
        int count = 0;
        
        // Verificamos que la posicion se encuentre dentro del rango
        if(pos < 0 || pos >= length()){
        	// Si no es asi mostramos mensaje de error
            System.out.println("La posicion insertada no es correcta");
        } else {
            // Recorremos la lista
            while(aux!=null){
            	// Verificamos que la posicion sea igual que el contador
                if(pos == count){
                    //Modificamos el dato directamente
                    aux.setData(data); 
                }

                // Actualizamos el contador
                count++;
                // Pasamos al siguiente nodo
                aux = aux.getNext();
            }
        }
	}
}