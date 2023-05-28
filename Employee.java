import java.util.ArrayList;
import java.util.List;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}

class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}

class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        // Add employees
        Employee emp1 = new Employee(1, "John Doe", 5000);
        Employee emp2 = new Employee(2, "Jane Smith", 6000);
        ems.addEmployee(emp1);
        ems.addEmployee(emp2);

        // Get all employees
        List<Employee> allEmployees = ems.getAllEmployees();
        for (Employee employee : allEmployees) {
            System.out.println(employee);
        }

        // Remove an employee
        ems.removeEmployee(emp1);

        // Get all employees after removal
        allEmployees = ems.getAllEmployees();
        for (Employee employee : allEmployees) {
            System.out.println(employee);
        }
    }
}