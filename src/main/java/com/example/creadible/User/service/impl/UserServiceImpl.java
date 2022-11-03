package com.example.creadible.User.service.impl;

import com.example.creadible.User.domain.repository.UserRepository;
import com.example.creadible.User.service.UserService;
import com.example.creadible.User.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserResponseDto signUp(UserSignUpDto userSignUpDto) {
        return new UserResponseDto(userRepository.save(userSignUpDto.toEntity()));
    }
}
