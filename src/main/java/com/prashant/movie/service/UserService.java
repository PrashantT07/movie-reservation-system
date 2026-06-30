package com.prashant.movie.service;

import com.prashant.movie.dto.LoginRequest;
import com.prashant.movie.dto.LoginResponse;
import com.prashant.movie.dto.RegisterRequest;

public interface UserService {

    void register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}