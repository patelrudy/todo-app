package dev.rudresh.todoappbackend.controller;

import dev.rudresh.todoappbackend.domain.TodoItem;
import dev.rudresh.todoappbackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;
    private Long id = 0L;
    //Fetch all todoitems
    @GetMapping("/api/todoItems")
    public ResponseEntity<?> fetchAllTodoItems() {
        List<TodoItem> todoItems = todoService.fetchAllTodoItems();
        if (todoItems == null || todoItems.size() == 0) {
            TodoItem item = new TodoItem(id++, "Task 1", false);
            todoItems.add(item);
        }
        return ResponseEntity.ok(todoItems);
    }
}
