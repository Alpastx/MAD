package com.example.pr7;

import  androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    DatePicker dp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp1 = findViewById(R.id.dp1);
        b1 = findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int month = dp1.getMonth() + 1;
                Toast.makeText(MainActivity.this, "Date: " + dp1.getDayOfMonth() + "/" + month + "/" + dp1.getYear(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}

