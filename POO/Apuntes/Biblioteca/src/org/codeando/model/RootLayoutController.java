package org.codeando.model;

import javafx.event.ActionEvent;

/**
 * Created by root on 29/11/16.
 * Controlador para la vista principal
 */
public class RootLayoutController extends ActionEvent{

    /*
    Metodos
     */

    public void openBookLayout(ActionEvent actionEvent)
    {
        // Mostramos la vista
        LC.loadBook();
    }

    public void openPersonLayout(ActionEvent actionEvent) {
        // Mostramos la vista
        LC.loadPerson();
    }

    public void openAbout(ActionEvent actionEvent) {
        // Abrimos a ventana acerca de
        LC.loadAbout();
    }

    public void closeWindow(ActionEvent actionEvent) {
        // Cerramos el programa
        LC.primaryStage.close();
    }

    public void openLendLayout(ActionEvent actionEvent) {
        // Abrimos el layout
        LC.loadLend();
    }

    public void openVenLendLayout(ActionEvent actionEvent) {
        // Abrimos el layout
        LC.loadVenLend();
    }
}
