/********************************************************
Componentes en JavaFX

Autor: Paulo Andrade
Fecha: 04/11/2016
********************************************************/

// Importamos la libreria de javaFX
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.control.*; // Cargamos todos los componentes
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.*; // Cargamos todos los layouts
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

		/* Componentes */
		Text sceneText = new Text("Welcome"); // Texto para el titulo
		sceneText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); // Estilos para el titulo
		grid.add(sceneText, 0, 0, 2, 1); // Agregamos el componente al grid (columna 0, fila 0)
		Label userName = new Label("User name: "); // Componente
		grid.add(userName, 0, 1); // Agregamos componente al grid
		TextField userTextField = new TextField(); // Componente
		grid.add(userTextField, 1, 1); // Agregamos componente a la rejilla
		Label pw = new Label("Password: "); // Componente
		grid.add(pw, 0, 2); // Agregamos componente a la rejilla
		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2); // Agregamos componente a la rejilaa

		/* Botones*/
		Button btn = new Button("Sign in"); // Componente
		HBox hbBtn = new HBox(10); // Creamos layout con 10px de separacion por lado
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT); // Alineamos el layout
		hbBtn.getChildren().add(btn); // Añadimos un hijo al layout
		grid.add(hbBtn, 1, 4); // Agregamos componente a la rejilla

		/* Control de texto */
		final Text actionTarget = new Text(); // Componente
		grid.add(actionTarget, 1, 6); // Agregamos componente a la rejilla

		grid.setGridLinesVisible(true); // Hace los bordes visibles
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