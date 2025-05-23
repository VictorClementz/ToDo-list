package main;
import Logic.Persistancy;
import Logic.Task;
import UI.ToDoUI;
import Logic.TaskManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private Scanner scanner = new Scanner(System.in);
    private Persistancy persistancy = new Persistancy();
    private TaskManager taskManager;
    private ToDoUI toDoUI;

    public static void main(String[] args) {
        Main mainApp = new Main();
        mainApp.start();
    }

    public void start() {
        ArrayList<Task> importedTasks = persistancy.importTasksFromJson();
        taskManager = new TaskManager(importedTasks);
        toDoUI = new ToDoUI(taskManager);

    }
}