package ru.soular.taskmanager.managers;

/**
 * Новый утилитарный класс по ТЗ
 * для соблюдения полиморфизма
 *
 * В ТЗ так и не было ясно расписано,
 * каким образом должна работать логика
 * возвращения конкретных реализаций
 * интерфейса ITaskManager, поэтому
 * была сделана простая заглушка.
 */

public class Managers {

    public static ITaskManager getDefault() {
        return InMemoryTaskManager.getInstance();
    }

    public static IHistoryManager getDefaultHistory() {
        return InMemoryHistoryManager.getInstance();
    }
}
