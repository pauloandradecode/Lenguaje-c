/*
 * Panel para resultados
 */

package principal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static principal.Aritmetica.control;

/**
 *
 * @author Paulo Andrade
 */
public class ResPanel extends JPanel implements ActionListener, MouseListener
{
    Aritmetica root; // Frame principal
    JLabel lblInstruccion, lblRes, lblicon;
    JButton btnNuevo, btnReiniciar;
    ImageIcon icon;
    
    // Constructor
    public ResPanel(Aritmetica frame)
    {
        super(); // constructor padre
        root = frame;
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
        String txt = "Obtuviste "+Aritmetica.ctrBien+" de 5 bien";
        lblInstruccion = new JLabel(txt, SwingConstants.CENTER);
        lblInstruccion.setBounds(10, 10, 740, 40);
        lblInstruccion.setFont(new Font(lblInstruccion.getFont().getName(), Font.BOLD, 30));
        
        if(Aritmetica.ctrBien > 3){
            txt = "Bien hecho!!!";
            icon = new ImageIcon("bien.png");
        } else if(Aritmetica.ctrBien == 3){
            txt = "Puedes mejorar...";
            icon = new ImageIcon("medio.png");
        } else if(Aritmetica.ctrBien < 3){
            txt = "Sigue practicando!";
            icon = new ImageIcon("mal.png");
        }
        lblRes = new JLabel(txt, SwingConstants.CENTER);
        lblRes.setBounds(10, 70, 740, 40);
        lblRes.setFont(new Font(lblRes.getFont().getName(), Font.BOLD, 30));
        lblRes.setForeground(Color.blue);
        
        lblicon = new JLabel(txt, SwingConstants.CENTER);
        lblicon.setBounds(230, 130, 300, 300);
        lblicon.setIcon(icon);
        
        btnNuevo = new JButton("Juego Nuevo");
        btnNuevo.setBounds(540,510,200,30);
        btnNuevo.setFont(new Font(btnNuevo.getFont().getName(), Font.BOLD, 18));
        btnNuevo.setBackground(Color.LIGHT_GRAY);
        btnNuevo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnReiniciar = new JButton("Reiniciar Juego");
        btnReiniciar.setBounds(320,510,200,30);
        btnReiniciar.setFont(new Font(btnReiniciar.getFont().getName(), Font.BOLD, 18));
        btnReiniciar.setBackground(Color.LIGHT_GRAY);
        btnReiniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Añadimos
        add(lblInstruccion);
        add(lblRes);
        add(lblicon);
        add(btnNuevo);
        add(btnReiniciar);
        
        // Eventos
        btnNuevo.addActionListener(this);
        btnNuevo.addMouseListener(this);
        btnReiniciar.addActionListener(this);
        btnReiniciar.addMouseListener(this);
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
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnNuevo)){
            Aritmetica.ctrSuma = 1;
            Aritmetica.ctrBien = 0;
            Aritmetica.control = "";
            root.cardLayout.removeLayoutComponent(root.pnSuma);
            root.cardLayout.removeLayoutComponent(root.pnResta);
            root.cardLayout.removeLayoutComponent(root.pnDiv);
            root.cardLayout.removeLayoutComponent(root.pnMul);
            root.createSumaPanel();
            root.createRestaPanel();
            root.createDivPanel();
            root.createMulPanel();
            root.panel.add(root.pnSuma, "sumaPanel");
            root.panel.add(root.pnResta, "restaPanel");
            root.panel.add(root.pnDiv, "divPanel");
            root.panel.add(root.pnMul, "mulPanel");
            root.cardLayout.show(root.panel, "mainPanel");
        } else if(e.getSource().equals(btnReiniciar)){
            if(!control.equals("")){
                Aritmetica.ctrSuma = 1;
                Aritmetica.ctrBien = 0;
                root.cardLayout.removeLayoutComponent(root.pnSuma);
                root.cardLayout.removeLayoutComponent(root.pnResta);
                root.cardLayout.removeLayoutComponent(root.pnDiv);
                root.cardLayout.removeLayoutComponent(root.pnMul);
                root.createSumaPanel();
                root.createRestaPanel();
                root.createDivPanel();
                root.createMulPanel();
                root.panel.add(root.pnSuma, "sumaPanel");
                root.panel.add(root.pnResta, "restaPanel");
                root.panel.add(root.pnDiv, "divPanel");
                root.panel.add(root.pnMul, "mulPanel");
                
                if(control.equals("suma")){
                    root.cardLayout.show(root.panel, "sumaPanel");
                } else if(control.equals("resta")){
                    root.cardLayout.show(root.panel, "restaPanel");
                } else if(control.equals("div")){
                    root.cardLayout.show(root.panel, "divPanel");
                } else if(control.equals("mul")){
                    root.cardLayout.show(root.panel, "mulPanel");
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        play("enter");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Code
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Code
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        play("select");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Code
    }
}
