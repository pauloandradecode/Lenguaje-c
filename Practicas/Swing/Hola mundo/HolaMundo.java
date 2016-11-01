/********************************************************
Primera ventana con swing

Autor: Paulo Andrade
Fecha: 01/11/2016
********************************************************/

// Importamos la libreria swing
import javax.swing.*;

public class HolaMundo extends JFrame
{
	private JLabel texto1, texto2;

	// Constructor
	HolaMundo()
	{
		setLayout(null);

		texto1 = new JLabel("Hola mundo");
		texto2 = new JLabel("Mi primera aplicacion con swing");

		texto1.setBounds(100, 100, 200, 40);
		texto2.setBounds(70, 140, 200, 40);

		add(texto1);
		add(texto2);
	}

	// Metodo principal
	public static void main(String[] args)
	{
		HolaMundo ventana = new HolaMundo();

		ventana.setBounds(500, 250, 300, 250);
		ventana.setVisible(true);
		ventana.setResizable(false);
	}
}