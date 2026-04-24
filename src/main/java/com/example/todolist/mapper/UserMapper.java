package com.example.todolist.mapper;

import com.example.todolist.controller.request.RegisterUserRequest;
import com.example.todolist.controller.response.LoginResponse;
import com.example.todolist.controller.response.RegisterUserResponse;
import com.example.todolist.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser (RegisterUserRequest registerUserRequest) {
        return User
                .builder()
                .email(registerUserRequest.email())
                .password(registerUserRequest.password())
                .build();
    }
    public RegisterUserResponse toUserResponse (User user) {
        return RegisterUserResponse
                .builder()
                .name(user.getUsername())
                .email(user.getEmail())
                .build();
    }
    public LoginResponse toLoginResponse (User user) {

    }
}
