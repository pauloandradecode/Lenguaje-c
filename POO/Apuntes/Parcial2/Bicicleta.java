/********************************************************
Clase Bicicleta

Autor: Paulo Andrade
Fecha: 31/10/2016
********************************************************/

public class Bicicleta extends Terrestre implements NoMotorizado
{
	public int velocidades;
	public int frenos;

	/***********************************
	Metodos getter y setter
	***********************************/

	public int getVelocidades()
	{
		return this.velocidades;
	}
	public int getFrenos()
	{
		return this.frenos;
	}
	public void setVelocidades(int velocidades)
	{
		this.velocidades = velocidades;
	}
	public void setFrenos(int frenos)
	{
		this.frenos = frenos;
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