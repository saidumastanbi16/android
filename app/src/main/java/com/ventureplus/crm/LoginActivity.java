package com.ventureplus.crm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button employeeLoginButton, adminLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        employeeLoginButton = findViewById(R.id.employeeLoginButton);
        adminLoginButton = findViewById(R.id.adminLoginButton);

        employeeLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin(false);
            }
        });

        adminLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin(true);
            }
        });
    }

    private void performLogin(boolean isAdmin) {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            return;
        }

        // Simple validation (in real app, this would be server validation)
        if (isValidLogin(username, password, isAdmin)) {
            Intent intent;
            if (isAdmin) {
                intent = new Intent(LoginActivity.this, AdminDashboardActivity.class);
            } else {
                intent = new Intent(LoginActivity.this, EmployeeDashboardActivity.class);
            }
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidLogin(String username, String password, boolean isAdmin) {
        // Simple validation for demo - replace with actual authentication
        if (isAdmin) {
            return username.equals("admin") && password.equals("admin123");
        } else {
            return username.equals("employee") && password.equals("emp123");
        }
    }
}
