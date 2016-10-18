/*****************************************************
Clase

Name: Paulo Andrade
Date: 18/10/2016
*****************************************************/

public class Cuadrado extends DosD implements Area
{
	public double lado;

	Cuadrado()
	{
		this.lado = 0.0;
	}

	/********************************************
	Metodos Getter y Setter
	********************************************/

	public double getLado()
	{
		return this.lado;
	}
	public void setLado(double lado)
	{
		this.lado = lado;
	}

	/********************************************
	Metodos
	********************************************/

	public double areas()
	{
		double result;

		// Procedimiento
		result = this.lado * this.lado; 

		return result;
	}
	public double perimetro()
	{
		return this.lado * 4;
	}
	
}