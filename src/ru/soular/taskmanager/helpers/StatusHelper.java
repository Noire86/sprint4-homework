package ru.soular.taskmanager.helpers;

import ru.soular.taskmanager.models.Epic;
import ru.soular.taskmanager.models.SubTask;
import ru.soular.taskmanager.models.Task.TaskState;

import java.util.List;

public class StatusHelper {

    private final Epic epic;
    private final List<SubTask> subTasks;

    public StatusHelper(Epic epic) {
        this.epic = epic;
        this.subTasks = epic.getSubTasks();
    }

    public TaskState updateEpicStatus() {
        if ((epic.getSubTasks().size() == 0) || checkSameStatus(TaskState.NEW)) {
            return TaskState.NEW;

        } else if (checkSameStatus(TaskState.DONE)) {
            return TaskState.DONE;

        } else {
            return TaskState.IN_PROGRESS;
        }
    }

    private boolean checkSameStatus(TaskState status) {
        return subTasks.stream().allMatch(s -> s.getStatus().equals(status));
    }
}
