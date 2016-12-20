package org.codeando.model;

import javafx.beans.property.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by root on 29/11/16.
 * Clase para libros
 * Usamos el data binding para la actualizacion automaticas de datos
 */

public class Libro extends Persona implements Prestamo
{
    private final StringProperty isbn;
    private final StringProperty titulo;
    private final StringProperty autor;
    private final StringProperty editorial;
    private final StringProperty anio;
    private final StringProperty fechaIn;
    private final StringProperty fechaOut;

    // Constructor sobrecargado
    public Libro(Integer id, String nombre, String domicilio, String telefono, String titulo, String autor, String isbn, String editorial, String anio, String fechaIn, String fechaOut)
    {
        super(id, nombre, domicilio, telefono);
        this.titulo = new SimpleStringProperty(titulo);
        this.autor = new SimpleStringProperty(autor);
        this.isbn = new SimpleStringProperty(isbn);
        this.editorial = new SimpleStringProperty(editorial);
        this.anio = new SimpleStringProperty(anio);
        this.fechaIn = new SimpleStringProperty(fechaIn);
        this.fechaOut = new SimpleStringProperty(fechaOut);
    }

    /*
    Metodos getter y setter
     */

    public String getIsbn() {
        return isbn.get();
    }
    public StringProperty isbnProperty() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn.set(isbn);
    }
    public String getTitulo() {
        return titulo.get();
    }
    public StringProperty tituloProperty() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo.set(titulo);
    }
    public String getAutor() {
        return autor.get();
    }
    public StringProperty autorProperty() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor.set(autor);
    }
    public String getEditorial() {
        return editorial.get();
    }
    public StringProperty editorialProperty() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial.set(editorial);
    }
    public String getAnio() {
        return anio.get();
    }
    public StringProperty anioProperty() {
        return anio;
    }
    public void setAnio(String anio) {
        this.anio.set(anio);
    }
    public String getFechaIn() {
        return fechaIn.get();
    }
    public StringProperty fechaInProperty() {
        return fechaIn;
    }
    public void setFechaIn(String fechaIn) {
        this.fechaIn.set(fechaIn);
    }
    public String getFechaOut() {
        return fechaOut.get();
    }
    public StringProperty fechaOutProperty() {
        return fechaOut;
    }
    public void setFechaOut(String fechaOut) {
        this.fechaOut.set(fechaOut);
    }

    /*
    Metodos
     */

    // Metodo implementado por interfaz
    public Date recargos(Date in, Date out)
    {
        Date test = new Date();

        return test;
    }
}
