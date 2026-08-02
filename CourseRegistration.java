import java.util.ArrayList;
import java.util.Scanner;

class CourseRegistration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Creating ArrayList to store registered courses
        ArrayList<String> courses = new ArrayList<>();

        int choice;

        // Menu-driven program
        do {
            System.out.println("\n===== STUDENT COURSE REGISTRATION =====");
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. View Registered Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Clears input buffer

            switch (choice) {

                // Add a new course
                case 1:
                    System.out.print("Enter Course Name: ");
                    String course = sc.nextLine();

                    // Adding course to ArrayList
                    courses.add(course);

                    System.out.println("Course Registered Successfully.");
                    break;

                // Remove registered course
                case 2:
                    System.out.print("Enter Course Name to Remove: ");
                    String removeCourse = sc.nextLine();

                    // Removing course from ArrayList
                    if (courses.remove(removeCourse))
                        System.out.println("Course Removed Successfully.");
                    else
                        System.out.println("Course Not Found.");

                    break;

                // Display all registered courses
                case 3:

                    // Creating StringBuffer for displaying course list
                    StringBuffer sb = new StringBuffer();

                    sb.append("\n===== REGISTERED COURSES =====\n");

                    // Checking if no courses are registered
                    if (courses.isEmpty()) {
                        sb.append("No courses registered.\n");
                    } 
                    else {

                        // Adding courses into StringBuffer
                        for (int i = 0; i < courses.size(); i++) {
                            sb.append((i + 1) + ". " + courses.get(i) + "\n");
                        }
                    }

                    // Displaying registered courses
                    System.out.println(sb);
                    break;

                // Exit application
                case 4:
                    System.out.println("Exiting Course Registration System...");
                    break;

                default:
                    System.out.println("Invalid Choice! Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
