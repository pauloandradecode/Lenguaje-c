/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Paulo Andrade
 */
public class Area extends JFrame implements ActionListener, KeyListener, MouseListener
{
    JLabel lblTitleNum, lblTitleFig, lblCirculo, lblRectangulo, lblTriangulo,
           lblBase, lblAltura, lblArea, lblRadio;
    JTextField txtBase, txtAltura, txtArea, txtRadio;
    JRadioButton rBtnTriangulo, rBtnCirculo, rBtnRectangulo;
    JButton btnCalcular, btnSalir;
    JPanel pNum, pFig;
    ButtonGroup grpFig;
    DecimalFormat df;
    
    public Area()
    {
        initComponent();
        df = new DecimalFormat("0.00");
    }
    
    public void initComponent()
    {
        setTitle("Calcular áreas");
        setSize(500, 300);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        
        // Objetos
        pNum = new JPanel();
        pNum.setBorder(BorderFactory.createLoweredBevelBorder());
        pNum.setBounds(10, 80, 290, 140);
        pNum.setLayout(null);
        
        pFig = new JPanel();
        pFig.setBorder(BorderFactory.createLoweredBevelBorder());
        pFig.setBounds(310, 90, 180, 120);
        pFig.setLayout(null);
        
        lblTitleNum = new JLabel("Números");
        lblTitleNum.setBounds(10, 50, 150, 26);
        lblTitleNum.setFont(new Font(lblTitleNum.getFont().getName(), Font.BOLD, 20));
        
        lblTitleFig = new JLabel("Figuras");
        lblTitleFig.setBounds(310, 60, 150, 26);
        lblTitleFig.setFont(new Font(lblTitleFig.getFont().getName(), Font.BOLD, 20));
        
        lblTriangulo = new JLabel("Triángulo");
        lblTriangulo.setBounds(40, 10, 90, 20);
        
        lblRectangulo = new JLabel("Rectángulo");
        lblRectangulo.setBounds(40, 50, 90, 20);
        
        lblCirculo = new JLabel("Círculo");
        lblCirculo.setBounds(40, 90, 90, 20);
        
        lblBase = new JLabel("Base");
        lblBase.setBounds(10, 20, 90, 20);
        
        lblAltura = new JLabel("Altura");
        lblAltura.setBounds(10, 60, 90, 20);
        
        lblArea = new JLabel("Área");
        lblArea.setBounds(10, 100, 90, 20);
        
        lblRadio = new JLabel("Radio");
        lblRadio.setBounds(10, 20, 90, 20);
        lblRadio.setVisible(false);
        
        txtBase = new JTextField("0");
        txtBase.setBounds(110, 20, 160, 20);
        txtBase.setHorizontalAlignment(JTextField.RIGHT);
        
        txtAltura = new JTextField("0");
        txtAltura.setBounds(110, 60, 160, 20);
        txtAltura.setHorizontalAlignment(JTextField.RIGHT);
        
        txtArea = new JTextField();
        txtArea.setBounds(110, 100, 160, 20);
        txtArea.setHorizontalAlignment(JTextField.RIGHT);
        txtArea.setEditable(false);
        
        txtRadio = new JTextField("0");
        txtRadio.setBounds(110, 20, 160, 20);
        txtRadio.setHorizontalAlignment(JTextField.RIGHT);
        txtRadio.setVisible(false);
        
        rBtnTriangulo = new JRadioButton();
        rBtnTriangulo.setBounds(10, 10, 20, 20);
        rBtnTriangulo.setSelected(true);
        
        rBtnRectangulo = new JRadioButton();
        rBtnRectangulo.setBounds(10, 50, 20, 20);
        
        rBtnCirculo = new JRadioButton();
        rBtnCirculo.setBounds(10, 90, 20, 20);
        
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(220, 260, 120, 20);
        
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(370, 260, 120, 20);
        
        grpFig = new ButtonGroup();
        grpFig.add(rBtnTriangulo);
        grpFig.add(rBtnRectangulo);
        grpFig.add(rBtnCirculo);
        
        // Añadimos objetos
        add(lblTitleNum);
        add(lblTitleFig);
        add(pNum);
        pNum.add(lblBase);
        pNum.add(lblRadio);
        pNum.add(lblAltura);
        pNum.add(lblArea);
        pNum.add(txtBase);
        pNum.add(txtRadio);
        pNum.add(txtAltura);
        pNum.add(txtArea);
        add(pFig);
        pFig.add(rBtnTriangulo);
        pFig.add(rBtnRectangulo);
        pFig.add(rBtnCirculo);
        pFig.add(lblTriangulo);
        pFig.add(lblRectangulo);
        pFig.add(lblCirculo);
        add(btnSalir);
        add(btnCalcular);
        
        // Eventos
        btnCalcular.addActionListener(this);
        btnSalir.addActionListener(this);
        txtBase.addKeyListener(this);
        txtAltura.addKeyListener(this);
        txtArea.addKeyListener(this);
        rBtnTriangulo.addMouseListener(this);
        rBtnRectangulo.addMouseListener(this);
        rBtnCirculo.addMouseListener(this);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Area();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // obtenemos los numeros
        Float base = Float.parseFloat(txtBase.getText());
        Float altura = Float.parseFloat(txtAltura.getText());
        Float radio = Float.parseFloat(txtRadio.getText());
        double pi = 3.1416;
        
        // Verificamos el boton presionado
        if(e.getSource().equals(btnCalcular)){
            // Verificamos el RadioButton Seleccionado
            if(rBtnTriangulo.isSelected()){
                txtArea.setText(df.format(base * altura / 2));
            } else if(rBtnRectangulo.isSelected()){
                txtArea.setText(df.format(base * altura));
            } else if(rBtnCirculo.isSelected()){
                txtArea.setText(df.format(radio * radio * Math.PI));
            }
        } else if(e.getSource().equals(btnSalir)){
            dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        
        if(Character.isLetter(key)){
            getToolkit().beep();
            
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // code
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // code
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Verificamos el RadiobutonSeleccionado
        if(e.getSource().equals(rBtnCirculo)){
            txtBase.setVisible(false);
            txtAltura.setVisible(false);
            lblBase.setVisible(false);
            lblAltura.setVisible(false);
            txtRadio.setVisible(true);
            lblRadio.setVisible(true);
        } else if(e.getSource().equals(rBtnRectangulo) || e.getSource().equals(rBtnTriangulo)){
            txtBase.setVisible(true);
            txtAltura.setVisible(true);
            lblBase.setVisible(true);
            lblAltura.setVisible(true);
            txtRadio.setVisible(false);
            lblRadio.setVisible(false);
        }
        
        txtArea.setText("");
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
