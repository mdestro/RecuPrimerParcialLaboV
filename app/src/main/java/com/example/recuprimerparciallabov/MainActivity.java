package com.example.recuprimerparciallabov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.recuprimerparciallabov.AutoAdapter;
import com.example.recuprimerparciallabov.AutoModel;
import com.example.recuprimerparciallabov.HiloHttp;
import com.example.recuprimerparciallabov.MyOnItemClick;
import com.example.rpplaboratoriov.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback, MyOnItemClick {

    public  List<AutoModel> autos;
    AutoAdapter adapter;
    HiloHttp miHilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler( this );
        miHilo = new HiloHttp(handler,"http://192.168.0.224:3000/autos",true);
        miHilo.start();

        autos = new ArrayList<AutoModel>();

        adapter = new AutoAdapter(autos, this, this);
        RecyclerView rvAuto = super.findViewById(R.id.rvAutos);
        rvAuto.setAdapter(adapter);
        rvAuto.setLayoutManager( new GridLayoutManager( this, 2));
        rvAuto.setLayoutManager( new LinearLayoutManager(this));

    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        //        Lee novedades del Handler

        Log.d("Mensaje","llego un mensaje"+msg.obj);

        this.autos = this.miHilo.autos;

        adapter.setAutos( this.autos );
        adapter.notifyDataSetChanged();

        return false;
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
