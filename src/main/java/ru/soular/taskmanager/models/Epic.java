package ru.soular.taskmanager.models;

import ru.soular.taskmanager.managers.TaskManager;

import java.util.List;

/**
 * Дочерняя модель для эпиков
 * Имеет встроенную защиту от кривых рук,
 * желающих установить свой статус для эпика
 */
public class Epic extends Task {
    private final TaskManager taskManager;

    public Epic(String name, String description) {
        super(name, description);
        taskManager = TaskManager.getInstance();
    }

    public List<SubTask> getChildSubtasks() {
        return taskManager.getSubTasks(this);
    }

    @Override
    public void setStatus(TaskState status) {
        super.setStatus(updateEpicStatus());
    }

    /**
     * Метод, проверяющий связанные с эпиком субтаски.
     * Если список пустой - NEW
     * Если у всех субтасков один статус - делаем такой же для эпика.
     * Иначе IN_PROGRESS
     */
    private TaskState updateEpicStatus() {
        if ((taskManager.getSubTasks(this).size() == 0) || checkSameStatus(TaskState.NEW)) {
            return TaskState.NEW;

        } else if (checkSameStatus(TaskState.DONE)) {
            return TaskState.DONE;

        } else {
            return TaskState.IN_PROGRESS;
        }
    }

    /**
     * Красивая лямбда для уменьшения повторяемых итераций
     */
    private boolean checkSameStatus(TaskState status) {
        return taskManager.getSubTasks(this).stream().allMatch(s -> s.getStatus().equals(status));
    }
}
