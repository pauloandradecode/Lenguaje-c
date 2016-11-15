/********************************************************
Clase principal - Framework JavaFX

Autor: Paulo Andrade
Fecha: 10/11/2016
********************************************************/

import javafx.application.Application; // Aplicacion principal javafx
import javafx.fxml.FXMLLoader; // Opciones para cargar archivos fxml
import javafx.scene.Parent; // Contenedor padre
import javafx.scene.Scene; // Contenedor estandar
import javafx.stage.Stage; // Contenedores por etapa (principal)

// Creamos la clase principal y extendemos de Application
public class Main extends Application
{
	// Metodo - Punto de inicio de la app
	// @param primarystage Contenedor de nivel superior
	public void start(Stage primaryStage) throws Exception
	{
		// Cargamos el archivo fxml principal
		Parent root = FXMLLoader.load(this.getClass().getResource("/main.fxml"));
		primaryStage.setTitle("Framework JavaFX"); // Titulo de la ventana principal
		primaryStage.setResizable(false); // Evitamos que se redimensione la ventana principal
		Scene escena = new Scene(root); // Asignamos la UI a un contenedor estandar
		primaryStage.setScene(escena); // Asignamos la escena al contenedor principal
		primaryStage.show(); // Mostramos la ventana
	}

	// Metodo principal
	// @param args argumentos ingresados por consola
	public static void main(String[] args)
	{
		// Ejecutamos el metodo start
		launch(args);
	}
}