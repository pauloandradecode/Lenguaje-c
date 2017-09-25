/*
 * Ventana para instrucciones
 */

package principal;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Paulo Andrade
 */
public class VentanaInstruccion extends JDialog
{
    Ahorcado root;
    JPanel mainPanel;
    JLabel lblTitulo;
    JTextArea area;
    
    // Constructor
    public VentanaInstruccion(Ahorcado parent)
    {
        super(parent);
        root = parent;
        
        initComponents();
    }
    
    // Inicializamos los componentes
    public void initComponents()
    {
        setTitle("Instrucciones");
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
        
        lblTitulo = new JLabel("Reglas para jugar: ");
        lblTitulo.setBounds(10, 10, 640, 20);
        lblTitulo.setFont(new Font(lblTitulo.getFont().getName(), Font.BOLD, 18));
        lblTitulo.setForeground(Color.blue);
        
        String text = "";
        text += "Objetivo:\n\n-Descubrir la palabra o frase incógnita.\n\n";
        text += "Jugando:\n\n1.- En el menu archivo seleccione \"Nuevo\" para iniciar un juego\n  nuevo\n";
        text += "2.- Seleccione la categoria de la palabra a encontrar.\n";
        text += "3.- De clic en jugar para comenzar con el juego.\n";
        text += "4.- En el tablero se le dibujara una pista con la cantidad de\n  letras que contiene la palabra incognita.\n";
        text += "5.- Gana si encuentra la palabra en un maximo de 5 intentos\n\n";
        text += "Opciones:\n\n";
        text += "- Puede detener o continuar el juego para no ver afectado el\n  tiempo.";
        
        area = new JTextArea();
        area.setBounds(10, 40, 640, 410);
        area.setEditable(false);
        area.setFont(new Font(area.getFont().getName(), Font.BOLD, 18));
        area.setText(text);
        
        // Añadimos componentes
        add(mainPanel);
        mainPanel.add(lblTitulo);
        mainPanel.add(area);
        
        // No mostramos la ventana
        setVisible(false);
    }
}
