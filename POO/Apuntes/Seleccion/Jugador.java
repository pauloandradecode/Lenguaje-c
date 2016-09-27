/****************************************************
Subclase Jugador

Name: Andrade Gonzalez Paulo Cesar
Fecha: 20/09/2016
****************************************************/

public class Jugador extends Persona
{
	public int numeroCamisa;
	public String posicion;

	/**************************************************
    Metodos getter y setter
    **************************************************/

    public String getPosicion()
    {
    	return this.posicion;
    }
    public int getNumeroCamisa()
    {
    	return this.numeroCamisa;
    }
    public void setPosicion(String posicion)
    {
    	this.posicion = posicion;
    }
    public void setNumeroCamisa(int numeroCamisa)
    {
    	this.numeroCamisa = numeroCamisa;
    }

    /**************************************************
    Metodos
    **************************************************/

    public String entrenar()
    {
    	return "Estoy entrenado";
    }
    public String jugar()
    {
    	return "Estoy jugando";
    }
}