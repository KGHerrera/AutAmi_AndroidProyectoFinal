package com.example.autami_proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import bd.FabBD;
import entidades.Fabricantes;

public class AltasActivity extends AppCompatActivity {
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

    public void btnReset(View v){
        cajaNombre = findViewById(R.id.cajaNombre);
        cajaDireccion = findViewById(R.id.cajaDireccion);
        cajaTelefono = findViewById(R.id.cajaTelefono);

        cajaNombre.setText("");
        cajaDireccion.setText("");
        cajaTelefono.setText("");
    }

    public void btnResetNoBoton(){
        cajaNombre = findViewById(R.id.cajaNombre);
        cajaDireccion = findViewById(R.id.cajaDireccion);
        cajaTelefono = findViewById(R.id.cajaTelefono);

        cajaNombre.setText("");
        cajaDireccion.setText("");
        cajaTelefono.setText("");
    }

    public void agregarRegistro(View v) {
        mensaje = "te faltan los datos de [";

        cajaNombre = findViewById(R.id.cajaNombre);
        cajaDireccion = findViewById(R.id.cajaDireccion);
        cajaTelefono = findViewById(R.id.cajaTelefono);


        boolean isCajaNombre = !cajaNombre.getText().toString().equals("");
        boolean isCajaDireccion = !cajaDireccion.getText().toString().equals("");
        boolean isCajaTelefono = !cajaTelefono.getText().toString().equals("");

        if(isCajaNombre && isCajaDireccion && isCajaTelefono){
            fabricante.setNombre(cajaNombre.getText().toString());
            fabricante.setDireccion(cajaDireccion.getText().toString());
            fabricante.setTelefono(cajaTelefono.getText().toString());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        FabBD bd = FabBD.getAppDatabase(getBaseContext());
                        fabricante.setIdFabricantes(bd.fabricanteDAO().obtenerIdUltimoAgregado() + 1);
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
                                btnResetNoBoton();
                            }
                        });
                    }

                }
            }).start();
        } else {

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