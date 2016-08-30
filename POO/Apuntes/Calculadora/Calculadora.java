/************************************************************
Clase Calculadora - Metodos aritmeticos

Nombre: Paulo Andrade
Email: source.compu@gmail.com
************************************************************/

public class Calculadora
{
	// Propiedades
	public double num1;
	public double num2;
	public double resultado;

	// Constructor
	Calculadora ()
	{
		this.num1 = 0.0;
		this.num2 = 0.0;
		this.resultado = 0.0;
	}

	// Metodos

	// Método para dividir dos numeros
	// @param n1 dividendo
	// @param n2 divisor
	public double division (double n1, double n2)
	{
		return n1 / n2;
	}
	// Metodo que retorna el factorial
	public long factorial()
	{
		long fac = 1; // Empezamos la base del factorial
		int n = (int) this.num1; // Convertimos a entero el tipo double para usarlo en el bucle

		// Obtenemos el factorial solo si el numero es mayor a 2
		if(n >= 2){
			// Proceso para obtener el factorial
			for(int i = 1; i <= n; i++){
				fac = i * fac;
			}
		}

		return fac;
	}
	// Método que retorna num1
	public double getNum1 ()
	{
		return this.num1;
	}
	// Método que retorna num2
	public double getNum2 ()
	{
		return this.num2;
	}
	// Método que retorna resultado
	public double getResultado ()
	{
		return this.resultado;
	}
	// Metodo para multiplicar dos variables
	public void multiplicar ()
	{
		this.resultado = this.num1 * this.num2;
	}
	// Método para mostrar si un numero es par
	// @param n numero a validar
	public boolean par (double n)
	{
		// Verificamos si el numero es un divisor de 2
		if(n % 2 == 0){
			// Si es asi es un numero par
			return true;
		} else {
			// Si no es impar
			return false;
		}
	}
	// Método para saber si el numero es primo
	public boolean primo ()
	{
		int a = 0; // Contador
		int n = (int) this.num1; // Convertimos a tipo int

		for(int i = 0; i <= n; i++){
			// Verificamos si el numero es divisible
			if(this.num1 % i == 0){
				// Si lo es, aumentamos el contador
				a++;
			}
		}

		// Verificamos que el contador sea diferente a dos
		// Ya que un numero primo solo debe ser divisible entre si y uno
		if(a != 2){
			// Si es diferente a dos no es primo
			return false;
		} else {
			// Si es igual a dos, es primo
			return true;
		}
	}
	// Metodo para restar dos variables
	public double restar ()
	{
		return this.num1 - this.num2;
	}
	// Método para almacenar un valor a num1
	public void setNum1 (double num1)
	{
		this.num1 = num1;
	}
	// Método para almacenar un valor a num2
	public void setNum2 (double num2)
	{
		this.num2 = num2;
	}
	// Método para almacenar un valor a resultado
	public void setResultado (double resultado)
	{
		this.resultado = resultado;
	}
	// Metodo para sumar dos variables
	// @param n1 primer numero a sumar
	// @param n2 segundo numero a sumar
	public double sumar (double n1, double n2)
	{
		return n1 + n2;
	}
}