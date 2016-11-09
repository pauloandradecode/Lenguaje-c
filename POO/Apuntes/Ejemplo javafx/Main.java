/********************************************************
Clase principal

Autor: Paulo Andrade
Fecha: 09/11/2016
********************************************************/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class Main extends Application
{

    // Metodo de inicio para la app
    public void start(Stage primaryStage) throws Exception
    {
        // Cargamos la plantilla xml (vinculamos)
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        // Titulo de la ventana principal
        primaryStage.setTitle("Factorial");
        // Tamaño de la ventana
        primaryStage.setScene(new Scene(root, 300, 275));
        // Mostramos la ventana
        primaryStage.show();
    }

    // Metodo principal
    public static void main(String[] args) {
        // Iniciamos la app
        launch(args);
    }
}
