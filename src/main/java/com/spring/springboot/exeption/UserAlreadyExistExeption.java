package com.spring.springboot.exeption;

public class UserAlreadyExistExeption extends Exception{
    public UserAlreadyExistExeption(String message) {
        super(message);
    }
}
