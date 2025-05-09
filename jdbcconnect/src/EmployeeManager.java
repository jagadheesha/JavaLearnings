import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    // CREATE - Add a new employee
    public void addEmployee(Employee employee) {
        String query = "INSERT INTO Employees (FirstName, LastName, Position, Salary) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastName());
            pstmt.setString(3, employee.getPosition());
            pstmt.setDouble(4, employee.getSalary());

            pstmt.executeUpdate();
            System.out.println("Employee added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ - Get all employees
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employees";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("EmployeeID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Position"),
                        rs.getDouble("Salary")
                );
                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    // UPDATE - Update an employee's details
    public void updateEmployee(Employee employee) {
        String query = "UPDATE Employees SET FirstName = ?, LastName = ?, Position = ?, Salary = ? WHERE EmployeeID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastName());
            pstmt.setString(3, employee.getPosition());
            pstmt.setDouble(4, employee.getSalary());
            pstmt.setInt(5, employee.getEmployeeID());

            pstmt.executeUpdate();
            System.out.println("Employee updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE - Delete an employee by ID
    public void deleteEmployee(int employeeID) {
        String query = "DELETE FROM Employees WHERE EmployeeID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, employeeID);
            pstmt.executeUpdate();
            System.out.println("Employee deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
