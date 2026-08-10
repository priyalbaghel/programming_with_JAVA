class Student {
    String name;
    int rollNo;

    // Default Constructor
    Student() {
        name = "Unknown";
        rollNo = 0;
    }

    // Parameterized Constructor
    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    // Display Method
    void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNo);
    }

    public static void main(String[] args) {
        // Object using Default Constructor
        Student s1 = new Student();

        // Object using Parameterized Constructor
        Student s2 = new Student("Rahul", 101);

        System.out.println("Default Constructor:");
        s1.display();

        System.out.println("\nParameterized Constructor:");
        s2.display();
    }
}
