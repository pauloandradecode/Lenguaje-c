/*****************************************************
Clase

Name: Paulo Andrade
Date: 18/10/2016
*****************************************************/

import java.lang.Math;

public class Cubo extends TresD implements Area
{
	public double lado;

	Cubo()
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
		return 6 * Math.pow(this.lado, 2);
	}
	public double volumen()
	{
		return Math.pow(this.lado, 3);
	}
	
}