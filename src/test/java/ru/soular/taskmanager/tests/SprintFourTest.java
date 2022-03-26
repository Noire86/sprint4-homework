package ru.soular.taskmanager.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.soular.taskmanager.models.Task;

import java.util.ArrayList;

public class SprintFourTest extends BaseTest {

    @Test
    @DisplayName("Проверка нового функционала LinkedList + HashMap")
    public void historyTest() {

        Task one = taskManager.get(task1.getId());
        Task two = taskManager.get(task2.getId());
        Task four = taskManager.get(subTask4.getId());
        Task three = taskManager.get(subTask2.getId());
        Task four1 = taskManager.get(subTask4.getId());
        Task sub = taskManager.get(epic1.getId());
        Task four2 = taskManager.get(subTask4.getId());
        Task four3 = taskManager.get(subTask4.getId());

        System.out.println("Размер списка истории: " + taskManager.history().size());
        taskManager.history().forEach(System.out::println);

        Assertions.assertNotEquals(8, taskManager.history().size(), "В истории присутствуют повторы!");

    }

    @Test
    @DisplayName("Проверка удаления единственной ноды в истории")
    public void historyTest2() {
        Task one = taskManager.get(task1.getId());
        int size1 = taskManager.history().size();
        System.out.println("Размер списка истории: " + size1);
        taskManager.history().forEach(System.out::println);

        taskManager.delete(one.getId());
        int size2 = taskManager.history().size();
        System.out.println("Размер списка истории: " + size2);
        taskManager.history().forEach(System.out::println);

        Assertions.assertNotEquals(size1, size2, "Удаление из истории прошло неудачно!");
    }


    @Test
    @DisplayName("Проверка удаления одной ноды в начале")
    public void historyTest3() {
        Task one = taskManager.get(task1.getId());
        Task two = taskManager.get(task2.getId());
        Task four = taskManager.get(subTask4.getId());
        Task three = taskManager.get(subTask2.getId());
        Task four1 = taskManager.get(subTask4.getId());
        Task sub = taskManager.get(epic1.getId());
        Task four2 = taskManager.get(subTask4.getId());
        Task four3 = taskManager.get(subTask4.getId());

        int size1 = taskManager.history().size();
        System.out.println("Размер списка истории: " + size1);
        taskManager.history().forEach(System.out::println);

        taskManager.delete(one.getId());
        int size2 = taskManager.history().size();
        System.out.println("Размер списка истории: " + size2);
        taskManager.history().forEach(System.out::println);

        Assertions.assertNotEquals(size1, size2, "Удаление из истории прошло неудачно!");
    }

    @Test
    @DisplayName("Проверка удаления одной ноды в конце")
    public void historyTest4() {
        Task one = taskManager.get(task1.getId());
        Task two = taskManager.get(task2.getId());
        Task four = taskManager.get(subTask4.getId());
        Task three = taskManager.get(subTask2.getId());
        Task four1 = taskManager.get(subTask4.getId());
        Task sub = taskManager.get(epic1.getId());
        Task four2 = taskManager.get(subTask4.getId());
        Task four3 = taskManager.get(subTask4.getId());

        int size1 = taskManager.history().size();
        System.out.println("Размер списка истории: " + size1);
        taskManager.history().forEach(System.out::println);

        taskManager.delete(four3.getId());
        int size2 = taskManager.history().size();
        System.out.println("Размер списка истории: " + size2);
        taskManager.history().forEach(System.out::println);

        Assertions.assertNotEquals(size1, size2, "Удаление из истории прошло неудачно!");
    }

    @Test
    @DisplayName("Проверка удаления эпика с подзадачами")
    public void historyTest5() {

        Task epic = taskManager.get(epic1.getId());
        Task sub1 = taskManager.get(subTask1.getId());
        Task sub2 = taskManager.get(subTask2.getId());
        Task sub3 = taskManager.get(subTask2.getId());

        int size1 = taskManager.history().size();
        System.out.println("Размер списка истории: " + size1);
        taskManager.history().forEach(System.out::println);

        taskManager.delete(epic.getId());
        int size2 = taskManager.history().size();
        System.out.println("Размер списка истории: " + size2);
        taskManager.history().forEach(System.out::println);

        Assertions.assertEquals(0, size2, "Удаление из истории прошло неудачно!");
    }


    @Test
    @DisplayName("Проверка очистки CustomLinkedList")
    public void historyTest6() {

        Task one = taskManager.get(task1.getId());
        Task two = taskManager.get(task2.getId());
        Task four = taskManager.get(subTask4.getId());
        Task three = taskManager.get(subTask2.getId());
        Task four1 = taskManager.get(subTask4.getId());
        Task sub = taskManager.get(epic1.getId());
        Task four2 = taskManager.get(subTask4.getId());
        Task four3 = taskManager.get(subTask4.getId());

        int size1 = taskManager.history().size();
        System.out.println("Размер списка истории: " + size1);
        taskManager.history().forEach(System.out::println);

        taskManager.deleteAll();
        int size2 = taskManager.history().size();
        System.out.println("Размер списка истории: " + size2);
        taskManager.history().forEach(System.out::println);

        Assertions.assertEquals(0, size2, "Удаление из истории прошло неудачно!");
    }
}
