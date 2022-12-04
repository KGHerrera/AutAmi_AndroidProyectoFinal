package com.example.autami_proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import bd.FabBD;
import entidades.Fabricantes;

public class BajasActivity extends AppCompatActivity {
    private EditText cajaID;
    private Fabricantes fabricante2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajas);
    }

    public void btnReset(View v){
        cajaID = findViewById(R.id.cajaIdFabricanteBaja);
        cajaID.setText("");
    }

    public void btnResetNoBoton(){
        cajaID = findViewById(R.id.cajaIdFabricanteBaja);
        cajaID.setText("");
    }

    public void verTablaFabricantes(View v) {
        RecyclerViewActivity.fabricante = fabricante2;
        Intent intent = new Intent(BajasActivity.this, RecyclerViewActivity.class);
        startActivity(intent);
    }

    public void eliminarRegistro(View v){
        cajaID = findViewById(R.id.cajaIdFabricanteBaja);

        if(!cajaID.getText().toString().equals("")){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        FabBD bd = FabBD.getAppDatabase(getBaseContext());
                        int resultado = bd.fabricanteDAO().eliminarPorIdFrabricante(Integer.parseInt(cajaID.getText().toString()));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(resultado == 1){
                                    Toast.makeText(getBaseContext(), "se elimino correctamente", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getBaseContext(), "no se elimino el id no existe", Toast.LENGTH_LONG).show();
                                }
                                btnResetNoBoton();
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