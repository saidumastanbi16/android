package com.ventureplus.crm;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NewVenturesActivity extends AppCompatActivity {

    private TextView titleTextView, descriptionTextView;
    private ImageView ventureImageView1, ventureImageView2;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ventures);

        initializeViews();
        setupViews();
        setupBackButton();
    }

    private void initializeViews() {
        titleTextView = findViewById(R.id.titleTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        ventureImageView1 = findViewById(R.id.ventureImageView1);
        ventureImageView2 = findViewById(R.id.ventureImageView2);
        backButton = findViewById(R.id.backButton);
    }

    private void setupViews() {
        descriptionTextView.setText(
            "What is New Ventures?\n\n" +
            "New Venture is a feature to view new ventures or upcoming ventures of our company. " +
            "It can be video and JPG Pictures."
        );

        // In a real app, these would load actual images/videos from server
        ventureImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NewVenturesActivity.this, "Opening Venture Gallery 1...", Toast.LENGTH_SHORT).show();
            }
        });

        ventureImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NewVenturesActivity.this, "Opening Venture Gallery 2...", Toast.LENGTH_SHORT).show();
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
