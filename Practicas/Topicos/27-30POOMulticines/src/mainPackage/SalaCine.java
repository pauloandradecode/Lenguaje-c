/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainPackage;

/**
 * SalaCine - Clase para salas de cine
 *
 * @date: 
 * @author Paulo Andrade <source.compu at gmail.com>
 * @email: source.compu@gmail.com
 */
public class SalaCine
{
    // Propiedades
    int _aforo;
    int _ocupadas;
    String _pelicula;
    Double _entrada;
    
    // Constructor
    SalaCine()
    {
        this._aforo = 100;
        this._ocupadas = 0;
        this._pelicula = "";
        this._entrada = 5.0;
    }
    
    /*
     * Metodos getter y setter
    */
    
    public int getAforo()
    {
        return this._aforo;
    }
    public Double getEntrada()
    {
        return this._entrada;
    }
    public double getIngresos()
    {
        return (double) this._ocupadas * this._entrada;
    }
    public int getLibres()
    {
        return this._aforo - this._ocupadas;
    }
    public double getPorcentajes()
    {
        return (double) this._ocupadas / (double) this._aforo * 100.0;
    }
    public int getOcupadas()
    {
        return this._ocupadas;
    }
    public String getPelicula()
    {
        return this._pelicula;
    }
    public void setAforo(int aforo)
    {
        this._aforo = aforo;
    }
    public void setEntrada(Double entrada)
    {
        this._entrada = entrada;
    }
    public void setLibres(int libres)
    {
        this._ocupadas = this._aforo - libres;
    }
    public void setOcupadas(int ocupadas)
    {
        this._ocupadas = ocupadas;
    }
    public void setPelicula(String pelicula)
    {
        this._pelicula = pelicula;
    }
    
    /*
     * Metodos
    */
    
    // Indicamos que entra una persona a la sala
    public boolean entraUno()
    {
        // Verificamos que no exceda el limite
        if(this._aforo > this._ocupadas){
            this._ocupadas++;
            
            return true;
        }
        
        return false;
    }
    // Limpiamos la pelicula y reseteamos las butacas ocupadas
    public void vaciar()
    {
        // Limpiamos la pelicula
        this._pelicula = "";
        
        // Reseteamos el numero de butacas ocupadas
        this._ocupadas = 0;
    }
}
