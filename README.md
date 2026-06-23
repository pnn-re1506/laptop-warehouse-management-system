# Laptop Warehouse Management System

## Project Overview

This is a comprehensive Laptop Warehouse Management System built in Java (Swing) with a MySQL database backend. The system provides functionality for managing laptop and PC inventory, including:

- **Product Management**: Add, edit, and delete laptops and PCs with detailed specifications
- **Supplier Management**: Manage supplier information and relationships
- **Import/Export Operations**: Track inventory imports and exports with detailed receipts
- **User Account Management**: Multi-role user system with authentication
- **Statistical Reports**: Generate reports and statistics for business insights
- **PDF Export**: Generate PDF reports and documents
- **Excel Integration**: Import/export data to Excel format

## Project Architecture

This project has been refactored to use **Maven** as its build and dependency management tool, ensuring a standardized, portable, and easily maintainable codebase.

```
├── pom.xml                   # Maven dependencies and build configuration
├── src/
│   ├── main/
│   │   ├── java/             # Java source code
│   │   │   ├── dao/          # Data Access Objects (Database Operations)
│   │   │   ├── database/     # Database connection utilities (JDBC)
│   │   │   ├── entity/       # Model classes (Account, Laptop, PC, etc.)
│   │   │   ├── helpers/      # Utility classes (PDF, Excel, Email, etc.)
│   │   │   └── view/         # Java Swing UI forms (.java & .form)
│   │   └── resources/        # Application resources
│   │       └── icon/         # Icons and images for the UI
├── database/                 # Database schema and SQL exports
└── local-repo/               # Local Maven repository for custom NetBeans libraries
```

## Setup Instructions

### 1. Clone the Repository
Clone this repository to your local machine:

```bash
git clone https://github.com/pnn-re1506/laptop-warehouse-management-system.git
cd laptop-warehouse-management-system
```

### 2. Set Up the Database

1. Install XAMPP (or any local MySQL server).
2. Start the **MySQL** module.
3. Open your web browser and navigate to: `http://localhost/phpmyadmin/`
4. Create a new database named `computer_inventory`.
5. Import the file `database/computer_inventory.sql` into the `computer_inventory` database.

*(Note: The database connection is configured in `src/main/java/database/JDBCUtil.java`. The default credentials are `root` with no password on `localhost:3306`).*

### 3. Build the Project

Ensure you have **Java 18** and **Maven** installed. Then run the following command to download all dependencies and compile the project into an executable JAR:

```bash
mvn clean package
```

### 4. Run the Project

You can run the project in two ways:

**Method 1: Run directly via Maven**
```bash
mvn exec:java -Dexec.mainClass="view.Login"
```

**Method 2: Run the built Fat JAR**
```bash
java -jar target/laptop-warehouse-management-system-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Default Login Credentials
After setting up the database, you can log in with the default administrator account:

- **Username**: `admin`
- **Password**: `123456`

## Development Notes

- **GUI Builder**: The project uses NetBeans GUI Builder. If you open this project in NetBeans, the `.form` files in `src/main/java/view/` will be automatically detected, allowing you to visually design the UI.
- **Dependencies**: All standard dependencies (MySQL Connector, Apache POI, FlatLaf, iTextPDF, etc.) are downloaded automatically by Maven. The `AbsoluteLayout` library used by NetBeans is stored in the `local-repo/` directory and is configured in `pom.xml`.
