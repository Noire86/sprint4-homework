package ru.soular.taskmanager.managers;

import ru.soular.taskmanager.models.Task;

import java.util.List;

public interface IHistoryManager {

    void add(Task task);

    List<Task> getHistory();
}
