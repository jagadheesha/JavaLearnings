import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeReg{
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Salary> salaries = new ArrayList<>();


    public static void addEmployee() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Designation: ");
        String designation = sc.nextLine();

        Employee employee = new Employee(id, name, department, designation);

        System.out.print("Enter Basic Pay: ");
        float basicPay = sc.nextFloat();

        System.out.print("Enter HRA: ");
        float hra = sc.nextFloat();

        System.out.print("Enter DA: ");
        float da = sc.nextFloat();

        Salary salary = new EmployeeSalary(basicPay, hra, da);

        employees.add(employee);
        salaries.add(salary);

        System.out.println("Employee added successfully.");
    }


    public static void showReport() {
        if (employees.isEmpty()) {
            System.out.println("No employees to show.");
            return;
        }

        System.out.println("Employee Report:");
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            Salary salary = salaries.get(i);


            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Department: " + employee.getDepartment());
            System.out.println("Designation: " + employee.getDesignation());
            System.out.println("Basic Pay: " + salary.basicPay);
            System.out.println("HRA: " + salary.hra);
            System.out.println("DA: " + salary.da);
            System.out.println("Total Salary: " + salary.calculateTotalSalary());
            System.out.println("---------");
        }
    }

    public static void deleteEmployee() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        boolean found = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                salaries.remove(i);
                found = true;
                System.out.println("Employee deleted successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Employee Registration System");
            System.out.println("1. Add Employee");
            System.out.println("2. Show Report");
            System.out.println("3. Delete Employee");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    showReport();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


