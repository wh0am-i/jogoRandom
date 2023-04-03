package com.example.jogorandom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int[] nudes = {R.drawable.ben10, R.drawable.finn, R.drawable.motomoto, R.drawable.titas, R.drawable.sally};
    ImageView nude;
    EditText entrada;
    TextView saida;
    Button confirmabtt, gerarbtt;
    int numero = 0;
    int tentativas = 5;
    Random gerador = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        nude = findViewById(R.id.nude);
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
        if (!entrada.getText().toString().isEmpty()) {
            int digitado = Integer.parseInt(entrada.getText().toString());
            if (tentativas > 0) {
                if (numero != 0) {
                    tentativas -= 1;
                    if (digitado > numero) {
                        saida.setText("O número digitado é maior! \n" + "Você ainda tem " + tentativas + " tentativas!");
                    } else if (digitado < numero) {
                        saida.setText("O número digitado é menor! \n" + "Você ainda tem " + tentativas + " tentativas!");
                    } else if (digitado == numero) {
                        saida.setText("Bom garoto, toma esse nude de recompensa!");
                        nude.setVisibility(View.VISIBLE);
                        nude.setImageResource(nudes[gerador.nextInt(5)]);
                    }
                } else {
                    saida.setText("Vai gerar numero não? Vacilão!");
                }
            } else {
                saida.setText("Acabou suas tentativas, ruinzão hein!");
            }
        }
        else {
            saida.setText("Queria crashar o app né amigão? \n Não vai rolar!");
        }
    }

    public void gerar() {
        nude.setVisibility(View.INVISIBLE);
        tentativas = 5;
        numero = gerador.nextInt(20) + 1;//gera números de 0 à 99 -> o +1 faz não ter o 0 e ir até 100
    }
}