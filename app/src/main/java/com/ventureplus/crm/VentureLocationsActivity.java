package com.ventureplus.crm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VentureLocationsActivity extends AppCompatActivity {

    private TextView titleTextView;
    private ListView venturesListView;
    private ArrayAdapter<String> venturesAdapter;
    private List<String> venturesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venture_locations);

        titleTextView = findViewById(R.id.titleTextView);
        venturesListView = findViewById(R.id.venturesListView);

        loadVentureData();
        setupListView();
    }

    private void loadVentureData() {
        venturesList.clear();
        for (DataManager.Venture dmVenture : DataManager.getVentures()) {
            venturesList.add(dmVenture.name);
        }
    }

    private void setupListView() {
        venturesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, venturesList);
        venturesListView.setAdapter(venturesAdapter);

        venturesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedVenture = venturesList.get(position);
                Intent intent = new Intent(VentureLocationsActivity.this, VentureMapActivity.class);
                intent.putExtra("venture_name", selectedVenture);
                startActivity(intent);
            }
        });
    }
}
