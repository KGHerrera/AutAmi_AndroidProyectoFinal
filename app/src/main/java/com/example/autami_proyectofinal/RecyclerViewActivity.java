package com.example.autami_proyectofinal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bd.FabBD;
import entidades.Fabricantes;

public class RecyclerViewActivity extends AppCompatActivity {
    public static Fabricantes fabricante;
    List<Fabricantes> elementos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        init();
    }

    public void init(){

        if (fabricante == null){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    FabBD bd = FabBD.getAppDatabase(getBaseContext());
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
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    FabBD bd = FabBD.getAppDatabase(getBaseContext());

                    if(fabricante.getIdFabricantes() == 0) elementos =
                            bd.fabricanteDAO().obtenerConsulta("%" ,fabricante.getNombre(),
                                    fabricante.getDireccion(), fabricante.getTelefono());
                    else elementos = bd.fabricanteDAO().obtenerConsulta(
                            "%" + fabricante.getIdFabricantes() +"%" ,fabricante.getNombre(),
                            fabricante.getDireccion(), fabricante.getTelefono());

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
}
