package org.codeando.model;

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
 * Controlador para la ventana de edicion de registros
 */

public class EditLendLayoutController extends ActionEvent
{

    public TextField txtFfechaFin;
    public TextField txtFfechaInicio;
    public ComboBox<String> comboNombre;
    public ComboBox<String> comboLibro;
    private FileController archivo = new FileController("lind.txt");
    private Libro lend;

    /*
    Metodo por defecto
     */

    public void init(Libro lend) throws Exception
    {
        // Guardamos los datos
        this.lend = lend;

        // Pasamos los datos a los combobox
        for(Persona temp: DataBinding.dataPerson){
            // Añadimos los datos a los combobox
            comboNombre.getItems().add(temp.getNombre());
        }

        for(Libro temp: DataBinding.dataBook){
            // Añadimos los datos a los combobox
            comboLibro.getItems().add(temp.getTitulo());
        }

        // valores por defecto de los combos
        comboNombre.getSelectionModel().select(lend.getNombre());
        comboLibro.getSelectionModel().select(lend.getTitulo());

        // Configuramos el maximo de filas a mostrar
        comboNombre.setVisibleRowCount(5);
        comboLibro.setVisibleRowCount(5);

        // Configuramos las fechas por default
        txtFfechaInicio.setText(lend.getFechaIn());
        txtFfechaFin.setText(lend.getFechaOut());
    }

    /*
    Metodos de la plantilla
     */

    // Guardamos los datos
    public void saveNewLend(ActionEvent actionEvent) throws Exception
    {
        String nombre;
        String titulo;
        String fechaInicio;
        String fechaFin;
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
            Date inicio = df.parse(fechaInicio);
            Date fin = df.parse(fechaFin);

            if(fin.compareTo(inicio) > 0) {
                // armamos la cadena para guardar
                for (Libro temp : DataBinding.dataBook) {
                    if (temp.getTitulo().equals(titulo)) {
                        autor = temp.getAutor();
                        isbn = temp.getIsbn();
                        editorial = temp.getEditorial();
                        anio = temp.getAnio();
                    }
                }
                for (Persona temp : DataBinding.dataPerson) {
                    if (temp.getNombre().equals(nombre)) {
                        domicilio = temp.getDomicilio();
                        telefono = temp.getTelefono();
                    }
                }

                // Actualizamos los datos
                this.lend.setTitulo(titulo);
                this.lend.setAutor(autor);
                this.lend.setIsbn(isbn);
                this.lend.setEditorial(editorial);
                this.lend.setAnio(anio);
                this.lend.setNombre(nombre);
                this.lend.setDomicilio(domicilio);
                this.lend.setTelefono(telefono);
                this.lend.setFechaIn(fechaInicio);
                this.lend.setFechaOut(fechaFin);

                // Guardamos la cadena en el archivo
                archivo.updateLendFile(DataBinding.dataLind);

                // Mostramos mensaje de exito
                JOptionPane.showMessageDialog(null, "El registro se edito con exito!");

                // Cerramos la ventana
                LC.closeWindows();
            } else {
                // Mostramos mensaje de error
                JOptionPane.showMessageDialog(null, "La fecha de entrega debe ser mayor a la fecha de prestamo", "Mensaje", JOptionPane.ERROR_MESSAGE);
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
