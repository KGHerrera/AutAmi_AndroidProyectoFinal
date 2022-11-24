package com.example.autami_proyectofinal;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bd.AutoBD;
import entidades.Fabricantes;

public class RecyclerViewActivity extends AppCompatActivity {

    List<Fabricantes> elementos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        init();
    }

    public void init(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                AutoBD bd = AutoBD.getAppDatabase(getBaseContext());
                elementos = bd.fabricanteDAO().obtenerTodos();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ListAdapter listAdapter = new ListAdapter(elementos, getBaseContext());
                        RecyclerView recyclerView = findViewById(R.id.lista_fabricantes);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                        recyclerView.setAdapter(listAdapter);
                    }
                });


            }
        }).start();


    }
}
