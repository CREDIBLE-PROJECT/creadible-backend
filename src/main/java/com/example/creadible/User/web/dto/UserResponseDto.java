package com.example.creadible.User.web.dto;

import com.example.creadible.User.domain.entity.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserResponseDto {
    private final Long id;
    private final String loginId;
    private final String password;
    private final String name;
    private final boolean gender;
    private final LocalDate birthday;
    private final String email;
    private final Role role;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.loginId = user.getLoginId();
        this.password = user.getPassword();
        this.name = user.getName();
        this.gender = user.isGender();
        this.birthday = user.getBirthday();
        this.email = user.getEmail();
        this.role = user.getRole();
    }
}
