/********************************************************
Clase Autobus

Autor: Paulo Andrade
Fecha: 31/10/2016
********************************************************/

public class Autobus extends Terrestre implements Motorizado
{
	public int asientos;
	public int cdf; // Caballos de fuerza

	/***********************************
	Metodos getter y setter
	***********************************/

	public int getAsientos()
	{
		return this.asientos;
	}
	public int getCdf()
	{
		return this.cdf;
	}
	public void setAsientos(int asientos)
	{
		this.asientos = asientos;
	}
	public void setCdf(int cdf)
	{
		this.cdf = cdf;
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