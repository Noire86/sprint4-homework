package ru.soular.taskmanager.models;

import java.util.Map;

public interface Crudable {

    Task get(int taskID);

    Map<Integer, Task> getAll();

    void create(Task task);

    void update(Task task, int taskID);

    void delete(int taskID);

    void deleteAll();
}
