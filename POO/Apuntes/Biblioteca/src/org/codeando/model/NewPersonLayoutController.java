package org.codeando.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

/**
 * Created by root on 2/12/16.
 * Controlador para la vista new person
 */

public class NewPersonLayoutController extends ActionEvent
{
    @FXML
    public TextField txtFnombre;
    @FXML
    public TextField txtFdireccion;
    @FXML
    public TextField txtFtelefono;
    private FileController archivo = new FileController("person.txt");

    public void closeNewPerson(ActionEvent actionEvent)
    {
        // Cerramos la ventana
        LC.closeWindows();
    }

    // Guardamos los datos
    public void saveNewPerson(ActionEvent actionEvent) throws Exception
    {
        String cadena = "";
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
            // armamos la cadena para guarda
            cadena += nombre + "#" + direccion + "#" + telefono;

            // Guardamos la cadena en el archivo
            archivo.writeFile(cadena);

            // Actualizamos la lista
            DataBinding.dataPerson.add(new Persona(DataBinding.dataPerson.size() + 1, nombre, direccion, telefono));

            // Mostramos mensaje de exito
            JOptionPane.showMessageDialog(null, "El cliente se guardo con exito!");

            // Cerramos la ventana
            LC.closeWindows();
        }
    }
}
