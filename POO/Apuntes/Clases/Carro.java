/************************************************************
Clase Carro - Contiene las funcionalidades de un carro

Autor: Paulo Andrade
Fecha: 22/08/2016
nota:
************************************************************/

public class Carro
{
    /*********** atributos ************/
    public String tipo;
    public String color;
    public String marca;
    public int numeroCilindros;
    public int caballosPoder;

    /********** Métodos ***************/

    // Mostramos mensajes de apagado
    public String apagar ()
    {
        return "Carro apagado";
    }
    // Mostramos mensake de avanzando
    public String avanzar ()
    {
        return "Estoy avanzando...";
    }
    // Mostramos mensaje de encendido
    public String encender ()
    {
        return "Carro encendido";
    }
    // Mostramos mensaje de frenar
    public String frenar ()
    {
        return "Estoy frenando...";
    }
    // Mostramos los caballos de poder
    public int getCaballosPoder ()
    {
        return this.caballosPoder;
    }
    // Mostramos el color del carro
    public String getColor ()
    {
        return this.color;
    }
    // Mostramos la marca del carro
    public String getMarca ()
    {
        return this.marca;
    }
    // Mostramos el numero de cilindros del carro
    public int getNumeroCilindros ()
    {
        return numeroCilindros;
    }
    // Mostramos el tipo de carro
    public String getTipo ()
    {
        return this.tipo;
    }
    // Alamacenamos los caballos de poder
    // @param caballosPoder caballos de poder del carro
    public void setCaballosPoder (int caballosPoder)
    {
        this.caballosPoder = caballosPoder;
    }
    // Almacenamos el color del carro
    // @param color color del carro
    public void setColor (String color)
    {
        this.color = color;
    }
    // Almacenamos la marca del carro
    // @param marca marca del carro
    public void setMarca (String marca)
    {
        this.marca = marca;
    }
    // Almacenamos el numero de cilindros del carro
    // @param numeroCilindros numero de cilindros del carro
    public void setNumeroCilindros (int numeroCilindros)
    {
        this.numeroCilindros = numeroCilindros;
    }
    // Alamacenamos el tipo de carro
    // @param tipo tipo de carro
    public void setTipo (String tipo)
    {
        this.tipo = tipo;
    }
}
