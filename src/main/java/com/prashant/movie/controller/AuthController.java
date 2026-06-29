package com.prashant.movie.controller;

import com.prashant.movie.dto.RegisterRequest;
import com.prashant.movie.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @Valid @RequestBody RegisterRequest request) {

        userService.register(request);

        return new ResponseEntity<>(
                "User registered successfully",
                HttpStatus.CREATED
        );
    }
}