package ru.soular.taskmanager.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.soular.taskmanager.models.SubTask;
import ru.soular.taskmanager.models.Task;

public class SprintThreeTest extends BaseTest {

    @Test
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
}
