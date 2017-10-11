/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycalcu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author paulo
 */
public class MyCalcu extends JFrame implements ActionListener
{
    private JLabel n1, n2, res;
    private JButton btnSumar, btnRestar, btnSalir;
    private JTextField txtn1, txtn2, txtRes;
    
    public MyCalcu()
    {
        initComponent();
    }
    
    public void initComponent()
    {
        // Propiedades de la ventana
        setTitle("Calculadora");
        setLayout(null);
        
        // Objetos
        n1 = new JLabel("Numero 1");
        n1.setBounds(10, 10, 100, 20);
        txtn1 = new JTextField("0");
        txtn1.setBounds(120, 10, 100, 20);
        txtn1.setHorizontalAlignment(JTextField.RIGHT);
        
        n2 = new JLabel("Numero 2");
        n2.setBounds(10, 40, 100, 20);
        txtn2 = new JTextField("0");
        txtn2.setBounds(120, 40, 100, 20);
        txtn2.setHorizontalAlignment(JTextField.RIGHT);
        
        res = new JLabel("Resultado");
        res.setBounds(10, 70, 100, 20);
        txtRes = new JTextField();
        txtRes.setBounds(120, 70, 100, 20);
        txtRes.setEnabled(false);
        txtRes.setHorizontalAlignment(JTextField.RIGHT);
        
        btnSumar = new JButton();
        btnSumar.setText("Sumar");
        btnSumar.setBounds(10, 100, 90, 20);
        
        btnRestar = new JButton();
        btnRestar.setText("Restar");
        btnRestar.setBounds(110, 100, 90, 20);
        
        btnSalir = new JButton();
        btnSalir.setText("Salir");
        btnSalir.setBounds(210, 100, 90, 20);
        
        // Añadimos los objetos
        add(n1);
        add(txtn1);
        add(n2);
        add(txtn2);
        add(res);
        add(txtRes);
        add(btnSumar);
        add(btnRestar);
        add(btnSalir);
        
        // Agregamos eventos a los botones
        btnSumar.addActionListener(this);
        btnRestar.addActionListener(this);
        btnSalir.addActionListener(this);
        
        setSize(310, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyCalcu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtenemos los valores de las cajas de texto
        int n1 = Integer.parseInt(txtn1.getText());
        int n2 = Integer.parseInt(txtn2.getText());
        
        // Verificamos que boton se pulso
        if(e.getSource().equals(btnSumar)){
            txtRes.setText(Integer.toString((n1 + n2)));
        } else if(e.getSource().equals(btnRestar)){
            txtRes.setText(Integer.toString((n1 - n2)));
        } else if(e.getSource().equals(btnSalir)){
            System.exit(0);
        }
    }
}
