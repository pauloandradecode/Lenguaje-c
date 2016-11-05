/********************************************************
Layout de tipo rejilla flexible

Autor: Paulo Andrade
Fecha: 04/11/2016
********************************************************/

// Importamos la libreria de javaFX
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

// Clase principal de la aplicacion
public class Ventana extends Application
{
	// Punto principal del programa (Stage es el contenedor principal)
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("JavaFX welcome"); // Titulo de la ventana
		primaryStage.show(); // Mostramos la ventana

		GridPane grid = new GridPane(); // Creamos una rejilla
		grid.setAlignment(Pos.CENTER); // Posicion del grid
		grid.setHgap(10); // Espacio entre filas
		grid.setVgap(10); // Espacio entre columnas
		grid.setPadding(new Insets(25, 25, 25, 25)); // Espacio del borde

		Scene escena = new Scene(grid, 300, 275); // Nodo root
		primaryStage.setScene(escena); // Agregamos una escena
	}

	// Metodo principal
	public static void main(String[] args)
	{
		// Iniciamos la aplicacion
		launch(args);
	}
}