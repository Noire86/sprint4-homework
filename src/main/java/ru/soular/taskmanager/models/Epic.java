package ru.soular.taskmanager.models;

import ru.soular.taskmanager.helpers.StatusHelper;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {

    private final List<SubTask> subTasks;
    private final StatusHelper statusHelper;

    public Epic(String name, String description) {
        super(name, description);
        subTasks = new ArrayList<>();
        statusHelper = new StatusHelper(this);
    }

    public SubTask addSubTask(SubTask task) {
        subTasks.add(task);
        return task;
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    @Override
    public void setStatus(TaskState status) {
        super.setStatus(statusHelper.updateEpicStatus());
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subTasks=" + subTasks +
                ", statusHelper=" + statusHelper +
                '}';
    }
}
