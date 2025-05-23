package Logic;

import java.util.ArrayList;
import java.util.*;
import java.util.Comparator;
import java.util.Scanner;
import UI.ToDoUI;

public class TaskManager {

    String name;
    String desc;
    String priorityString;
    String removedTask;

    public ArrayList<Task> tasksCollection = new ArrayList<Task>();



    public void add(String name, String desc, int prio){

        Task newTask = new Task(name, desc, prio);
        priorityProbing(newTask.getPriority());
        tasksCollection.add(newTask);
        sort();
        for (Task task : tasksCollection){
            System.out.println(task);
        }

    }

    private void priorityProbing(int priority){
        for (Task task : tasksCollection){
            System.out.println("1");
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

    public void removeSelect(Scanner scanner){

        System.out.println("--------------------Current task--------------------");
        printTasks();
        System.out.println("----------------------------------------------------");
        System.out.println("Enter the name of the task you want to remove ");
        removedTask = scanner.nextLine();
        removeTask(removedTask);
    }

    public void removeTask(String removedTask){
        for(Task task : tasksCollection){
            if (task.getName().equals(removedTask)){
                tasksCollection.remove(task);
                System.out.println("Removed succesfully");
                return;
            } else {
                System.out.println("No task with that name");
            }

        }
    }



}
