package com.spring.springboot.controller;

import com.spring.springboot.entity.TodoEntity;
import com.spring.springboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/create_todo")
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long userId){
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/update_todo")
    public ResponseEntity completeTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(todoService.complete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get_todo")
    public ResponseEntity getTodo(@RequestParam Long id){
        try {
            return ResponseEntity.ok(todoService.getTodoById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
