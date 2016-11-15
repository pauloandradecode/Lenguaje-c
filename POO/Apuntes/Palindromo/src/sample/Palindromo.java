package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static jdk.nashorn.internal.objects.NativeArray.push;

/**
 * Created by plalex on 14/11/2016.
 */

public class Palindromo
{
    public String quitarEspacios(String frase) {
        // cadena auxiliar
        String cadenaAux = "";
        // Convertimos la frase en un array de caracteres
        char[] aux = frase.toCharArray();

        // Recorremos el array de caracteres
        for(int i = 0; i < aux.length; i++){
            // Verificamos si hay espacios
            if(aux[i] != ' '){
                cadenaAux += aux[i];
            }
        }

        // Retornamos la cadena
        return cadenaAux;
    }

    public String voltearCadena(char[] caracteres) {
        String cadena = ""; // Cadena a armar
        int i = caracteres.length - 1; // Contador

        // Recorremos la cadena
        while(i >= 0){
            // Concatenamos el caracter a la cadena
            cadena += caracteres[i];
            // Disminuimos el contador
            i--;
        }

        // Retornamos la cadena
        return cadena;
    }

    // Metodo para verificar si es un polindromo
    public Boolean verificarPolindromo(String cad1, String cad2) {
        boolean result; // REsultado

        // Les quitamos los espacios a las cadenas
        cad1 = this.quitarEspacios(cad1);
        cad2 = this.quitarEspacios(cad2);

        // Verificamos si son iguales
        if(cad1.equals(cad2)){
            // retornamos el resultado
            return true;
        } else {
            // retornamos el resultado
            return false;
        }
    }

    // Metodo para rellenar una listview
    public ObservableList llenarListaObservable(char[] caracteres){
        // Creamos un arrayList observable vacio
        ObservableList lista = FXCollections.observableArrayList();

        // Recorremos el array de caracteres
        for(char c:caracteres){
            // Verificamos si hay espacio
            if(c != ' ') {
                // Agregamos al arrayList Observable
                lista.add(c);
            }
        }

        // Retornamos el arrayList Observable
        return lista;
    }
}
