package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Controller {
    Palindromo pal = new Palindromo(); // Instanciamos clase palidromo
    public String cadena = ""; // Cadena ingresada
    public String cadena2 = ""; // Cadena ingresada

    // Enlace con la plantilla fxml
    public Button btnMostrar;
    public TextField textfFrase;
    public Button btnAceptar;
    public Button btnLimpiar;
    public ListView mPila1;
    public ListView mPila2;

    // Metodo para rellenar las listview
    public void clickMostrar(ActionEvent actionEvent) {
        // Verificamos si hay texto
        if(textfFrase.getText().length() > 0) {
            // Obtenemos la cadena que se ingreo
            cadena = textfFrase.getText();
            // Convertimos la cadena en un array de caracteres
            char[] caracteres = cadena.toCharArray();
            // Llenamos la ListView 1
            mPila1.setItems(pal.llenarListaObservable(caracteres));
            // Volteamos la cadena
            cadena2 = pal.voltearCadena(caracteres);
            // Convertimos la cadena2 en un array de caracteres
            char[] caracteres2 = cadena2.toCharArray();
            // Llenamos la listView 2
            mPila2.setItems(pal.llenarListaObservable(caracteres2));
        } else {
            textfFrase.requestFocus(); // Ponemos el focus en el text field
        }
    }

    // Metodo para comprobar si es un polindromo
    public void click(ActionEvent actionEvent) {
        // verificamos si el textfFrase tiene contenido
        if(textfFrase.getText().length() > 0){
            // Verificamos si las cadenas tienen contenido
            if(cadena.length() == 0 && cadena2.length() == 0) {
                this.clickMostrar(actionEvent);
            } else if(!textfFrase.getText().equals(cadena)) {
                this.clickMostrar(actionEvent);
            }
            // Verificamos si la frase es de tipo polindromo
            if (pal.verificarPolindromo(this.cadena, this.cadena2)) {
                // Si es polindromo
                JOptionPane.showMessageDialog(null, "Es un palindromo");
            } else {
                // Si no es polindromo
                JOptionPane.showMessageDialog(null, "No es un palindromo", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            textfFrase.requestFocus(); // Ponemos el focus en el text field
        }
    }

    // Metodo para limpiar los controles del programa
    public void clickLimpiar(ActionEvent actionEvent) {
        textfFrase.setText(""); // Limpiamos el text field
        mPila1.setItems(null); // Limpiamos lista 1
        mPila2.setItems(null); // Limpiamos lista 2
        textfFrase.requestFocus(); // Ponemos el focus en el text field
    }
}
