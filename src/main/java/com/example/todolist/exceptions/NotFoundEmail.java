package com.example.todolist.exceptions;

public class NotFoundEmail extends RuntimeException {
    public NotFoundEmail(String message) {
        super(message);
    }
}
