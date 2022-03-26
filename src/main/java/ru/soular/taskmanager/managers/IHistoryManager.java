package ru.soular.taskmanager.managers;

import ru.soular.taskmanager.models.Task;

import java.util.List;

/**
 * Интерфейс для менеджеров истории тасок
 */
public interface IHistoryManager {

    void add(Task task);

    void remove(int taskID);

    List<Task> getHistory();

    void clear();
}
