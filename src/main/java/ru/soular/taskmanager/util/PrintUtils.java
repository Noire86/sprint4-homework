package ru.soular.taskmanager.util;

import ru.soular.taskmanager.managers.TaskManager;
import ru.soular.taskmanager.models.Epic;
import ru.soular.taskmanager.models.SubTask;
import ru.soular.taskmanager.models.Task;

import java.util.List;
import java.util.Map;

/**
 * Утилитарный класс для текстового
 * вывода данных о сущностях и задачах.
 */
public class PrintUtils {

    public static final String DELIMITER = "---------------------------";

    /**
     * Генерализованный метод 3 в 1:
     * Печатает то, какой тип задачи вы ему дадите.
     */
    public static <T extends Task> void printTasks(List<T> tasks) {
        tasks.forEach(t -> {
            if (t.getClass() == Task.class) {
                System.out.printf("Обычная задача - %s  | ID: %d | Статус: %s | Описание: %s%n",
                        t.getName(), t.getId(), t.getStatus(), t.getDescription());

            } else if (t.getClass() == Epic.class) {
                System.out.printf("Epic задача - %s  | ID: %d | Статус: %s | Описание: %s | Кол-во субзадач: %d%n",
                        t.getName(), t.getId(), t.getStatus(), t.getDescription(), TaskManager.getInstance().getSubTasks((Epic) t).size());

            } else if (t.getClass() == SubTask.class) {
                System.out.printf("Cубзадача - %s  | ID: %d | Статус: %s | Описание: %s | Имя и ID эпика: %s:%d%n",
                        t.getName(), t.getId(), t.getStatus(), t.getDescription(), ((SubTask) t).getParentEpic().getName(), ((SubTask) t).getParentEpic().getId());

            }
        });
        System.out.println(DELIMITER);
    }

    /**
     * Здесь просто печатаем все и сразу, что имеется в HashMap
     */
    public static void printAllTasks(Map<Integer, Task> tasksMap) {
        tasksMap.forEach((key, value) ->
                System.out.printf("ID Задачи: %d | Имя задачи: %s | Тип задачи: %s%n",
                key, value.getName(), value.getClass().getSimpleName()));

        System.out.println(DELIMITER);
    }
}
