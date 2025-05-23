package Logic;


public class Task {

    private String name;
    private String desc;
    private int priority;

    public Task(String name, String desc, int priority){
    this.name = name;
    this.desc = desc;
    this.priority = priority;

    }

    public String getName(){
        return name;
    }

    public String toString() {
        return "Task: " + name + " | Description: " + desc + " | Priority: " + priority;
    }
    public int getPriority() {
        return priority;
    }
    public int setPriority(int num){
       return priority = num;
    }

    public String getDesc(){
        return desc;
    }
}
