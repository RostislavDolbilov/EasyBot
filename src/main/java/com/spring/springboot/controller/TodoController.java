package com.spring.springboot.controller;

import com.spring.springboot.entity.TodoEntity;
import com.spring.springboot.service.TodoService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
//@Hidden
@Tag(name="TodoController", description="Creation of new todo, updating and getting")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/create_todo")
    @Operation( summary = "Creation a new todo",
                description = "Creation a new todo")
    public ResponseEntity createTodo(@RequestBody @Parameter(description = "Header with todo body") TodoEntity todo,
                                     @RequestParam @Parameter(description = "User ID") Long userId){
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/update_todo")
    @Operation( summary = "Updating status completing of todo",
                description = "Updating status completing of todo")
    public ResponseEntity completeTodo(@RequestParam @Parameter(description = "Todo ID") Long id) {
        try {
            return ResponseEntity.ok(todoService.complete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get_todo")
    @Operation( summary = "Getting todo by ID",
                description = "Getting todo by ID")
    public ResponseEntity getTodo(@RequestParam @Parameter(description = "Todo ID") Long id){
        try {
            return ResponseEntity.ok(todoService.getTodoById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
