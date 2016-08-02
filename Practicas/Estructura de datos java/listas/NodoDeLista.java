/*
* Nodo de lista (Estruxtura basica)
* Descripción: Clase base para nuestra estructura de datos, contiene por lo menos un dato y
*              y un objeto de la clase NodoDeLista (no necesariamente instanciado).
*
* Métodos de la clase
	getData() - Retornamos el dato almacenado
    setData(String data) - Insertamos un dato
    getNext() - Retornamos el nodo siguiente
    setNext(NodoDeLista next) - Asignamos un nodo a la propiedad next
*/

public class NodoDeLista<T>
{
	// Datos para la estructura
	private T data;
	// Objeto de tipo lista (primera referencia de nuestra lista)
	private NodoDeLista next;
	//private NodoDeLista tope;

	// Constructor por defecto (crea una lista vacia)
	public NodoDeLista()
	{
		data = null;
		next = null;
	}
	// Constructor (crea una lista con un primer nodo)
	public NodoDeLista(T d)
	{
		data = d;
		next = null;
	}
	public NodoDeLista(T d, NodoDeLista next)
	{
		this.next = next;
		data = d;
	}

	/*
	* Métodos para manipular la estructura
	*/

	// Retornamos el dato
	public T getData()
	{
        return data;
    }
    // Insertamos un dato
    public void setData(T data)
    {
        this.data = data;
    }
    // Retornamos el nodo siguiente
    public NodoDeLista getNext()
    {
        return next;
    }
    // Asignamos un nodo a next
    public void setNext(NodoDeLista next)
    {
        this.next = next;
    }
}