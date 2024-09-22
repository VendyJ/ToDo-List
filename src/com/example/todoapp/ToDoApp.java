package com.example.todoapp;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
    private final ArrayList<String> tasks;

    public ToDoApp() {
        tasks = new ArrayList<>();
    }

    public static void main(String[] args) {
        ToDoApp app = new ToDoApp();
        app.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Enter command (add, list, delete, exit): ");
            command = scanner.nextLine();

            switch (command) {
                case "add":
                    addTask(scanner);
                    break;
                case "list":
                    listTasks();
                    break;
                case "delete":
                    deleteTask(scanner);
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }

    private void addTask(Scanner scanner) {
        System.out.println("Enter task description: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added.");
    }

    private void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
        } else {
            System.out.println("Tasks");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private void deleteTask(Scanner scanner) {
        listTasks();
        if (!tasks.isEmpty()) {
            System.out.println("Enter task number to delete: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); //consume the newline character
            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                tasks.remove(taskNumber - 1);
                System.out.println("Task deleted.");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}
