package com.spring.springboot.exeption;

public class UserNotFoundExeption extends Exception{
    public UserNotFoundExeption(String message) {
        super(message);
    }
}
