/****************************************************
Subclase Masajista

Name: Andrade Gonzalez Paulo Cesar
Fecha: 20/09/2016
****************************************************/

public class Masajista extends Persona
{
	public String especialidad;

	/**************************************************
    Metodos getter y setter
    **************************************************/

    public String getEspecialidad()
    {
    	return this.especialidad;
    }
    public void setEspecialidad(String especialidad)
    {
    	this.especialidad = especialidad;
    }

    /**************************************************
    Metodos
    **************************************************/

    public String darMasaje()
    {
    	return "Estoy dando masaje";
    }
}