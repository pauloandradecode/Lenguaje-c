package org.codeando.mycalculadora3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView lblRes;
    Double num = 0.0;
    String op = "";
    boolean control = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtenemos los elementos
        lblRes = (TextView) findViewById(R.id.lblRes);
    }

    // Botones numericos
    public void clickBtn0(View view)
    {
        // Verificamos que sea distinto a 0
        if(lblRes.getText().length() > 0){
            // Verificamos si el control esta disponible
            if(control) {
                if (Double.parseDouble(lblRes.getText().toString()) != 0) {
                    lblRes.setText(String.valueOf(lblRes.getText() + "0"));
                } else if (lblRes.getText().toString().contains(".")) {
                    lblRes.setText(String.valueOf(lblRes.getText() + "0"));
                }
            } else {
                lblRes.setText("0");
                control = true;
            }
        } else {
            lblRes.setText("0");
        }
    }
    public void clickBtn1(View view)
    {
        // Comprobamos si hay elementos en pantalla
        if(lblRes.getText().length() > 0){
            // Verificamos si el control esta disponible
            if(control) {
                // Comprobamos si es distinto a 0
                if(Double.parseDouble(lblRes.getText().toString()) != 0){
                    lblRes.setText(String.valueOf(lblRes.getText()+"1"));
                } else if(lblRes.getText().toString().contains(".")){
                    lblRes.setText(String.valueOf(lblRes.getText()+"1"));
                } else {
                    lblRes.setText("1");
                }
            } else {
                lblRes.setText("1");
                control = true;
            }
        } else {
            // Si no hay elementos solo agregamos el numero
            lblRes.setText("1");
        }
    }
    public void clickBtn2(View view)
    {
        // Comprobamos si hay elementos en pantalla
        if(lblRes.getText().length() > 0){
            // Verificamos si el control esta disponible
            if(control) {
                // Comprobamos si es distinto a 0
                if(Double.parseDouble(lblRes.getText().toString()) != 0){
                    lblRes.setText(String.valueOf(lblRes.getText()+"2"));
                } else if(lblRes.getText().toString().contains(".")){
                    lblRes.setText(String.valueOf(lblRes.getText()+"2"));
                } else {
                    lblRes.setText("2");
                }
            } else {
                lblRes.setText("2");
                control = true;
            }
        } else {
            // Si no hay elementos solo agregamos el numero
            lblRes.setText("2");
        }
    }
    public void clickBtn3(View view)
    {
        // Comprobamos si hay elementos en pantalla
        if(lblRes.getText().length() > 0){
            // Verificamos si el control esta disponible
            if(control) {
                // Comprobamos si es distinto a 0
                if(Double.parseDouble(lblRes.getText().toString()) != 0){
                    lblRes.setText(String.valueOf(lblRes.getText()+"3"));
                } else if(lblRes.getText().toString().contains(".")){
                    lblRes.setText(String.valueOf(lblRes.getText()+"3"));
                } else {
                    lblRes.setText("3");
                }
            } else {
                lblRes.setText("3");
                control = true;
            }
        } else {
            // Si no hay elementos solo agregamos el numero
            lblRes.setText("3");
        }
    }
    public void clickBtn4(View view)
    {
        // Comprobamos si hay elementos en pantalla
        if(lblRes.getText().length() > 0){
            // Verificamos si el control esta disponible
            if(control) {
                // Comprobamos si es distinto a 0
                if(Double.parseDouble(lblRes.getText().toString()) != 0){
                    lblRes.setText(String.valueOf(lblRes.getText()+"4"));
                } else if(lblRes.getText().toString().contains(".")){
                    lblRes.setText(String.valueOf(lblRes.getText()+"4"));
                } else {
                    lblRes.setText("4");
                }
            } else {
                lblRes.setText("4");
                control = true;
            }
        } else {
            // Si no hay elementos solo agregamos el numero
            lblRes.setText("4");
        }
    }
    public void clickBtn5(View view)
    {
        // Comprobamos si hay elementos en pantalla
        if(lblRes.getText().length() > 0){
            // Verificamos si el control esta disponible
            if(control) {
                // Comprobamos si es distinto a 0
                if(Double.parseDouble(lblRes.getText().toString()) != 0){
                    lblRes.setText(String.valueOf(lblRes.getText()+"5"));
                } else if(lblRes.getText().toString().contains(".")){
                    lblRes.setText(String.valueOf(lblRes.getText()+"5"));
                } else {
                    lblRes.setText("5");
                }
            } else {
                lblRes.setText("5");
                control = true;
            }
        } else {
            // Si no hay elementos solo agregamos el numero
            lblRes.setText("5");
        }
    }
    public void clickBtn6(View view)
    {
        // Comprobamos si hay elementos en pantalla
        if(lblRes.getText().length() > 0){
            // Verificamos si el control esta disponible
            if(control) {
                // Comprobamos si es distinto a 0
                if(Double.parseDouble(lblRes.getText().toString()) != 0){
                    lblRes.setText(String.valueOf(lblRes.getText()+"6"));
                } else if(lblRes.getText().toString().contains(".")){
                    lblRes.setText(String.valueOf(lblRes.getText()+"6"));
                } else {
                    lblRes.setText("6");
                }
            } else {
                lblRes.setText("6");
                control = true;
            }
        } else {
            // Si no hay elementos solo agregamos el numero
            lblRes.setText("6");
        }
    }
    public void clickBtn7(View view)
    {
        // Comprobamos si hay elementos en pantalla
        if(lblRes.getText().length() > 0){
            // Verificamos si el control esta disponible
            if(control) {
                // Comprobamos si es distinto a 0
                if(Double.parseDouble(lblRes.getText().toString()) != 0){
                    lblRes.setText(String.valueOf(lblRes.getText()+"7"));
                } else if(lblRes.getText().toString().contains(".")){
                    lblRes.setText(String.valueOf(lblRes.getText()+"7"));
                } else {
                    lblRes.setText("7");
                }
            } else {
                lblRes.setText("7");
                control = true;
            }
        } else {
            // Si no hay elementos solo agregamos el numero
            lblRes.setText("7");
        }
    }
    public void clickBtn8(View view)
    {
        // Comprobamos si hay elementos en pantalla
        if(lblRes.getText().length() > 0){
            // Verificamos si el control esta disponible
            if(control) {
                // Comprobamos si es distinto a 0
                if(Double.parseDouble(lblRes.getText().toString()) != 0){
                    lblRes.setText(String.valueOf(lblRes.getText()+"8"));
                } else if(lblRes.getText().toString().contains(".")){
                    lblRes.setText(String.valueOf(lblRes.getText()+"8"));
                } else {
                    lblRes.setText("8");
                }
            } else {
                lblRes.setText("8");
                control = true;
            }
        } else {
            // Si no hay elementos solo agregamos el numero
            lblRes.setText("8");
        }
    }
    public void clickBtn9(View view)
    {
        // Comprobamos si hay elementos en pantalla
        if(lblRes.getText().length() > 0){
            // Verificamos si el control esta disponible
            if(control) {
                // Comprobamos si es distinto a 0
                if(Double.parseDouble(lblRes.getText().toString()) != 0){
                    lblRes.setText(String.valueOf(lblRes.getText()+"9"));
                } else if(lblRes.getText().toString().contains(".")){
                    lblRes.setText(String.valueOf(lblRes.getText()+"9"));
                } else {
                    lblRes.setText("9");
                }
            } else {
                lblRes.setText("9");
                control = true;
            }
        } else {
            // Si no hay elementos solo agregamos el numero
            lblRes.setText("9");
        }
    }

    // Botones de operaciones
    public void clickSuma(View view)
    {
        op = "+";
        num = Double.parseDouble(lblRes.getText().toString());
        lblRes.setText("");
    }
    public void clickResta(View view)
    {
        op = "-";
        num = Double.parseDouble(lblRes.getText().toString());
        lblRes.setText("");
    }
    public void clickDiv(View view)
    {
        op = "/";
        num = Double.parseDouble(lblRes.getText().toString());
        lblRes.setText("");
    }
    public void clickMul(View view)
    {
        op = "*";
        num = Double.parseDouble(lblRes.getText().toString());
        lblRes.setText("");
    }

    // Botones punto, igual, borrar
    public void clickPunto(View view)
    {
        // Verificamos si ya existe un punto en la pantalla
        if(!lblRes.getText().toString().contains(".")){
            lblRes.setText(String.valueOf(lblRes.getText() + "."));
        }
    }
    public void clickClear(View view)
    {
        // Limpiamos
        lblRes.setText("0");
        num = 0.0;
        op = "";
        control = true;
    }
    public void clickIgual(View view)
    {
        // Obtenemos el numero 2
        Double num2 = Double.parseDouble(lblRes.getText().toString());

        // verificamos la operacion a realizar
        switch(op){
            case "+":
                num = num + num2;
                break;
            case "-":
                num = num - num2;
                break;
            case "/":
                num = num / num2;
                break;
            case "*":
                num = num * num2;
                break;
        }

        // Mostramos el resultado
        lblRes.setText(String.valueOf(num));
        control = false;
    }
}
