package faculty;

public class Faculty {
    int id;
    String name;
    String subject;

    public Faculty(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    public void displayFaculty() {
        System.out.println("Faculty ID: " + id);
        System.out.println("Faculty Name: " + name);
        System.out.println("Subject: " + subject);
    }
}