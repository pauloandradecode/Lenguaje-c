/********************************************************
Componente con evento

Autor: Paulo Andrade
Fecha: 04/11/2016
********************************************************/

// Importamos la libreria de swing
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class BotonVentana extends JFrame
{
	public BotonVentana()
	{
		super("Boton"); // Titulo de la ventana
		setSize(200, 100); // Definimos el tamaño de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Accion de cierre

		Container cp = getContentPane(); // Contenedor principal
		cp.setLayout(new FlowLayout()); // Añadimos un layout al contenedor

		JButton boton = new JButton("Pulsame"); // Componente
		// Añadimos un evento al boton
		boton.addActionListener(new EventoBotonPulsado());

		cp.add(boton); // Añadimos el boton al contenedor
	}
}