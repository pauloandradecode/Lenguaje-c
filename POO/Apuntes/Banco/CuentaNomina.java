/****************************************************
Subclase

Name: Andrade Gonzalez Paulo Cesar
Fecha: 04/10/2016
****************************************************/

public class CuentaNomina extends CuentaBancaria
{
	public String empresa;
	public double cantidadMinima;

	/*************************************************
	Metodos getter y setter
	*************************************************/

	public String getEmpresa()
	{
		return this.empresa;
	}
	public double getCantidadMinima()
	{
		return this.cantidadMinima;
	}
	public void setEmpresa(String empresa)
	{
		this.empresa = empresa;
	}
	public void setCantidadMinima(double cantidadMinima)
	{
		this.cantidadMinima = cantidadMinima;
	}

	/*************************************************
	Metodos
	*************************************************/
}