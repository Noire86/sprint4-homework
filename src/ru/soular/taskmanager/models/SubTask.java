package ru.soular.taskmanager.models;

public class SubTask extends Task {

    private final Epic parentEpic;

    public SubTask(String name, String description, Epic parentEpic) {
        super(name, description);
        this.parentEpic = parentEpic;
        parentEpic.addSubTask(this);
    }

    public Epic getParentEpic() {
        return parentEpic;
    }
}