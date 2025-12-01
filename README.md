# Laptop Warehouse Management System

## Project Overview

This is a comprehensive Laptop Warehouse Management System built in Java with a MySQL database backend. The system provides functionality for managing laptop and PC inventory, including:

- Product Management: Add, edit, and delete laptops and PCs with detailed specifications
- Supplier Management: Manage supplier information and relationships
- Import/Export Operations: Track inventory imports and exports with detailed receipts
- User Account Management: Multi-role user system with authentication
- Statistical Reports: Generate reports and statistics for business insights
- PDF Export: Generate PDF reports and documents
- Excel Integration: Import/export data to Excel format

## Setup Instructions

### 1. Clone the Repository
First, clone this repository to your local machine:

```bash
git clone https://github.com/pnn-re1506/laptop-warehouse-management-system.git
```

### 2. Install and Configure XAMPP

1. Download and install XAMPP
2. Launch XAMPP Control Panel
3. Start the MySQL and Apache modules by clicking the "Start" buttons

### 3. Set Up the Database

1. Open your web browser and navigate to: `http://localhost/phpmyadmin/`
2. Create a new database name `managelaptop`
3. Import file `database/computer_inventory.sql` to the `managelaptop` database

### 4. Configure Database Connection

Important: Check your MySQL port configuration and update if necessary.
1. Open the file: `src/util/JDBCUtil.java`
2. Locate line 16 with the database URL:
   ```java
   String url = "jdbc:mySQL://localhost:3307/managelaptop";
   ```
3. If your MySQL runs on port 3306 (default), change it to:
   ```java
   String url = "jdbc:mySQL://localhost:3306/managelaptop";
   ```
4. If you're using a different port, update accordingly

### 5. Run the Project

Open and run this project in NetBeans IDE

## Project Structure
```
├── src/
│   ├── dao/           # Data Access Objects for database operations
│   ├── database/      # Database connection
│   ├── entity/        # Entity/Model classes (Account, Computer, Laptop, etc.)
│   ├── helpers/       # Helper and utility classes
│   ├── icon/          # Application icons and images
│   └── view/          # GUI classes and forms (Swing components)
├── database/          # Database schema and sample data
├── lib/              # External JAR dependencies
├── build/            # Compiled classes and build artifacts
├── dist/             # Distribution files
├── test/             # Test files
└── nbproject/        # NetBeans project configuration
```


## Default Login Credentials
After setting up the database, you can log in with the default admin account:

- Username: admin
- Password: 15062005
