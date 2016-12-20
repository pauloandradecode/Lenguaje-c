package org.codeando.model;

import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by root on 3/12/16.
 * Controlador para la vista nuevo registro
 */

public class NewLendLayoutController extends ActionEvent
{

    public TextField txtFfechaFin;
    public TextField txtFfechaInicio;
    public ComboBox<String> comboNombre;
    public ComboBox<String> comboLibro;
    private FileController archivo = new FileController("lind.txt");

    /*
    Metodo por defecto
     */

    public void init() throws Exception
    {
        // Pasamos los datos a los combobox
        for(Persona temp: DataBinding.dataPerson){
            // Añadimos los datos a los combobox
            comboNombre.getItems().add(temp.getNombre());
        }

        for(Libro temp: DataBinding.dataBook){
            // Añadimos los datos a los combobox
            comboLibro.getItems().add(temp.getTitulo());
        }

        // Configuramos el maximo de filas a mostrar
        comboNombre.setVisibleRowCount(5);
        comboLibro.setVisibleRowCount(5);

        // Configuramos las fechas por default
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        txtFfechaInicio.setText(df.format(new Date()));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, 5); // Sumamos 5 dias
        txtFfechaFin.setText(df.format(calendar.getTime()));
    }

    /*
    Metodos de la plantilla
     */

    // Guardamos el registro
    public void saveNewLend(ActionEvent actionEvent) throws Exception
    {
        String nombre;
        String titulo;
        String fechaInicio;
        String fechaFin;
        String cadena = "";
        String domicilio = "", telefono = "", autor = "", isbn = "", editorial = "", anio = "";

        // Obtenemos los datos de los textField
        nombre = comboNombre.getValue();
        titulo = comboLibro.getValue();
        fechaInicio = txtFfechaInicio.getText();
        fechaFin = txtFfechaFin.getText();

        // Comprobamos que los campos de textos esten llenos
        if(nombre.length() == 0 || titulo.length() == 0 || fechaInicio.length() == 0 || fechaFin.length() == 0){
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Mensaje", JOptionPane.ERROR_MESSAGE);
        } else {
            // Checamos las fechas
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date inicio = new Date();
            Date fin = df.parse(fechaInicio);

            if(inicio.compareTo(fin) <= 1) {
                // armamos la cadena para guardar
                for (Libro temp : DataBinding.dataBook) {
                    if (temp.getTitulo().equals(titulo)) {
                        cadena += temp.getTitulo() + "#" + temp.getAutor() + "#" + temp.getIsbn() + "#" + temp.getEditorial() + "#" + temp.getAnio() + "#";
                        autor = temp.getAutor();
                        isbn = temp.getIsbn();
                        editorial = temp.getEditorial();
                        anio = temp.getAnio();
                    }
                }
                for (Persona temp : DataBinding.dataPerson) {
                    if (temp.getNombre().equals(nombre)) {
                        cadena += temp.getNombre() + "#" + temp.getDomicilio() + "#" + temp.getTelefono();
                        domicilio = temp.getDomicilio();
                        telefono = temp.getTelefono();
                    }
                }
                // Agregamos las fechas a la cadena
                cadena += "#" + fechaInicio + "#" + fechaFin;

                // Guardamos la cadena en el archivo
                archivo.writeFile(cadena);

                // Actualizamos la lista

                DataBinding.dataLind.add(new Libro(0, nombre, domicilio, telefono, titulo, autor, isbn, editorial, anio, fechaInicio, fechaFin));

                // Mostramos mensaje de exito
                JOptionPane.showMessageDialog(null, "El registro se guardo con exito!");

                // Cerramos la ventana
                LC.closeWindows();
            } else {
                // Mostramos mensaje de error
                JOptionPane.showMessageDialog(null, "La fecha de entrega debe ser igual o mayor a la fecha actual", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Cerramos la ventana
    public void closeNewLend(ActionEvent actionEvent)
    {
        LC.closeWindows();
    }

    /*
    Metodos adicionales
     */

    // Verificamos la fecha al ingresar
    public void checkDate(KeyEvent keyEvent) throws Exception
    {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        Date inicio;
        Date fin;
        String fechaIn = txtFfechaInicio.getText();
        String fechaFin;

        // Comprobamos la cantidad de caracteres de la fecha de inicio
        if(fechaIn.length() == 10){
            // Convertimos las fechas
            inicio = df.parse(fechaIn);
            // Sumamos 5 dias a la fecha
            calendar.setTime(inicio);
            calendar.add(Calendar.DAY_OF_YEAR, 5); // Sumamos 5 dias
            fin = calendar.getTime();
            // Convertimos la fecha de fin
            fechaFin = df.format(fin);

            // Asignamos la nueva fecha
            txtFfechaFin.setText(fechaFin);
        } else {
            txtFfechaFin.setText("");
        }
    }
}
