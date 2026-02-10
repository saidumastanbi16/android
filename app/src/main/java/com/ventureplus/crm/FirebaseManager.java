package com.ventureplus.crm;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.util.Log;
import java.util.Map;

public class FirebaseManager {
    private static final String TAG = "FirebaseManager";
    private static DatabaseReference database;
    private static FirebaseAuth mAuth;
    private static final String DATABASE_URL = "https://venture-plus-crm-demo-default-rtdb.firebaseio.com/";
    
    public static void initialize() {
        try {
            // Use Realtime Database instead of Firestore
            database = FirebaseDatabase.getInstance(DATABASE_URL).getReference();
            mAuth = FirebaseAuth.getInstance();
            Log.d(TAG, "Firebase Realtime Database initialized successfully");
        } catch (Exception e) {
            Log.e(TAG, "Firebase initialization failed: " + e.getMessage());
        }
    }
    
    public static DatabaseReference getDatabase() {
        if (database == null) {
            initialize();
        }
        return database;
    }
    
    public static FirebaseAuth getAuth() {
        if (mAuth == null) {
            initialize();
        }
        return mAuth;
    }
    
    public static String getCurrentUserId() {
        FirebaseUser user = mAuth.getCurrentUser();
        return user != null ? user.getUid() : null;
    }
    
    public static boolean isUserLoggedIn() {
        return mAuth.getCurrentUser() != null;
    }
    
    public static void logout() {
        mAuth.signOut();
        Log.d(TAG, "User logged out");
    }
    
    // Demo data methods for testing
    public static void addDemoVentures() {
        try {
            DatabaseReference venturesRef = database.child("ventures");
            
            Map<String, Object> venture1 = Map.of(
                "name", "Sunrise Apartments",
                "description", "Premium residential complex",
                "totalPlots", 45
            );
            
            Map<String, Object> venture2 = Map.of(
                "name", "Green Valley Estates",
                "description", "Luxury housing project",
                "totalPlots", 32
            );
            
            venturesRef.child("venture1").setValue(venture1);
            venturesRef.child("venture2").setValue(venture2);
            
            Log.d(TAG, "Demo ventures added to Firebase Realtime Database");
        } catch (Exception e) {
            Log.e(TAG, "Error adding demo ventures: " + e.getMessage());
        }
    }
    
    public static void addDemoCustomers() {
        try {
            DatabaseReference customersRef = database.child("customers");
            
            Map<String, Object> customer1 = Map.of(
                "name", "John Smith",
                "email", "john.smith@email.com",
                "phone", "+1234567890",
                "plotNumber", "A-101"
            );
            
            Map<String, Object> customer2 = Map.of(
                "name", "Sarah Johnson",
                "email", "sarah.j@email.com", 
                "phone", "+0987654321",
                "plotNumber", "B-205"
            );
            
            customersRef.child("customer1").setValue(customer1);
            customersRef.child("customer2").setValue(customer2);
            
            Log.d(TAG, "Demo customers added to Firebase Realtime Database");
        } catch (Exception e) {
            Log.e(TAG, "Error adding demo customers: " + e.getMessage());
        }
    }
}
