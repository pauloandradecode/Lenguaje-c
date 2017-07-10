/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elementosVentanas;

import javax.swing.JButton;

/**
 * Main Class - 
 *
 * @date: 
 * @author Paulo Andrade <source.compu at gmail.com>
 * @email: source.compu@gmail.com
 */
class BotonContador extends JButton
{
	int _pulsaciones;

	// Constructor
	BotonContador()
	{
		super(); // Constructor clase padre
		this._pulsaciones = 0;
	}

	/*
	 * Metodos getter y setter
	 */

	public int getPulsaciones()
	{
		return this._pulsaciones;
	}
	public void setPulsaciones(int pulsaciones)
	{
		this._pulsaciones = pulsaciones;
	}

	/*
	 * Métodos
	 */

	// Aumenta en una cantidad las pulsaciones
	public void aumentar(int pulsaciones)
	{
		this._pulsaciones += pulsaciones;
	}
	// Decrementa las pulsaciones en 1
	public void decrementa()
	{
		if(this._pulsaciones > 0){
			this._pulsaciones--;
		}
	}
	// Disminuye en una cantidad las pulsaciones
	public void disminuir(int pulsaciones)
	{
		if(this._pulsaciones >= pulsaciones)
		{
			this._pulsaciones -= pulsaciones;
		}
	}
	// Incrementa las pulsaciones en 1
	public void incrementa()
	{
		this._pulsaciones++;
	}
	// Reinicia las pulsaciones a 0
	public void reinicia()
	{
		this._pulsaciones = 0;
	}
}
