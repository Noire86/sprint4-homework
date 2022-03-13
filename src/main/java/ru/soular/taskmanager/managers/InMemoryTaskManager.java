package ru.soular.taskmanager.managers;

import ru.soular.taskmanager.models.Epic;
import ru.soular.taskmanager.models.SubTask;
import ru.soular.taskmanager.models.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Главный класс - менеджер.
 * Реализует интерфейс ITaskManager операций.
 * Соответствует требованиям ТЗ спринта
 *
 * UPD: Превращен в InMemoryTaskManager
 */
public class InMemoryTaskManager implements ITaskManager {

    private final Map<Integer, Task> tasks;
    private final IHistoryManager historyManager = Managers.getDefaultHistory();

    private InMemoryTaskManager() {
        tasks = new HashMap<>();
    }


    /**
     * А здесь - симпатичный синглтон (потокобезопасный)
     */
    private static class Holder {
        public static final InMemoryTaskManager INSTANCE = new InMemoryTaskManager();
    }

    public static InMemoryTaskManager getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * Добавлена работа с history
     */
    @Override
    public Task get(int taskID) {
        Task result = tasks.get(taskID);
        historyManager.add(result);
        return result;
    }


    /**
     * Генерализованный метод для удобного получения
     * задач по типам из одной единой Map<K, V>
     */
    @Override
    public <T extends Task> List<T> getTasksByType(Class<T> task) {
        List<T> result = new ArrayList<>();
    
        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            if (entry.getValue().getClass() == task) {
                result.add(task.cast(entry.getValue()));
                historyManager.add(task.cast(entry.getValue()));
            }
        }

        return result;
    }

    /**
     * Генерализованный метод для удобного удалени
     * задач по типам из одной единой Map<K, V>
     */

    @Override
    public <T extends Task> void deleteTasksByType(Class<T> task) {
        tasks.values().removeAll(getTasksByType(task));
    }

    @Override
    public Map<Integer, Task> getAll() {
        return tasks;
    }

    @Override
    public Task create(Task task) {
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public void update(Task task, int taskID) {
        tasks.put(taskID, task);
    }

    @Override
    public void delete(int taskID) {
        tasks.remove(taskID);
    }

    @Override
    public void deleteAll() {
        tasks.clear();
    }

    /**
     * Генерализованный метод получения субзадач из
     * главной коллекции HashMap.
     */

    @Override
    public List<SubTask> getSubTasks(Epic epic) {
        List<SubTask> result = new ArrayList<>();

        tasks.forEach((key, value) -> {
            if (value.getClass() == SubTask.class && ((SubTask) value).getParentEpic().equals(epic)) {
                result.add((SubTask) value);
            }
        });
        return result;
    }

    @Override
    public List<Task> history() {
        return historyManager.getHistory();
    }
}
