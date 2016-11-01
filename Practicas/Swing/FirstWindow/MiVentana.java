/********************************************************
Mi primera ventana con swing

Autor: Paulo Andrade
Fecha: 01/11/2016
********************************************************/

import javax.swing.*;

public class MiVentana extends JFrame
{
	// Constructor
	MiVentana()
	{
		// Titulo de la ventana
		super("Titulo de la ventana");
		// Tamaño de la ventana
		setSize(400, 300);
		// Operacion al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}