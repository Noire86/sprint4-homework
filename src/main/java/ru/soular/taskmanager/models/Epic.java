package ru.soular.taskmanager.models;

import ru.soular.taskmanager.helpers.StatusHelper;
import ru.soular.taskmanager.managers.TaskManager;

import java.util.List;

/**
 * Дочерняя модель для эпиков
 * Имеет встроенную защиту от кривых рук,
 * желающих установить свой статус для эпика
 */
public class Epic extends Task {
    private final StatusHelper statusHelper;
    private final TaskManager taskManager;

    public Epic(String name, String description) {
        super(name, description);
        statusHelper = new StatusHelper(this);
        taskManager = TaskManager.getInstance();
    }

    public List<SubTask> getChildSubtasks() {
        return taskManager.getSubTasks(this);
    }

    @Override
    public void setStatus(TaskState status) {
        super.setStatus(statusHelper.updateEpicStatus());
    }
}
