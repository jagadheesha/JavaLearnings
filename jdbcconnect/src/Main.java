public class Main {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();

        // CREATE: Adding new employees
        Employee emp1 = new Employee(0, "John", "Doe", "Software Engineer", 60000);
        employeeManager.addEmployee(emp1);

        Employee emp2 = new Employee(0, "Jane", "Smith", "HR Manager", 70000);
        employeeManager.addEmployee(emp2);

        // READ: Get all employees
        System.out.println("All Employees:");
        for (Employee employee : employeeManager.getAllEmployees()) {
            System.out.println(employee.getEmployeeID() + ": " + employee.getFirstName() + " " + employee.getLastName());
        }

        // UPDATE: Update an employee's salary
        emp1.setSalary(65000);
        employeeManager.updateEmployee(emp1);

        // DELETE: Delete an employee
        employeeManager.deleteEmployee(emp2.getEmployeeID());

        // READ again to confirm update and deletion
        System.out.println("\nUpdated Employee List:");
        for (Employee employee : employeeManager.getAllEmployees()) {
            System.out.println(employee.getEmployeeID() + ": " + employee.getFirstName() + " " + employee.getLastName());
        }
    }
}
