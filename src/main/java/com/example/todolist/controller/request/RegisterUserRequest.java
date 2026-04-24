package com.example.todolist.controller.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record RegisterUserRequest (@NotEmpty String name, @NotEmpty String email, @NotEmpty String password) {

}
