package com.example.autami_proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bd.FabBD;
import entidades.Usuarios;

public class MainActivity extends AppCompatActivity {

    private Button iniciarSesion;
    private EditText cajaUser;
    private EditText cajaPassword;
    private Usuarios usuario = new Usuarios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void restet(View v) {

        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                FabBD bd = FabBD.getAppDatabase(getBaseContext());
                bd.usuarioDAO().agregarUsuario(new Usuarios(2, "admin", "admin"));
            }
        }).start();
        */

        cajaUser = findViewById(R.id.cajaUser);
        cajaPassword = findViewById(R.id.cajaPassword);

        cajaUser.setText("");
        cajaPassword.setText("");
    }

    public void verificarUsuario(View v) {
        cajaUser = findViewById(R.id.cajaUser);
        cajaPassword = findViewById(R.id.cajaPassword);

        boolean isCajaUser = !cajaUser.getText().toString().equals("");
        boolean isPassword = !cajaPassword.getText().toString().equals("");

        if(isCajaUser && isPassword) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        FabBD bd = FabBD.getAppDatabase(getBaseContext());
                        String resultado = bd.usuarioDAO().verificarUsuario(cajaUser.getText().toString(), cajaPassword.getText().toString());

                        if (resultado != null){
                            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                            startActivity(intent);
                        } else{
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getBaseContext(), "datos incorrectos", Toast.LENGTH_LONG).show();
                                }
                            });
                        }

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
            Toast.makeText(getBaseContext(), "faltan datos", Toast.LENGTH_LONG).show();
        }

    }




}