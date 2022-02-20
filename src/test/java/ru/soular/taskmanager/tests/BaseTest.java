package ru.soular.taskmanager.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.soular.taskmanager.managers.TaskManager;
import ru.soular.taskmanager.models.Epic;
import ru.soular.taskmanager.models.SubTask;
import ru.soular.taskmanager.models.Task;

/**
 * Базовый тест-родитель.
 * Инициализирует новые сущности перед каждым тестом.
 * Очищает их после завершения теста.
 */
public class BaseTest {
    protected TaskManager taskManager = TaskManager.getInstance();
    protected Faker faker = new Faker();

    protected Task task1;
    protected Task task2;
    protected Epic epic1;
    protected SubTask subTask1;
    protected SubTask subTask2;
    protected Epic epic2;
    protected SubTask subTask3;

    @BeforeEach
    public void init() {
        task1 = taskManager.create(new Task(faker.cat().name(), faker.cat().breed()));
        task2 = taskManager.create(new Task(faker.dog().name(), faker.dog().breed()));
        epic1 = (Epic) taskManager.create(new Epic(faker.funnyName().name(), faker.funnyName().name()));
        subTask1 = (SubTask) taskManager.create(new SubTask(faker.book().author(), faker.book().publisher(), epic1));
        subTask2 = (SubTask) taskManager.create(new SubTask(faker.book().title(), faker.book().author(), epic1));
        epic2 = (Epic) taskManager.create(new Epic(faker.funnyName().name(), faker.funnyName().name()));
        subTask3 = (SubTask) taskManager.create(new SubTask(faker.currency().name(), faker.currency().code(), epic2));
    }

    @AfterEach
    public void clean() {
        taskManager.deleteAll();
    }
}
