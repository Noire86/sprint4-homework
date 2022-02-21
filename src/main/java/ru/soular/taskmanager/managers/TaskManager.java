package ru.soular.taskmanager.managers;

import ru.soular.taskmanager.models.Epic;
import ru.soular.taskmanager.models.SubTask;
import ru.soular.taskmanager.models.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Главный класс - менеджер.
 * Реализует интерфейс CRUD операций.
 * Соответствует требованиям ТЗ спринта
 */
public class TaskManager implements CRUD {

    private final Map<Integer, Task> tasks;

    private TaskManager() {
        tasks = new HashMap<>();
    }


    /**
     * А здесь - симпатичный синглтон (потокобезопасный)
     */
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


    /**
     * Генерализованный метод для удобного получения
     * задач по типам из одной единой Map<K, V>
     */
    public <T extends Task> List<T> getTasksByType(Class<T> task) {
        List<T> result = new ArrayList<>();

        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            if (entry.getValue().getClass() == task) {
                result.add(task.cast(entry.getValue()));
            }
        }

        return result;
    }

    /**
     * Генерализованный метод для удобного удаления
     * задач по типам из одной единой Map<K, V>
     */
    public <T extends Task> void deleteTasksByType(Class<T> task) {
        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            if (entry.getValue().getClass() == task) {
                tasks.remove(entry.getKey());
            }
        }
    }

    @Override
    public Map<Integer, Task> getAll() {
        return tasks;
    }

    @Override
    public Task create(Task task) {
        tasks.put(task.getId(), task);
        return task;
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

    /**
     * Генерализованный метод получения субзадач из
     * главной коллекции HashMap.
     */
    public List<SubTask> getSubTasks(Epic epic) {
        List<SubTask> result = new ArrayList<>();

        tasks.forEach((key, value) -> {
            if (value.getClass() == SubTask.class && ((SubTask) value).getParentEpic().equals(epic)) {
                result.add((SubTask) value);
            }
        });
        return result;
    }
}
