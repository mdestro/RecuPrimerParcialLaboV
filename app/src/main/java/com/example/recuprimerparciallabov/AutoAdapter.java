package com.example.recuprimerparciallabov;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rpplaboratoriov.R;

import java.util.List;

public class AutoAdapter extends RecyclerView.Adapter<AutoViewHolder> {
    private List<AutoModel> autos;
    private MyOnItemClick listener;
    private AppCompatActivity activity;

    public AutoAdapter ( List<AutoModel> autos, MyOnItemClick listener, AppCompatActivity act )
    {
        this.autos = autos;
        this.listener = listener;
        this.activity = act;
    }

    public List<AutoModel> getAutos() {
        return autos;
    }

    public void setAutos(List<AutoModel> autos) {
        this.autos = autos;
    }

    @NonNull
    @Override
    public AutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//     Transofrma un objeto XML LAYOUT en un objeto view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_auto, parent, false);

        AutoViewHolder vh = new AutoViewHolder(view, listener, activity, autos, this);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AutoViewHolder holder, int position) {
//    Bindea el objeto visual con la lista de autos
        AutoModel p = this.autos.get(position);
        holder.tvModelo.setText(p.getModelo());
        holder.tvMarca.setText(p.getMarca());
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return this.autos.size();
    }
}
