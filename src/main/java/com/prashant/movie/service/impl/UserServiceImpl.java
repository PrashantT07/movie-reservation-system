package com.prashant.movie.service.impl;

import com.prashant.movie.dto.RegisterRequest;
import com.prashant.movie.entity.Role;
import com.prashant.movie.entity.User;
import com.prashant.movie.repository.UserRepository;
import com.prashant.movie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.prashant.movie.dto.LoginRequest;
import com.prashant.movie.dto.LoginResponse;
import com.prashant.movie.security.JwtService;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public void register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .role(Role.USER)
                .enabled(true)
                .build();

        userRepository.save(user);
    }
    @Override
public LoginResponse login(LoginRequest request) {

    User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("Invalid email or password"));

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        throw new RuntimeException("Invalid email or password");
    }

    String token = jwtService.generateToken(user.getEmail());

    return new LoginResponse(token);
}
}