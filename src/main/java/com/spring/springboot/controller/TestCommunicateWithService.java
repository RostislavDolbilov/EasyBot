package com.spring.springboot.controller;

import com.spring.springboot.model.FullTodo;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
@Tag(name="TestCommunicateWithService", description="Testing restTemplate request from another controller(service or project)")
public class TestCommunicateWithService {
    final String URL_TODO = "http://localhost:8090/todos/get_todo?id=";

    @GetMapping("/get_todo")
    @Operation(
            summary = "getTodo method",
            description = "Getting todo info by ID, from another controller(service or project)"
    )
    public ResponseEntity getTodo(@RequestParam("ID") @Parameter(description = "ID of todo") Long id){
        RestTemplate restTemplate = new RestTemplate();

        try {
            FullTodo fullTodo = restTemplate.getForObject(URL_TODO + id, com.spring.springboot.model.FullTodo.class);
            return ResponseEntity.ok(fullTodo);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
