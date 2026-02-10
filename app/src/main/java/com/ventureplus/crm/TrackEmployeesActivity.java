package com.ventureplus.crm;

import androidx.appcompat.app.AppCompatActivity;
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

public class TrackEmployeesActivity extends AppCompatActivity {

    private TextView titleTextView;
    private ListView employeesListView;
    private ArrayAdapter<String> employeesAdapter;
    private List<String> employeesList;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_employees);

        initializeViews();
        setupEmployeesList();
        setupListView();
        setupBackButton();
    }

    private void initializeViews() {
        titleTextView = findViewById(R.id.titleTextView);
        employeesListView = findViewById(R.id.employeesListView);
        backButton = findViewById(R.id.backButton);
    }

    private void setupEmployeesList() {
        employeesList = new ArrayList<>();
        employeesList.add("John Smith - Total Sales: 15 - Performance: Excellent");
        employeesList.add("Sarah Johnson - Total Sales: 12 - Performance: Good");
        employeesList.add("Mike Wilson - Total Sales: 8 - Performance: Average");
        employeesList.add("Emily Davis - Total Sales: 18 - Performance: Excellent");
        employeesList.add("Robert Brown - Total Sales: 10 - Performance: Good");
    }

    private void setupListView() {
        employeesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employeesList);
        employeesListView.setAdapter(employeesAdapter);

        employeesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedEmployee = employeesList.get(position);
                Toast.makeText(TrackEmployeesActivity.this, "Selected: " + selectedEmployee, Toast.LENGTH_SHORT).show();
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
