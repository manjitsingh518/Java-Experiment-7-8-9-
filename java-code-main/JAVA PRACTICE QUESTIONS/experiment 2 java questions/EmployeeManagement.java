import java.io.*;
import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + salary;
    }

    static Employee fromString(String line) {
        String[] parts = line.split(",");
        return new Employee(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]));
    }
}

public class EmployeeManagement {
    static final String FILE_NAME = "employees.txt";

    public static void addEmployee(Employee e) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(e.toString());
            bw.newLine();
            System.out.println("Employee added successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void viewEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Employee Records ---");
            while ((line = br.readLine()) != null) {
                Employee e = Employee.fromString(line);
                System.out.println("ID: " + e.id + ", Name: " + e.name + ", Salary: " + e.salary);
            }
        } catch (IOException ex) {
            System.out.println("No employees found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee Management Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    Employee e = new Employee(id, name, salary);
                    addEmployee(e);
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
