package com.example.pr8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.tb1);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WifiManager wifi = (WifiManager) getApplicationContext() .getSystemService(Context.WIFI_SERVICE);
                if(t1.isChecked()){
                    wifi.setWifiEnabled(false);
                    Toast.makeText(MainActivity.this, "Wifi is disabled", Toast.LENGTH_SHORT).show();
                }else{
                    wifi.setWifiEnabled(true);
                    Toast.makeText(MainActivity.this, "Wifi is enabled", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

