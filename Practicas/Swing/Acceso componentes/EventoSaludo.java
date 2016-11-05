/********************************************************
Evento para componente

Autor: Paulo Andrade
Fecha: 04/11/2016
********************************************************/

// Importamos la libreria de swing
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class EventoSaludo implements ActionListener
{
	private JTextField cuadroTexto;

	// Constructor
	public EventoSaludo(JTextField cuadroTexto)
	{
		// Asignamos el valor del cuadro de texto
		this.cuadroTexto = cuadroTexto;
	}

	// Evento
	public void actionPerformed(ActionEvent e)
	{
		// Mostramos una caja de dialogo con mensaje
		JOptionPane.showMessageDialog(null, "Hola " + cuadroTexto.getText() + "!");
	}
}