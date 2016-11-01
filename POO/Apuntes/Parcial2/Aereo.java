/********************************************************
Clase para vehiculos aereos

Autor: Paulo Andrade
Fecha: 31/10/2016
********************************************************/

public class Aereo extends Vehiculo
{
	public int alas;
	public int puertas;

	/***********************************
	Metodos getter y setter
	***********************************/

	public int getAlas()
	{
		return this.alas;
	}
	public int getPuertas()
	{
		return this.puertas;
	}
	public void setAlas(int alas)
	{
		this.alas = alas;
	}
	public void setPuertas(int puertas)
	{
		this.puertas = puertas;
	}

	/***********************************
	Metodos
	***********************************/

	public void volar()
	{
		System.out.println("Estoy volando...");
	}
	public void aterrizar()
	{
		System.out.println("Estoy aterrizando...");
	}
}