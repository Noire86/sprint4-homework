package ru.soular.taskmanager;

import ru.soular.taskmanager.models.Epic;
import ru.soular.taskmanager.models.SubTask;

public class Main {
    public static void main(String[] args) {
        SubTask task = new SubTask("Test", "Test Task", new Epic("test epic", "Test Epic"));


        System.out.println(task.getId());
    }
}
