import student.Student;
import faculty.Faculty;

public class Main {
    public static void main(String[] args) {

        Student s = new Student(101, "Priya", "Computer Science");

        Faculty f = new Faculty(201, "Dr. Sharma", "Java Programming");

        System.out.println("----- Student Details -----");
        s.displayStudent();

        System.out.println();

        System.out.println("----- Faculty Details -----");
        f.displayFaculty();
    }
}