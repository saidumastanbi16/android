package com.ventureplus.crm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VentureMapActivity extends AppCompatActivity {

    private TextView ventureNameTextView;
    private GridView plotGridView;
    private PlotGridAdapter plotAdapter;
    private List<Plot> plotList = new ArrayList<>();
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venture_map);

        ventureNameTextView = findViewById(R.id.ventureNameTextView);
        plotGridView = findViewById(R.id.plotGridView);
        backButton = findViewById(R.id.backButton);

        String ventureName = getIntent().getStringExtra("venture_name");
        if (ventureName == null) ventureName = "Sunrise Apartments";
        ventureNameTextView.setText(ventureName);

        setupPlotGrid();
        loadPlotData();
        setupGridView();
        setupBackButton();
        
        Toast.makeText(this, "Loaded " + plotList.size() + " plots", Toast.LENGTH_SHORT).show();
    }

    private void setupPlotGrid() {
        plotList = new ArrayList<>();
    }

    private void loadPlotData() {
        plotList.clear();
        for (DataManager.Plot dmPlot : DataManager.getPlots()) {
            Plot plot = new Plot(dmPlot.name, dmPlot.status, Integer.parseInt(dmPlot.id.substring(1)));
            plotList.add(plot);
        }
    }

    private void setupGridView() {
        plotAdapter = new PlotGridAdapter(this, plotList);
        plotGridView.setAdapter(plotAdapter);

        plotGridView.setOnItemClickListener((parent, view, position, id) -> {
            Plot selectedPlot = plotList.get(position);
            if (selectedPlot.getStatus().equals("green")) {
                Intent intent = new Intent(VentureMapActivity.this, CustomerDetailsActivity.class);
                intent.putExtra("plot_number", selectedPlot.getNumber());
                intent.putExtra("venture_name", ventureNameTextView.getText().toString());
                startActivity(intent);
            } else if (selectedPlot.getStatus().equals("orange")) {
                Intent intent = new Intent(VentureMapActivity.this, CustomerDetailsActivity.class);
                intent.putExtra("plot_number", selectedPlot.getNumber());
                intent.putExtra("venture_name", ventureNameTextView.getText().toString());
                intent.putExtra("is_orange", true);
                startActivity(intent);
            } else {
                Toast.makeText(this, "This plot is already sold", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupBackButton() {
        backButton.setOnClickListener(v -> finish());
    }

    public static class Plot {
        private String name;
        private String status;
        private int number;

        public Plot(String name, String status, int number) {
            this.name = name;
            this.status = status;
            this.number = number;
        }

        public String getName() { return name; }
        public String getStatus() { return status; }
        public int getNumber() { return number; }
    }
}
