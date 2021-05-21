package com.example.recuprimerparciallabov;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rpplaboratoriov.R;

import java.util.List;

public class AutoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public View view;
    public TextView tvMarca;
    public TextView tvModelo;
    private MyOnItemClick listener;
    private int position;
    private AppCompatActivity activity;
    private List<AutoModel> autos;
    private AutoAdapter adapter;

    public AutoViewHolder(@NonNull View itemView, MyOnItemClick listener, AppCompatActivity act, List<AutoModel> autos, AutoAdapter adapter) {
        super(itemView);
        this.view = itemView;
        this.tvMarca = this.view.findViewById(R.id.tvMarca);
        this.tvModelo = this.view.findViewById(R.id.tvModelo);
        this.adapter = adapter;


        itemView.setOnClickListener(this);
        this.listener = listener;
        this.activity = act;
        this.autos = autos;
}

    public void setPosition(int position)
    {
        this.position = position;
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(position);
        Log.d("Se hizo un click","Click en position"+position);

        AutoModel auto = this.autos.get(position);
        Intent intent = new Intent(this.activity, AutoView.class);
        intent.putExtra("marca",auto.getMarca().toString());
        intent.putExtra("modelo",auto.getModelo().toString());
        intent.putExtra("anio",auto.getAnio());
        intent.putExtra("id",auto.getId());
        this.activity.startActivity(intent);


    }
}
