package Logic;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Persistancy {

    public ArrayList<Task> importTasksFromJson() {
        ArrayList<Task> tasks = new ArrayList<>();
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("task.json")) {
            Type taskListType = new TypeToken<ArrayList<Task>>() {}.getType();
            tasks = gson.fromJson(reader, taskListType);

            if (tasks != null) {
                for (Task t : tasks) {
                    System.out.println("Laddad: " + t.getName() + ", " + t.getDesc() + ", " + t.getPriority());
                }
            } else {
                tasks = new ArrayList<>();
            }

        } catch (IOException e) {
            System.out.println("Ingen befintlig JSON hittades, startar tom lista.");

        }

        return tasks;
    }
}
