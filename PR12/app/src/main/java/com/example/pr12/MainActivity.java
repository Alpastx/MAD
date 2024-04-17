package com.example.pr12;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import java.util.ArrayList;
import java.util.Set;
public class MainActivity extends AppCompatActivity {
    ImageButton imgon;
    ImageButton imgoff;
    private BluetoothAdapter bluetoothAdapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgon = findViewById(R.id.wion);
        imgoff = findViewById(R.id.wioff);
        listView = findViewById(R.id.listView);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        imgon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enableBluetooth();
            }
        });
        imgoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableBluetooth();
            }
        });
        // List paired devices when the activity starts
        listPairedDevices();
        // Set up item click listener for the ListView
        listView.setOnItemClickListener(new

                                                AdapterView.OnItemClickListener() {
                                                    @Override
                                                    public void
                                                    onItemClick(AdapterView<?> adapterView, View view,

                                                                int i, long l) {
                                                        String deviceName =
                                                                (String)

                                                                        adapterView.getItemAtPosition(i);

                                                        Toast.makeText(MainActivity.this, "Clicked on: " +
                                                                        deviceName,
                                                                Toast.LENGTH_SHORT).show();
                                                    }
                                                });
    }
    private void enableBluetooth() {
        if (!bluetoothAdapter.isEnabled()) {
            Intent turnOn = new
                    Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn, 0);
        }
        Toast.makeText(MainActivity.this, "Bluetooth Enabled",
                Toast.LENGTH_SHORT).show();
        imgon.setVisibility(View.INVISIBLE);
        imgoff.setVisibility(View.VISIBLE);
    }
    private void disableBluetooth() {
        bluetoothAdapter.disable();
        Toast.makeText(MainActivity.this, "Bluetooth Disabled",
                Toast.LENGTH_SHORT).show();
        imgon.setVisibility(View.VISIBLE);
        imgoff.setVisibility(View.INVISIBLE);
    }
    private void listPairedDevices() {
        Set<BluetoothDevice> pairedDevices =
                bluetoothAdapter.getBondedDevices();
        ArrayList<String> devicesList = new ArrayList<>();
        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                devicesList.add(device.getName() + "\n" +
                        device.getAddress());
            }
        } else {
            devicesList.add("No paired devices");
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, devicesList);
        listView.setAdapter(arrayAdapter);
    }
}