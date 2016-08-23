/************************************************************
Clase TestCarro - Clase para poner en marcha un carro

Autor: Paulo Andrade
Fecha: 22/08/2016
nota:
************************************************************/

public class TestCarro
{
	// Método principal de la clase
	public static void main(String[] args)
	{
		// Inicializamos dos objetos de la clase carro
		Carro bocho = new Carro();
		Carro chevy = new Carro();

		// Asignamos valores a las propiedades del objeto bocho
		bocho.setTipo("Sedan");
		bocho.setColor("Rojo");
		bocho.setCaballosPoder(75);
		bocho.setMarca("VW");
		bocho.setNumeroCilindros(4);

		// bocho.color = "Azul";

		// Mostramos la información
		System.out.println("Hola soy un " + bocho.getTipo());
		System.out.println("Soy de color " + bocho.getColor());
		System.out.println("Tengo " + bocho.getCaballosPoder());
		System.out.println(bocho.encender());
		System.out.println(bocho.avanzar());
	}
}