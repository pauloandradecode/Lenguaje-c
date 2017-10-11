/*
 * Panel para la pagina principal
 */

package principal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
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
import javax.swing.SwingConstants;

/**
 *
 * @author Paulo Andrade
 */

public class MainPanel extends JPanel implements MouseListener
{
    Aritmetica _root; // Frame princial
    JLabel lblInstruccion;
    JButton btnSuma, btnResta, btnDivision, btnMultiplicacion;
    ImageIcon icoSuma, icoResta, icoDivision, icoMultiplicacion;
    
    // Constructor
    public MainPanel(Aritmetica frame)
    {
        super(); // Constructor padre
        _root = frame;
        initComponent();
    }
    
    // Inicializamos los componentes
    public void initComponent()
    {
        // Componente principal
        setSize(760, 560);
        setBackground(Color.white);
        // this.setBorder(BorderFactory.createLoweredBevelBorder());
        setLayout(null);
        
        // Componentes
        String txt = "Seleccione una operación aritmética";
        lblInstruccion = new JLabel(txt, SwingConstants.CENTER);
        lblInstruccion.setBounds(10, 10, 740, 40);
        lblInstruccion.setFont(new Font(lblInstruccion.getFont().getName(), Font.BOLD, 30));
        
        icoSuma = new ImageIcon("suma.png");
        icoResta = new ImageIcon("resta.png");
        icoDivision = new ImageIcon("div_1.png");
        icoMultiplicacion = new ImageIcon("mul.png");
        
        btnSuma = new JButton();
        btnSuma.setBounds(10, 60, 370, 245);
        btnSuma.setIcon(icoSuma);
        btnSuma.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSuma.setBorderPainted(false);
        
        btnResta = new JButton();
        btnResta.setBounds(380, 60, 370, 245);
        btnResta.setIcon(icoResta);
        btnResta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnResta.setBorderPainted(false);
        
        btnDivision = new JButton();
        btnDivision.setBounds(10, 305, 370, 245);
        btnDivision.setIcon(icoDivision);
        btnDivision.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDivision.setBorderPainted(false);
        
        btnMultiplicacion = new JButton();
        btnMultiplicacion.setBounds(380, 305, 370, 245);
        btnMultiplicacion.setIcon(icoMultiplicacion);
        btnMultiplicacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMultiplicacion.setBorderPainted(false);
        
        // Añadimos componentes
        add(lblInstruccion);
        add(btnSuma);
        add(btnResta);
        add(btnDivision);
        add(btnMultiplicacion);
        
        // Añadimos eventos
        btnSuma.addMouseListener(this);
        btnResta.addMouseListener(this);
        btnDivision.addMouseListener(this);
        btnMultiplicacion.addMouseListener(this);
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
    public void mouseClicked(MouseEvent e) {
        // Verificamos que boton fue seleccionado
        if(e.getSource().equals(btnSuma)){
            _root.cardLayout.show(_root.panel, "sumaPanel");
        } else if(e.getSource().equals(btnResta)){
            _root.cardLayout.show(_root.panel, "restaPanel");
        } else if(e.getSource().equals(btnDivision)){
            _root.cardLayout.show(_root.panel, "divPanel");
        } else if(e.getSource().equals(btnMultiplicacion)){
            _root.cardLayout.show(_root.panel, "mulPanel");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        play("enter");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // code
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        play("select");
        
        if(e.getSource().equals(btnSuma)){
            btnSuma.setBorderPainted(true);
        } else if(e.getSource().equals(btnResta)){
            btnResta.setBorderPainted(true);
        } else if(e.getSource().equals(btnDivision)){
            btnDivision.setBorderPainted(true);
        } else if(e.getSource().equals(btnMultiplicacion)){
            btnMultiplicacion.setBorderPainted(true);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource().equals(btnSuma)){
            btnSuma.setBorderPainted(false);
        } else if(e.getSource().equals(btnResta)){
            btnResta.setBorderPainted(false);
        } else if(e.getSource().equals(btnDivision)){
            btnDivision.setBorderPainted(false);
        } else if(e.getSource().equals(btnMultiplicacion)){
            btnMultiplicacion.setBorderPainted(false);
        }
    }
}
