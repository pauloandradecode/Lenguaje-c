/********************************************************
Primera ventana con swing

Autor: Paulo Andrade
Fecha: 01/11/2016
********************************************************/

// Importamos la libreria swing
import javax.swing.*;

// clase que extiende de jfram para ventana principal
public class HolaMundo extends JFrame
{
	// Etiquetas
	private JLabel texto1, texto2;

	// Constructor
	HolaMundo()
	{
		// Utilizamos una ventana con layout libre
		setLayout(null);

		// Cremoas dos componentes
		texto1 = new JLabel("Hola mundo");
		texto2 = new JLabel("Mi primera aplicacion con swing");

		// Agregamos las dimensiones
		texto1.setBounds(100, 100, 200, 40);
		texto2.setBounds(70, 140, 200, 40);

		// Agregamos los componentes al layout
		add(texto1);
		add(texto2);
	}

	// Metodo principal
	public static void main(String[] args)
	{
		// Cremoas la ventana
		HolaMundo ventana = new HolaMundo();

		// Agregamos las dimensiones
		ventana.setBounds(500, 250, 300, 250);
		// La hacemos visible
		ventana.setVisible(true);
		// La ventana no se puede redimencionar
		ventana.setResizable(false);
	}
}