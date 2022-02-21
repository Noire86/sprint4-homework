package ru.soular.taskmanager.models;

/**
 * Дочерняя модель для субтасков.
 * Примечательна тем что принудительно
 * запускает процесс установки статуса эпика
 * при изменении своего.
 */

public class SubTask extends Task {

    private final Epic parentEpic;

    public SubTask(String name, String description, Epic parentEpic) {
        super(name, description);
        this.parentEpic = parentEpic;
    }

    public Epic getParentEpic() {
        return parentEpic;
    }

    @Override
    public void setStatus(TaskState status) {
        super.setStatus(status);
        parentEpic.setStatus(status);
    }
}
