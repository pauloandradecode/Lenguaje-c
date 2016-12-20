package org.codeando.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.codeando.MainApp;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by root on 4/12/16.
 * Controlador para la entrega de libros
 */

public class SetLendLayoutController extends ActionEvent
{

    public TextField txtFNombre;
    public TextField txtFTitulo;
    public TextField txtFfechaIn;
    public TextField txtFfechaOut;
    public TextField txtFfechaEntrega;
    public TextField txtFpenalizacion;
    public Button btnEntrega;
    public Button btnCancel;
    private FileController archivo = new FileController("lind.txt");
    final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
    public TableView<Libro> lendTable;
    public Boolean type;

    /*
    Metodo por defecto
     */

    // Inicializamos los componentes
    public void init(Libro lend, TableView<Libro> lendTable, Boolean type) throws Exception
    {
        this.lendTable = lendTable;
        this.type = type;

        long dif = 0;

        txtFNombre.setText(lend.getNombre());
        txtFTitulo.setText(lend.getTitulo());
        txtFfechaIn.setText(lend.getFechaIn());
        txtFfechaOut.setText(lend.getFechaOut());

        // Fecha actual
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = new Date();
        Date prestamo = df.parse(lend.getFechaOut());
        String entrega = df.format(fecha);

        txtFfechaEntrega.setText(entrega);

        // Obtenemos la diferencia de dias solo si la fecha de entrega es mayor a la de prestamo
        if(fecha.compareTo(prestamo) > 0) {
            dif = (fecha.getTime() - prestamo.getTime()) / MILLSECS_PER_DAY;
        }

        // Obtenemos la penaizacion
        dif *= 10;

        txtFpenalizacion.setText(String.valueOf(dif));
    }

    /*
    Metodos de la plantilla
     */

    // Entrega de libros
    public void entregaSetLend(ActionEvent actionEvent) throws Exception
    {
        // Obtenemos el index de la persona a eliminar
        int selectedIndex = this.lendTable.getSelectionModel().getSelectedIndex();

        // Eliminamos a la persona
        this.lendTable.getItems().remove(selectedIndex);

        // Actualizamos el registro
        if(this.type){
            // vencidos
            // archivo.updateVenLendFile(DataBinding.dataLind, nombre);
            archivo.updateLendFile(DataBinding.dataLind);
        } else {
            // Todos
            archivo.updateLendFile(DataBinding.dataLind);
        }

        // Mostramos mensaje
        JOptionPane.showMessageDialog(null, "Transaccion exitosa!");

        // Cerramos la ventana
        LC.closeWindows();
    }

    // Cerramos la ventana
    public void cancelSetLend(ActionEvent actionEvent)
    {
        LC.closeWindows();
    }
}
