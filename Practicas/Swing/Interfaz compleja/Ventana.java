/********************************************************
Creando una interfaz compleja

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
		super("Añadir usuario"); // Titulo para la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Operacion al cerrar

		// Panel para fecha
		JPanel panelFecha = new JPanel(); // Creamos un panel
		panelFecha.setLayout(new FlowLayout()); // Añadimos un layout al panel
		panelFecha.add(new JTextField(2)); // Componente
		panelFecha.add(new JLabel("/")); // Componente
		panelFecha.add(new JTextField(2)); // Componente
		panelFecha.add(new JLabel("/")); // Componente
		panelFecha.add(new JTextField(2)); // Componente

		// Panel de datos
		JPanel panelDatos = new JPanel(); // Creamos un panel
		GridLayout gl = new GridLayout(3, 2, 0, 5); // Rejilla
		panelDatos.setLayout(gl); // Añadimos un layout al panel
		panelDatos.add(new JLabel("Nombre: ")); // Componente
		panelDatos.add(new JTextField(10)); // Componente
		panelDatos.add(new JLabel("DNI: ")); // Componente
		panelDatos.add(new JTextField(10)); // Componente
		panelDatos.add(new JLabel("Fecha nacimiento: ")); // Componente
		panelDatos.add(panelFecha); // Añadimos el panel fecha

		// Panel de botones
		JPanel panelBotones = new JPanel(); // Creamos un panel
		panelBotones.setLayout(new FlowLayout()); // Añadimos un layout al panel
		panelBotones.add(new JButton("Aceptar")); // Componente
		panelBotones.add(new JButton("Cancelar")); // Componente

		// Cremoas el contenedor
		Container cp = getContentPane();
		// Agregamos el panel datos al centro
		cp.add(panelDatos, BorderLayout.CENTER);
		// Agregamos el panel de otones abajo
		cp.add(panelBotones, BorderLayout.SOUTH);
	}
}