Programa calculadora - java
===========================

En este programa simulamos la función de una calculadora basica, la idea del programa es emplear de diversas formas la información que puede procesar un método, ya sea obtenida mediante parametros o desde las propiedades de la clase, asi como las diversas formas de retornar la información ya procesada.

# Observaciones del código

## Entrada de datos desde el teclado

Para poder obtener datos desde el teclado vamos a utilizar la clase Scanner (incluida en el SDK de java), podemos obtener diferentes tipos de datos, pero en este programa utilizaremos el método nextDouble() para obtener datos de tipo double.-

```java
// Importamos la clase Scanner
import java.util.Scanner;

// Declaramos la clase
class Calculadora
{
	// Método principal
	public static void main(String[] args)
	{
		// Creamos una instancia de la clase scanner
		Scanner lector = new Scanner(System.in);

		// Obtenemos un dato desde el teclado
		double numero = lector.nextDouble();
	}
}
```

## Imprimir cierto numero de decimales

Para mostrar un cierto numero de decimales vamos a utilizar la clase decimalFormat (incluida en el SDK de java), mediante el metodo format().-


```java
// Importamos la clase DecimalFormat
import java.text.DecimalFormat;

// Declaramos la clase
class Calculadora
{
	// Método principal
	public static void main(String[] args)
	{
		// Creamos una instancia de la clase DecimalFormat
		DecimalFormat df = new DecimalFormat("0.00"); // Indicamos el total de decimales a mostrar

		// Declaramos un numero tipo double
		double pi = 3.141516;

		// Mostramos el numero con solo dos decimales
		System.out.println(df.format(pi));
	}
}
```

## Numeros bastantes grandes con BigInteger

Normalmente sacar el factorial del númer 21 en delante nos genera un desbordamiento en el tipo de dato long, para solucionar este problema podemos hacer uso de la clase BigInteger (incluido en el SDK de java).-

```java
// Importamos la clase BigInteger
import java.math.BigInteger;

// Declaramos la clase
class Calculadora
{
	// Método principal
	public static void main(String[] args)
	{
		// Creamos una instancia de la clase BigInteger
		// El numero debe estar entre comillas
		BigInteger f = new BigInteger("1"); // Inicializamos el numero con el valor 1

		// Obtenemos el factorial de 21
		for(int i = 0; i <= 20; i++){
			// El método multiply() multiplica el valor de su variable por el
			// parametro que le pasemos
			f = f.multiply(i + "");
		}

		// Mostramos el numero
		System.out.println(f);
	}
}
```

## Errores y aclaraciones sobre el código

Si encuentras algun error en el código o la forma de optimizarlo puedes informarme en el siguiente enlace para realizar las correcciones correspondientes.-

<a href="https://github.com/nemesis866/Lenguaje-c/issues">https://github.com/nemesis866/lenguaje-c/issues</a>