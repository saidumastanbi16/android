# Venture Plus CRM Android Application

A comprehensive Android CRM application for real estate management based on the Venture Plus cloud computing CRM service.

## Features

### Employee Features
- **Login System**: Secure authentication for employees
- **Dashboard**: Quick access to all major features
- **Venture Locations**: Browse and select different venture sites
- **Interactive Map**: Color-coded plot availability (Green, Orange, Red)
  - **Green**: Available plots for customer leads
  - **Orange**: Plots under purchase process (advance paid)
  - **Red**: Sold plots
- **Customer Details**: Form to capture customer information for plot locking
- **Reports**: Track and convert plot statuses (Green→Orange→Red)
- **New Ventures**: View upcoming ventures with images/videos
- **Total Data**: Collect customer information for follow-ups
- **Track Customers**: Monitor customer interests and budgets

### Admin Features
- **Admin Login**: Chairman/CEO access with elevated privileges
- **All Employee Features**: Complete access to employee functionalities
- **Track Employees**: Monitor employee performance and records
- **Record Ownership Management**: Change ownership when employees leave
- **Admin Total Data**: Enhanced data management with employee assignment

## Project Structure

```
app/
├── src/main/
│   ├── java/com/ventureplus/crm/
│   │   ├── LoginActivity.java
│   │   ├── EmployeeDashboardActivity.java
│   │   ├── AdminDashboardActivity.java
│   │   ├── VentureLocationsActivity.java
│   │   ├── VentureMapActivity.java
│   │   ├── CustomerDetailsActivity.java
│   │   ├── ReportsActivity.java
│   │   ├── NewVenturesActivity.java
│   │   ├── TotalDataActivity.java
│   │   ├── TrackCustomersActivity.java
│   │   ├── TrackEmployeesActivity.java
│   │   ├── AdminTotalDataActivity.java
│   │   └── PlotGridAdapter.java
│   ├── res/
│   │   ├── layout/
│   │   ├── values/
│   │   ├── drawable/
│   │   └── xml/
│   └── AndroidManifest.xml
├── build.gradle
└── proguard-rules.pro
```

## Installation

1. Clone the repository
2. Open in Android Studio
3. Build and run the application

## Login Credentials

**Employee Login:**
- Username: `employee`
- Password: `emp123`

**Admin Login:**
- Username: `admin`
- Password: `admin123`

## Key Features Explained

### Plot Status Management
- **Green Plots**: Available for showing to customers. Agents can lock plots by filling customer details, but the plot remains green for lead generation.
- **Orange Plots**: Customer has paid advance, plot is under purchase process.
- **Red Plots**: Plot has been sold and is no longer available.

### Lead Generation
- Multiple customers can be associated with a single green plot
- Track demand and convert leads efficiently
- Maintain customer data for follow-ups even if not immediately interested

### Admin Capabilities
- Monitor employee performance
- Reassign records when employees leave the company
- Complete oversight of all CRM operations

## Technologies Used

- **Platform**: Android
- **Language**: Java
- **UI Components**: Material Design, ConstraintLayout, RecyclerView
- **Architecture**: MVC pattern
- **Build System**: Gradle

## Future Enhancements

- Real-time cloud synchronization
- Advanced reporting and analytics
- Push notifications for plot status changes
- Integration with payment gateways
- Document management system
- GPS integration for venture locations

## Support

For support and inquiries, please contact the development team.
# android
