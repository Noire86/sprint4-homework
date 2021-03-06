package ru.soular.taskmanager.models;

import java.util.Objects;
import java.util.Random;

/**
 * Основной класс-модель задачки
 * ID генерируем рандомно, а
 * displayName для потомков,
 * которые будут писать UI-фронт
 */
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(name, task.name) && Objects.equals(displayName, task.displayName) && Objects.equals(description, task.description) && status == task.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, displayName, description, status);
    }

    /**
     * Удобный enum, как без него.
     */
    public enum TaskState {
        NEW,
        IN_PROGRESS,
        DONE,
    }
}
