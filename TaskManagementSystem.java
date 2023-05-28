import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String name;
    private String deadline;

    public Task(String name, String deadline) {
        this.name = name;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}

public class TaskManagementSystem {
    private static List<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task Deadline");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    updateTaskDeadline();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter task deadline: ");
        String deadline = scanner.nextLine();
        Task task = new Task(name, deadline);
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    private static void updateTaskDeadline() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        Task task = findTaskByName(name);
        if (task != null) {
            System.out.print("Enter new deadline: ");
            String newDeadline = scanner.nextLine();
            task.setDeadline(newDeadline);
            System.out.println("Task deadline updated successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    private static void deleteTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        Task task = findTaskByName(name);
        if (task != null) {
            tasks.remove(task);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    private static Task findTaskByName(String name) {
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                return task;
            }
        }
        return null;
    }
}