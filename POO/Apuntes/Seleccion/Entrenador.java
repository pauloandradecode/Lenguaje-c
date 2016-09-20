/****************************************************


Name: Andrade Gonzalez Paulo Cesar
Fecha: 20/09/2016
****************************************************/

class Entrenador extends Persona
{
	public String historial;
	public int aniosExperiencia;
	public String especialidad;

	/**************************************************
    Metodos getter y setter
    **************************************************/

    public String getHistorial()
    {
    	return this.historial;
    }
    public int getAniosExperiencia()
    {
    	return this.aniosExperiencia;
    }
    public String getEspecialidad()
    {
    	return this.especialidad;
    }
    public void setHistorial(String historial)
    {
    	this.historial = historial;
    }
    public void setAniosExperiencia(int aniosExperiencia)
    {
    	this.aniosExperiencia = aniosExperiencia;
    }
    public void setEspecialidad(String especialidad)
    {
    	this.especialidad = especialidad;
    }

    /**************************************************
    Metodos
    **************************************************/

    public void dirigirEntrenamiento()
    {
    	System.out.println("Estoy dirigiendo el entrenamiento");
    }
    public String dirigirPartido()
    {
    	return "Estoy dirigiendo el partido";
    }
}