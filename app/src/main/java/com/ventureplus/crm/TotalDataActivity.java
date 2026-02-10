package com.ventureplus.crm;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TotalDataActivity extends AppCompatActivity {

    private TextView titleTextView;
    private EditText contactNameEditText, contactNumberEditText, locationEditText, budgetEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_data);

        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        titleTextView = findViewById(R.id.titleTextView);
        contactNameEditText = findViewById(R.id.contactNameEditText);
        contactNumberEditText = findViewById(R.id.contactNumberEditText);
        locationEditText = findViewById(R.id.locationEditText);
        budgetEditText = findViewById(R.id.budgetEditText);
        submitButton = findViewById(R.id.submitButton);
    }

    private void setupClickListeners() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    submitTotalData();
                }
            }
        });
    }

    private boolean validateForm() {
        String contactName = contactNameEditText.getText().toString().trim();
        String contactNumber = contactNumberEditText.getText().toString().trim();
        String location = locationEditText.getText().toString().trim();
        String budget = budgetEditText.getText().toString().trim();

        if (contactName.isEmpty()) {
            Toast.makeText(this, "Please enter contact name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (contactNumber.isEmpty()) {
            Toast.makeText(this, "Please enter contact number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (location.isEmpty()) {
            Toast.makeText(this, "Please enter location", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (budget.isEmpty()) {
            Toast.makeText(this, "Please enter budget", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void submitTotalData() {
        // In a real app, this would save to a database
        Toast.makeText(this, "Total data submitted successfully! Customer added for follow-up.", Toast.LENGTH_LONG).show();
        
        // Clear form
        contactNameEditText.setText("");
        contactNumberEditText.setText("");
        locationEditText.setText("");
        budgetEditText.setText("");
    }
}
