package com.example.autami_proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import bd.AutoBD;
import entidades.Fabricantes;

public class AltasActivity extends AppCompatActivity {
    private EditText cajaID;
    private EditText cajaNombre;
    private EditText cajaDireccion;
    private EditText cajaTelefono;
    private Fabricantes fabricante = new Fabricantes();
    private String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);
    }

    public void agregarRegistro(View v) {
        mensaje = "te faltan los datos de [";
        cajaID = findViewById(R.id.cajaIdFabricanteAlta);
        cajaNombre = findViewById(R.id.cajaNombre);
        cajaDireccion = findViewById(R.id.cajaDireccion);
        cajaTelefono = findViewById(R.id.cajaTelefono);

        boolean isCajaID = !cajaID.getText().toString().equals("");
        boolean isCajaNombre = !cajaNombre.getText().toString().equals("");
        boolean isCajaDireccion = !cajaDireccion.getText().toString().equals("");
        boolean isCajaTelefono = !cajaTelefono.getText().toString().equals("");

        if(isCajaID && isCajaNombre && isCajaDireccion && isCajaTelefono){

            fabricante.setIdFabricantes(Integer.parseInt(cajaID.getText().toString()));
            fabricante.setNombre(cajaNombre.getText().toString());
            fabricante.setDireccion(cajaDireccion.getText().toString());
            fabricante.setTelefono(cajaTelefono.getText().toString());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        AutoBD bd = AutoBD.getAppDatabase(getBaseContext());
                        bd.fabricanteDAO().agregarFabricante(fabricante);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(), "agregado correctamente", Toast.LENGTH_LONG).show();
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
        } else {
            
            if (!isCajaID){
                mensaje += " idFabricante";
            }

            if (!isCajaNombre){
                mensaje += " nombre";
            }

            if (!isCajaDireccion){
                mensaje += " direccion";
            }

            if (!isCajaTelefono){
                mensaje += " telefono";
            }

            mensaje += " ]";
            Toast.makeText(getBaseContext(), mensaje, Toast.LENGTH_LONG).show();
        }
    }

}