package com.example.creadible.User.service;

import com.example.creadible.User.web.dto.*;

public interface UserService {
    UserResponseDto signUp(UserSignUpDto userSignUpDto);
    UserScoreResponseDto calculate(String userName);
    UserResponseDto login(UserLoginDto loginDto);
}
