package com.example.autami_proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MenuActivity extends AppCompatActivity {
    private Button btnAltas;
    private Button btnBajas;
    private Button btnCambios;
    private Button btnConsultas;
    private Button btnVerTabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnAltas = (Button) findViewById(R.id.btnAltas);
        btnBajas = (Button) findViewById(R.id.btnBajas);
        btnCambios = (Button) findViewById(R.id.btnCambios);
        btnConsultas = (Button) findViewById(R.id.btnConsultas);
        btnVerTabla = (Button) findViewById(R.id.btnVerTabla);

        btnAltas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AltasActivity.class);
                startActivity(intent);
            }
        });

        btnBajas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, BajasActivity.class);
                startActivity(intent);
            }
        });

        btnCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, CambiosActivity.class);
                startActivity(intent);
            }
        });

        btnConsultas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ConsultasActivity.class);
                startActivity(intent);
            }
        });

        btnVerTabla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });




    }
}