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

public class TrackCustomersActivity extends AppCompatActivity {

    private TextView titleTextView;
    private ListView customersListView;
    private ArrayAdapter<String> customersAdapter;
    private List<String> customersList = new ArrayList<>();
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_customers);

        initializeViews();
        loadCustomerData();
        setupListView();
        setupBackButton();
    }

    private void initializeViews() {
        titleTextView = findViewById(R.id.titleTextView);
        customersListView = findViewById(R.id.customersListView);
        backButton = findViewById(R.id.backButton);
    }

    private void loadCustomerData() {
        customersList.clear();
        for (DataManager.Customer dmCustomer : DataManager.getCustomers()) {
            customersList.add(dmCustomer.name);
        }
    }

    private void setupListView() {
        customersAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, customersList);
        customersListView.setAdapter(customersAdapter);

        customersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCustomer = customersList.get(position);
                Toast.makeText(TrackCustomersActivity.this, "Selected: " + selectedCustomer, Toast.LENGTH_SHORT).show();
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
