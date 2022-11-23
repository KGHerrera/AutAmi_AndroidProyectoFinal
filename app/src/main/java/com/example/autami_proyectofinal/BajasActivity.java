package com.example.autami_proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import bd.AutoBD;

public class BajasActivity extends AppCompatActivity {
    private EditText cajaID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajas);
    }

    public void eliminarRegistro(View v){
        cajaID = findViewById(R.id.cajaIdFabricanteBaja);

        if(!cajaID.getText().toString().equals("")){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        AutoBD bd = AutoBD.getAppDatabase(getBaseContext());
                        bd.fabricanteDAO().eliminarPorIdFrabricante(Integer.parseInt(cajaID.getText().toString()));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(), "se ejecuto la consulta", Toast.LENGTH_LONG).show();
                            }
                        });

                    } catch (Exception exception){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(), "ocurrio un error", Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                }
            }).start();

        } else{
            Toast.makeText(getBaseContext(), "introduce el id", Toast.LENGTH_LONG).show();
        }
    }
}