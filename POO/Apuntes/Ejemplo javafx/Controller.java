/********************************************************
Test Controlador para la vista

Autor: Paulo Andrade
Fecha: 09/11/2016
********************************************************/

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;
import javax.swing.*;

public class Controller
{
    public int numero;
    public Label lblNumero;
    public Button btnPrincipal;
    public TextField txtfNumero;

    // Metodo de accion para el boton de la ventana
    public void click(ActionEvent e)
    {
        numero = Integer.parseInt(txtfNumero.getText());

        int fact = 1;

        while(numero > 1){
            fact *= numero;
            numero--;
        }
        // Aqui mostrariamo el resultado en el label de la ventana
        // lblNumero.setText(String.valueOf(fact));
        // Limpiamos el textfiel
        txtfNumero.setText("");
        // Mostramos el mensaje en una ventana modal
        JOptionPane.showMessageDialog(null, "El factorial es: " + fact);
    }
}
