/*
 * Panel para operaciones
 */

package principal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import static java.lang.Math.random;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Paulo Andrade
 */
public class MulPanel extends JPanel implements ActionListener, KeyListener, MouseListener
{
    Aritmetica root; // Frame principal
    JLabel lblInstruccion, lblNum1, lblNum2, lblSigno, lblIgual;
    JTextField txtRes;
    JButton btnValidar, btnNext;
    ImageIcon icoValidar, icoNext;
    int num1, num2, numRes;
    
    public MulPanel(Aritmetica frame)
    {
        super(); // constructor padre
        root = frame;
        num1 = (int) (random() * 9) + 1; // Generamos numeros aleatorios
        num2 = (int) (random() * 9) + 1;
        numRes = num1 * num2; // Resultado a obtener
        
        initComponent();
    }
    
    // Inicializamos los componentes
    public void initComponent()
    {
        // Componente principal
        setSize(760, 560);
        setBackground(Color.white);
        setLayout(null);
        
        // Componentes
        icoValidar = new ImageIcon("validar.png");
        icoNext = new ImageIcon("siguiente.png");
        
        String txt = "Multiplicación " + Aritmetica.ctrSuma + " de " + 5;
        lblInstruccion = new JLabel(txt, SwingConstants.CENTER);
        lblInstruccion.setBounds(10, 10, 740, 40);
        lblInstruccion.setFont(new Font(lblInstruccion.getFont().getName(), Font.BOLD, 30));
        
        lblNum1 = new JLabel(""+num1, SwingConstants.CENTER);
        lblNum1.setBounds(10, 100, 130, 150);
        lblNum1.setFont(new Font(lblInstruccion.getFont().getName(), Font.BOLD, 140));
        lblNum1.setForeground(Color.GRAY);
        
        lblSigno = new JLabel("x", SwingConstants.CENTER);
        lblSigno.setBounds(140, 100, 130, 150);
        lblSigno.setFont(new Font(lblInstruccion.getFont().getName(), Font.BOLD, 140));
        lblSigno.setForeground(Color.red);
        
        lblNum2 = new JLabel(""+num2, SwingConstants.CENTER);
        lblNum2.setBounds(270, 100, 130, 150);
        lblNum2.setFont(new Font(lblInstruccion.getFont().getName(), Font.BOLD, 140));
        lblNum2.setForeground(Color.blue);
        
        lblIgual = new JLabel("=", SwingConstants.CENTER);
        lblIgual.setBounds(400, 100, 130, 150);
        lblIgual.setFont(new Font(lblInstruccion.getFont().getName(), Font.BOLD, 140));
        lblIgual.setForeground(Color.red);
        
        txtRes = new JTextField("", 2);
        txtRes.setBounds(530, 100, 220, 150);
        txtRes.setFont(new Font(lblInstruccion.getFont().getName(), Font.BOLD, 140));
        txtRes.setHorizontalAlignment(JTextField.CENTER);
        txtRes.setBackground(Color.white);
        txtRes.setForeground(Color.orange);
        txtRes.setFocusable(true);
        txtRes.requestFocusInWindow();
        
        btnValidar = new JButton();
        btnValidar.setBounds(130, 300, 500, 150);
        btnValidar.setIcon(icoValidar);
        btnValidar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnValidar.setBorderPainted(false);
        
        btnNext = new JButton();
        btnNext.setBounds(550, 480, 200, 70);
        btnNext.setIcon(icoNext);
        btnNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNext.setBorderPainted(false);
        
        // añadimos elementos
        add(lblInstruccion);
        add(lblNum1);
        add(lblSigno);
        add(lblNum2);
        add(lblIgual);
        add(txtRes);
        add(btnValidar);
        add(btnNext);
        
        // Eventos
        txtRes.addKeyListener(this);
        btnValidar.addMouseListener(this);
        btnValidar.addActionListener(this);
        btnNext.addMouseListener(this);
        btnNext.addActionListener(this);
    }
    
    // Reproduciomos el sonido
    public void play(String value)
    {       
        try {
            
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(value+".wav"));
            AudioFormat format = inputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip)AudioSystem.getLine(info);
            clip.open(inputStream);
            clip.start();
        }catch(Exception ex){
            System.err.println( ex.getMessage() );
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        
        if(txtRes.getText().length() < 2){
            if(Character.isLetter(key)){
                getToolkit().beep();

                e.consume();
            }
        } else {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // code
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Al presionar una tecla
        switch(e.getKeyCode()){
            case 10:
                btnValidar.doClick();
                break;
            case 39:
                btnNext.doClick();
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // code
        if(e.getSource().equals(btnNext)){
            play("enter");
        }
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
        play("select");
        
        if(e.getSource().equals(btnValidar)){
            btnValidar.setBorderPainted(true);
        } else if(e.getSource().equals(btnNext)){
            btnNext.setBorderPainted(true);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource().equals(btnValidar)){
            btnValidar.setBorderPainted(false);
        } else if(e.getSource().equals(btnNext)){
            btnNext.setBorderPainted(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtenemos el resultado
        int res;
        if(txtRes.getText().length() > 0){
            res = Integer.parseInt(txtRes.getText());
        } else {
            res = 0;
        }
        
        if(e.getSource().equals(btnValidar)){
            if(numRes == res){
                play("win");
                setBackground(Color.green);
            } else {
                play("wrong");
                setBackground(Color.MAGENTA);
            }
        } else if(e.getSource().equals(btnNext)){
            // aumentamos
            Aritmetica.ctrSuma++;
            Aritmetica.control = "mul";
            if(numRes == res){
                Aritmetica.ctrBien++;
            } else {
                Aritmetica.ctrMal++;
            }
            
            // Pasamos a la siguiente
            if(Aritmetica.ctrSuma <= 5){
                reset();
            } else {
                root.cardLayout.removeLayoutComponent(root.pnRes);
                root.createResPanel();
                root.panel.add(root.pnRes, "resPanel");
                root.cardLayout.show(root.panel, "resPanel");
            }
        }
    }
    
    // Reseteamos el panel
    public void reset()
    {
        String txt = "Multiplicación " + Aritmetica.ctrSuma + " de " + 5;
        lblInstruccion.setText(txt);
        num1 = (int) (random() * 9) + 1; // Generamos numeros aleatorios
        num2 = (int) (random() * 9) + 1;
        numRes = num1 * num2;
        lblNum1.setText(""+num1);
        lblNum2.setText(""+num2);
        txtRes.setText("");
        txtRes.grabFocus();
        setBackground(Color.white);
    }
}
