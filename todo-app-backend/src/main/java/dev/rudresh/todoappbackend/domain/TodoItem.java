package dev.rudresh.todoappbackend.domain;

public class TodoItem {
    private Long id;
    private String task;
    private Boolean isComplete;

//    public TodoItem() {}

//    public TodoItem(Long id, String task, Boolean isComplete) {

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

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }

}
