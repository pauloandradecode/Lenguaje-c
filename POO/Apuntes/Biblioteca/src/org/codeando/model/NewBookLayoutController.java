package org.codeando.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.swing.*;

/**
 * Created by root on 2/12/16.
 * Controlador para agregar nuevos libros
 */

public class NewBookLayoutController extends ActionEvent
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
    private FileController archivo = new FileController("book.txt");

    // Guardamos el libro
    public void saveNewBook(ActionEvent actionEvent) throws Exception
    {
        String cadena = "";
        String titulo;
        String autor;
        String isbn;
        String editorial;
        String anio;

        // Obtenemos los datos de los textField
        titulo = txtFtitulo.getText();
        autor = txtFautor.getText();
        isbn = txtFisbn.getText();
        editorial= txtFeditorial.getText();
        anio = txtFanio.getText();

        // Comprobamos que los campos de textos esten llenos
        if(titulo.length() == 0 || autor.length() == 0 || isbn.length() == 0 || editorial.length() == 0 || anio.length() == 0){
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Mensaje", JOptionPane.ERROR_MESSAGE);
        } else {
            // armamos la cadena para guarda
            cadena += titulo+"#"+autor+"#"+isbn+"#"+editorial+"#"+anio;

            // Guardamos la cadena en el archivo
            archivo.writeFile(cadena);

            // Actualizamos la lista
            DataBinding.dataBook.add(new Libro(DataBinding.dataBook.size() + 1, "", "", "", titulo, autor, isbn, editorial, anio, null, null));

            // Mostramos mensaje de exito
            JOptionPane.showMessageDialog(null, "El libro se guardo con exito!");

            // Cerramos la ventana
            LC.closeWindows();
        }
    }

    // Cerramos la ventana
    public void closeLendLayout(ActionEvent actionEvent)
    {
        // Cerramos la ventana
        LC.closeWindows();
    }
}
