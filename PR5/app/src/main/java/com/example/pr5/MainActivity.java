package com.example.pr5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ListView lv1;
    String[] cars = {"Ferrari", "Lamborghini", "Buggati", "Konigsegg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = findViewById(R.id.lv1);
        ArrayAdapter<String> arr = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cars);

        lv1.setAdapter(arr);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Selected = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, Selected, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
