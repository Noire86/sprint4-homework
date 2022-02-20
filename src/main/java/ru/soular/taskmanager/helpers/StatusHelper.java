package ru.soular.taskmanager.helpers;


import ru.soular.taskmanager.managers.TaskManager;
import ru.soular.taskmanager.models.Epic;
import ru.soular.taskmanager.models.Task.TaskState;

public class StatusHelper {

    private final Epic epic;
    private final TaskManager taskManager;

    public StatusHelper(Epic epic) {
        this.epic = epic;
        this.taskManager = TaskManager.getInstance();
    }

    public TaskState updateEpicStatus() {
        if ((taskManager.getSubTasks(epic).size() == 0) || checkSameStatus(TaskState.NEW)) {
            return TaskState.NEW;

        } else if (checkSameStatus(TaskState.DONE)) {
            return TaskState.DONE;

        } else {
            return TaskState.IN_PROGRESS;
        }
    }

    private boolean checkSameStatus(TaskState status) {
        return taskManager.getSubTasks(epic).stream().allMatch(s -> s.getStatus().equals(status));
    }
}
