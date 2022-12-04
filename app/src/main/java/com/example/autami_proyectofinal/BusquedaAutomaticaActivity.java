package com.example.autami_proyectofinal;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bd.FabBD;
import entidades.Fabricantes;

public class BusquedaAutomaticaActivity extends AppCompatActivity {
    List<Fabricantes> elementos;
    EditText cajaCampo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_dinamica);

        init();
    }

    public void init(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                FabBD bd = FabBD.getAppDatabase(getBaseContext());
                elementos = bd.fabricanteDAO().obtenerTodos();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ListAdapter listAdapter = new ListAdapter(elementos, getBaseContext());
                        RecyclerView recyclerView = findViewById(R.id.lista_nueva);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                        recyclerView.setAdapter(listAdapter);
                    }
                });
            }
        }).start();

        cajaCampo = findViewById(R.id.cajaCampoMagico);

        cajaCampo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        FabBD bd = FabBD.getAppDatabase(getBaseContext());
                        String texto = "%" + cajaCampo.getText().toString() + "%";
                        elementos = bd.fabricanteDAO().obtenerBusquedaDinamica(texto, texto, texto, texto);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ListAdapter listAdapter = new ListAdapter(elementos, getBaseContext());
                                RecyclerView recyclerView = findViewById(R.id.lista_nueva);
                                recyclerView.setHasFixedSize(true);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                                recyclerView.setAdapter(listAdapter);
                            }
                        });
                    }
                }).start();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

}
