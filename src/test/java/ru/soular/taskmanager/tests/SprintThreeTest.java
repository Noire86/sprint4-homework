package ru.soular.taskmanager.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.soular.taskmanager.models.Epic;
import ru.soular.taskmanager.models.SubTask;
import ru.soular.taskmanager.models.Task;

public class SprintThreeTest extends BaseTest {

    /**
     * Тест для проверки пополнения списка истории
     */
    @Test
    @Disabled
    @DisplayName("Проверка списка истории запросов")
    public void historyTest() {
        int size = taskManager.history().size();
        System.out.println("Размер списка истории: " + size);
        Assertions.assertEquals(0, size);

        Task testTask = taskManager.get(task1ID);
        System.out.printf("Получили задачу с ID %d и названием %s%n", testTask.getId(), testTask.getName());

        int newSize = taskManager.history().size();
        System.out.println("Размер списка истории после получения задачи: " + newSize);
        Assertions.assertEquals(1, newSize);

        int veryNewSize = taskManager.getTasksByType(SubTask.class).size();
        System.out.println("Размер списка истории после получения задач по типу: " + veryNewSize);
        Assertions.assertEquals(3, veryNewSize);
    }

    @Test
    @Disabled
    @DisplayName("Проверка ограничения истории 10 элементами")
    public void historyCapTest() {
        int size1 = taskManager.history().size();
        System.out.println("Начальный размер списка истории: " + size1);
        Assertions.assertEquals(0, size1);

        taskManager.getTasksByType(Task.class);
        taskManager.getTasksByType(SubTask.class);
        taskManager.getTasksByType(SubTask.class);
        taskManager.getTasksByType(Epic.class);

        int size2 = taskManager.history().size();
        System.out.println("Итоговый размер списка истории: " + size2);
        Assertions.assertEquals(10, size2);
    }
}
