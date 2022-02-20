package ru.soular.taskmanager.models;

import ru.soular.taskmanager.helpers.StatusHelper;

/**
 * Дочерняя модель для эпиков
 * Имеет встроенную защиту от кривых рук,
 * желающих установить свой статус для эпика
 */
public class Epic extends Task {
    private final StatusHelper statusHelper;

    public Epic(String name, String description) {
        super(name, description);
        statusHelper = new StatusHelper(this);
    }

    @Override
    public void setStatus(TaskState status) {
        super.setStatus(statusHelper.updateEpicStatus());
    }
}
