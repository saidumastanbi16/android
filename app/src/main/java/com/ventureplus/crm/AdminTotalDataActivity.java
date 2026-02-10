package com.ventureplus.crm;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AdminTotalDataActivity extends AppCompatActivity {

    private TextView titleTextView;
    private EditText contactNameEditText, contactNumberEditText, locationEditText, budgetEditText;
    private EditText recordOwnerEditText;
    private Spinner employeeSpinner;
    private Button submitButton;
    private ArrayAdapter<String> employeeAdapter;
    private List<String> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_total_data);

        initializeViews();
        setupEmployeeSpinner();
        setupClickListeners();
    }

    private void initializeViews() {
        titleTextView = findViewById(R.id.titleTextView);
        contactNameEditText = findViewById(R.id.contactNameEditText);
        contactNumberEditText = findViewById(R.id.contactNumberEditText);
        locationEditText = findViewById(R.id.locationEditText);
        budgetEditText = findViewById(R.id.budgetEditText);
        recordOwnerEditText = findViewById(R.id.recordOwnerEditText);
        employeeSpinner = findViewById(R.id.employeeSpinner);
        submitButton = findViewById(R.id.submitButton);
    }

    private void setupEmployeeSpinner() {
        employeeList = new ArrayList<>();
        employeeList.add("SELECT EMPLOYEE");
        employeeList.add("John Smith");
        employeeList.add("Sarah Johnson");
        employeeList.add("Mike Wilson");
        employeeList.add("Emily Davis");

        employeeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, employeeList);
        employeeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        employeeSpinner.setAdapter(employeeAdapter);

        employeeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    recordOwnerEditText.setText(employeeList.get(position));
                } else {
                    recordOwnerEditText.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                recordOwnerEditText.setText("");
            }
        });
    }

    private void setupClickListeners() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    submitAdminTotalData();
                }
            }
        });
    }

    private boolean validateForm() {
        String contactName = contactNameEditText.getText().toString().trim();
        String contactNumber = contactNumberEditText.getText().toString().trim();
        String location = locationEditText.getText().toString().trim();
        String budget = budgetEditText.getText().toString().trim();
        String recordOwner = recordOwnerEditText.getText().toString().trim();

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
        if (recordOwner.isEmpty()) {
            Toast.makeText(this, "Please select an employee for record ownership", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void submitAdminTotalData() {
        // In a real app, this would save to a database with record ownership
        Toast.makeText(this, "Admin total data submitted successfully! Record ownership assigned.", Toast.LENGTH_LONG).show();
        
        // Clear form
        contactNameEditText.setText("");
        contactNumberEditText.setText("");
        locationEditText.setText("");
        budgetEditText.setText("");
        recordOwnerEditText.setText("");
        employeeSpinner.setSelection(0);
    }
}
