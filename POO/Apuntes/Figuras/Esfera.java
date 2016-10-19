/*****************************************************
Clase

Name: Paulo Andrade
Date: 18/10/2016
*****************************************************/

import java.lang.Math;

public class Esfera extends TresD implements Area
{
	public double radio;

	Esfera()
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
		return 4 * Math.PI * Math.pow(this.radio, 2);
	}
	public double volumen()
	{
		return (4 * Math.PI * Math.pow(this.radio, 3)) / 3;
	}
	
}