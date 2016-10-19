/*****************************************************
Clase

Name: Paulo Andrade
Date: 18/10/2016
*****************************************************/

import java.lang.Math;

public class Circulo extends DosD implements Area
{
	public double radio;

	Circulo()
	{
		this.radio = 0.0;
	}

	/********************************************
	Metodos Getter y Setter
	********************************************/

	public double getRadio()
	{
		return this.radio;
	}
	public void setRadio(double radio)
	{
		this.radio = radio;
	}

	/********************************************
	Metodos
	********************************************/

	public double areas()
	{
		double result;

		// Procedimiento
		result = Math.PI * Math.pow(this.radio, 2); 

		return result;
	}
	public double perimetro()
	{
		return 2 * Math.PI * this.radio;
	}
	
}