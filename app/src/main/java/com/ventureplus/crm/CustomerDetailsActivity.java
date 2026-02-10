package com.ventureplus.crm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerDetailsActivity extends AppCompatActivity {

    private TextView plotNumberTextView, statusLabel;
    private EditText contactNameEditText, contactNumberEditText, locationEditText, 
                     uniqueIdEditText, pricePerSqYardEditText;
    private Button uploadButton, submitButton;
    private boolean isOrangePlot = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        initializeViews();
        setupData();
        setupClickListeners();
    }

    private void initializeViews() {
        plotNumberTextView = findViewById(R.id.plotNumberTextView);
        statusLabel = findViewById(R.id.statusLabel);
        contactNameEditText = findViewById(R.id.contactNameEditText);
        contactNumberEditText = findViewById(R.id.contactNumberEditText);
        locationEditText = findViewById(R.id.locationEditText);
        uniqueIdEditText = findViewById(R.id.uniqueIdEditText);
        pricePerSqYardEditText = findViewById(R.id.pricePerSqYardEditText);
        uploadButton = findViewById(R.id.uploadButton);
        submitButton = findViewById(R.id.submitButton);
    }

    private void setupData() {
        int plotNumber = getIntent().getIntExtra("plot_number", 1);
        String ventureName = getIntent().getStringExtra("venture_name");
        isOrangePlot = getIntent().getBooleanExtra("is_orange", false);

        plotNumberTextView.setText("PLOT NO: " + plotNumber);
        locationEditText.setText(ventureName);

        if (isOrangePlot) {
            statusLabel.setText("ORANGE TO RED");
            statusLabel.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        } else {
            statusLabel.setText("(FOR GREEN)");
            statusLabel.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        }
    }

    private void setupClickListeners() {
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomerDetailsActivity.this, "Photo upload feature coming soon", Toast.LENGTH_SHORT).show();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    submitCustomerData();
                }
            }
        });
    }

    private boolean validateForm() {
        String contactName = contactNameEditText.getText().toString().trim();
        String contactNumber = contactNumberEditText.getText().toString().trim();
        String uniqueId = uniqueIdEditText.getText().toString().trim();
        String price = pricePerSqYardEditText.getText().toString().trim();

        if (contactName.isEmpty()) {
            Toast.makeText(this, "Please enter contact name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (contactNumber.isEmpty()) {
            Toast.makeText(this, "Please enter contact number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (uniqueId.isEmpty()) {
            Toast.makeText(this, "Please enter unique ID", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (price.isEmpty()) {
            Toast.makeText(this, "Please enter price per sq.yard", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void submitCustomerData() {
        // In a real app, this would save to a database
        String message = isOrangePlot ? 
            "Customer details submitted successfully! Plot status updated to SOLD." :
            "Customer details submitted successfully! Plot remains available for other leads.";
        
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        
        // Navigate back to venture map
        finish();
    }
}
