package org.codeando;

/**
 * Created by root on 29/11/16.
 * Aplicacion principal de JavaFX
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.codeando.model.DataBinding;
import org.codeando.model.FileController;
import org.codeando.model.LC;
import org.codeando.model.Persona;

import java.io.IOException;

public class MainApp extends Application {
    // Metodo principal de la aplicacion
    public static void main(String[] args) {
        launch(args);
    }

    // Punto de entrada para la aplicacion
    @Override
    public void start(Stage primaryStage) throws Exception{
        LC.primaryStage = primaryStage;
        LC.primaryStage.setTitle("Sistema de Administración de Bibliotecas - SAB");

        // Iniciamos el layout principal
        initRootLayout();

        // Cargamos los datos para persona
        loadPerson();

        // Cargamos los datos para libros
        loadBook();

        // Cargamos los datos para prestamos
        loadLind();

        // Cargamos los datos para prestamos vencidos
        loadVenLind();
    }

    // Metodo para inicializar el layout principal
    private void initRootLayout()
    {
        try{
            // Cargamos el layout principal
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            LC.rootLayout = (BorderPane) loader.load();

            // Mostramos la ecena conteniendo el layout principal
            Scene scene = new Scene(LC.rootLayout, 800, 600);
            LC.primaryStage.setScene(scene);
            LC.primaryStage.setResizable(false);
            LC.primaryStage.show();
        } catch(IOException e){
            // Mostramos mensaje de error
            e.printStackTrace();
        }
    }

    // Obtenemos los datos de persona
    public void loadPerson() throws Exception
    {
        DataBinding.loadPerson();
    }

    // Obtenemos los datos de libros
    public void loadBook() throws Exception
    {
        DataBinding.loadBook();
    }

    // Obtenemos los datos de prestamos
    public void loadLind() throws Exception
    {
        DataBinding.loadLind();
    }

    // Obtenemos los datos de prestamos
    public void loadVenLind() throws Exception
    {
        DataBinding.loadVenLind();
    }
}
