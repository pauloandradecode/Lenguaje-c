Clases, métodos y propiedades
=============================

Creamos una clase de prueba en el lenguaje Java, donde aprendemos a estructurar código orientado a objetos.

# Observaciones en el código

## Declarar una clase

Para declarar una clase utilizamos la palabra reservada class, el identificador de la clase tiene que estar en formato CamelUpperCase, el nombre del archivo donde esta nuestra clase tiene que tener el mismo nombre de la clase. ejemplo.-

```java
// TestCarro.java
class TestCarro
{
	// Contenido de la clase
}
```

## Propiedades

En una clase las propiedades son variables donde podemos almacenar valores, estan propiedades pueden ser accedidas desde fuera de la clase si son declaradas con el modificador public, o solo ser accedidas desde dentro de la clase (desde los métodos) si son declarados con el modificador private.

```java
// TestCarro.java
class TestCarro
{
	// Propiedades
	public string nombre; // Puede acceder al valor de la propiedad fuera y dentro de la clase
	private int edad; // Puede acceder al valor de la propiedad SOLO dentro de la clase
}
```

## Métodos

Los metodos son lo que conocemos como funciones en la programación estructurada, en esta clase vemos los metodos getter y setter, los métodos getter nos sirven para mostrar el valor de una propiedad y los métodos setter nos sirven para almacenar un valor en una propiedad.

```java
// TestCarro.java
class TestCarro
{
	// Propiedades
	public string nombre;
	private int edad;

	// Métodos
	public int getEdad()
	{
		return this.edad;
	}
	public string getNombre()
	{
		return this.nombre;
	}
	public void setEdad(int edad)
	{
		this.edad = edad;
	}
	public void setNombre(string nombre)
	{
		this.nombre = nombre;
	}
}
```

## Modificadores de acceso

Los modificadores de acceso nos permite controlar desde que parte del código y como tenemos acceso a las propiedades y métodos de nuestras clases.

* public.- Este modificador nos permite acceder al componente tanto dentro como fuera de la clase.
* private.- Este modificador nos permite acceder al componente SOLO desde la clase donde es declarado.

Nota.- Entiendase como componente las propiedades y métodos de una clase.

## Método principal

En programa desarrollado en java, debe existir un método principal llamado main, el cual es el punto de entrada para empezar a correr el programa.-

```java
// Método principal del programa
public static void main(String[] args)
{
	// Contenido del método
}
```

## Constructor

El constructor de la clase es un método que se utiliza para inicializar un objeto, es recomendable utilizarlo para inicializar todas las propiedades utilizadas, el identificador del constructor es exactamente el mismo nombre de la clase.-

```java
// TestCarro.java
class TestCarro
{
	// Propiedades
	public string nombre;
	private int edad;

	// Constructor
	TestCarro()
	{
		this.nombre = "";
		this.edad = 0;
	}
}
```

## Errores y aclaraciones sobre el código

Si encuentras algun error en el código o la forma de optimizarlo puedes informarme en el siguiente enlace para realizar las correcciones correspondientes.-

<a href="https://github.com/nemesis866/lenguaje-c/issues">https://github.com/nemesis866/lenguaje-c/issues</a>