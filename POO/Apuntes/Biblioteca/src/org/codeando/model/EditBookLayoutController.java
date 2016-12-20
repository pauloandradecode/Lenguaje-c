package org.codeando.model;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import javax.swing.*;

/**
 * Created by root on 2/12/16.
 * Controlador para edicion de libros
 */

public class EditBookLayoutController extends ActionEvent
{

    public TextField txtFtitulo;
    public TextField txtFautor;
    public TextField txtFisbn;
    public TextField txtFeditorial;
    public TextField txtFanio;
    private FileController archivo = new FileController("book.txt");
    private Libro book;

    /*
    Metodos de la plantilla
     */

    // Editamos los datos
    public void saveEditBook(ActionEvent actionEvent)
    {
        String titulo;
        String autor;
        String isbn;
        String editorial;
        String anio;

        // Obtenemos los datos de los textField
        titulo = txtFtitulo.getText();
        autor = txtFautor.getText();
        isbn = txtFisbn.getText();
        editorial = txtFeditorial.getText();
        anio = txtFanio.getText();

        // Comprobamos que los campos de textos esten llenos
        if(titulo.length() == 0 || autor.length() == 0 || isbn.length() == 0 || editorial.length() == 0 || anio.length() == 0){
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Mensaje", JOptionPane.ERROR_MESSAGE);
        } else {
            // Actualizamos la lista
            this.book.setTitulo(titulo);
            this.book.setAutor(autor);
            this.book.setIsbn(isbn);
            this.book.setEditorial(editorial);
            this.book.setAnio(anio);

            // Guardamos la cadena en el archivo
            archivo.updateBookFile(DataBinding.dataBook);

            // Mostramos mensaje de exito
            JOptionPane.showMessageDialog(null, "El libro se edito con exito!");

            // Cerramos la ventana
            LC.closeWindows();
        }
    }

    // Metodo para cerrar la ventana
    public void closeEditBook(ActionEvent actionEvent)
    {
        // Cerramos la ventana
        LC.closeWindows();
    }

    /*
    Metodos adicionales
     */

    // Enviamos los datos de la persona a editar
    public void setData(Libro book)
    {
        // Guardamos los datos
        this.book = book;

        // Actualizamos los datos
        txtFtitulo.setText(book.getTitulo());
        txtFautor.setText(book.getAutor());
        txtFisbn.setText(book.getIsbn());
        txtFeditorial.setText(book.getEditorial());
        txtFanio.setText(book.getAnio());
    }
}
