package org.codeando.mycalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    private EditText txtNum1, txtNum2, txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazamos las variables
        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);
        txtRes = (EditText) findViewById(R.id.txtRes);
    }

    public void sumar(View view)
    {
        // verificamos que tengan valores
        if(txtNum1.getText().length() > 0 && txtNum2.getText().length() > 0) {
            // Obtenemos los valores
            Double num1 = Double.parseDouble(txtNum1.getText().toString());
            Double num2 = Double.parseDouble(txtNum2.getText().toString());

            // Mostramos el resultado
            txtRes.setText(""+(num1 + num2));
        }
    }
}
