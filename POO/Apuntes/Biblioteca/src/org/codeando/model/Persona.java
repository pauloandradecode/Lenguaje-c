package org.codeando.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by root on 29/11/16.
 * Clase para Personas
 * Usamos el data binding para la actualizacion automaticas de datos
 */

public class Persona {
    private final IntegerProperty id;
    private final StringProperty nombre;
    private final StringProperty domicilio;
    private final StringProperty telefono;

    // Sobrecarga del constructor
    public Persona(Integer id, String nombre, String domicilio, String telefono)
    {
        // Inicializamos las propiedades
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.domicilio = new SimpleStringProperty(domicilio);
        this.telefono = new SimpleStringProperty(telefono);
    }

    /*
    Metodos gettet y setter
     */

    public int getId() {
        return id.get();
    }
    public IntegerProperty idProperty() {
        return id;
    }
    public void setId(int id) {
        this.id.set(id);
    }
    public String getNombre() {
        return nombre.get();
    }
    public StringProperty nombreProperty() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
    public String getDomicilio() {
        return domicilio.get();
    }
    public StringProperty domicilioProperty() {
        return domicilio;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio.set(domicilio);
    }
    public String getTelefono() {
        return telefono.get();
    }
    public StringProperty telefonoProperty() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono.set(telefono);
    }

    /*
    Metodos
     */
}
