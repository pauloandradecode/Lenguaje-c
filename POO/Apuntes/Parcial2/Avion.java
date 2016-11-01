/********************************************************
Clase Avion

Autor: Paulo Andrade
Fecha: 31/10/2016
********************************************************/

public class Avion extends Aereo implements Motorizado
{
	public int turbinas;
	public int banios;

	/***********************************
	Metodos getter y setter
	***********************************/

	public int getTurbinas()
	{
		return this.turbinas;
	}
	public int getBanios()
	{
		return this.banios;
	}
	public void setTurbinas(int turbinas)
	{
		this.turbinas = turbinas;
	}
	public void setBanios(int banios)
	{
		this.banios = banios;
	}

	/***********************************
	Metodos
	***********************************/

	public void encender()
	{
		System.out.println("Estoy encendiendo");
	}
	public void apagar()
	{
		System.out.println("Estoy apagando...");
	}
}