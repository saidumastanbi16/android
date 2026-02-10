package com.ventureplus.crm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminDashboardActivity extends AppCompatActivity {

    private TextView profileTitle;
    private Button ventureLocationsButton, trackCustomersButton, reportsButton, newVentureButton, 
                   totalDataButton, trackEmployeesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        profileTitle = findViewById(R.id.profileTitle);
        ventureLocationsButton = findViewById(R.id.ventureLocationsButton);
        trackCustomersButton = findViewById(R.id.trackCustomersButton);
        reportsButton = findViewById(R.id.reportsButton);
        newVentureButton = findViewById(R.id.newVentureButton);
        totalDataButton = findViewById(R.id.totalDataButton);
        trackEmployeesButton = findViewById(R.id.trackEmployeesButton);

        setupClickListeners();
    }

    private void setupClickListeners() {
        ventureLocationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboardActivity.this, VentureLocationsActivity.class);
                startActivity(intent);
            }
        });

        trackCustomersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboardActivity.this, TrackCustomersActivity.class);
                startActivity(intent);
            }
        });

        reportsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboardActivity.this, ReportsActivity.class);
                startActivity(intent);
            }
        });

        newVentureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboardActivity.this, NewVenturesActivity.class);
                startActivity(intent);
            }
        });

        totalDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboardActivity.this, AdminTotalDataActivity.class);
                startActivity(intent);
            }
        });

        trackEmployeesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboardActivity.this, TrackEmployeesActivity.class);
                startActivity(intent);
            }
        });
    }
}
