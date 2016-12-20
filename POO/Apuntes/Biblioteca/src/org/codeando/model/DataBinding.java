package org.codeando.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by root on 30/11/16.
 * Controlador para el manojo de datos
 * Data binding
 */

public class DataBinding
{
    // Lista observable para los datos de persona
    public static ObservableList<Persona> dataPerson = FXCollections.observableArrayList();
    // Lista observable para los datos de libros
    public static ObservableList<Libro> dataBook = FXCollections.observableArrayList();
    // Lista observable para los datos de prestamos
    public static ObservableList<Libro> dataLind = FXCollections.observableArrayList();
    // Lista observable para los datos de prestamos vencidos
    public static ObservableList<Libro> dataVenLind = FXCollections.observableArrayList();

    /*
    Metodos
     */

    // Metodo que retorna los datos de Personas
    public static ObservableList<Persona> getDataPerson()
    {
        return dataPerson;
    }
    // Metodo que retorna los datos de libros
    public static ObservableList<Libro> getDataBook()
    {
        return dataBook;
    }
    // Metodo que retorna los datos de prestamos
    public static ObservableList<Libro> getDataLend()
    {
        return dataLind;
    }
    public static ObservableList<Libro> getDataVenLend()
    {
        return dataVenLind;
    }

    // Obtenemos los datos de persona
    public static void loadPerson() throws Exception
    {
        FileController archivo = new FileController("person.txt");
        String[] data = archivo.readFile();
        String[] parts;
        int control = 1;

        // Recorremos los datos
        for (String temp: data){
            // Cortamos la cadena obtenida
            parts = temp.split("#");

            // Agregamos los datos al observable list
            dataPerson.add(new Persona(control, parts[0], parts[1], parts[2]));

            control++;
        }
    }

    // Obtenemos los datos de libros
    public static void loadBook() throws Exception
    {
        FileController archivo = new FileController("book.txt");
        String[] data = archivo.readFile();
        String[] parts;
        int control = 1;

        // Recorremos los datos
        for (String temp: data){
            // Cortamos la cadena obtenida
            parts = temp.split("#");

            // Agregamos los datos al observable list
            dataBook.add(new Libro(control, "", "", "", parts[0], parts[1], parts[2], parts[3], parts[4], null, null));

            control++;
        }
    }

    // Obtenemos los datos de libros
    public static void loadLind() throws Exception
    {
        FileController archivo = new FileController("lind.txt");
        String[] data = archivo.readFile();
        String[] parts;
        int control = 1;

        // Recorremos los datos
        for(String temp: data){
            // Cortamos la cadena obtenida
            parts = temp.split("#");

            // Agregamos los datos al observable list
            dataLind.add(new Libro(control,parts[5], parts[6], parts[7], parts[0], parts[1], parts[2], parts[3], parts[4], parts[8], parts[9]));

            control++;
        }
    }

    // Obtenemos los datos de libros
    public static void loadVenLind() throws Exception
    {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        FileController archivo = new FileController("lind.txt");
        String[] data = archivo.readFile();
        String[] parts;
        int control = 1;
        Date fecha = new Date();

        // Recorremos los datos
        for(String temp: data){
            // Cortamos la cadena obtenida
            parts = temp.split("#");

            // Guardamos los datos solo si estan vencidos
            if(fecha.compareTo(df.parse(parts[9])) > 0) {
                // Agregamos los datos al observable list
                dataVenLind.add(new Libro(control, parts[5], parts[6], parts[7], parts[0], parts[1], parts[2], parts[3], parts[4], parts[8], parts[9]));

                control++;
            }
        }
    }

    // Recargamos los datos para actualizar el ID
    public static void reloadPerson() throws Exception
    {
        dataPerson = null;
        dataPerson = FXCollections.observableArrayList();
        loadPerson();
    }
}
