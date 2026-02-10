package com.ventureplus.crm;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;

public class SimpleCRMActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Initialize data
        try {
            // Skip Firebase for now - use demo data directly
            // FirebaseManager.initialize();
            // FirebaseManager.addDemoVentures();
            // FirebaseManager.addDemoCustomers();
            DataManager.initializeData();
            Log.d("CRM", "Demo data loaded successfully!");
        } catch (Exception e) {
            Log.e("CRM", "Data loading failed: " + e.getMessage());
            // Fallback to demo data
            DataManager.initializeData();
        }
        
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setBackgroundColor(Color.WHITE);
        
        // Title
        TextView titleText = new TextView(this);
        titleText.setText("🏢 Venture Plus CRM");
        titleText.setTextSize(24);
        titleText.setTextColor(Color.parseColor("#2196F3"));
        titleText.setPadding(20, 20, 20, 20);
        LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        titleParams.setMargins(0, 0, 0, 30);
        
        // Demo URL Display
        TextView urlText = new TextView(this);
        urlText.setText("🌐 Backend: Demo Mode (Local Data)");
        urlText.setTextSize(14);
        urlText.setTextColor(Color.parseColor("#757575"));
        urlText.setPadding(20, 10, 20, 10);
        LinearLayout.LayoutParams urlParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        urlParams.setMargins(0, 0, 0, 30);
        
        Button loginButton = new Button(this);
        loginButton.setText("👤 Employee Login");
        loginButton.setTextColor(Color.WHITE);
        loginButton.setBackgroundColor(Color.parseColor("#4CAF50"));
        loginButton.setPadding(40, 30, 40, 30);
        LinearLayout.LayoutParams loginParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        loginParams.setMargins(40, 10, 40, 20);
        
        Button adminButton = new Button(this);
        adminButton.setText("⚙️ Admin Panel");
        adminButton.setTextColor(Color.WHITE);
        adminButton.setBackgroundColor(Color.parseColor("#FF9800"));
        adminButton.setPadding(40, 30, 40, 30);
        LinearLayout.LayoutParams adminParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        adminParams.setMargins(40, 10, 40, 20);
        
        Button demoButton = new Button(this);
        demoButton.setText("📊 View Demo Data");
        demoButton.setTextColor(Color.WHITE);
        demoButton.setBackgroundColor(Color.parseColor("#9C27B0"));
        demoButton.setPadding(40, 30, 40, 30);
        LinearLayout.LayoutParams demoParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        demoParams.setMargins(40, 10, 40, 20);
        
        loginButton.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(this, "Opening Employee Login", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Login screen coming soon!", Toast.LENGTH_SHORT).show();
            }
        });
        
        adminButton.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(this, AdminDashboardActivity.class);
                startActivity(intent);
                Toast.makeText(this, "Opening Admin Dashboard", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Admin panel coming soon!", Toast.LENGTH_SHORT).show();
            }
        });
        
        demoButton.setOnClickListener(v -> {
            try {
                String demoInfo = "Ventures: 4, Plots: 20, Customers: 3";
                Toast.makeText(this, demoInfo, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(this, "Demo data loaded!", Toast.LENGTH_SHORT).show();
            }
        });
        
        layout.addView(titleText, titleParams);
        layout.addView(urlText, urlParams);
        layout.addView(loginButton, loginParams);
        layout.addView(adminButton, adminParams);
        layout.addView(demoButton, demoParams);
        
        setContentView(layout);
    }
}
