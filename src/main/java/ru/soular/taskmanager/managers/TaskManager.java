package ru.soular.taskmanager.managers;

import ru.soular.taskmanager.models.CRUD;
import ru.soular.taskmanager.models.Epic;
import ru.soular.taskmanager.models.SubTask;
import ru.soular.taskmanager.models.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager implements CRUD {

    private final Map<Integer, Task> tasks;

    private TaskManager() {
        tasks = new HashMap<>();
    }

    private static class Holder {
        public static final TaskManager INSTANCE = new TaskManager();
    }

    public static TaskManager getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public Task get(int taskID) {
        return tasks.get(taskID);
    }

    public <T extends Task> List<T> getTasksByType(Class<T> task) {
        List<T> result = new ArrayList<T>();

        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            if (entry.getValue().getClass() == task) {
                result.add(task.cast(entry.getValue()));
            }
        }

        return result;
    }

    @Override
    public Map<Integer, Task> getAll() {
        return tasks;
    }

    @Override
    public void create(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void update(Task task, int taskID) {
        tasks.put(taskID, task);
    }

    @Override
    public void delete(int taskID) {
        tasks.remove(taskID);
    }

    @Override
    public void deleteAll() {
        tasks.clear();
    }

    public List<SubTask> getSubTasks(Epic epic) {
        return epic.getSubTasks();
    }
}
