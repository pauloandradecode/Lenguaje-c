package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;

import javax.swing.*;

public class Controller {
    public int numero;
    public Label lblNumero;
    public Button btnPrincipal;
    public TextField txtfNumero;

    public void click(ActionEvent e)
    {
        numero = Integer.parseInt(txtfNumero.getText());

        int fact = 1;

        while(numero > 1){
            fact *= numero;
            numero--;
        }
        // lblNumero.setText(String.valueOf(fact));
        // Mostramos el mensaje
        JOptionPane.showMessageDialog(null, "El factorial es: " + fact);
        // Limpiamos el textfiel
        txtfNumero.setText("");
        // System.out.println("prueba");
    }
}
