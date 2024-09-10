import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
    // List to store tasks
    private ArrayList<String> tasks;

    // Constructor
    public ToDoApp() {
        tasks = new ArrayList<>();
    }

    // Method to add a task
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    // Method to edit a task
    public void editTask(int taskNumber, String newTask) {
        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            tasks.set(taskNumber, newTask);
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Method to remove a task
    public void removeTask(int taskNumber) {
        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            tasks.remove(taskNumber);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Method to display tasks
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoApp toDoApp = new ToDoApp();
        int choice;

        do {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Display Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the task to add: ");
                    String taskToAdd = scanner.nextLine();
                    toDoApp.addTask(taskToAdd);
                    break;
                case 2:
                    toDoApp.displayTasks();
                    System.out.print("Enter the task number to edit: ");
                    int taskNumberToEdit = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter the new task: ");
                    String newTask = scanner.nextLine();
                    toDoApp.editTask(taskNumberToEdit - 1, newTask);
                    break;
                case 3:
                    toDoApp.displayTasks();
                    System.out.print("Enter the task number to remove: ");
                    int taskNumberToRemove = scanner.nextInt();
                    toDoApp.removeTask(taskNumberToRemove - 1);
                    break;
                case 4:
                    toDoApp.displayTasks();
                    break;
                case 5:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
