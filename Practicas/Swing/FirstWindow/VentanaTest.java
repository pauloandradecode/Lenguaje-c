/********************************************************
Test

Autor: Paulo Andrade
Fecha: 01/11/2016
********************************************************/

public class VentanaTest
{
	public static void main(String[] args)
	{
		// Creamos una ventana nueva
		MiVentana v = new MiVentana();
		// Hacemos visible la ventana
		v.setVisible(true);
		// La hacemos no redimensionable
		v.setResizable(false);
	}
}