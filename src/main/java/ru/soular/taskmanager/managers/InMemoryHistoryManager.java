package ru.soular.taskmanager.managers;

import ru.soular.taskmanager.models.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Менеджер истории тасков в памяти
 */
public class InMemoryHistoryManager implements IHistoryManager {

    private final List<Task> history;

    /**
     * А здесь - симпатичный синглтон (потокобезопасный)
     */
    private InMemoryHistoryManager() {
        this.history = new ArrayList<>();
    }

    private static class Holder {
        public static final InMemoryHistoryManager INSTANCE = new InMemoryHistoryManager();
    }

    public static InMemoryHistoryManager getInstance() {
        return InMemoryHistoryManager.Holder.INSTANCE;
    }

    @Override
    public void add(Task task) {
        if (history.size() > 10) {
            history.remove(1);
        }
        history.add(task);
    }

    @Override
    public List<Task> getHistory() {
        return history;
    }
}
