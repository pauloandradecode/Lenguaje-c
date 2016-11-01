/********************************************************
Clase para vehiclos terrestres

Autor: Paulo Andrade
Fecha: 31/10/2016
********************************************************/

public class Terrestre extends Vehiculo
{
	public int llantas;
	public int pistones;

	/***********************************
	Metodos getter y setter
	***********************************/

	public int getLlantas()
	{
		return this.llantas;
	}
	public int getPistones()
	{
		return this.pistones;
	}
	public void setLlantas(int llantas)
	{
		this.llantas = llantas;
	}
	public void setPistones(int pistones)
	{
		this.pistones = pistones;
	}

	/***********************************
	Metodos
	***********************************/

	public void darVuelta()
	{
		System.out.println("Estoy dando vuelta...");
	}
	public void reversa()
	{
		System.out.println("Estoy en reversa...");
	}
}