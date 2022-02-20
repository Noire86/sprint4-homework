package ru.soular.taskmanager.models;

import java.util.Random;

public class Task {
    private final int id;
    private String name;
    private String displayName;
    private String description;
    private TaskState status;

    public Task(String name, String description) {
        Random random = new Random();
        this.id = random.nextInt(100000);
        this.name = name;
        this.displayName = name;
        this.description = description;
        this.status = TaskState.NEW;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskState getStatus() {
        return status;
    }

    public void setStatus(TaskState status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    public enum TaskState {
        NEW,
        IN_PROGRESS,
        DONE,
    }
}
