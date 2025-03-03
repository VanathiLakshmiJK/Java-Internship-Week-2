import java.util.*;

class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private double salary;

    public Employee(int id, String name, int age, String department, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Department: " + department + ", Salary: ₹"
                + salary;
    }
}

public class EmployeeManagementSystem {
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        viewEmployees();
                        break;
                    case 3:
                        searchEmployee();
                        break;
                    case 4:
                        deleteEmployee();
                        break;
                    case 5:
                        System.out.println("Exiting... Thank you!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice! Please enter again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please enter a number.");
                sc.next();
            }
        }
    }

    public static void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Department: ");
            String department = sc.nextLine();
            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, age, department, salary);
            employeeList.add(emp);
            System.out.println("Employee Added Successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter correct data.");
            sc.nextLine();
        }
    }

    public static void viewEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No Employees Found!");
        } else {
            for (Employee emp : employeeList) {
                System.out.println(emp);
            }
        }
    }

    public static void searchEmployee() {
        System.out.print("Enter Employee ID to Search: ");
        int id = sc.nextInt();
        boolean found = false;
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                System.out.println(emp);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee Not Found!");
        }
    }

    public static void deleteEmployee() {
        System.out.print("Enter Employee ID to Delete: ");
        int id = sc.nextInt();
        boolean removed = employeeList.removeIf(emp -> emp.getId() == id);

        if (removed) {
            System.out.println("Employee Deleted Successfully!");
        } else {
            System.out.println("Employee Not Found!");
        }
    }
}
