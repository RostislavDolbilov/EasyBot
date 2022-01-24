package com.spring.springboot.exeption;

public class TodoNotFoundException extends Exception{
    public TodoNotFoundException(String message) {
        super(message);
    }
}
