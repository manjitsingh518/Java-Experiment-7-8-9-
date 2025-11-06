import java.io.*;

// Student class should implement Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

public class StudentSerialization {
    public static void main(String[] args) {
        // Serialization
        try {
            Student s1 = new Student(101, "Abhishek", 89.5);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"));
            oos.writeObject(s1);
            oos.close();
            System.out.println("Student object serialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Deserialization
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"));
            Student s2 = (Student) ois.readObject();
            ois.close();
            System.out.println("Deserialized Student object:");
            s2.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
