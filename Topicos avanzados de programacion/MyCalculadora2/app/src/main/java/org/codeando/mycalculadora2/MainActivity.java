package org.codeando.mycalculadora2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity
{
    private EditText txtNum1, txtNum2, txtRes;
    private RadioButton rbSuma, rbResta, rbDiv, rbMul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazamos con la vista
        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);
        txtRes = (EditText) findViewById(R.id.txtRes);
        rbSuma = (RadioButton) findViewById(R.id.rbSuma);
        rbResta = (RadioButton) findViewById(R.id.rbResta);
        rbDiv = (RadioButton) findViewById(R.id.rbDiv);
        rbMul = (RadioButton) findViewById(R.id.rbMul);
    }

    // Metodos para operar
    public void calcular(View view)
    {
        Double num1;
        Double num2;

        // Obteneos los valores
        if(txtNum1.getText().length() > 0 && txtNum2.getText().length() > 0) {
            num1 = Double.parseDouble(txtNum1.getText().toString());
            num2 = Double.parseDouble(txtNum2.getText().toString());
        } else {
            num1 = 0.0;
            num2 = 0.0;
        }
        Double res = 0.0;

        // Verificamos el radio buttin presionado
        if(rbSuma.isChecked()){
            res = num1 + num2;
        } else if(rbResta.isChecked()){
            res = num1 - num2;
        } else if(rbDiv.isChecked()){
            res = num1 / num2;
        } else if(rbMul.isChecked()){
            res = num1 * num2;
        }

        // Mostramos el resultado en pantalla
        txtRes.setText(""+res);
    }
}
