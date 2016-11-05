/********************************************************
Test

Autor: Paulo Andrade
Fecha: 04/11/2016
********************************************************/

public class TestBotonVentana
{
	public static void main(String[] args)
	{
		// Creamos una ventana nueva
		BotonVentana v = new BotonVentana();
		// Hacemos visible la ventana
		v.setVisible(true);
		// La hacemos no redimensionable
		v.setResizable(false);
	}
}