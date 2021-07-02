package tasks;

import java.util.Scanner;

public class TaskMenu {
    TaskController taskController = new TaskController();
    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        String taskInput = "";

        do{
            System.out.println("Welcome to the To Do list!");
            System.out.println("==========================\n");

            System.out.println("1. View To Do list");
            System.out.println("2. Create a task");
            System.out.println("3. Search for a task");
            System.out.println("4. Remove task");
            System.out.println("5. Update task");
            System.out.println("6. Exit");

            System.out.println("\nEnter your option: ");
            taskInput = scanner.nextLine();

            switch (taskInput) {
                case "1":
                    taskController.getAllTasks();
                    break;
                case "2":
                   // taskController.createTask();
                    break;
                case "3":
                   // taskController.findTaskByProgress();
                    break;
                case "4":
                    taskController.removeTask();
                    break;
                case "5":
                    taskController.updateTask();
                    break;
                case "6":
                    System.out.println("Exiting To Do list!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Something went wrong, try again");
                    break;

            }
            System.out.println("\nPress ENTER to continue\n");
            scanner.nextLine();

        } while(!taskInput.equalsIgnoreCase("6"));

        return;
    }
}

