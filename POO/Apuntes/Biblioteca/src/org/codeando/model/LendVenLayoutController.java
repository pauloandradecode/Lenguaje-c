package org.codeando.model;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import javax.swing.*;
import java.text.SimpleDateFormat;

/**
 * Created by root on 29/11/16.
 * Controlador para la vista de prestamos
 */
public class LendVenLayoutController extends ActionEvent
{
    public TextField txtFfechaFin;
    public TextField txtFfechaInicio;
    public ComboBox comboNombre;
    public ComboBox comboLibro;
    public Button btnEditLend;
    public Button btnDeleteLend;
    public TextField txtFtitulo;
    public TextField txtFautor;
    public TextField txtFisbn;
    public TextField txtFeditorial;
    public TextField txtFanio;
    public TextField txtFnombre;
    public TextField txtFdireccion;
    public TextField txtFtelefono;
    public TextField txtFfechaIn;
    public TextField txtFfechaOut;
    public TableColumn<Libro, String> lendColumnTitulo;
    public TableColumn<Libro, String> lendColumnAutor;
    public TableColumn<Libro, String> lendColumnIsbn;
    public TableColumn<Libro, String> lendColumnEditorial;
    public TableColumn<Libro, String> lendColumnAnio;
    public TableColumn<Libro, String> lendColumnNombre;
    public TableColumn<Libro, String> lendColumnDireccion;
    public TableColumn<Libro, String> lendColumnTelefono;
    public TableColumn<Libro, String> lendColumnFechaIn;
    public TableColumn<Libro, String> lendColumnFechaOut;
    public TableView<Libro> lendTable;
    public Button btbGetLend;
    private FileController archivo = new FileController("lind.txt");

    /*
    Metodo inicializado automaticamente
     */

    public void initialize()
    {
        // Configuramos las columnas de la tabla
        lendColumnTitulo.setCellValueFactory((cellData->cellData.getValue().tituloProperty()));
        lendColumnAutor.setCellValueFactory((cellData->cellData.getValue().autorProperty()));
        lendColumnIsbn.setCellValueFactory((cellData->cellData.getValue().isbnProperty()));
        lendColumnEditorial.setCellValueFactory((cellData->cellData.getValue().editorialProperty()));
        lendColumnAnio.setCellValueFactory((cellData->cellData.getValue().anioProperty()));
        lendColumnNombre.setCellValueFactory(cellData->cellData.getValue().nombreProperty());
        lendColumnDireccion.setCellValueFactory(cellData->cellData.getValue().domicilioProperty());
        lendColumnTelefono.setCellValueFactory(cellData->cellData.getValue().telefonoProperty());
        lendColumnFechaIn.setCellValueFactory(cellData->cellData.getValue().fechaInProperty());
        lendColumnFechaOut.setCellValueFactory(cellData->cellData.getValue().fechaOutProperty());

        // Limpiamos los datos
        this.showLendDetails(null);

        // Escuchamos los cambios en la tabla
        lendTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)->showLendDetails(newValue));
    }

    // Abrimos la ventana de edicion
    public void editLend(ActionEvent actionEvent) throws Exception
    {
        // Obtenemos el registro seleccionado
        Libro selectedLend = lendTable.getSelectionModel().getSelectedItem();
        // Cargamos la ventana para editar
        LC.loadEditLend(selectedLend);
    }

    // Eliminamos un registro
    public void deleteLend(ActionEvent actionEvent) throws Exception{
        // Obtenemos el index de la persona a eliminar
        int selectedIndex = lendTable.getSelectionModel().getSelectedIndex();
        // Eliminamos a la persona
        lendTable.getItems().remove(selectedIndex);
        // Actualizamos el archivo
        archivo.updateLendFile(DataBinding.dataLind);
        // Mostramos mensaje de exito
        JOptionPane.showMessageDialog(null, "El registro se elimino con exito!");
    }

    // Cerramos la ventana
    public void closeLend(ActionEvent actionEvent)
    {
        LC.rootLayout.setCenter(null);
    }

    /*
    Metodos adicionales
     */

    // Inicializamos la tabla
    public void initTable()
    {
        lendTable.setItems(DataBinding.getDataVenLend());
    }

    // Mostramos los datos de una sola persona
    private void showLendDetails(Libro lend)
    {
        // Verificamos si el objeto no esta vacio
        if(lend != null){
            // Rellenamos los campos con los datos de esta objeto
            txtFtitulo.setText(lend.getTitulo());
            txtFautor.setText(lend.getAutor());
            txtFisbn.setText(lend.getIsbn());
            txtFeditorial.setText(lend.getEditorial());
            txtFanio.setText(lend.getAnio());
            txtFnombre.setText(lend.getNombre());
            txtFdireccion.setText(lend.getDomicilio());
            txtFtelefono.setText(lend.getTelefono());
            txtFfechaIn.setText(lend.getFechaIn());
            txtFfechaOut.setText(lend.getFechaOut());
            // Habilitamos los botons
            btnEditLend.setDisable(false);
            btnDeleteLend.setDisable(false);
            btbGetLend.setDisable(false);
        } else {
            // Si el objeto es nulo vaciamos los campos
            txtFtitulo.setText("");
            txtFautor.setText("");
            txtFisbn.setText("");
            txtFeditorial.setText("");
            txtFanio.setText("");
            txtFnombre.setText("");
            txtFdireccion.setText("");
            txtFtelefono.setText("");
            txtFfechaIn.setText("");
            txtFfechaOut.setText("");
            // deshabilitamos los botons
            btnEditLend.setDisable(true);
            btnDeleteLend.setDisable(true);
            btbGetLend.setDisable(true);
        }
    }

    // Entrega de libros
    public void setLend(ActionEvent actionEvent) throws Exception
    {
        // Obtenemos el registro seleccionado
        Libro selectedLend = lendTable.getSelectionModel().getSelectedItem();
        // Cargamos la ventana para editar
        LC.loadSetLend(selectedLend, lendTable, true);
    }
}
