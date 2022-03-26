package ru.soular.taskmanager.managers;

import ru.soular.taskmanager.models.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.soular.taskmanager.util.CustomLinkedList;
import ru.soular.taskmanager.util.CustomLinkedList.*;

/**
 * Менеджер истории тасков в памяти
 */
public class InMemoryHistoryManager implements IHistoryManager {

    Map<Integer, Node<Task>> history;
    CustomLinkedList<Task> historyLinked;

    /**
     * А здесь - симпатичный синглтон (потокобезопасный)
     */
    private InMemoryHistoryManager() {
        this.history = new HashMap<>();
        this.historyLinked = new CustomLinkedList<>();
    }

    private static class Holder {
        public static final InMemoryHistoryManager INSTANCE = new InMemoryHistoryManager();
    }

    public static InMemoryHistoryManager getInstance() {
        return InMemoryHistoryManager.Holder.INSTANCE;
    }

    @Override
    public void add(Task task) {
        if (history.containsKey(task.getId())) { //Проверяем что в хешмапе есть уже такая задача
            remove(task.getId()); //удаляем ноду из двусвязного списка
        }
        history.put(task.getId(), historyLinked.linkLast(task)); //Кладем новую ноду в HashMap по тому же ID задачи
    }

    /**
     * Метод для удаления записи истории
     */
    @Override
    public void remove(int taskID) {
        Node<Task> node = history.get(taskID);

        if (node != null) {
            historyLinked.removeNode(node);
        }
        history.remove(taskID);
    }

    /**
     * Получение списка истории теперь
     * запрашивается из кастомного
     * связанного списка
     */
    @Override
    public List<Task> getHistory() {
        return historyLinked.getTasks();
    }

    /**
     * Метод очистки кастомной коллекции.
     * Не требуется непосредственно в ТЗ,
     * но жизненно необходим в тестировании
     * функционала
     */
    @Override
    public void clear() {
        historyLinked.clear();
    }
}
