package com.example.creadible.User.service;

import com.example.creadible.User.web.dto.*;

public interface UserService {
    UserResponseDto signUp(UserSignUpDto userSignUpDto);
}
