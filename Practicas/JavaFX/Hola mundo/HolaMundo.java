/********************************************************
Evento para componente

Autor: Paulo Andrade
Fecha: 04/11/2016
********************************************************/

// Importamos la libreria de javaFX
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// Clase principal de la aplicacion
public class HolaMundo extends Application
{
	// Punto principal del programa
	public void start(Stage stage)
	{
		Button boton = new Button(); // Componente
		boton.setText("Di hola mundo"); // Texto del boton
		// Añadimos un evento
		boton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e)
			{
				System.out.println("Hola mundo!");
			}
		});

		StackPane layout = new StackPane(); // Nodo raiz
		layout.getChildren().add(boton);
		Scene escena = new Scene(layout, 300, 250);

		stage.setTitle("Hola mundo!"); // Titulo
		stage.setScene(escena); // Agregamos la escena
		stage.show(); // Hacemos visible la escena
	}

	// Metodo principal
	public static void main(String[] args)
	{
		// Iniciamos la aplicacion
		launch(args);
	}
}