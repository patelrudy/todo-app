package dev.rudresh.todoappbackend.repository;

import dev.rudresh.todoappbackend.domain.TodoItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TodoRepository {

    private List<TodoItem> todoItems = new ArrayList<>();
    private static Long id = 0L;

    public List<TodoItem> fetchAllTodoItems() {
        if (todoItems.size() == 0) {
            TodoItem item = new TodoItem();
            item.setIsComplete(false);
            item.setId(++id);
            item.setTask("TODO " + id);
            todoItems.add(item);
        }
        return todoItems;
    }

    public TodoItem save(TodoItem todoItem) {
        todoItem.setId(++id);
        todoItems.add(todoItem);
        return todoItem;
    }

    public void delete(Long id) {
        todoItems = todoItems.stream().filter(todoItem -> !todoItem.getId().equals(id)).collect(Collectors.toList());
    }
}
