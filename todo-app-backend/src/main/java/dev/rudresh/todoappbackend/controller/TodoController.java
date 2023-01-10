package dev.rudresh.todoappbackend.controller;

import dev.rudresh.todoappbackend.domain.TodoItem;
import dev.rudresh.todoappbackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    //Fetch all todoitems
    @GetMapping("/api/todoItems")
    public ResponseEntity<?> fetchAllTodoItems() {
        List<TodoItem> todoItems = todoService.fetchAllTodoItems();

        return ResponseEntity.ok(todoItems);
    }

    @PostMapping("/api/todoItems")
    public ResponseEntity<?> createNewTodoItem() {
        TodoItem todoItem = todoService.createTodoItem();
        return ResponseEntity.ok(todoItem);
    }

    @PutMapping("/api/todoItems/{id}")
    public ResponseEntity<?> updateTodoItem(@PathVariable Long  id, @RequestBody TodoItem todoItem) {

        TodoItem updatedTodoItem = todoService.updateTodoItem(id, todoItem);

        return (updatedTodoItem != null) ? ResponseEntity.ok(updatedTodoItem) : (ResponseEntity<?>) ResponseEntity.notFound();
    }

    @DeleteMapping("/api/todoItems/{id}")
    public ResponseEntity<?> deleteTodoItem(@PathVariable Long id) {
        todoService.deleteTodoItem(id);
        return ResponseEntity.ok("{\"status\": \"ok\"}");
    }
}
