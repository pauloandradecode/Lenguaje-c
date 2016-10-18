/****************************************************
Subclase

Name: Andrade Gonzalez Paulo Cesar
Fecha: 04/10/2016
****************************************************/

public class CuentaAhorro extends CuentaBancaria
{
	public int interes;
	public int plazo;

	/*************************************************
	Metodos getter y setter
	*************************************************/

	public int getInteres()
	{
		return this.interes;
	}
	public int getPlazo()
	{
		return this.plazo;
	}
	public void setInteres(int interes)
	{
		this.interes = interes;
	}
	public void setPlazo(int plazo)
	{
		this.plazo = plazo;
	}

	/*************************************************
	Metodos
	*************************************************/

	public double rendimiento(int interes, int plazo)
	{
		double total = 0.0;

		return total;
	}	
}