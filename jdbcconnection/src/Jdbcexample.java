import java.sql.*;
import java.util.Scanner;

public class Jdbcexample {


    // Database connection details
    private static final String DB_URL = "jdbc:sqlserver://192.168.9.202;databaseName=JaganDB;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa";  // Replace with your SQL Server username
    private static final String PASS = "password@123";  // Replace with your SQL Server password

    public static void main(String[] args) {

        // Initialize the connection and statement variables
        Connection connection = null;
        Statement statement = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 1: Establish the connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database successfully.");

            // Step 2: Create a Statement object
            statement = connection.createStatement();

            // Input: Ask the user to enter employee details
            System.out.println("Enter Employee ID:");
            int empId = scanner.nextInt();  // Read empId

            scanner.nextLine();  // Consume the newline character from the input buffer

            System.out.println("Enter Employee Name:");
            String name = scanner.nextLine();  // Read name

            System.out.println("Enter Department:");
            String department = scanner.nextLine();  // Read department

            System.out.println("Enter Designation:");
            String designation = scanner.nextLine();  // Read designation

            System.out.println("Enter Salary:");
            double salary = scanner.nextDouble();  // Read salary

            // Step 3: Create an SQL INSERT statement
            String insertQuery = "INSERT INTO Employees (empId, name, department, designation, salary) "
                    + "VALUES (" + empId + ", '" + name + "', '" + department + "', '" + designation + "', " + salary + ")";

            // Step 4: Execute the INSERT query
            int rowsAffected = statement.executeUpdate(insertQuery);
            System.out.println("Employee added successfully. Rows affected: " + rowsAffected);

            // Optional: Display all employees after the insertion
            String selectQuery = "SELECT * FROM Employees";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            System.out.println("\nAll Employees:");
            while (resultSet.next()) {
                empId = resultSet.getInt("empId");
                name = resultSet.getString("name");
                department = resultSet.getString("department");
                designation = resultSet.getString("designation");
                salary = resultSet.getDouble("salary");

                // Display employee data
                System.out.println("Employee ID: " + empId + ", Name: " + name + ", Department: " + department +
                        ", Designation: " + designation + ", Salary: " + salary);
            }

        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
            System.out.println("Error while connecting to the database or performing database operation.");
        } finally {
            // Step 5: Close resources (Statement, Connection, and Scanner)
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                if (scanner != null) {
                    scanner.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
