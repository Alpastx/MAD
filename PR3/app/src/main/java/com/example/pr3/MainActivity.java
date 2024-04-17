package com.example.pr3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class MainActivity extends AppCompatActivity {
    String[] state = {"Maharashtra","Manipur","Gujurat","Andhra Pradesh","Haryana","Sikkim","Arunachal Pradesh","Himachal Pradesh","Tamil Nadu","Tripura"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter arr = new ArrayAdapter(this, android.R.layout.select_dialog_item, state);
        AutoCompleteTextView ac = (AutoCompleteTextView)findViewById(R.id.atv);
        ac.setThreshold(1);
        ac.setAdapter(arr);
    }
}
