/****************************************************


Name: Andrade Gonzalez Paulo Cesar
Fecha: 20/09/2016
****************************************************/

import java.util.Date;

public class Persona
{
	public String nombre;
    public Date fechaNacimiento;
    public String domicilio;
    public String telefono;

    /**************************************************
    Metodos getter y setter
    **************************************************/

    public String getDomicilio() {
        return domicilio;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**************************************************
    Metodos
    **************************************************/

    public String concentrarse()
    {
    	return "Estoy en la concentración";
    }
    public void viajar()
    {
    	System.out.println("Estoy viajando");
    }
}