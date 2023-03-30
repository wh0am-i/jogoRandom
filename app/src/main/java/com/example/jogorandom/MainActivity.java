package com.example.jogorandom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText entrada;
    TextView saida;
    Button confirmabtt, gerarbtt;
    int numero = 0;
    int tentativas;
    Random gerador = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        entrada = findViewById(R.id.entrada);
        saida = findViewById(R.id.saida);
        confirmabtt = findViewById(R.id.confirmabtt);
        confirmabtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirma();
            }
        });
        gerarbtt = findViewById(R.id.gerarbtt);
        gerarbtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gerar();
            }
        });
    }

    public void confirma() {
        int digitado = Integer.parseInt(entrada.getText().toString());
        if (digitado > numero) {

        } else if (digitado < numero) {

        } else if (numero != 0 && digitado == numero) {

        } else {
            Toast.makeText(this, "", Toast.LENGTH_LONG).show();
        }
    }

    public void gerar() {
        tentativas = 0;
        numero = gerador.nextInt(100) + 1;//gera números de 0 à 99 -> o +1 faz não ter o 0 e ir até 100
    }
}