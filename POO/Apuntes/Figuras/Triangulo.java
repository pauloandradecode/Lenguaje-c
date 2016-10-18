/*****************************************************
Clase

Name: Paulo Andrade
Date: 18/10/2016
*****************************************************/

public class Triangulo extends DosD implements Area
{
	public double altura;
	public double base;
	public String tipo;
	public double l1, l2, l3;

	Triangulo()
	{
		this.altura = 0.0;
		this.base = 0.0;
		this.tipo = "equilatero";
		this.l1 = 0.0;
		this.l2 = 0.0;
		this.l3 = 0.0;
	}

	/********************************************
	Metodos Getter y Setter
	********************************************/

	public double getAltura()
	{
		return this.altura;
	}
	public double getBase()
	{
		return this.base;
	}
	public String getTipo()
	{
		return this.tipo;
	}
	public double getL1()
	{
		return this.l1;
	}
	public double getL2()
	{
		return this.l2;
	}
	public double getL3()
	{
		return this.l3;
	}
	public void setAltura(double altura)
	{
		this.altura = altura;
	}
	public void setBase(double base)
	{
		this.base = base;
	}
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	public void setL1(double l1)
	{
		this.l1 = l1;
	}
	public void setL2(double l2)
	{
		this.l2 = l2;
	}
	public void setL3(double l3)
	{
		this.l3 = l3;
	}

	/********************************************
	Metodos
	********************************************/

	public double areas()
	{
		double result;

		// Procedimiento
		result = (this.base * this.altura) / 2;

		return result;
	}
	public double perimetro()
	{
		double result = 0.0;

		// Verificamos el tipo de triangulo
		switch(this.tipo){
			case "equilatero":
				result = this.l1 * 3;
				break;
			case "isoseles":
				result = (this.l1 * 2) + base;
				break;
			case "escaleno":
				result = l1 + l2 + l3;
				break;
		}

		return result;
	}
	
}