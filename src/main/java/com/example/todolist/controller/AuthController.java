package com.example.todolist.controller;

import com.example.todolist.controller.request.LoginRequest;
import com.example.todolist.controller.request.RegisterUserRequest;
import com.example.todolist.controller.response.LoginResponse;
import com.example.todolist.controller.response.RegisterUserResponse;
import com.example.todolist.mapper.UserMapper;
import com.example.todolist.model.User;
import com.example.todolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest loginRequest) {
        try {
            UsernamePasswordAuthenticationToken userandPass = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());
            Authentication authentication = authenticationManager.authenticate(userandPass);

            return ResponseEntity.ok();
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }

    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register (RegisterUserRequest request) {
        User user = new User();
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toUserResponse(user));
    }
}
