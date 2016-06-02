/*
* Fecha: 28/05/2016
* Nombre: atributos y metodos (pagina 30)
* Nota: En este programa vamos a ver como utilizar atributos y metodos estaticos, un metodo
*       declarado como static, se puede utilizar sin necesidad de inicializar un objeto de
*       la clase, solo tiene una restricción y es que solo puede acceder a atributos y
*       metodos declarados como static.
*/

public class AtributosMetodos
{
	// Declaramos un atributo de la clase
	private static int numeroInstancias = 0;

	// Constructor de la clase
	public AtributosMetodos()
	{
		// Cada vez que sea instanciado un objeto aumentamos el contador
		numeroInstancias++;
	}

	// Metodo principal de la clase
	public static void main(String args[])
	{
		// Imprimimos el numero de instancias
		System.out.println(AtributosMetodos.cuantasInstancias());

		// Instanciamos un objeto
		AtributosMetodos am = new AtributosMetodos();

		// Imprimimos el numero de instancias
		System.out.println(AtributosMetodos.cuantasInstancias());
	}

	// Metodo - contar numeros de instancias de la clase
	public static int cuantasInstancias()
	{
		return numeroInstancias;
	}
}