package ru.soular.taskmanager.managers;

/**
 * Новый утилитарный класс по ТЗ
 * для соблюдения полиморфизма
 */
public class Managers {

    public static ITaskManager getDefault() {
        return InMemoryTaskManager.getInstance();
    }

    public static IHistoryManager getDefaultHistory() {
        return InMemoryHistoryManager.getInstance();
    }
}
