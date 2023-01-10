package dev.rudresh.todoappbackend.repository;

import dev.rudresh.todoappbackend.domain.TodoItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepository {

    private List<TodoItem> todoItems = new ArrayList<>();
    private Long id = 0L;

    public List<TodoItem> fetchAllTodoItems() {
        if (todoItems.size() == 0) {
//            TodoItem item = new TodoItem(id++, "Task 1", true);
            TodoItem item = new TodoItem();
            item.setIsComplete(true);
            item.setId(id++);
            item.setTask("task one");
            todoItems.add(item);
        }
        return todoItems;
    }
}
