package com.ventureplus.crm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EmployeeDashboardActivity extends AppCompatActivity {

    private TextView profileTitle;
    private Button ventureLocationsButton, trackCustomersButton, reportsButton, newVentureButton, totalDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_dashboard);

        profileTitle = findViewById(R.id.profileTitle);
        ventureLocationsButton = findViewById(R.id.ventureLocationsButton);
        trackCustomersButton = findViewById(R.id.trackCustomersButton);
        reportsButton = findViewById(R.id.reportsButton);
        newVentureButton = findViewById(R.id.newVentureButton);
        totalDataButton = findViewById(R.id.totalDataButton);

        setupClickListeners();
    }

    private void setupClickListeners() {
        ventureLocationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeDashboardActivity.this, VentureLocationsActivity.class);
                startActivity(intent);
            }
        });

        trackCustomersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeDashboardActivity.this, TrackCustomersActivity.class);
                startActivity(intent);
            }
        });

        reportsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeDashboardActivity.this, ReportsActivity.class);
                startActivity(intent);
            }
        });

        newVentureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeDashboardActivity.this, NewVenturesActivity.class);
                startActivity(intent);
            }
        });

        totalDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeDashboardActivity.this, TotalDataActivity.class);
                startActivity(intent);
            }
        });
    }
}
