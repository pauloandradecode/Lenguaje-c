package org.codeando.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.File;

/**
 * Created by root on 29/11/16.
 * Controlador para la vista libros
 */

public class BookLayoutController extends ActionEvent
{
    @FXML
    public TextField txtFtitulo;
    @FXML
    public TextField txtFautor;
    @FXML
    public TextField txtFisbn;
    @FXML
    public TextField txtFeditorial;
    @FXML
    public TextField txtFanio;
    @FXML
    public TableView<Libro> bookTable;
    @FXML
    public TableColumn<Libro, Number> bookColumnId;
    @FXML
    public TableColumn<Libro, String> bookColumnTitulo;
    @FXML
    public TableColumn<Libro, String> bookColumnAutor;
    @FXML
    public TableColumn<Libro, String> bookColumnIsbn;
    @FXML
    public TableColumn<Libro, String> bookColumnEditorial;
    @FXML
    public TableColumn<Libro, String> bookColumnAnio;
    @FXML
    public Button btnEditPerson;
    @FXML
    public Button btnDeletePerson;
    private FileController archivo = new FileController("book.txt");

    /*
    Metodo inicializado automaticamente
     */

    public void initialize()
    {
        // Configuramos las columnas de la tabla
        bookColumnId.setCellValueFactory((cellData->cellData.getValue().idProperty()));
        bookColumnTitulo.setCellValueFactory((cellData->cellData.getValue().tituloProperty()));
        bookColumnAutor.setCellValueFactory((cellData->cellData.getValue().autorProperty()));
        bookColumnIsbn.setCellValueFactory((cellData->cellData.getValue().isbnProperty()));
        bookColumnEditorial.setCellValueFactory((cellData->cellData.getValue().editorialProperty()));
        bookColumnAnio.setCellValueFactory((cellData->cellData.getValue().anioProperty()));

        // Limpiamos los datos
        this.showBookDetails(null);

        // Escuchamos los cambios en la tabla
        bookTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)->showBookDetails(newValue));
    }

    /*
    Metodos de la plantilla
     */

    public void newBook(ActionEvent actionEvent) {
        // Cargamos la ventana para registros
        LC.loadNewBook();
    }

    // Editamos los libros seleccionados
    public void editBook(ActionEvent actionEvent)
    {
        // Obtenemos el registro seleccionado
        Libro selectedBook = bookTable.getSelectionModel().getSelectedItem();
        // Cargamos la ventana para editar
        LC.loadEditBook(selectedBook);
    }

    // Eliminamos un libro
    public void deleteBook(ActionEvent actionEvent) throws Exception
    {
        // Obtenemos el index de la persona a eliminar
        int selectedIndex = bookTable.getSelectionModel().getSelectedIndex();
        // Eliminamos a la persona
        bookTable.getItems().remove(selectedIndex);
        // Actualizamos el archivo
        archivo.updateBookFile(DataBinding.dataBook);
        // Actualizamos el archivo
        // DataBinding.reloadPerson();
        // Mostramos mensaje de exito
        JOptionPane.showMessageDialog(null, "El libro se elimino con exito!");
    }

    public void closeBook(ActionEvent actionEvent)
    {
        // Cerramos la ventana
        LC.rootLayout.setCenter(null);
    }

    /*
    Metodos adicionales
     */

    // Inicializamos la tabla
    public void initTable()
    {
        bookTable.setItems(DataBinding.getDataBook());
    }

    // Mostramos los datos de una sola persona
    private void showBookDetails(Libro book)
    {
        // Verificamos si el objeto no esta vacio
        if(book != null){
            // Rellenamos los campos con los datos de esta objeto
            txtFtitulo.setText(book.getTitulo());
            txtFautor.setText(book.getAutor());
            txtFisbn.setText(book.getIsbn());
            txtFeditorial.setText(book.getEditorial());
            txtFanio.setText(book.getAnio());
            // Habilitamos los botons
            btnEditPerson.setDisable(false);
            btnDeletePerson.setDisable(false);
        } else {
            // Si el objeto es nulo vaciamos los campos
            txtFtitulo.setText("");
            txtFautor.setText("");
            txtFisbn.setText("");
            txtFeditorial.setText("");
            txtFanio.setText("");
            // deshabilitamos los botons
            btnEditPerson.setDisable(true);
            btnDeletePerson.setDisable(true);
        }
    }
}
