package ru.soular.taskmanager.helpers;


import ru.soular.taskmanager.managers.TaskManager;
import ru.soular.taskmanager.models.Epic;
import ru.soular.taskmanager.models.Task.TaskState;

/**
 * Класс-хелпер для обработки статусов эпиков
 * Возможно понадобится и далее при расширении
 * функционала статусов и типов задач.
 */
public class StatusHelper {

    private final Epic epic;
    private final TaskManager taskManager;

    public StatusHelper(Epic epic) {
        this.epic = epic;
        this.taskManager = TaskManager.getInstance();
    }

    /**
     * Метод, проверяющий связанные с эпиком субтаски.
     * Если список пустой - NEW
     * Если у всех субтасков один статус - делаем такой же для эпика.
     * Иначе IN_PROGRESS
     */
    public TaskState updateEpicStatus() {
        if ((taskManager.getSubTasks(epic).size() == 0) || checkSameStatus(TaskState.NEW)) {
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
        return taskManager.getSubTasks(epic).stream().allMatch(s -> s.getStatus().equals(status));
    }
}
