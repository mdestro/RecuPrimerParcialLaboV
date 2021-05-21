package com.example.recuprimerparciallabov;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rpplaboratoriov.R;

public class AutoView extends AppCompatActivity implements View.OnClickListener {

    public static AutoModel auto;
   // public static AutoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_auto);

        //  Disponibilizar el back
        ActionBar toolbar = super.getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);

        //Obtener la informacion para iniciar la actividad
        Bundle bundle = super.getIntent().getExtras();

        EditText ed = findViewById(R.id.edMarca);
        ed.setText((String) bundle.get("marca"));

        ed = findViewById(R.id.edModelo);
        ed.setText((String) bundle.get("modelo"));

        ed = findViewById(R.id.edyear);
        ed.setText((String) bundle.get("anio"));

        Button button = findViewById(R.id.BtnEdit);
        button.setOnClickListener( this );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menuItem)
    {
        super.getMenuInflater().inflate(R.menu.menu, menuItem);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

//Captura la accion sobre el BACK
        if (item.getItemId()==android.R.id.home)
        {
            Log.d("Click en menu","HOME");
            super.finish();
        }

        return false;
    }


    @Override
    public void onClick(View v) {
            Log.d("Click en Edit","edit");
        AutoController autoController;
        autoController = new AutoController( this );

        if ( v.getId() == R.id.BtnEdit ){
            autoController.Save();
            Log.d("Click en Edit","edit");

            super.finish();
        } }


    }

