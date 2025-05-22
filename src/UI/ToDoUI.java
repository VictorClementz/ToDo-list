package UI;
import Logic.Task;
import Logic.TaskManager;

import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.util.ArrayList;

public class ToDoUI implements ActionListener{
    private TaskManager taskManager = new TaskManager();
    JFrame frame;
    JButton addButton;
    Font myFont = new Font("Inc Free", Font.BOLD,30);
    DefaultListModel<String> listModel;
    JList<String> taskList;

    JTextField nameField;
    JTextField descField;
    JTextField priorityField;

    public ToDoUI(){

        frame = new JFrame("ToDo-List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 550);
        frame.setLayout(null);

        addButton = new JButton("Add task");
        addButton.setBounds(50, 430, 200, 50);
        addButton.addActionListener(this);
        addButton.setFont(myFont);
        addButton.setFocusable(false);
        frame.add(addButton);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setBounds(50, 50, 300, 350);
        frame.add(taskList);

        nameField = new JTextField();
        nameField.setBounds(400, 50, 300, 25);
        frame.add(nameField);

        descField = new JTextField();
        descField.setBounds(400, 100, 300, 25);
        frame.add(descField);

        priorityField = new JTextField();
        priorityField.setBounds(400, 150, 50, 25);
        frame.add(priorityField);

        frame.setVisible(true);

        frame.setVisible(true);
    }

    public void loadTasksFromLogic(ArrayList<Task> taskCollections) {
        listModel.clear();


        ArrayList<Task> test = taskCollections;
        for (Task task : test) {
            listModel.addElement(task.getName());
            listModel.addElement(task.getDesc());
            listModel.addElement("Priority: " + String.valueOf(task.getPriority()));
            listModel.addElement("----------------------------------------------");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText();
            String desc = descField.getText();
            String prioStr = priorityField.getText();

            if (name.isEmpty() || desc.isEmpty() || prioStr.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields are required.");
                return;
            }

            if (!isNumeric(prioStr)) {
                JOptionPane.showMessageDialog(frame, "Priority must be a number.");
                return;
            }

            int prio = Integer.parseInt(prioStr);
            taskManager.add(name, desc, prio);  // <-- new logic method
            loadTasksFromLogic(taskManager.tasksCollection);

            nameField.setText("");
            descField.setText("");
            priorityField.setText("");
        }


    }
    private boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
