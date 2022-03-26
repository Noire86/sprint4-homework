package ru.soular.taskmanager.managers;

import ru.soular.taskmanager.models.Epic;
import ru.soular.taskmanager.models.SubTask;
import ru.soular.taskmanager.models.Task;

import java.util.List;
import java.util.Map;

/**
 * Полезный ITaskManager интерфейс для потомков
 *
 * Мы ведь серьезные бэкэндеры
 *
 * UPD: Превращен в ITaskManager в задании 3 спринта
 */
public interface ITaskManager {

    Task get(int taskID);

    <T extends Task> List<T> getTasksByType(Class<T> task);

    <T extends Task> void deleteTasksByType(Class<T> task);

    Map<Integer, Task> getAll();

    Task create(Task task);

    void update(Task task, int taskID);

    void delete(int taskID);

    void deleteAll();

    List<SubTask> getSubTasks(Epic epic);

    void deleteSubtasksByEpic(Epic epic);

    List<Task> history();
}
