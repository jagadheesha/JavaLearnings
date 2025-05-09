import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeFileExample {
    public static void main(String[] args) {
        // Add employees to file
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 12345, "Software Engineer"));
        employees.add(new Employee("Jane Smith", 67890, "HR Manager"));

        // Write employees to file
        writeEmployeesToFile(employees);

        // Retrieve employees from file
        ArrayList<Employee> retrievedEmployees = readEmployeesFromFile();

        // Display the retrieved employees
        for (Employee employee : retrievedEmployees) {
            System.out.println(employee);
        }
    }

    // Method to write employees to file
    public static void writeEmployeesToFile(ArrayList<Employee> employees) {
        try {
            FileOutputStream fileOut = new FileOutputStream("employees.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            // Write the list of employees to the file
            out.writeObject(employees);

            // Close the streams
            out.close();
            fileOut.close();

            System.out.println("Employee data has been written to employees.ser");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read employees from file
    public static ArrayList<Employee> readEmployeesFromFile() {
        ArrayList<Employee> employees = null;
        try {
            FileInputStream fileIn = new FileInputStream("employees.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            // Read the list of employees from the file
            employees = (ArrayList<Employee>) in.readObject();

            // Close the streams
            in.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return employees;
    }
}

class Employee implements java.io.Serializable {
    private String name;
    private int id;
    private String position;

    public Employee(String name, int id, String position) {
        this.name = name;
        this.id = id;
        this.position = position;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", position=" + position + "]";
    }
}

