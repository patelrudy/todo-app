package dev.rudresh.todoappbackend.repository;

import dev.rudresh.todoappbackend.domain.TodoItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepository {

    private List<TodoItem> todoItems = new ArrayList<>();
    public List<TodoItem> fetchAllTodoItems() {
        return todoItems;
    }
}
