/********************************************************
Clase principal

Autor: Paulo Andrade
Fecha: 31/10/2016
********************************************************/

public class Vehiculo
{
	public String color;
	public String tamanio;

	/***********************************
	Metodos getter y setter
	***********************************/

	public String getColor()
	{
		return this.color;
	}
	public String getTamanio()
	{
		return this.tamanio;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	public void setTamanio(String tamanio)
	{
		this.tamanio = tamanio;
	}

	/***********************************
	Metodos
	***********************************/

	public void avanzar()
	{
		System.out.println("Estoy avanzando...");
	}
	public void detener()
	{
		System.out.println("Me estoy deteniendo...");
	}
}