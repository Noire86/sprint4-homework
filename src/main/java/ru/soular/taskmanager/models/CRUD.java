package ru.soular.taskmanager.models;

import java.util.Map;

/**
 * Полезный CRUD интерфейс для потомков
 *
 * Мы ведь серьезные бэкэндеры
 */
public interface CRUD {

    Task get(int taskID);

    Map<Integer, Task> getAll();

    Task create(Task task);

    void update(Task task, int taskID);

    void delete(int taskID);

    void deleteAll();
}
