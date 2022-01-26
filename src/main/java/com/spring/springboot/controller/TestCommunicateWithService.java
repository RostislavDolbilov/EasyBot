package com.spring.springboot.controller;

import com.spring.springboot.model.FullTodo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestCommunicateWithService {
    final String URL_EMPLOYEES = "http://localhost:8090/todos/get_todo?id=";

    @GetMapping("/get_todo")
    public ResponseEntity getTodo(@RequestParam Long id){
        RestTemplate restTemplate = new RestTemplate();

        try {
            FullTodo fullTodo = restTemplate.getForObject(URL_EMPLOYEES + id, com.spring.springboot.model.FullTodo.class);
            return ResponseEntity.ok(fullTodo);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
