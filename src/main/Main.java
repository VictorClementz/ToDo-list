package main;
import UI.ToDoUI;
import Logic.TaskManager;
import java.util.Scanner;

public class Main {

    private Scanner scanner = new Scanner(System.in);
    private TaskManager taskManager = new TaskManager();
    private ToDoUI toDoUI = new ToDoUI();

    public static void main(String[] args) {

        Main mainApp = new Main();
        //mainApp.startMenu();
    }
/////terminal old
//    public void startMenu(){
//        String menuChoice;
//        System.out.println("Enter 1 for adding tasks");
//        System.out.println("Enter 2 for viewing task list");
//        System.out.println("Enter 3 for removing tasks");
//        menuChoice = scanner.nextLine();
//
//        switch (menuChoice){
//            case "1":
//                taskManager.add(scanner);
//                break;
//            case "2":
//                taskManager.printTasks();
//                break;
//            case "3":
//                toDoUI.loadTasksFromLogic(taskManager.tasksCollection);
//                taskManager.removeSelect(scanner);
//                break;
//            default:
//                System.out.println("Incorrect input try again");
//                break;
//
//        }
//        startMenu();
//    }
}