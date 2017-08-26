/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class Calculadora extends JFrame implements ActionListener, KeyListener
{
    JButton btnSuma, btnResta, btnDivision, btnMultiplicacion, btnSalir;
    JLabel lblNum1, lblNum2, lblRes;
    JTextField txtNum1, txtNum2, txtRes;
    JPanel ingreso;
    DecimalFormat df;
    
    public Calculadora()
    {
        initComponent();
        df = new DecimalFormat("0.00");
    }

    public void initComponent()
    {
        setTitle("Calculadora");
        setSize(300, 240);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        
        // Objetos
        ingreso = new JPanel();
        ingreso.setBounds(10, 10, 280, 150);
        ingreso.setLayout(null);
        ingreso.setBorder(BorderFactory.createTitledBorder("Calculadora"));
        ingreso.addKeyListener(this);
        
        btnSuma = new JButton("Sumar");
        btnSuma.setBounds(10, 180, 120, 20);
        
        btnResta = new JButton("Restar");
        btnResta.setBounds(170, 180, 120, 20);
        
        btnDivision = new JButton("Dividir");
        btnDivision.setBounds(10, 210, 120, 20);
        
        btnMultiplicacion = new JButton("Multiplicar");
        btnMultiplicacion.setBounds(170, 210, 120, 20);
        
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(10, 10, 90, 20);
        
        lblNum1 = new JLabel("Numero 1: ");
        lblNum1.setBounds(10, 30, 100, 20);
        
        lblNum2 = new JLabel("Numero 2: ");
        lblNum2.setBounds(10, 60, 100, 20);
        
        lblRes = new JLabel("resultado: ");
        lblRes.setBounds(10, 90, 100, 20);
        
        txtNum1 = new JTextField("0");
        txtNum1.setBounds(120, 30, 100, 20);
        txtNum1.setHorizontalAlignment(JTextField.RIGHT);
        
        txtNum2 = new JTextField("0");
        txtNum2.setBounds(120, 60, 100, 20);
        txtNum2.setHorizontalAlignment(JTextField.RIGHT);
        
        txtRes = new JTextField();
        txtRes.setBounds(120, 90, 100, 20);
        txtRes.setHorizontalAlignment(JTextField.RIGHT);
        txtRes.setEditable(false);
        
        // Añadimos objetos
        add(ingreso);
        ingreso.add(lblNum1);
        ingreso.add(txtNum1);
        ingreso.add(lblNum2);
        ingreso.add(txtNum2);
        ingreso.add(lblRes);
        ingreso.add(txtRes);
        add(btnSuma);
        add(btnResta);
        add(btnDivision);
        add(btnMultiplicacion);
        // add(btnSalir);
        
        // Eventos
        btnSuma.addActionListener(this);
        btnResta.addActionListener(this);
        btnDivision.addActionListener(this);
        btnMultiplicacion.addActionListener(this);
        btnSalir.addActionListener(this);
        txtNum1.addKeyListener(this);
        txtNum2.addKeyListener(this);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        // Creamos la ventana
        new Calculadora();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtenemos los valores de las cajas de texto
        Float num1 = Float.parseFloat(txtNum1.getText());
        Float num2 = Float.parseFloat(txtNum2.getText());
        
        // Comprobamos que boton fue pulsado
        if(e.getSource().equals(btnSuma)){
            txtRes.setText(df.format(num1 + num2));
        } else if(e.getSource().equals(btnResta)){
            txtRes.setText(df.format(num1 - num2));
        } else if(e.getSource().equals(btnDivision)){
            // Verificamos la división entre 0
            if(num2 == 0){
                txtRes.setText("ERR MATH");
            } else {
                txtRes.setText(df.format(num1 / num2));
            }
        } else if(e.getSource().equals(btnMultiplicacion)) {
            txtRes.setText(df.format(num1 * num2));
        } else if(e.getSource().equals("btnSalir")){
            System.exit(0);
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
