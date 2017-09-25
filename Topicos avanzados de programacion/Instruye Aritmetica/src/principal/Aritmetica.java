/*
 * Clase principal
 */
        
package principal;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author Paulo Andrade
 */

public class Aritmetica implements ActionListener
{
    CardLayout cardLayout; // Creamos un manejador de diseño
    JFrame root; // Frame principal
    JPanel panel, pnMain, pnSuma, pnRes, pnResta, pnDiv, pnMul; // Panes
    JMenuBar menuBar;
    JMenu menuArchivo;
    JMenuItem miNuevo, miSalir, miReiniciar;
    public static int ctrSuma; // Control de operaciones
    public static int ctrBien, ctrMal; // Control de resultados
    public static String control;
    
    // Constructor
    public Aritmetica()
    {
        ctrReset();
        createMainPanel();
        createSumaPanel();
        createRestaPanel();
        createDivPanel();
        createMulPanel();
        createResPanel();
        createCardLayout();
        initComponent();
    }
    
    // Inicializamos componentes
    public void initComponent()
    {
        // Creamos el frame principal
        root = new JFrame();
        root.setTitle("Aprende aritmética");
        root.setSize(800, 630);
        root.setResizable(false);
        root.setLayout(null);
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setLocationRelativeTo(root);
        root.setFocusable(true);
        root.setFocusTraversalKeysEnabled(false);
        
        // Componentes
        menuBar = new JMenuBar();
        root.setJMenuBar(menuBar);
        
        menuArchivo = new JMenu("Archivo");
        menuArchivo.setFont(new Font(menuArchivo.getFont().getName(), Font.BOLD, 18));
        menuBar.add(menuArchivo);
        
        miNuevo = new JMenuItem("Nuevo");
        miNuevo.setFont(new Font(miNuevo.getFont().getName(), Font.BOLD, 18));
        miNuevo.addActionListener(this);
        
        miReiniciar = new JMenuItem("Reiniciar");
        miReiniciar.setFont(new Font(miReiniciar.getFont().getName(), Font.BOLD, 18));
        miReiniciar.addActionListener(this);
        
        JSeparator sp = new JSeparator();
        
        miSalir = new JMenuItem("Salir");
        miSalir.setFont(new Font(miSalir.getFont().getName(), Font.BOLD, 18));
        miSalir.addActionListener(this);
        
        menuArchivo.add(miNuevo);
        menuArchivo.add(miReiniciar);
        menuArchivo.add(sp);
        menuArchivo.add(miSalir);
        
        // Agregamos componentes
        root.add(panel);
        
        // Mostramos el panel pordefecto
        cardLayout.show(panel, "mainPanel");
        
        // mostramos el frame
        root.setVisible(true);
    }
    
    // Creamos el manejador de paneles
    public void createCardLayout()
    {
        // Creamos el panel contenedor
        panel = new JPanel();
        panel.setBounds(20, 20, 760, 560);
        // Creamos el card layout
        cardLayout = new CardLayout();
        // Lo agregamos como layout
        panel.setLayout(cardLayout);
        
        // Añadimos los paneles con identificador
        panel.add(pnMain, "mainPanel");
        panel.add(pnSuma, "sumaPanel");
        panel.add(pnResta, "restaPanel");
        panel.add(pnDiv, "divPanel");
        panel.add(pnMul, "mulPanel");
        panel.add(pnRes, "resPanel");
    }
    
    // Creamos el panel principal
    public void createMainPanel()
    {
        pnMain = new MainPanel(this);
        pnMain.setBounds(20, 20, 760, 560);
    }
    
    // Creamos el panel suma
    public void createSumaPanel()
    {
        pnSuma = new SumaPanel(this);
        pnSuma.setBounds(20, 20, 760, 560);
    }
    
    // Creamos el panel resta
    public void createRestaPanel()
    {
        pnResta = new RestaPanel(this);
        pnResta.setBounds(20, 20, 760, 560);
    }
    
    // Creamos el panel division
    public void createDivPanel()
    {
        pnDiv = new DivPanel(this);
        pnDiv.setBounds(20, 20, 760, 560);
    }
    
    // Creamos el panel muliplicacion
    public void createMulPanel()
    {
        pnMul = new MulPanel(this);
        pnMul.setBounds(20, 20, 760, 560);
    }
    
    // Creamos el panel resultado
    public void createResPanel()
    {
        pnRes = new ResPanel(this);
        pnRes.setBounds(20, 20, 760, 560);
    }
    
    // Reseteamos los controles
    public void ctrReset()
    {
        ctrSuma = 1;
        control = "";
        ctrBien = 0;
        ctrMal = 0;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inicializamos la ventana
        new Aritmetica();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(miNuevo)){
            Aritmetica.ctrSuma = 1;
            Aritmetica.ctrBien = 0;
            Aritmetica.control = "";
            cardLayout.removeLayoutComponent(pnSuma);
            cardLayout.removeLayoutComponent(pnResta);
            cardLayout.removeLayoutComponent(pnDiv);
            cardLayout.removeLayoutComponent(pnMul);
            createSumaPanel();
            createRestaPanel();
            createDivPanel();
            createMulPanel();
            panel.add(pnSuma, "sumaPanel");
            panel.add(pnResta, "restaPanel");
            panel.add(pnDiv, "divPanel");
            panel.add(pnMul, "mulPanel");
            cardLayout.show(panel, "mainPanel");
        } else if(e.getSource().equals(miSalir)){
            root.dispose();
        } else if(e.getSource().equals(miReiniciar)){
            if(!control.equals("")){
                Aritmetica.ctrSuma = 1;
                Aritmetica.ctrBien = 0;
                cardLayout.removeLayoutComponent(pnSuma);
                cardLayout.removeLayoutComponent(pnResta);
                cardLayout.removeLayoutComponent(pnDiv);
                cardLayout.removeLayoutComponent(pnMul);
                createSumaPanel();
                createRestaPanel();
                createDivPanel();
                createMulPanel();
                panel.add(pnSuma, "sumaPanel");
                panel.add(pnResta, "restaPanel");
                panel.add(pnDiv, "divPanel");
                panel.add(pnMul, "mulPanel");
                
                if(control.equals("suma")){
                    cardLayout.show(panel, "sumaPanel");
                } else if(control.equals("resta")){
                    cardLayout.show(panel, "restaPanel");
                } else if(control.equals("div")){
                    cardLayout.show(panel, "divPanel");
                } else if(control.equals("mul")){
                    cardLayout.show(panel, "mulPanel");
                }
            }
        }
    }
    
}
