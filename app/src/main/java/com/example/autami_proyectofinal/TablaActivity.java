package com.example.autami_proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import bd.FabBD;
import entidades.Fabricantes;

public class TablaActivity extends AppCompatActivity {

    ListView listaViewAutos;
    List<Fabricantes> listaFabricantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla);
        listaViewAutos = findViewById(R.id.textview_fabricantes);


        new Thread(new Runnable() {
            @Override
            public void run() {
                FabBD bd = FabBD.getAppDatabase(getBaseContext());
                listaFabricantes = bd.fabricanteDAO().obtenerTodos();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter adaptador = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listaFabricantes);
                        listaViewAutos.setAdapter(adaptador);
                    }
                });


            }
        }).start();

    }
}