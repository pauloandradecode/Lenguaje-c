/**********************************************
* Programa 5 - Practica 1
* Fecha: 18/04/2016
* Nombre: Circulo
**********************************************/

import java.util.Scanner; //Importación del código de la clase Scanner desde la biblioteca Java
import java.text.DecimalFormat; // Para limitar el numero de decimales

public class Circulo
{
    private static double radio;
    private static double diametro;
    private static double area;
    private static double perimetro;
    private static double PI = 3.1416;

    public static void main(String[] args)
    {
        // Instanciamos un objeto de DecimalFormat y le asignamos 2 decimales
        DecimalFormat df = new DecimalFormat("0.00");

        // Ingresamos el radio del circulo
        System.out.print("Ingrese el radio del circulo: ");
        radio = lee();

        // Realizamos la operaciones
        diametro = radio * 2;
        area = PI * (radio * radio);
        perimetro = 2 * PI * radio;

        // Mostramos los resultados
        System.out.println("Diametro: "+df.format(diametro));
        System.out.println("Perimetro: "+df.format(perimetro));
        System.out.println("Area: "+df.format(area));
    }
    public static double lee()
    {
        // Declaramos variables locales
        double x;
        String data;

        // Leemos
        Scanner cin = new Scanner(System.in); //Creación de un objeto Scanner
        data = cin.nextLine(); //Invocamos un método sobre un objeto Scanner
        x = Double.parseDouble(data); // Convertimos de String a int

        return x;
    }
}