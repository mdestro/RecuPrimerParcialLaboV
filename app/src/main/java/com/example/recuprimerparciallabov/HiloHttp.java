package com.example.recuprimerparciallabov;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HiloHttp extends Thread {

    private Handler handler;
    private String url;
    private Boolean text;
    List<AutoModel> autos;

    public HiloHttp(Handler handler, String url, Boolean text)
    {
        this.handler = handler;
        this.url = url;
        this.text = text;
    }

    @Override
    public void run() {

        HttpManager manager = new HttpManager();
        Log.d("SERVICIO 1", "Intenta consumir");

        String respuestaServidor = manager.consumerAutos(this.url);

        Log.d("SERVICIO 1", "Servicio consumido");
//
        if (respuestaServidor != null) {

//            Armar lista de objetos
            this.autos = new ArrayList<AutoModel>();
            JSONArray array = null;
            try {
                array = new JSONArray(respuestaServidor);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    Log.d("id", object.getString("id"));
                    Log.d("marca", object.getString("make"));
                    Log.d("modelo", object.getString("model"));
                    Log.d("year", object.getString("year"));

                    AutoModel a = new AutoModel(Integer.getInteger(object.getString("id")), object.getString("make"), object.getString("model"), Integer.getInteger( object.getString("year")));
                    autos.add(a);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else {
            Log.d("SERVICIO 1", "respuesta nula");
        }

        Message message = new Message();
        message.obj = respuestaServidor;
        this.handler.sendMessage(message);
    }

    }


