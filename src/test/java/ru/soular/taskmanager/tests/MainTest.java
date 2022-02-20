package ru.soular.taskmanager.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.soular.taskmanager.models.Epic;
import ru.soular.taskmanager.models.SubTask;
import ru.soular.taskmanager.models.Task;
import ru.soular.taskmanager.util.PrintUtils;

/**
 * Основной тест для проверки функционала приложения
 * Проверяем здесь все, что указано в ТЗ.
 */
public class MainTest extends BaseTest {

    @Test
    @DisplayName("Проверка создания и вывода сущностей в консоль")
    public void taskManagerTest() {
        PrintUtils.printAllTasks(taskManager.getAll());

        PrintUtils.printTasks(taskManager.getTasksByType(Task.class));
        PrintUtils.printTasks(taskManager.getTasksByType(Epic.class));
        PrintUtils.printTasks(taskManager.getTasksByType(SubTask.class));
    }

    @ParameterizedTest
    @EnumSource(Task.TaskState.class)
    @DisplayName("Проверка изменения статуса обычных задач")
    public void taskStatusTest(Task.TaskState value) {
        PrintUtils.printTasks(taskManager.getTasksByType(Task.class));

        Assertions.assertEquals(task1.getStatus(), Task.TaskState.NEW);
        Assertions.assertEquals(task2.getStatus(), Task.TaskState.NEW);

        task1.setStatus(value);
        task2.setStatus(value);

        Assertions.assertEquals(value, task1.getStatus());
        Assertions.assertEquals(value, task2.getStatus());



    }

    @ParameterizedTest
    @EnumSource(Task.TaskState.class)
    @DisplayName("Проверка изменения статусов эпиков")
    public void epicStatusTest(Task.TaskState value) {

        Assertions.assertEquals(epic1.getStatus(), Task.TaskState.NEW);
        Assertions.assertEquals(epic2.getStatus(), Task.TaskState.NEW);

        subTask1.setStatus(value);
        subTask2.setStatus(value);
        subTask3.setStatus(value);

        PrintUtils.printTasks(taskManager.getTasksByType(Epic.class));
        PrintUtils.printTasks(taskManager.getTasksByType(SubTask.class));

        Assertions.assertEquals(value, subTask1.getStatus());
        Assertions.assertEquals(value, subTask2.getStatus());
        Assertions.assertEquals(value, subTask3.getStatus());

        Assertions.assertEquals(value, epic1.getStatus());
        Assertions.assertEquals(value, epic2.getStatus());
    }

    @Test
    @DisplayName("Проверка удаления задач и эпиков")
    public void deleteTest() {
        int previousSize = taskManager.getAll().size();

        taskManager.delete(task1.getId());
        taskManager.delete(epic1.getId());

        Assertions.assertNotEquals(previousSize, taskManager.getAll().size());
    }
}
