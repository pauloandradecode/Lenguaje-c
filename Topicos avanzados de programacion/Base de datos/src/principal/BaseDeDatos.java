/*
 * Conexion a base de datos
 */

package principal;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Paulo Andrade
 */
public class BaseDeDatos extends JFrame implements ActionListener, KeyListener
{
    JPanel dataPanel, buttonPanel;
    JLabel lblClave, lblNombre, lblFecha;
    JTextField txtClave, txtNombre, txtFecha;
    JButton btnGuardar, btnModificar, btnConsulta, btnEliminar, btnSalir;
    Odbc db;

    // Constructor
    public BaseDeDatos()
    {
        db = new Odbc();
        initComponents();
    }
    
    // Iicializamos componentes
    public void initComponents()
    {
        setTitle("Base de datos con MySql");
        setSize(830, 370);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        // Componentes
        dataPanel = new JPanel();
        dataPanel.setBounds(20, 40, 790, 220);
        dataPanel.setBorder(BorderFactory.createTitledBorder("Datos"));
        dataPanel.setLayout(null);
        
        buttonPanel = new JPanel();
        buttonPanel.setBounds(20, 300, 790, 70);
        buttonPanel.setLayout(null);
        
        lblClave = new JLabel("Clave: ");
        lblClave.setBounds(20, 40, 130, 20);
        lblClave.setFont(new Font(lblClave.getFont().getName(), Font.BOLD, 18));
        
        lblNombre = new JLabel("Nombre: ");
        lblNombre.setBounds(20, 100, 130, 20);
        lblNombre.setFont(new Font(lblNombre.getFont().getName(), Font.BOLD, 18));
        
        lblFecha = new JLabel("Fecha Nac: ");
        lblFecha.setBounds(20, 160, 130, 20);
        lblFecha.setFont(new Font(lblFecha.getFont().getName(), Font.BOLD, 18));
        
        txtClave = new JTextField();
        txtClave.setBounds(170, 40, 200, 25);
        txtClave.setFont(new Font(txtClave.getFont().getName(), Font.BOLD, 18));
        
        txtNombre = new JTextField();
        txtNombre.setBounds(170, 100, 350, 25);
        txtNombre.setFont(new Font(txtNombre.getFont().getName(), Font.BOLD, 18));
        
        txtFecha = new JTextField();
        txtFecha.setBounds(170, 160, 160, 25);
        txtFecha.setFont(new Font(txtFecha.getFont().getName(), Font.BOLD, 18));
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(0, 0, 150, 30);
        btnGuardar.setFont(new Font(btnGuardar.getFont().getName(), Font.BOLD, 18));
        btnGuardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(160, 0, 150, 30);
        btnModificar.setFont(new Font(btnModificar.getFont().getName(), Font.BOLD, 18));
        btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnConsulta = new JButton("Consulta");
        btnConsulta.setBounds(320, 0, 150, 30);
        btnConsulta.setFont(new Font(btnConsulta.getFont().getName(), Font.BOLD, 18));
        btnConsulta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(480, 0, 150, 30);
        btnEliminar.setFont(new Font(btnEliminar.getFont().getName(), Font.BOLD, 18));
        btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(640, 0, 150, 30);
        btnSalir.setFont(new Font(btnSalir.getFont().getName(), Font.BOLD, 18));
        btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Añadimos componentes
        add(dataPanel);
        dataPanel.add(lblClave);
        dataPanel.add(lblNombre);
        dataPanel.add(lblFecha);
        dataPanel.add(txtClave);
        dataPanel.add(txtNombre);
        dataPanel.add(txtFecha);
        add(buttonPanel);
        buttonPanel.add(btnGuardar);
        buttonPanel.add(btnModificar);
        buttonPanel.add(btnConsulta);
        buttonPanel.add(btnEliminar);
        buttonPanel.add(btnSalir);
        
        // Eventos
        btnGuardar.addActionListener(this);
        btnModificar.addActionListener(this);
        btnConsulta.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnSalir.addActionListener(this);
        txtClave.addKeyListener(this);
        txtFecha.addKeyListener(this);
        
        // Mostramos la ventana
        setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new BaseDeDatos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtenemos los valores
        int numClave = 0;
        String clave = txtClave.getText();
        String nombre = txtNombre.getText();
        String fecha = txtFecha.getText();
        // Convertimos la clave en entero
        if(clave.length() > 0){
            numClave = Integer.parseInt(txtClave.getText());
        }
        
        if(e.getSource().equals(btnSalir)){
            dispose();
        } else if(e.getSource().equals(btnGuardar)){
            // Verificamos que todos los campos esten llenos
            if(clave.length() == 0 || nombre.length() == 0 || fecha.length() == 0){
                // Mostramos mensaje
                // Mostramos mensaje
                JOptionPane.showMessageDialog(null, "Llene todos los campos", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
            } else {
                // Creamos la sentencia sql
                String sql = "INSERT persona VALUES ("+numClave;
                sql += ",'"+nombre+"','"+fecha+"')";
                
                try {
                    // Procesamos la solicitud
                    if(db.action(sql)){
                        // Limpiamos
                        txtClave.setText("");
                        txtNombre.setText("");
                        txtFecha.setText("");
                        
                        // Mostramos mensaje
                        JOptionPane.showMessageDialog(null, "El registro se guardo con exito", "Mensaje del sistema", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Mostramos mensaje
                        JOptionPane.showMessageDialog(null, "Error al guardar el registro\nIntente de nuevo", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if(e.getSource().equals(btnModificar)){
            // Verificamos que todos los campos esten llenos
            if(clave.length() == 0 || nombre.length() == 0 || fecha.length() == 0){
                // Mostramos mensaje
                // Mostramos mensaje
                JOptionPane.showMessageDialog(null, "Llene todos los campos", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
            } else {
                // Creamos la sentencia sql
                String sql = "UPDATE persona SET nombre='"+nombre+"',";
                sql += "nacimiento='"+fecha+"' where id="+clave;
                
                try {
                    // Procesamos la solicitud
                    if(db.action(sql)){
                        // Limpiamos
                        txtClave.setText("");
                        txtNombre.setText("");
                        txtFecha.setText("");
                        
                        // Mostramos mensaje
                        JOptionPane.showMessageDialog(null, "El registro se modifico con exito", "Mensaje del sistema", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Mostramos mensaje
                        JOptionPane.showMessageDialog(null, "Error al modificar el registro\nLa clave no existe", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if(e.getSource().equals(btnConsulta)){
            // Creamos la sentencia sql
            String sql = "SELECT * FROM persona";

            try {
                // Procesamos la solicitud
                ResultSet res = db.select(sql);
                
                // Obtenemos todos los resultados
                while(res.next()){
                    // Mostramos mensaje
                    String text = "Clave: "+res.getInt("id");
                    text += "\nNombre: "+res.getString("nombre");
                    text += "\nFecha Nac: "+res.getDate("nacimiento");
                    JOptionPane.showMessageDialog(null, text, "Registros", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(e.getSource().equals(btnEliminar)){
            // Verificamos que todos los campos esten llenos
            if(clave.length() == 0){
                // Mostramos mensaje
                JOptionPane.showMessageDialog(null, "Llene el campo clave", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
            } else {
                // Creamos la sentencia sql
                String sql = "DELETE FROM persona WHERE id="+clave;
                
                try {
                    // Procesamos la solicitud
                    if(db.action(sql)){
                        // Limpiamos
                        txtClave.setText("");
                        txtNombre.setText("");
                        txtFecha.setText("");
                        
                        // Mostramos mensaje
                        JOptionPane.showMessageDialog(null, "El registro se elimino con exito", "Mensaje del sistema", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Mostramos mensaje
                        JOptionPane.showMessageDialog(null, "Error al eliminar el registro\nLa clave no existe", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
        // Code
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Code
    }
    
}
