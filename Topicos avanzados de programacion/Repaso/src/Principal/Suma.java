/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author paulo
 */
public class Suma
{
    private int num1,
                num2;
    
    public Suma()
    {
        num1 = 0;
        num2 = 0;
    }
    
    /*
    Metodos getter y setter
    */

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
    
    /*
    Metodos
    */
    public int suma()
    {
        return num1 + num2;
    }
}
