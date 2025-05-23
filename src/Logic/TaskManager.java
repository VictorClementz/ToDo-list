package Logic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import UI.ToDoUI;
import com.google.gson.Gson;


public class TaskManager {


    String removedTask;

    public ToDoUI toDoUI;

    public ArrayList<Task> tasksCollection = new ArrayList<Task>();

    public TaskManager(ArrayList<Task> importedTasks){

        tasksCollection.addAll(importedTasks);
        for (Task task : tasksCollection){
            System.out.println(task);
        }
    }




    public void add(String name, String desc, int prio){

        Task newTask = new Task(name, desc, prio);
        priorityProbing(newTask.getPriority());
        tasksCollection.add(newTask);
        sort();
        for (Task task : tasksCollection){
            System.out.println(task + "add");
        }

     exportTasksToJson(tasksCollection);
    }

    private void priorityProbing(int priority){
        for (Task task : tasksCollection){

            if (task.getPriority() == priority){
                priorityProbing(priority + 1);
                task.setPriority(priority + 1);
                break;
            }
        }
    }

    public void printTasks(){
        sort();
        System.out.println("----------------------------------------------------");
        for (Task task : tasksCollection){
            System.out.println(task);
        }
    }



    private void sort(){
        tasksCollection.sort((t1, t2) -> Integer.compare(t1.getPriority(), t2.getPriority()));

    }
    //not used
    public void removeSelect(Scanner scanner){

        System.out.println("--------------------Current task--------------------");
        printTasks();
        System.out.println("----------------------------------------------------");
        System.out.println("Enter the nam   §e of the task you want to remove ");
        removedTask = scanner.nextLine();
        removeTask(removedTask);
    }

    public void removeTask(String removedTask){
        for(Task task : tasksCollection){
            if (task.getName().equals(removedTask)){
                tasksCollection.remove(task);
                exportTasksToJson(tasksCollection);
                System.out.println("Removed succesfully");
                return;
            } else {
                System.out.println("No task with that name");
            }

        }
    }

    private void exportTasksToJson(ArrayList<Task> tasksCollection) {
        try (FileWriter writer = new FileWriter("task.json")) {
            Gson gson = new Gson();
            gson.toJson(tasksCollection, writer);
        } catch (IOException e) {
            e.printStackTrace();
            //Exceeption
        }
    }



}
