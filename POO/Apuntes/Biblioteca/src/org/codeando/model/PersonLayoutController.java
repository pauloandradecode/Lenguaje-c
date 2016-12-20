package org.codeando.model;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javax.swing.*;

/**
 * Created by root on 29/11/16.
 * Controlador para la vista personas
 */

public class PersonLayoutController extends ActionEvent
{
    @FXML
    public TextField txtFnombre;
    @FXML
    public TextField txtFdireccion;
    @FXML
    public TextField txtFtelefono;
    @FXML
    public TableView<Persona> personTable;
    @FXML
    public TableColumn<Persona, Number> personColumnId;
    @FXML
    public TableColumn<Persona, String> personColumnNombre;
    @FXML
    public TableColumn<Persona, String> personColumnDireccion;
    @FXML
    public TableColumn<Persona, String> personColumnTelefono;
    public Button btnEditPerson;
    public Button btnDeletePerson;
    private FileController archivo = new FileController("person.txt");

    /*
    Metodo inicializado automaticamente
     */

    public void initialize()
    {
        // Configuramos las columnas de la tabla
        personColumnId.setCellValueFactory((cellData->cellData.getValue().idProperty()));
        personColumnNombre.setCellValueFactory(cellData->cellData.getValue().nombreProperty());
        personColumnDireccion.setCellValueFactory(cellData->cellData.getValue().domicilioProperty());
        personColumnTelefono.setCellValueFactory(cellData->cellData.getValue().telefonoProperty());

        // Limpiamos los datos
        this.showPersonDetails(null);

        // Escuchamos los cambios en la tabla
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)->showPersonDetails(newValue));
    }

    /*
    Metodos de la plantilla
     */

    public void newPerson(ActionEvent actionEvent)
    {
        // Cargamos la ventana para registro
        LC.loadNewPerson();
    }

    public void editPerson(ActionEvent actionEvent)
    {
        // Obtenemos el registro seleccionado
        Persona selectedPerson = personTable.getSelectionModel().getSelectedItem();
        // Cargamos la ventana para editar
        LC.loadEditPerson(selectedPerson);
    }

    // Eliminamos una persona
    public void deletePerson(ActionEvent actionEvent) throws Exception
    {
        // Obtenemos el index de la persona a eliminar
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        // Eliminamos a la persona
        personTable.getItems().remove(selectedIndex);
        // Actualizamos el archivo
        archivo.updatePersonFile(DataBinding.dataPerson);
        // Actualizamos el archivo
        // DataBinding.reloadPerson();
        // Mostramos mensaje de exito
        JOptionPane.showMessageDialog(null, "El cliente se elimino con exito!");
    }

    // Metodo para cerrar la ventana
    public void closePerson(ActionEvent actionEvent)
    {
        LC.rootLayout.setCenter(null);
    }

    /*
    Metodos adicionales
     */

    // Inicializamos la tabla
    public void initTable()
    {
        personTable.setItems(DataBinding.getDataPerson());
    }

    // Mostramos los datos de una sola persona
    private void showPersonDetails(Persona person)
    {
        // Verificamos si el objeto no esta vacio
        if(person != null){
            // Rellenamos los campos con los datos de esta objeto
            txtFnombre.setText(person.getNombre());
            txtFdireccion.setText(person.getDomicilio());
            txtFtelefono.setText(person.getTelefono());
            // Habilitamos los botons
            btnEditPerson.setDisable(false);
            btnDeletePerson.setDisable(false);
        } else {
            // Si el objeto es nulo vaciamos los campos
            txtFnombre.setText("");
            txtFdireccion.setText("");
            txtFtelefono.setText("");
            // deshabilitamos los botons
            btnEditPerson.setDisable(true);
            btnDeletePerson.setDisable(true);
        }
    }
}
