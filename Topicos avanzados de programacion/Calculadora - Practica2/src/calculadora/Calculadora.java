/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.text.DecimalFormat;

/**
 *
 * @author paulo
 */
public class Calculadora extends JFrame implements ActionListener, KeyListener, WindowListener, MouseListener
{
    JButton btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7,
        btnNum8, btnNum9, btnSuma, btnResta, btnDiv, btnMul, btnMod, btnPunto,
        btnBorrar, btnSigno, btnIgual;
    JTextField txtRes;
    String temp;
    boolean control, controlBorrar, controlIgual;
    double resultado;
    char op;
    DecimalFormat df;
    
    public Calculadora()
    {
        initComponent();
        df = new DecimalFormat("0.00");
        control = true;
        controlBorrar = true;
        controlIgual = false;
        resultado = 0.0;
        op = '+';
        temp = "";
    }
    
    public void initComponent()
    {
        setTitle("Calculadora");
        setSize(240, 350);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        // Objetos
        txtRes = new JTextField("0");
        txtRes.setBounds(0, 0, 240, 50);
        txtRes.setFont(new Font(txtRes.getFont().getName(), Font.BOLD, 36));
        txtRes.setHorizontalAlignment(JTextField.RIGHT);
        txtRes.setEditable(false);
        txtRes.setBackground(Color.white);
        
        // Creamos los botones
        btnBorrar = new JButton("AC");
        btnBorrar.setBounds(0, 50, 60, 60);
        btnBorrar.setBackground(Color.lightGray);
        
        btnSigno = new JButton("+/-");
        btnSigno.setBounds(60, 50, 60, 60);
        btnSigno.setBackground(Color.lightGray);
        
        btnMod = new JButton("%");
        btnMod.setBounds(120, 50, 60, 60);
        btnMod.setBackground(Color.lightGray);
        
        btnDiv = new JButton("/");
        btnDiv.setBounds(180, 50, 60, 60);
        btnDiv.setBackground(Color.orange);
        
        btnNum7 = new JButton("7");
        btnNum7.setBounds(0, 110, 60, 60);
        
        btnNum8 = new JButton("8");
        btnNum8.setBounds(60, 110, 60, 60);
        
        btnNum9 = new JButton("9");
        btnNum9.setBounds(120, 110, 60, 60);
        
        btnMul = new JButton("X");
        btnMul.setBounds(180, 110, 60, 60);
        btnMul.setBackground(Color.orange);
        
        btnNum4 = new JButton("4");
        btnNum4.setBounds(0, 170, 60, 60);
        
        btnNum5 = new JButton("5");
        btnNum5.setBounds(60, 170, 60, 60);
        
        btnNum6 = new JButton("6");
        btnNum6.setBounds(120, 170, 60, 60);
        
        btnResta = new JButton("-");
        btnResta.setBounds(180, 170, 60, 60);
        btnResta.setBackground(Color.orange);
        
        btnNum1 = new JButton("1");
        btnNum1.setBounds(0, 230, 60, 60);
        
        btnNum2 = new JButton("2");
        btnNum2.setBounds(60, 230, 60, 60);
        
        btnNum3 = new JButton("3");
        btnNum3.setBounds(120, 230, 60, 60);
        
        btnSuma = new JButton("+");
        btnSuma.setBounds(180, 230, 60, 60);
        btnSuma.setBackground(Color.orange);
        
        btnNum0 = new JButton("0");
        btnNum0.setBounds(0, 290, 120, 60);
        
        btnPunto = new JButton(".");
        btnPunto.setBounds(120, 290, 60, 60);
        
        btnIgual = new JButton("=");
        btnIgual.setBounds(180, 290, 60, 60);
        btnIgual.setBackground(Color.orange);
        
        // Agregamos objetos
        add(txtRes);
        add(btnBorrar);
        add(btnSigno);
        add(btnMod);
        add(btnDiv);
        add(btnNum7);
        add(btnNum8);
        add(btnNum9);
        add(btnMul);
        add(btnNum4);
        add(btnNum5);
        add(btnNum6);
        add(btnResta);
        add(btnNum1);
        add(btnNum2);
        add(btnNum3);
        add(btnSuma);
        add(btnNum0);
        add(btnPunto);
        add(btnIgual);
        
        // Eventos
        btnNum0.addActionListener(this);
        btnNum1.addActionListener(this);
        btnNum2.addActionListener(this);
        btnNum3.addActionListener(this);
        btnNum4.addActionListener(this);
        btnNum5.addActionListener(this);
        btnNum6.addActionListener(this);
        btnNum7.addActionListener(this);
        btnNum8.addActionListener(this);
        btnNum9.addActionListener(this);
        btnSuma.addActionListener(this);
        btnResta.addActionListener(this);
        btnDiv.addActionListener(this);
        btnMul.addActionListener(this);
        btnMod.addActionListener(this);
        btnPunto.addActionListener(this);
        btnBorrar.addActionListener(this);
        btnSigno.addActionListener(this);
        btnIgual.addActionListener(this);
        txtRes.addMouseListener(this);
        addMouseListener(this);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        // Creamos la ventana
        new Calculadora();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Comprobamos el boton pulsado
        if(e.getSource().equals(btnNum0)){
            if(control){ txtRes.setText("0"); } 
            else { txtRes.setText(txtRes.getText()+"0"); }
            // Reseteamos el resultado
            if(controlIgual){
                resultado = 0.0;
                controlIgual = false;
            }
        } else if(e.getSource().equals(btnNum1)){
            if(control){
                txtRes.setText("1");
                control = false;
            } else { txtRes.setText(txtRes.getText()+"1"); }
            controlBorrar = false;
            // Reseteamos el resultado
            if(controlIgual){
                resultado = 0.0;
                controlIgual = false;
            }
        } else if(e.getSource().equals(btnNum2)){
            if(control){
                txtRes.setText("2");
                control = false;
            } else { txtRes.setText(txtRes.getText()+"2"); }
            controlBorrar = false;
            // Reseteamos el resultado
            if(controlIgual){
                resultado = 0.0;
                controlIgual = false;
            }
        } else if(e.getSource().equals(btnNum3)){
            if(control){
                txtRes.setText("3");
                control = false;
            } else { txtRes.setText(txtRes.getText()+"3"); }
            controlBorrar = false;
            // Reseteamos el resultado
            if(controlIgual){
                resultado = 0.0;
                controlIgual = false;
            }
        } else if(e.getSource().equals(btnNum4)){
            if(control){
                txtRes.setText("4");
                control = false;
            } else { txtRes.setText(txtRes.getText()+"4"); }
            controlBorrar = false;
            // Reseteamos el resultado
            if(controlIgual){
                resultado = 0.0;
                controlIgual = false;
            }
        } else if(e.getSource().equals(btnNum5)){
            if(control){
                txtRes.setText("5");
                control = false;
            } else { txtRes.setText(txtRes.getText()+"5"); }
            controlBorrar = false;
            // Reseteamos el resultado
            if(controlIgual){
                resultado = 0.0;
                controlIgual = false;
            }
        } else if(e.getSource().equals(btnNum6)){
            if(control){
                txtRes.setText("6");
                control = false;
            } else { txtRes.setText(txtRes.getText()+"6"); }
            controlBorrar = false;
            // Reseteamos el resultado
            if(controlIgual){
                resultado = 0.0;
                controlIgual = false;
            }
        } else if(e.getSource().equals(btnNum7)){
            if(control){
                txtRes.setText("7");
                control = false;
            } else { txtRes.setText(txtRes.getText()+"7"); }
            controlBorrar = false;
            // Reseteamos el resultado
            if(controlIgual){
                resultado = 0.0;
                controlIgual = false;
            }
        } else if(e.getSource().equals(btnNum8)){
            if(control){
                txtRes.setText("8");
                control = false;
            } else { txtRes.setText(txtRes.getText()+"8"); }
            controlBorrar = false;
            // Reseteamos el resultado
            if(controlIgual){
                resultado = 0.0;
                controlIgual = false;
            }
        } else if(e.getSource().equals(btnNum9)){
            if(control){
                txtRes.setText("9");
                control = false;
            } else { txtRes.setText(txtRes.getText()+"9"); }
            controlBorrar = false;
            // Reseteamos el resultado
            if(controlIgual){
                resultado = 0.0;
                controlIgual = false;
            }
        } else if(e.getSource().equals(btnBorrar)){
            // Verificamos el control para borrar
            if(controlBorrar){
                // Si no hay un digito o es 0 borramos
                txtRes.setText("0");
                control = true;
                controlBorrar = true;
            } else {
                int n = txtRes.getText().length() - 1;
                // verifiquemos que no contenga un punto
                if(txtRes.getText().contains(".")){
                    // Borramos un solo digito
                    txtRes.setText(txtRes.getText().substring(0, n));
                    // Verificmos si el numero es distinto a 0
                    if(Double.parseDouble(txtRes.getText()) != 0.0){
                        // Borramos
                        control = true;
                        controlBorrar = true;
                        System.out.print("ok");
                    }
                } else {
                    // Verificamos si la cadena esta vacia
                    int count = txtRes.getText().length();
                    if(count == 1){
                        // Borramos todo
                        txtRes.setText("0");
                        control = true;
                        controlBorrar = true;
                    } else {
                        // Borramos un solo digito
                        txtRes.setText(txtRes.getText().substring(0, n));
                    }
                }
            }
        } else if(e.getSource().equals(btnSigno)){
            int n = txtRes.getText().length();
            // Verificamos que este un numero distinto a 0 en pantalla
            if(!control || controlIgual){
                // verificamos que sea distinto a 0
                if(Double.parseDouble(txtRes.getText()) != 0.0){
                    // Verificamos si la expresion ya tiene signo negativo
                    if(txtRes.getText().substring(0, 1).contains("-")){
                        // Quitamos signo negativo
                        txtRes.setText(txtRes.getText().substring(1, n));
                    } else {
                        // Agregamos signo negativo
                        txtRes.setText("-"+txtRes.getText());
                    }
                }
            }
        } else if(e.getSource().equals(btnMod)){
            // Verificamos si hay error
            if(txtRes.getText().contentEquals("ERR MATH")){ txtRes.setText("0"); }
            // Reseteamos los controles
            control = true;
            controlBorrar = true;
            // Obtenemos el valor
            op = '%';
            // verificamos el control igual
            if(controlIgual){
                // Reseteamos
                resultado = 0.0;
                controlIgual = false;
            }
            // Realizamos la operacion
            operacion(Double.parseDouble(txtRes.getText()));
        } else if(e.getSource().equals(btnDiv)){
            // Verificamos si hay error
            if(txtRes.getText().contentEquals("ERR MATH")){ txtRes.setText("0"); }
            // Reseteamos los controles
            control = true;
            controlBorrar = true;
            // Obtenemos el valor
            op = '/';
            // verificamos el control igual
            if(controlIgual){
                // Reseteamos
                resultado = 0.0;
                controlIgual = false;
            }
            // Realizamos la operacion
            operacion(Double.parseDouble(txtRes.getText()));
        } else if(e.getSource().equals(btnMul)){
            // Verificamos si hay error
            if(txtRes.getText().contentEquals("ERR MATH")){ txtRes.setText("0"); }
            // Reseteamos los controles
            control = true;
            controlBorrar = true;
            // Obtenemos el valor
            op = '*';
            // verificamos el control igual
            if(controlIgual){
                // Reseteamos
                resultado = 0.0;
                controlIgual = false;
            }
            // Realizamos la operacion
            operacion(Double.parseDouble(txtRes.getText()));
        } else if(e.getSource().equals(btnResta)){
            // Verificamos si hay error
            if(txtRes.getText().contentEquals("ERR MATH")){ txtRes.setText("0"); }
            // Verificamos que sea distinto a 0
            if(Double.parseDouble(txtRes.getText()) != 0.0){
                // Reseteamos los controles
                control = true;
                controlBorrar = true;
                // Obtenemos el valor
                op = '-';
                // verificamos el control igual
                if(controlIgual){
                    // Reseteamos
                    resultado = 0.0;
                    controlIgual = false;
                }
                // Realizamos la operacion
                operacion(Double.parseDouble(txtRes.getText()));
            } else {
                txtRes.setText("-");
                control = false;
                controlBorrar = false;
            }
        } else if(e.getSource().equals(btnSuma)){
            // Verificamos si hay error
            if(txtRes.getText().contentEquals("ERR MATH")){ txtRes.setText("0"); }
            
            // Reseteamos los controles
            control = true;
            controlBorrar = true;
            // Obtenemos el valor
            op = '+';
            // verificamos el control igual
            if(controlIgual){
                // Reseteamos
                resultado = 0.0;
                controlIgual = false;
            }
            // Realizamos la operacion
            operacion(Double.parseDouble(txtRes.getText()));
        } else if(e.getSource().equals(btnPunto)){
            // Verificamos que no contenga un punto la expresion
            if(!txtRes.getText().contains(".")){
                // Insertamos el punto
                txtRes.setText(txtRes.getText()+".");
                // Cambiamos los estados
                control = false;
                controlBorrar = false;
            }
        } else if(e.getSource().equals(btnIgual)){
            double val = Double.parseDouble(txtRes.getText());
            // Verificamos que resultado sea distinto a 0
            if(resultado != 0.0){
                operacion(val);
                // Verificamos si tiene decimales
                String cad = ""+resultado;
                String[] data = cad.split("\\.");
                if(Double.parseDouble(data[1]) != 0.0){
                    txtRes.setText(""+df.format(resultado));
                } else {
                    int res = (int) resultado;
                    txtRes.setText(""+res);
                    // Verificamos si hay error
                    if(temp.length() > 0){
                        txtRes.setText(temp);
                        temp = "";
                    }
                }
            } else if(op == '/' || op == '*' || op == '%'){
                txtRes.setText("0");
            } else if(op == '+'){
                txtRes.setText(""+val);
            } else {
                txtRes.setText("-"+val);
            }
            // Reseteamos los controles
            control = true;
            controlBorrar = true;
            // cambiamos el estado
            controlIgual = true;
        }
        
        // Control del borrado
        if(controlBorrar){
            btnBorrar.setText("AC");
        } else {
            btnBorrar.setText("C");
        }
    }
    
    public void operacion(double val){
        switch(op){
            case '+':
                resultado += val;
                break;
            case '-':
                if(resultado == 0.0) { resultado += val; }
                else { resultado -= val; }
                break;
            case '*':
                if(resultado == 0.0) { resultado += val; }
                else { resultado *= val; }
                break;
            case '/':
                if(resultado == 0.0) { resultado += val; }
                else { 
                    if(val == 0) {
                        resultado = 0.0;
                        temp = "ERR MATH";
                    } else { resultado /= val; }
                }
                break;
            case '%':
                if(resultado == 0.0) { resultado += val; }
                else { resultado %= val; }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        // Verificamos
        switch(e.getKeyChar()){
            case '0':
                btnNum0.doClick();
                break;
            case '1':
                btnNum1.doClick();
                break;
            case '2':
                btnNum2.doClick();
                break;
            case '3':
                btnNum3.doClick();
                break;
            case '4':
                btnNum4.doClick();
                break;
            case '5':
                btnNum5.doClick();
                break;
            case '6':
                btnNum6.doClick();
                break;
            case '7':
                btnNum7.doClick();
                break;
            case '8':
                btnNum8.doClick();
                break;
            case '9':
                btnNum9.doClick();
                break;
            case '+':
                btnSuma.doClick();
                break;
            case '-':
                btnResta.doClick();
                break;
            case '/':
                btnDiv.doClick();
                break;
            case '*':
                btnMul.doClick();
                break;
            case '%':
                btnMod.doClick();
                break;
            case '.':
                btnPunto.doClick();
                break;
        } 
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        // Code
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        // Al presionar una tecla
        switch(e.getKeyCode()){
            case 8:
                btnBorrar.doClick();
                break;
            case 10:
                btnIgual.doClick();
                break;
            case 16:
                btnSigno.doClick();
                break;
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // code
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // code
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // code
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // code
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // code
    }

    @Override
    public void windowActivated(WindowEvent e) {
        this.requestFocus();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // code
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // code
        this.requestFocus();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // code
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // code
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // code
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // code
    }
}
