package com.example.autami_proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import entidades.Fabricantes;

public class ConsultasActivity extends AppCompatActivity {
    private EditText cajaID;
    private EditText cajaNombre;
    private EditText cajaDireccion;
    private EditText cajaTelefono;
    private Fabricantes fabricante = new Fabricantes();
    private String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);
    }

    public void btnReset(View v){
        cajaID = findViewById(R.id.cajaIdFabricantesConsultas);
        cajaNombre = findViewById(R.id.cajaNombreConsultas);
        cajaDireccion = findViewById(R.id.cajaDireccionConsultas);
        cajaTelefono = findViewById(R.id.cajaTelefonoConsultas);

        cajaID.setText("");
        cajaNombre.setText("");
        cajaDireccion.setText("");
        cajaTelefono.setText("");
    }

    public void obtenerConsulta(View v){
        mensaje = "introduce al menos un dato";
        cajaID = findViewById(R.id.cajaIdFabricantesConsultas);
        cajaNombre = findViewById(R.id.cajaNombreConsultas);
        cajaDireccion = findViewById(R.id.cajaDireccionConsultas);
        cajaTelefono = findViewById(R.id.cajaTelefonoConsultas);

        boolean isCajaID = !cajaID.getText().toString().trim().equals("");
        boolean isCajaNombre = !cajaNombre.getText().toString().trim().equals("");
        boolean isCajaDireccion = !cajaDireccion.getText().toString().trim().equals("");
        boolean isCajaTelefono = !cajaTelefono.getText().toString().trim().equals("");

        if(isCajaID || isCajaNombre || isCajaDireccion || isCajaTelefono){

            if(isCajaID){
                fabricante.setIdFabricantes(Integer.parseInt(cajaID.getText().toString()));
            } else{
                fabricante.setIdFabricantes(0);
            }

            if(isCajaNombre){
                fabricante.setNombre( "%" + cajaNombre.getText().toString().trim() + "%");
            } else{
                fabricante.setNombre("%");
            }

            if(isCajaDireccion){
                fabricante.setDireccion("%" + cajaDireccion.getText().toString().trim() + "%");
            } else{
                fabricante.setDireccion("%");
            }

            if(isCajaTelefono){
                fabricante.setTelefono("%" + cajaTelefono.getText().toString().trim() + "%");
            } else {
                fabricante.setTelefono("%");
            }


            RecyclerViewActivity.fabricante = fabricante;

            Intent intent = new Intent(ConsultasActivity.this, RecyclerViewActivity.class);
            startActivity(intent);


        } else {
            Toast.makeText(getBaseContext(), mensaje, Toast.LENGTH_LONG).show();
        }

    }
}