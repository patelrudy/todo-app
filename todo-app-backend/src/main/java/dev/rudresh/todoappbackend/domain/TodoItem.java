package dev.rudresh.todoappbackend.domain;

public class TodoItem {
    private Long id;
    private String task;
    private Boolean isComplete;

    public TodoItem() {}

    public TodoItem(Long id, String task, Boolean isComplete) {
        this.id = id;
        this.task = task;
        this.isComplete = isComplete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }
}
