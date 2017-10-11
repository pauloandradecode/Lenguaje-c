/*
 * Pong - practica 7
 */

package principal;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Paulo Andrade
 */
public class Pong extends JFrame implements KeyListener, WindowListener
{
    int x, y; // Coordenadas de la pelota
    int size; // Tamaño de la pelota
    int vx, vy; // velocidad horizontal y vertical de la pelota
    int width, height; // Ancho y alto de la pantala
    int yDer, yIzq; // Coordenadas barras
    int scoreA, scoreB; // Marcador jugadores
    int error; // Rango de error
    JLabel lblPelota, lblInfo, lblIzq, lblDer;
    JPanel mainPanel;
    
    // Constructor
    public Pong()
    {
        width = 780;
        height = 560;
        x = width / 2;
        y = 0;
        size = 60;
        vx = 10;
        vy = 10;
        yDer = 0;
        yIzq = 0;
        scoreA = 0;
        scoreB = 0;
        error = 10; // Rango de error
        
        initComponents();
    }
    
    // Inicializamos componentes
    public void initComponents()
    {
        setTitle("Pong");
        setSize(800, 600);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        getContentPane().setBackground(Color.BLACK);
        
        // Componentes
        mainPanel = new JPanel();
        mainPanel.setBounds(10, 10, width, height);
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(null);
        
        lblPelota = new JLabel("");
        lblPelota.setBounds(x, y, size, size);
        lblPelota.setIcon(new ImageIcon("pelota.gif"));
        
        lblInfo = new JLabel("");
        lblInfo.setBounds(10, 570, 780, 20);
        lblInfo.setBackground(Color.LIGHT_GRAY);
        lblInfo.setForeground(Color.white);
        
        lblIzq = new JLabel("");
        lblIzq.setBounds(10, yIzq, 30, 150);
        lblIzq.setBackground(Color.blue);
        lblIzq.setOpaque(true);
        
        lblDer = new JLabel("");
        lblDer.setBounds(width - 40, yDer, 30, 150);
        lblDer.setBackground(Color.blue);
        lblDer.setOpaque(true);
        
        // Añadimos componentes
        add(mainPanel);
        add(lblInfo);
        mainPanel.add(lblPelota);
        mainPanel.add(lblIzq);
        mainPanel.add(lblDer);
        
        // Eventos
        addKeyListener(this);
        
        // Mostramos ventana
        setVisible(true);
    }
    
    // Metodo para pintar la pelota
    public void paint()
    {
        lblPelota.setBounds(x, y, size, size);
    }
    
    // Metodo para mover la pelota
    public void moverPelota()
    {
        // Checar con intersects
        x += vx;
        y += vy;
        int derY = yDer + 150;
        int derX = width - 40;
        int izqY = yIzq + 150;
        int izqX = 40;
        int pelY = y + size;
        int pelX = x + size;
        
        // Mostramos las coordenadas
        String txt = "x: "+x+"  y: "+y;
        txt += "          ";
        txt += "Score: "+scoreA+" - "+scoreB;
        lblInfo.setText(txt);
        
        // Controlamos la colicion con el bloque derecho
        if((pelY > (yDer-error) && pelY < (derY + error)) && (pelX == derX && vx > 0)){
            vx = -1*vx;
        }
        
        // Controlamos la colicion con el bloque izquierdo
        if((y > (yIzq-error) && y < (izqY+error)) && (x == izqX && vx < 0)){
            vx = -1*vx;
        }
        
        // Controlamos el movimiento de y+
        if((y + size) >= height){
            vy = -1*vy;
        }
        
        // Controlamos el movimiento de x+
        if((x + size) >= width){
            vx = -1*vx;
            scoreA++;
        }
        
        // Controlamos el movimiento de y-
        if((y) <= 0){
            vy = -1*vy;
        }
        
        // Controlamos el movimiento de x-
        if((x) <= 0){
            vx = -1*vx;
            scoreB++;
        }
        
        paint();
    }
    
    // Movemos barra para arriba
    public void upDer()
    {
        // Comprobamos
        if(yDer != 0){
            yDer -= 10;
        }
        
        lblDer.setBounds(width - 40, yDer, 30, 150);
    }
    
    // Movemos barra para abajo
    public void downDer()
    {
        // Comprobamos
        if((yDer + 150) < height){
            yDer += 10;
        }
        
        lblDer.setBounds(width - 40, yDer, 30, 150);
    }
    
    // Movemos barra para arriba
    public void upIzq()
    {
        // Comprobamos
        if(yIzq != 0){
            yIzq -= 10;
        }
        
        lblIzq.setBounds(10, yIzq, 30, 150);
    }
    
    // Movemos barra para abajo
    public void downIzq()
    {
        // Comprobamos
        if((yIzq + 150) < height){
            yIzq += 10;
        }
        
        lblIzq.setBounds(10, yIzq, 30, 150);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creamos la ventana
        Pong ventana = new Pong();
        
        // Movemos la pelota
        while (true){
            ventana.moverPelota();
        
            try{
                Thread.sleep(25);
            } catch(InterruptedException ex){
                System.out.print("Error: "+ex.getMessage());
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Code
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Code
        int key = e.getKeyCode();
                
        switch(key){
            case 38:
                upDer();
                break;
            case 40:
                downDer();
                break;
            case 87:
                upIzq();
                break;
            case 83:
                downIzq();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Code
    }

    @Override
    public void windowOpened(WindowEvent e) {
        requestFocus();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // Code
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // Code
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // Code
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // Code
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // Code
        requestFocus();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // Code
    }
    
}
