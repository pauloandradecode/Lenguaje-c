/*
 * Juego del ahorcado
 */

package principal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Random;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author Paulo Andrade
 */
public class Ahorcado extends JFrame implements ActionListener, KeyListener, ItemListener
{
    JMenuBar menuBar;
    JMenu menuArchivo, menuInstrucciones, menuCreditos;
    JMenuItem miNuevo, miContinuar, miDetener, miSalir, miCreditos, miAyuda;
    JPanel mainPanel, imgPanel;
    JLabel lblImg, lblInstruccion, lblUsadas, lblPalabra, lblMensaje, lblCronometro;
    JTextArea area;
    JComboBox combo;
    JButton btnInicio, btnDetener, btnSeguir;
    JDialog dgInstruccion, dgCredito;
    DefaultComboBoxModel model;
    int ctrIntentos; // Intentos
    boolean ctrProcess; // Controlador para procesos
    String[][] lista = {{"Pera", "Piña", "Limon", "Sandia"},
        {"Juan", "Pedro", "Oscar", "Javier"}};
    String[] categorias = {"","Frutas", "Nombres"};
    String usadas, palabra, ctrPalabra;
    Random random;
    
    // Constructor
    public Ahorcado()
    {
        ctrIntentos = 1;
        ctrProcess = false;
        usadas = "";
        palabra = "";
        ctrPalabra = "";
        
        initComponents();
    }
    
    // Iicializamos componentes
    public void initComponents()
    {
        setTitle("Ahorcado");
        setSize(800, 630);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        // Menu
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        menuArchivo = new JMenu("Archivo");
        menuArchivo.setFont(new Font(menuArchivo.getFont().getName(), Font.BOLD, 18));
        menuBar.add(menuArchivo);
        
        menuInstrucciones = new JMenu("Instrucciones");
        menuInstrucciones.setFont(new Font(menuInstrucciones.getFont().getName(), Font.BOLD, 18));
        menuBar.add(menuInstrucciones);
        
        menuCreditos = new JMenu("Creditos");
        menuCreditos.setFont(new Font(menuCreditos.getFont().getName(), Font.BOLD, 18));
        menuBar.add(menuCreditos);
        
        miNuevo = new JMenuItem("Nuevo");
        miNuevo.setFont(new Font(miNuevo.getFont().getName(), Font.BOLD, 18));
        miNuevo.addActionListener(this);
        
        JSeparator sp1 = new JSeparator();
        
        miContinuar = new JMenuItem("Continuar");
        miContinuar.setFont(new Font(miContinuar.getFont().getName(), Font.BOLD, 18));
        miContinuar.setEnabled(false);
        miContinuar.addActionListener(this);
        
        miDetener = new JMenuItem("Detener");
        miDetener.setFont(new Font(miDetener.getFont().getName(), Font.BOLD, 18));
        miDetener.setEnabled(false);
        miDetener.addActionListener(this);
        
        JSeparator sp2 = new JSeparator();
        
        miSalir = new JMenuItem("Salir");
        miSalir.setFont(new Font(miSalir.getFont().getName(), Font.BOLD, 18));
        miSalir.addActionListener(this);
        
        miAyuda = new JMenuItem("ver");
        miAyuda.setFont(new Font(miAyuda.getFont().getName(), Font.BOLD, 18));
        miAyuda.addActionListener(this);
        
        miCreditos = new JMenuItem("ver");
        miCreditos.setFont(new Font(miCreditos.getFont().getName(), Font.BOLD, 18));
        miCreditos.addActionListener(this);
        
        menuArchivo.add(miNuevo);
        menuArchivo.add(sp1);
        menuArchivo.add(miContinuar);
        menuArchivo.add(miDetener);
        menuArchivo.add(sp2);
        menuArchivo.add(miSalir);
        menuInstrucciones.add(miAyuda);
        menuCreditos.add(miCreditos);
        
        // JDialog
        dgInstruccion = new VentanaInstruccion(this);
        dgCredito = new VentanaCredito(this);
        
        // Componentes
        mainPanel = new JPanel();
        mainPanel.setBounds(20, 20, 760, 560);
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(null);
        
        lblImg = new JLabel("imagen", SwingConstants.CENTER);
        lblImg.setBounds(400, 50, 350,350);
        lblImg.setIcon(new ImageIcon("ahorcado.png"));
        
        lblInstruccion = new JLabel("Seleccione una categoria: ");
        lblInstruccion.setBounds(10, 10, 380, 20);
        lblInstruccion.setFont(new Font(lblInstruccion.getFont().getName(), Font.BOLD, 18));
        lblInstruccion.setVisible(false);
        
        model = new DefaultComboBoxModel();
        for(String item : categorias){
            model.addElement(item);
        }
        combo = new JComboBox();
        combo.setModel(model);
        combo.setBounds(10, 40, 300, 20);
        combo.setFont(new Font(combo.getFont().getName(), Font.BOLD, 18));
        combo.setVisible(false);
        
        btnInicio = new JButton("Iniciar");
        btnInicio.setBounds(80, 70, 150, 30);
        btnInicio.setFont(new Font(btnInicio.getFont().getName(), Font.BOLD, 18));
        btnInicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnInicio.setVisible(false);
        
        btnDetener = new JButton("Detener");
        btnDetener.setBounds(80, 70, 150, 30);
        btnDetener.setFont(new Font(btnDetener.getFont().getName(), Font.BOLD, 18));
        btnDetener.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDetener.setVisible(false);
        
        btnSeguir = new JButton("Continuar");
        btnSeguir.setBounds(80, 70, 150, 30);
        btnSeguir.setFont(new Font(btnSeguir.getFont().getName(), Font.BOLD, 18));
        btnSeguir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSeguir.setVisible(false);
        
        lblPalabra = new JLabel();
        lblPalabra.setBounds(10, 120, 380, 100);
        lblPalabra.setFont(new Font(lblPalabra.getFont().getName(), Font.BOLD, 50));
        lblPalabra.setVisible(false);
        
        lblUsadas = new JLabel("Letras Utilizadas: ");
        lblUsadas.setBounds(10, 380, 380, 20);
        lblUsadas.setFont(new Font(lblUsadas.getFont().getName(), Font.BOLD, 18));
        lblUsadas.setVisible(false);
        
        area = new JTextArea();
        area.setBounds(10, 410, 740, 60);
        area.setEditable(false);
        area.setBackground(Color.GREEN);
        area.setFont(new Font(area.getFont().getName(), Font.BOLD, 18));
        area.setVisible(false);
        
        lblCronometro = new Cronometro();
        lblCronometro.setBounds(10, 480, 200, 20);
        
        // Añadimos componentes
        add(mainPanel);
        mainPanel.add(lblImg);
        mainPanel.add(lblInstruccion);
        mainPanel.add(combo);
        mainPanel.add(btnInicio);
        mainPanel.add(btnDetener);
        mainPanel.add(btnSeguir);
        mainPanel.add(lblPalabra);
        mainPanel.add(lblUsadas);
        mainPanel.add(area);
        // mainPanel.add(lblCronometro);
        
        // Eventos
        addKeyListener(this);
        combo.addItemListener(this);
        btnInicio.addActionListener(this);
        btnDetener.addActionListener(this);
        btnSeguir.addActionListener(this);
        
        // Mostramos ventana
        setVisible(true);
    }
    
    // Reiniciamos el layout
    public void reset()
    {
        // Reiniciamos la imagen
        mainPanel.setBackground(Color.white);
        lblImg.setIcon(new ImageIcon("ahorcado.png"));
        lblInstruccion.setVisible(true);
        combo.setVisible(true);
        combo.setEnabled(true);
        combo.setSelectedIndex(0);
        btnInicio.setVisible(false);
        btnDetener.setVisible(false);
        btnDetener.setEnabled(true);
        btnSeguir.setVisible(false);
        lblPalabra.setVisible(false);
        lblPalabra.setText("");
        lblUsadas.setVisible(false);
        area.setVisible(false);
        area.setText("");
        ctrIntentos = 1;
        usadas = "";
        ctrPalabra = "";
        
        // Elementos del menu
        miContinuar.setEnabled(false);
        miDetener.setEnabled(false);
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
    
    // Trabajamos con la letra
    public void chekLetter(String key)
    {
        // Verificamos el numero de intentos
        if(ctrIntentos <= 5){
            // Convertimos a mayusculas
            key = key.toUpperCase();

            // Verificamo si se encuentra en la palabra
            if(palabra.contains(key)){
                // Mostramos las letras
                String text = "";
                String ctrText = "";
                for(int i = 0; i < palabra.length(); i++){
                    if(palabra.substring(i, i+1).contains(key)){
                        text += key+" ";
                        ctrText += key;
                    } else {
                        if(ctrPalabra.substring(i, i+1).contains(" ")){
                            text += "_ ";
                            ctrText += ctrPalabra.substring(i, i+1);
                        } else {
                            text += ctrPalabra.substring(i, i+1)+" ";
                            ctrText += ctrPalabra.substring(i, i+1);
                        }
                    }
                }
                lblPalabra.setText(text);
                ctrPalabra = ctrText;
                
                // Verificamos si gano
                if(ctrPalabra.contains(palabra)){
                    // Cambiamos el estado
                    ctrProcess = false;
                    mainPanel.setBackground(Color.green);
                    btnDetener.setEnabled(false);
                    miDetener.setEnabled(false);
                    play("win");
                }
            } else {
                // Mandamos la letra a usadas
                if(!usadas.contains(key)){
                    play("wrong");
                    // Agregamos a usadas
                    usadas += key + " ";

                    // Imprimimos las letras usadas
                    area.setText(usadas);
                    
                    // Cambiamos la imagen
                    for(int i = 1; i <= 5; i++){
                        if(i == ctrIntentos){
                            lblImg.setIcon(new ImageIcon("ahorcado"+i+".png"));
                        }
                        if(ctrIntentos == 5){
                            // Cambiamos el estado
                            ctrProcess = false;
                            mainPanel.setBackground(Color.red);
                            btnDetener.setEnabled(false);
                            miDetener.setEnabled(false);
                        }
                    }
                    
                    // Aumentamos el contador de intentos
                    ctrIntentos++;
                }
            }
        } else {
            // Si perdio
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Ahorcado();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        
        if(!Character.isLetter(key)){
            getToolkit().beep();

            e.consume();
        } else {
            if(ctrProcess){
                chekLetter(""+key);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Code
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Code
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(miSalir)){
            dispose(); // Cerramos la ventana
        } else if(e.getSource().equals(miNuevo)){
            reset();
        } else if(e.getSource().equals(miContinuar)){
            btnSeguir.doClick();
        } else if(e.getSource().equals(miDetener)){
            btnInicio.doClick();
        } else if(e.getSource().equals(miAyuda)){
            dgInstruccion.setVisible(true);
        } else if(e.getSource().equals(miCreditos)){
            dgCredito.setVisible(true);
        } else if(e.getSource().equals(btnInicio)){
            // Elementos del menu
            miDetener.setEnabled(true);
            // Desactivamos el combo
            combo.setEnabled(false);
            // Cambiamos el boton
            btnInicio.setVisible(false);
            btnDetener.setVisible(true);
            // Mostramos elementos
            lblPalabra.setVisible(true);
            lblUsadas.setVisible(true);
            area.setVisible(true);
            // Cambiamos el estado
            ctrProcess = true;
        } else if(e.getSource().equals(btnDetener)){
            // Elementos del menu
            miContinuar.setEnabled(true);
            miDetener.setEnabled(false);
            // Cambiamos el boton
            btnDetener.setVisible(false);
            btnSeguir.setVisible(true);
            // Cambiamos el estado
            ctrProcess = false;
        } else if(e.getSource().equals(btnSeguir)){
            // Elementos del menu
            miContinuar.setEnabled(false);
            miDetener.setEnabled(true);
            // Cambiamos el boton
            btnDetener.setVisible(true);
            btnSeguir.setVisible(false);
            // Cambiamos el estado
            ctrProcess = true;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if(e.getSource().equals(combo)){
                // Verificamos que solo sea el evento de seleccion
                // Obtenemos el valor seleccionado
                int index = combo.getSelectedIndex();
                // Verificamos que el valor sea distinto de 0
                if(index != 0){
                    // Obtenemos la longitud del vector
                    int len = lista[index - 1].length;
                    // Generamos un numero aleatorio
                    random = new Random();
                    int aleatorio = random.nextInt(len) + 0;
                    // obtenemos la palabra
                    palabra = lista[index-1][aleatorio].toUpperCase();
                    // Obtenemos la longitud de la palabra
                    int lenPalabra = palabra.length();
                    // llenamos el lblPalabra
                    for(int i = 0; i < lenPalabra; i++){
                        lblPalabra.setText(lblPalabra.getText()+"_ ");
                        ctrPalabra += " ";
                    }
                    // Mostramos boton jugar
                    btnInicio.setVisible(true);
                } else {
                    // Ocultamos boton inicio
                    btnInicio.setVisible(false);
                }
            }
        }
    }
    
}
