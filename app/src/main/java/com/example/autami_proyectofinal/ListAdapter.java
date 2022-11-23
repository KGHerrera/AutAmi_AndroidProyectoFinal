package com.example.autami_proyectofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import entidades.Fabricantes;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Fabricantes> fData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<Fabricantes> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.fData = itemList;
    }

    @Override
    public int getItemCount(){return fData.size(); }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.lista_elementos, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(fData.get(position));
    }

    public void setItems(List<Fabricantes> items){ fData = items; }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView nombre, direccion, telefono;

        ViewHolder(View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            nombre = itemView.findViewById(R.id.nombreTextView);
            direccion = itemView.findViewById(R.id.direccionTextView);
            telefono = itemView.findViewById(R.id.telefonoTextView);
        }

        void bindData(final Fabricantes item){
            nombre.setText(item.getNombre());
            direccion.setText(item.getDireccion());
            telefono.setText(item.getTelefono());
        }
    }



}
