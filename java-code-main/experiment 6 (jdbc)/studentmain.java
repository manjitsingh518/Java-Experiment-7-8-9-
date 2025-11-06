package View;
import java.util.*;
import Model.Student;
import Controller.StudentDAO;

public class StudentMain {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            StudentDAO dao = new StudentDAO();

            while (true) {
                System.out.println("\n===== Student Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student Marks");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();
                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();
                        dao.addStudent(new Student(id, name, dept, marks));
                        break;
                    case 2:
                        dao.viewStudents();
                        break;
                    case 3:
                        System.out.print("Enter StudentID to Update: ");
                        int uid = sc.nextInt();
                        System.out.print("Enter new Marks: ");
                        double newMarks = sc.nextDouble();
                        dao.updateStudent(uid, newMarks);
                        break;
                    case 4:
                        System.out.print("Enter StudentID to Delete: ");
                        int did = sc.nextInt();
                        dao.deleteStudent(did);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
