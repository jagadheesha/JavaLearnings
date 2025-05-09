import java.util.List;
import java.util.Arrays;

public class EmployeeSalary {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 60000),
                new Employee("Charlie", "Finance", 70000)
        );


        double totalSalaryStream = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total Salary (using Streams): " + totalSalaryStream);
    }
}

