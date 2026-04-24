package com.example.todolist.controller.response;

import lombok.Builder;

@Builder
public record RegisterUserResponse(String name, String email) {
}
