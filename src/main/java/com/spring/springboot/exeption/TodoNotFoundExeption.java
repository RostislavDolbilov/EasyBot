package com.spring.springboot.exeption;

public class TodoNotFoundExeption extends Exception{
    public TodoNotFoundExeption(String message) {
        super(message);
    }
}
