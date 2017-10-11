/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula.general;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Paulo Andrade
 */
public class FormulaGeneral extends JFrame implements ActionListener, KeyListener
{
    JButton btnCalcular, btnSalir;
    JLabel lblNum1, lblNum2, lblNum3, lblRaiz1, lblRaiz2;
    JTextField txtNum1, txtNum2, txtNum3, txtRaiz1, txtRaiz2, txtRaiz3;
    JPanel ingreso, salida;
    DecimalFormat df;
    
    public FormulaGeneral()
    {
        initComponent();
        df = new DecimalFormat("0.0000");
    }

    public void initComponent()
    {
        setTitle("Formula general");
        setSize(300, 340);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        
        // Objetos
        ingreso = new JPanel();
        ingreso.setBounds(10, 10, 280, 150);
        ingreso.setLayout(null);
        ingreso.setBorder(BorderFactory.createTitledBorder("Ingrese valores"));
        ingreso.addKeyListener(this);
        
        salida = new JPanel();
        salida.setBounds(10, 180, 280, 110);
        salida.setLayout(null);
        salida.setBorder(BorderFactory.createTitledBorder("Resultados"));
        salida.addKeyListener(this);
        
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(60, 300, 120, 20);
        
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(200, 300, 90, 20);
        
        lblNum1 = new JLabel("A: ");
        lblNum1.setBounds(20, 30, 70, 20);
        
        lblNum2 = new JLabel("B: ");
        lblNum2.setBounds(20, 70, 70, 20);
        
        lblNum3 = new JLabel("C: ");
        lblNum3.setBounds(20, 110, 70, 20);
        
        lblRaiz1 = new JLabel("Raiz 1: ");
        lblRaiz1.setBounds(20, 30, 70, 20);
        
        lblRaiz2 = new JLabel("Raiz 2: ");
        lblRaiz2.setBounds(20, 70, 70, 20);
        
        txtNum1 = new JTextField();
        txtNum1.setBounds(110, 30, 150, 20);
        txtNum1.setHorizontalAlignment(JTextField.RIGHT);
        
        txtNum2 = new JTextField();
        txtNum2.setBounds(110, 70, 150, 20);
        txtNum2.setHorizontalAlignment(JTextField.RIGHT);
        
        txtNum3 = new JTextField();
        txtNum3.setBounds(110, 110, 150, 20);
        txtNum3.setHorizontalAlignment(JTextField.RIGHT);
        
        txtRaiz1 = new JTextField();
        txtRaiz1.setBounds(110, 30, 150, 20);
        txtRaiz1.setHorizontalAlignment(JTextField.RIGHT);
        txtRaiz1.setEditable(false);
        
        txtRaiz2 = new JTextField();
        txtRaiz2.setBounds(110, 70, 150, 20);
        txtRaiz2.setHorizontalAlignment(JTextField.RIGHT);
        txtRaiz2.setEditable(false);
        
        // Añadimos objetos
        add(ingreso);
        ingreso.add(lblNum1);
        ingreso.add(lblNum2);
        ingreso.add(lblNum3);
        ingreso.add(txtNum1);
        ingreso.add(txtNum2);
        ingreso.add(txtNum3);
        add(salida);
        salida.add(lblRaiz1);
        salida.add(lblRaiz2);
        salida.add(txtRaiz1);
        salida.add(txtRaiz2);
        add(btnSalir);
        add(btnCalcular);
        
        // Eventos
        btnSalir.addActionListener(this);
        btnCalcular.addActionListener(this);
        txtNum1.addKeyListener(this);
        txtNum2.addKeyListener(this);
        txtNum3.addKeyListener(this);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        // Creamos la ventana
        new FormulaGeneral();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtenemos los valores de las cajas de texto
        double a = Double.parseDouble(txtNum1.getText());
        double b = Double.parseDouble(txtNum2.getText());
        double c = Double.parseDouble(txtNum3.getText());
        
        // Comprobamos que boton fue pulsado
        if(e.getSource().equals(btnSalir)){
            System.exit(0);
        } else if(e.getSource().equals(btnCalcular)){
            double raiz = pow(b, 2) - (4*a*c);
            
            // Verificamos si es negativa
            if(raiz < 0){
                txtRaiz1.setText("ERR MATH");
                txtRaiz2.setText("ERR MATH");
            } else {
                double r1 = (-b + sqrt(raiz))/(2*a);
                double r2 = (-b - sqrt(raiz))/(2*a);
                txtRaiz1.setText("" + df.format(r1));
                txtRaiz2.setText("" + df.format(r2));
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        // Obtenemos la tecla presiona
        char key = e.getKeyChar();
        
        // Verificamos que solo sean numeros
        if(Character.isLetter(key)){
            getToolkit().beep();
            
            // No procesamos la info
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        // Al presionar una tecla
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        // Al soltar la tecla presionada
    }
    
}
