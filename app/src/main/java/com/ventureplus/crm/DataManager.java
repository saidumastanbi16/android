package com.ventureplus.crm;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static List<Venture> ventures = new ArrayList<>();
    private static List<Plot> plots = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<Report> reports = new ArrayList<>();
    
    public static void initializeData() {
        // Initialize Ventures
        ventures.add(new Venture("Sunrise Apartments", "Premium residential complex", 45));
        ventures.add(new Venture("Green Valley", "Commercial property hub", 28));
        ventures.add(new Venture("Tech Park", "Modern office spaces", 67));
        ventures.add(new Venture("Lake View", "Waterfront properties", 34));
        
        // Initialize Plots
        for(int i = 1; i <= 20; i++) {
            String status;
            if(i <= 8) status = "GREEN";
            else if(i <= 14) status = "ORANGE";
            else status = "RED";
            
            plots.add(new Plot("P" + i, status, "Plot " + i));
        }
        
        // Initialize Customers
        customers.add(new Customer("John Smith", "john@example.com", "9876543210", "Sunrise Apartments", "P5", "₹45,00,000"));
        customers.add(new Customer("Sarah Johnson", "sarah@example.com", "9876543211", "Green Valley", "P12", "₹32,00,000"));
        customers.add(new Customer("Mike Wilson", "mike@example.com", "9876543212", "Tech Park", "P3", "₹78,00,000"));
        
        // Initialize Reports
        reports.add(new Report("Daily Sales", "5 properties sold today", "GREEN"));
        reports.add(new Report("Weekly Pipeline", "12 new leads", "ORANGE"));
        reports.add(new Report("Monthly Revenue", "₹1.2Cr generated", "RED"));
    }
    
    public static List<Venture> getVentures() { return ventures; }
    public static List<Plot> getPlots() { return plots; }
    public static List<Customer> getCustomers() { return customers; }
    public static List<Report> getReports() { return reports; }
    
    // Data classes
    public static class Venture {
        String name, description;
        int totalPlots;
        
        Venture(String name, String description, int totalPlots) {
            this.name = name;
            this.description = description;
            this.totalPlots = totalPlots;
        }
    }
    
    public static class Plot {
        String id, status, name;
        
        Plot(String id, String status, String name) {
            this.id = id;
            this.status = status;
            this.name = name;
        }
    }
    
    public static class Customer {
        String name, email, phone, venture, plot, budget;
        
        Customer(String name, String email, String phone, String venture, String plot, String budget) {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.venture = venture;
            this.plot = plot;
            this.budget = budget;
        }
    }
    
    public static class Report {
        String title, description, status;
        
        Report(String title, String description, String status) {
            this.title = title;
            this.description = description;
            this.status = status;
        }
    }
}
