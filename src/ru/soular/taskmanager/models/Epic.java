package ru.soular.taskmanager.models;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {

    private final List<SubTask> subTasks = new ArrayList<>();

    public Epic(String name, String description) {
        super(name, description);
    }

    @Override
    public void setStatus(TaskState status) {
        this.updateStatus();
    }

    private void updateStatus() {

    }

    public void addSubTask(SubTask task) {
        subTasks.add(task);
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }
}
