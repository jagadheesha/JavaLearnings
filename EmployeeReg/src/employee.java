import java.io.*;
import java.util.*;

class Employee {
    String empId, name, department, designation;
    double basicPay, hra, da;

    // Constructor to initialize an employee
    public Employee(String empId, String name, String department, String designation, double basicPay, double hra, double da) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.basicPay = basicPay;
        this.hra = hra;
        this.da = da;
    }

    // Method to convert Employee object to a string for storage
    @Override
    public String toString() {
        return empId + "," + name + "," + department + "," + designation + "," + basicPay + "," + hra + "," + da;
    }
}

class EmployeeRegister {
    List<Employee> employees = new ArrayList<>();

    // Constructor to load employees from file
    public EmployeeRegister() {
        loadEmployees();
    }

    // Add a new employee to the list
    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        String empId = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();

        System.out.print("Enter Basic Pay: ");
        double basicPay = scanner.nextDouble();

        System.out.print("Enter HRA: ");
        double hra = scanner.nextDouble();

        System.out.print("Enter DA: ");
        double da = scanner.nextDouble();

        Employee employee = new Employee(empId, name, department, designation, basicPay, hra, da);
        employees.add(employee);
        saveEmployees();
        System.out.println("Employee added successfully!");
    }

    // Display all employees
    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println(String.format("%-10s%-20s%-15s%-15s%-10s%-10s%-10s", "ID", "Name", "Department", "Designation", "Basic Pay", "HRA", "DA"));
            for (Employee emp : employees) {
                System.out.println(String.format("%-10s%-20s%-15s%-15s%-10.2f%-10.2f%-10.2f", emp.empId, emp.name, emp.department, emp.designation, emp.basicPay, emp.hra, emp.da));
            }
        }
    }

    // Search employee by ID
    public void searchEmployeeById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID to search: ");
        String empId = scanner.nextLine();

        for (Employee emp : employees) {
            if (emp.empId.equals(empId)) {
                System.out.println("Employee found: " + emp);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Update employee information
    public void updateEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID to update: ");
        String empId = scanner.nextLine();

        Employee employeeToUpdate = null;
        for (Employee emp : employees) {
            if (emp.empId.equals(empId)) {
                employeeToUpdate = emp;
                break;
            }
        }

        if (employeeToUpdate != null) {
            System.out.println("Updating information for employee: " + employeeToUpdate.name);
            System.out.print("Enter new Name (or press Enter to keep current): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) employeeToUpdate.name = name;

            System.out.print("Enter new Department (or press Enter to keep current): ");
            String department = scanner.nextLine();
            if (!department.isEmpty()) employeeToUpdate.department = department;

            System.out.print("Enter new Designation (or press Enter to keep current): ");
            String designation = scanner.nextLine();
            if (!designation.isEmpty()) employeeToUpdate.designation = designation;

            System.out.print("Enter new Basic Pay (or press Enter to keep current): ");
            String basicPayInput = scanner.nextLine();
            if (!basicPayInput.isEmpty()) employeeToUpdate.basicPay = Double.parseDouble(basicPayInput);

            System.out.print("Enter new HRA (or press Enter to keep current): ");
            String hraInput = scanner.nextLine();
            if (!hraInput.isEmpty()) employeeToUpdate.hra = Double.parseDouble(hraInput);

            System.out.print("Enter new DA (or press Enter to keep current): ");
            String daInput = scanner.nextLine();
            if (!daInput.isEmpty()) employeeToUpdate.da = Double.parseDouble(daInput);

            saveEmployees();
            System.out.println("Employee information updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Delete an employee by ID
    public void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID to delete: ");
        String empId = scanner.nextLine();

        Employee employeeToDelete = null;
        for (Employee emp : employees) {
            if (emp.empId.equals(empId)) {
                employeeToDelete = emp;
                break;
            }
        }

        if (employeeToDelete != null) {
            employees.remove(employeeToDelete);
            saveEmployees();
            System.out.println("Employee with ID " + empId + " deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Save all employees to file
    private void saveEmployees() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee_data.txt"))) {
            for (Employee emp : employees) {
                writer.write(emp.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving employee data.");
        }
    }

    // Load employees from file
    private void loadEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader("employee_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Employee employee = new Employee(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]), Double.parseDouble(data[5]), Double.parseDouble(data[6]));
                employees.add(employee);
            }
        } catch (IOException e) {
            System.out.println("No employee data file found, starting fresh.");
        }
    }
}

class SalaryRegister {
    Map<String, Double> salaryDetails = new HashMap<>();

    // Constructor to load salary data from file
    public SalaryRegister() {
        loadSalary();
    }

    // Add salary for employee
    public void addSalary(EmployeeRegister employeeRegister) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEmployee List:");
        employeeRegister.displayEmployees();

        System.out.print("\nEnter Employee ID for Salary Registration: ");
        String empId = scanner.nextLine();

        System.out.print("Enter Month: ");
        String month = scanner.nextLine();

        System.out.print("Enter Year: ");
        String year = scanner.nextLine();

        for (Employee emp : employeeRegister.employees) {
            if (emp.empId.equals(empId)) {
                double totalSalary = emp.basicPay + emp.hra + emp.da;
                salaryDetails.put(empId + "," + month + "," + year, totalSalary);
                saveSalary();
                System.out.println("Salary for " + emp.name + " (" + emp.empId + ") for " + month + ", " + year + " has been added successfully.");
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    // Display salary for a specific employee
    public void displaySalary() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID to view salary: ");
        String empId = scanner.nextLine();

        System.out.print("Enter Month: ");
        String month = scanner.nextLine();

        System.out.print("Enter Year: ");
        String year = scanner.nextLine();

        String key = empId + "," + month + "," + year;
        if (salaryDetails.containsKey(key)) {
            System.out.println("Salary for Employee " + empId + " in " + month + ", " + year + ": " + salaryDetails.get(key));
        } else {
            System.out.println("No salary data found for this employee.");
        }
    }

    // Save salary details to file
    private void saveSalary() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("salary_data.txt"))) {
            for (Map.Entry<String, Double> entry : salaryDetails.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving salary data.");
        }
    }

    // Load salary data from file
    private void loadSalary() {
        try (BufferedReader reader = new BufferedReader(new FileReader("salary_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                salaryDetails.put(data[0] + "," + data[1] + "," + data[2], Double.parseDouble(data[3]));
            }
        } catch (IOException e) {
            System.out.println("No salary data file found, starting fresh.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeRegister employeeRegister = new EmployeeRegister();
        SalaryRegister salaryRegister = new SalaryRegister();

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Employee Register");
            System.out.println("2. Salary Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                while (true) {
                    System.out.println("\nEmployee Register Menu:");
                    System.out.println("1. Add Employee");
                    System.out.println("2. Display Employees");
                    System.out.println("3. Search Employee by ID");
                    System.out.println("4. Update Employee Information");
                    System.out.println("5. Delete Employee");
                    System.out.println("6. Exit");
                    System.out.print("Enter your choice: ");
                    String empChoice = scanner.nextLine();

                }
            }
        }
    }

}

