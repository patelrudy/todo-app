package dev.rudresh.todoappbackend.service;

import dev.rudresh.todoappbackend.domain.TodoItem;
import dev.rudresh.todoappbackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoItem> fetchAllTodoItems() {
        return todoRepository.fetchAllTodoItems();
    }
}
