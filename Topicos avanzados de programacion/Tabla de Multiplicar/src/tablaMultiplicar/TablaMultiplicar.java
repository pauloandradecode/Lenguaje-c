/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablaMultiplicar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author paulo
 */
public class TablaMultiplicar extends JFrame implements ActionListener, KeyListener
{
    JLabel lblNumero;
    JTextField txtNum;
    JButton btnCalcular;
    JPanel pInfo;
    JTextArea res;
    
    public TablaMultiplicar()
    {
        initComponent();
    }

    public void initComponent()
    {
        setTitle("Tabla de multiplicar");
        setSize(400, 400);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        
        // Objetos
        pInfo = new JPanel();
        pInfo.setBounds(10, 10, 380, 100);
        pInfo.setLayout(null);
        pInfo.setBorder(BorderFactory.createTitledBorder("Ingrese valores"));
        pInfo.addKeyListener(this);
        
        lblNumero = new JLabel();
        lblNumero.setText("Número: ");
        lblNumero.setBounds(20, 20, 100, 20);
        
        txtNum = new JTextField();
        txtNum.setBounds(140, 20, 220, 20);
        txtNum.setHorizontalAlignment(JTextField.RIGHT);
        
        btnCalcular = new JButton();
        btnCalcular.setText("Calcular");
        btnCalcular.setBounds(20, 60, 150, 20);
        
        res = new JTextArea();
        res.setBounds(10, 120, 380, 270);
        
        // Agregamos objetos
        add(pInfo);
        pInfo.add(lblNumero);
        pInfo.add(txtNum);
        pInfo.add(btnCalcular);
        add(res);
        
        // Eventos
        txtNum.addKeyListener(this);
        btnCalcular.addActionListener(this);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        // Creamos la ventana
        new TablaMultiplicar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtenemos los valores de las cajas de texto
        int n = Integer.parseInt(txtNum.getText());
        String text = new String("");
        
        // Boton seleccionado
        if(e.getSource().equals(btnCalcular)){
            for(int i = 1; i <= 10; i++){
                text += n +" * "+ i +" = "+ (n*i)+"\n";
            }
        }
        
        res.append(text);
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
