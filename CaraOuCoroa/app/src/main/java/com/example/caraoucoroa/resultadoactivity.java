package com.example.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class resultadoactivity extends AppCompatActivity {

    private ImageView imageVoltar;
    private ImageView imageResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadoactivity);

        imageVoltar = findViewById(R.id.imageVoltar);
        imageResultado = findViewById(R.id.imageResultado);

        //recuperar dados
        Bundle dados = getIntent().getExtras();
        int numero = dados.getInt( "numero" );

        if( numero == 0 ){ //cara
            imageResultado.setImageResource(R.drawable.moeda_cara);
            Toast.makeText(getApplicationContext(), "Cara", Toast.LENGTH_SHORT).show();

        }else{ //coroa
            imageResultado.setImageResource(R.drawable.moeda_coroa);
            Toast.makeText(getApplicationContext(),"Coroa", Toast.LENGTH_SHORT).show();
        }

        imageVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });

    }
}