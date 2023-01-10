package dev.rudresh.todoappbackend.service;

import dev.rudresh.todoappbackend.domain.TodoItem;
import dev.rudresh.todoappbackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoItem> fetchAllTodoItems() {
        return todoRepository.fetchAllTodoItems();
    }

    public TodoItem updateTodoItem(Long id, TodoItem todoItem) {
        Optional<TodoItem> todoItemOptional = todoRepository.fetchAllTodoItems().stream().filter(item -> item.getId().equals(id)).findAny();
        if (todoItemOptional.isPresent()) {
            TodoItem item = todoItemOptional.get();
            item.setIsComplete(todoItem.getIsComplete());
            item.setTask(todoItem.getTask());
            return item;
        }
        return null;
    }
}
