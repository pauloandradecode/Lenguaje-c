/********************************************************
Ventana principal

Autor: Paulo Andrade
Fecha: 04/11/2016
********************************************************/

// Importamos la libreria de swing
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame
{
	// Constructor
	public Ventana()
	{
		super("Titulo de la ventana"); // titulo de la ventana
		setSize(400, 300); // Tamañp de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Operacion de cierre
		setLayout(new FlowLayout()); // Asignamos un layout a la ventana

		Container cp = getContentPane(); // Contenedor principal

		cp.add(new JLabel("Nombre: ")); // Componente
		JTextField texto = new JTextField(20); // Componente
		cp.add(texto); // Agregamos componente
		JButton botonSaludo = new JButton("Saludar"); // Componente
		cp.add(botonSaludo); // Agregamos componente

		// Añadimos evento
		botonSaludo.addActionListener(new EventoSaludo(texto));
	}
}