package com.matisoft.tp5mdiaz_matias_nicolas;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class Llamada extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Verifica si el dispositivo se ha conectado a una red Wi-Fi
        boolean conexion = intent.getBooleanExtra("connected", false);
        if (conexion) {
            Toast.makeText(context, "Wifi ON, LLAMANDO", Toast.LENGTH_SHORT).show();
            llamar(context); // Pasa el contexto a la función llamar
        } else {
            Toast.makeText(context, "Wifi OFF", Toast.LENGTH_SHORT).show();
        }
    }

    private void llamar(Context context) {
        String numeroTelefono = "2657556122";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + numeroTelefono)); // Corrige el formato de la URI
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}