/********************************************************
Componentes para una aplicacion swing

Autor: Paulo Andrade
Fecha: 04/11/2016
********************************************************/

// Importamos la libreria de swing
import javax.swing.*;
import java.awt.*;

public class Componentes extends JFrame
{
	public Componentes()
	{
		super("Titulo de la ventana"); // Titulo para la ventana
		setSize(400, 300); // Tamaño de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Operacion al cerrar

		Container cp = getContentPane(); // Contenedor principal
		cp.setLayout(new FlowLayout()); // Creamos un layout

		JLabel etiqueta = new JLabel("Nombre: "); // Componente etiqueta
		JTextField texto = new JTextField(20); // Componente caja de texto (tamaño 20)
		JButton boton = new JButton("Saludar"); // Componente boton

		// Agregamos los componentes al layout
		cp.add(etiqueta);
		cp.add(texto);
		cp.add(boton);
	}
}