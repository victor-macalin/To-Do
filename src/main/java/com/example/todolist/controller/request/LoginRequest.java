package com.example.todolist.controller.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record LoginRequest (@NotEmpty(message = "Email e obrigatorio") String username, @NotEmpty(message = "senha e obrigatorio") String password) {}
