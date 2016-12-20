package org.codeando.model;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import javax.swing.*;

/**
 * Created by root on 2/12/16.
 * Controlador para editar a las personas
 */

public class EditPersonLayoutController extends ActionEvent
{
    public TextField txtFnombre;
    public TextField txtFdireccion;
    public TextField txtFtelefono;
    private FileController archivo = new FileController("person.txt");
    private Persona person;

    /*
    Metodos de la plantilla
     */

    // Editamos los datos
    public void saveEditPerson(ActionEvent actionEvent)
    {
        String nombre;
        String direccion;
        String telefono;

        // Obtenemos los datos de los textField
        nombre = txtFnombre.getText();
        direccion = txtFdireccion.getText();
        telefono = txtFtelefono.getText();

        // Comprobamos que los campos de textos esten llenos
        if(nombre.length() == 0 || direccion.length() == 0 || telefono.length() == 0){
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Mensaje", JOptionPane.ERROR_MESSAGE);
        } else {
            // Actualizamos la lista
            this.person.setNombre(nombre);
            this.person.setDomicilio(direccion);
            this.person.setTelefono(telefono);

            // Guardamos la cadena en el archivo
            archivo.updatePersonFile(DataBinding.dataPerson);

            // Mostramos mensaje de exito
            JOptionPane.showMessageDialog(null, "El cliente se edito con exito!");

            // Cerramos la ventana
            LC.closeWindows();
        }
    }

    // Metodo para cerrar la ventana
    public void closeEditPerson(ActionEvent actionEvent)
    {
        // Cerramos la ventana
        LC.closeWindows();
    }

    /*
    Metodos adicionales
     */

    // Enviamos los datos de la persona a editar
    public void setData(Persona person)
    {
        // Guardamos los datos
        this.person = person;

        // Actualizamos los datos
        txtFnombre.setText(person.getNombre());
        txtFdireccion.setText(person.getDomicilio());
        txtFtelefono.setText(person.getTelefono());
    }
}
