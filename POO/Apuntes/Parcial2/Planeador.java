/********************************************************
Clase Planeador

Autor: Paulo Andrade
Fecha: 31/10/2016
********************************************************/

public class Planeador extends Aereo implements NoMotorizado
{
	public int asientos;
	public int llantas;

	/***********************************
	Metodos getter y setter
	***********************************/

	public int getAsientos()
	{
		return this.asientos;
	}
	public int getLlantas()
	{
		return this.llantas;
	}
	public void setAsientos(int asientos)
	{
		this.asientos = asientos;
	}
	public void setLlantas(int llantas)
	{
		this.llantas = llantas;
	}

	/***********************************
	Metodos
	***********************************/

	public void avanzarSinMotor()
	{
		System.out.println("Estoy avanzando sin motor...");
	}
	public void detenerSinMotor()
	{
		System.out.println("Me estoy deteniendo sin motor...");
	}
}