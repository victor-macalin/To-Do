package com.example.todolist.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.todolist.model.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private final String secret = "minhaSecret";

    public String generateToken (User user) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        String token = JWT
                .create()

                .withIssuer("auth-api")
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withSubject(user.getEmail())
                .sign(algorithm);
        return token;
    }


    public Instant tempo () {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}


























