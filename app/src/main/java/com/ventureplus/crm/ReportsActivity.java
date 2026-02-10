package com.ventureplus.crm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ReportsActivity extends AppCompatActivity {

    private TextView titleTextView;
    private ListView reportsListView;
    private ArrayAdapter<String> reportsAdapter;
    private List<String> reportsList = new ArrayList<>();
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        initializeViews();
        loadReportData();
        setupListView();
        setupBackButton();
    }

    private void initializeViews() {
        titleTextView = findViewById(R.id.titleTextView);
        reportsListView = findViewById(R.id.reportsListView);
        backButton = findViewById(R.id.backButton);
    }

    private void loadReportData() {
        reportsList.clear();
        for (DataManager.Report dmReport : DataManager.getReports()) {
            reportsList.add(dmReport.title);
        }
    }

    private void setupListView() {
        reportsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, reportsList);
        reportsListView.setAdapter(reportsAdapter);

        reportsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedReport = reportsList.get(position);
                Toast.makeText(ReportsActivity.this, "Selected: " + selectedReport, Toast.LENGTH_SHORT).show();
                
                // Navigate to customer details for status conversion
                Intent intent = new Intent(ReportsActivity.this, CustomerDetailsActivity.class);
                intent.putExtra("plot_number", position + 1);
                intent.putExtra("venture_name", "VENTURE 1");
                intent.putExtra("is_orange", selectedReport.contains("Orange to Red"));
                startActivity(intent);
            }
        });
    }

    private void setupBackButton() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
