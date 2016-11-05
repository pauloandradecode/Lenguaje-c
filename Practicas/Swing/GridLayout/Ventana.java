/********************************************************
Layout en forma de rejilla

Autor: Paulo Andrade
Fecha: 04/11/2016
********************************************************/

// Importamos la libreria de swing
import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame
{
	public Ventana()
	{
		super("Usando GridLayout"); // Titulo para la ventana
		setSize(400, 300); // Tamaño de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Operacion al cerrar

		Container cp = getContentPane(); // Contenedor principal
		GridLayout gl = new GridLayout(4, 3); // Creamos una rejilla de 4 filas y 3 columnas
		gl.setHgap(5); // Espacio horizontal entre filas
		gl.setVgap(5); // Espacio vertical entre columnas
		cp.setLayout(gl); // Agregamos el layout al contenedor

		for(int i = 1; i <= 9; i++){
			// Creamos los componentes
			cp.add(new JButton(String.valueOf(i)));
		}

		// Agregamos mas componentes al layout
		cp.add(new JButton("*"));
		cp.add(new JButton("0"));
		cp.add(new JButton("#"));
	}
}