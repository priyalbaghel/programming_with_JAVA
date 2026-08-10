import java.util.ArrayList;
import java.util.Scanner;

class ToDoList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Creating ArrayList to store tasks dynamically
        ArrayList<String> tasks = new ArrayList<>();

        int choice;

        // Loop runs until user selects Exit
        do {
            System.out.println("\n===== TO-DO LIST =====");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Clears the input buffer

            switch (choice) {

                // Add a new task
                case 1:
                    System.out.print("Enter Task: ");
                    String task = sc.nextLine();

                    // Adding task into ArrayList
                    tasks.add(task);

                    System.out.println("Task Added Successfully.");
                    break;

                // Remove an existing task
                case 2:
                    System.out.print("Enter Task to Remove: ");
                    String removeTask = sc.nextLine();

                    // Removing task from ArrayList
                    if (tasks.remove(removeTask))
                        System.out.println("Task Removed Successfully.");
                    else
                        System.out.println("Task Not Found.");

                    break;

                // Display all tasks using StringBuffer
                case 3:
                    StringBuffer sb = new StringBuffer();

                    sb.append("\n===== TO-DO TASKS =====\n");

                    // Checking whether task list is empty
                    if (tasks.isEmpty()) {
                        sb.append("No tasks available.\n");
                    } 
                    else {
                        // Adding tasks to StringBuffer
                        for (int i = 0; i < tasks.size(); i++) {
                            sb.append((i + 1) + ". " + tasks.get(i) + "\n");
                        }
                    }

                    // Displaying task list
                    System.out.println(sb);
                    break;

                // Exit the application
                case 4:
                    System.out.println("Exiting To-Do List...");
                    break;

                default:
                    System.out.println("Invalid Choice! Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
