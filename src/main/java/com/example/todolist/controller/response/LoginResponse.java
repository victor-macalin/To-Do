package com.example.todolist.controller.response;

import lombok.Builder;

@Builder
public record LoginResponse (String token) {

}
