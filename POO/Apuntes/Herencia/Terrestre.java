/*******************************************************
Subclase de vehiculo

Name: Andrade Gonzalez Paulo Cesar
Fecha: 19/09/2016
*******************************************************/

public class Terrestre extends Vehiculo
{
	public int numeroEjes;
	public String traccion;

	public void subirVelocidad()
	{
		System.out.println("Estoy subiendo velocidad . . .");
	}
	public void bajarVelocidad()
	{
		System.out.println("Estoy bajando velocidad . . .");
	}
}