/********************************************************
Test

Autor: Paulo Andrade
Fecha: 04/11/2016
********************************************************/

public class TestVentana
{
	public static void main(String[] args)
	{
		// Creamos una ventana nueva
		Ventana v = new Ventana();
		// Hacemos visible la ventana
		v.setVisible(true);
		// La hacemos no redimensionable
		v.setResizable(false);
	}
}