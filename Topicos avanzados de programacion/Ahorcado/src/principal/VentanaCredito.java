/*
 * Ventana para instrucciones
 */

package principal;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author Paulo Andrade
 */
public class VentanaCredito extends JDialog
{
    Ahorcado root;
    JPanel mainPanel;
    JLabel lblTitulo, lblImg;
    JTextArea area;
    
    // Constructor
    public VentanaCredito(Ahorcado parent)
    {
        super(parent);
        root = parent;
        
        initComponents();
    }
    
    // Inicializamos los componentes
    public void initComponents()
    {
        setTitle("Creditos");
        setSize(700, 500);
        setLocationRelativeTo(root);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);
        setLayout(null);
        
        // Componentes
        mainPanel = new JPanel();
        mainPanel.setBounds(20, 20, 660, 460);
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(null);
        
        lblTitulo = new JLabel("Practica N° 5", SwingConstants.CENTER);
        lblTitulo.setBounds(10, 10, 640, 20);
        lblTitulo.setFont(new Font(lblTitulo.getFont().getName(), Font.BOLD, 18));
        lblTitulo.setForeground(Color.blue);
        
        String text = "";
        text += "Profesor:\n - García Cerpas José Luis.\n\n";
        text += "Alumno:\n - Andrade González Paulo César";
        
        area = new JTextArea();
        area.setBounds(10, 40, 640, 140);
        area.setEditable(false);
        area.setFont(new Font(area.getFont().getName(), Font.BOLD, 18));
        area.setText(text);
        
        lblImg = new JLabel("");
        lblImg.setBounds(145,190 ,350, 203);
        lblImg.setIcon(new ImageIcon("tec.png"));
        
        // Añadimos componentes
        add(mainPanel);
        mainPanel.add(lblTitulo);
        mainPanel.add(area);
        mainPanel.add(lblImg);
        // No mostramos la ventana
        setVisible(false);
    }
}
