package com.matisoft.tp5mdiaz_matias_nicolas;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Llamada llamada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1500);
        }
        conectarseBroadcast();
    }

    private void conectarseBroadcast(){
        this.llamada=new Llamada();
        registerReceiver(this.llamada,new IntentFilter("android.net.wifi.supplicant.CONNECTION_CHANGE"));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.llamada);
    }
}