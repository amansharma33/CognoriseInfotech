import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> todoList = new ArrayList<>();

        while (true) {
            System.out.println("===== Todo List Menu =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String task = scanner.nextLine();
                    todoList.add(task);
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    System.out.println("===== Tasks List =====");
                    if (todoList.isEmpty()) {
                        System.out.println("No tasks in the list.");
                    } else {
                        for (int i = 0; i < todoList.size(); i++) {
                            System.out.println((i + 1) + ". " + todoList.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter task number to mark as done: ");
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    if (taskNumber >= 1 && taskNumber <= todoList.size()) {
                        int index = taskNumber - 1;
                        String markedTask = todoList.get(index);
                        System.out.println("Marking task '" + markedTask + "' as done.");
                        // You can optionally implement a way to mark tasks as done
                        // For simplicity, this example doesn't actually change task status
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 4:
                    System.out.print("Enter task number to remove: ");
                    int removeTaskNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    if (removeTaskNumber >= 1 && removeTaskNumber <= todoList.size()) {
                        int index = removeTaskNumber - 1;
                        String removedTask = todoList.remove(index);
                        System.out.println("Task '" + removedTask + "' removed successfully.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the Todo List application.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }
}