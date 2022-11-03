package com.example.creadible.User.web.dto;

import com.example.creadible.User.domain.entity.User;
import lombok.Getter;

import java.time.LocalDate;
@Getter
public class UserSignUpDto {
    private String loginId;
    private String password;
    private String name;
    private boolean gender;
    private LocalDate birthday;
    private String email;

    public User toEntity() {
        return User.builder()
                .loginId(loginId)
                .password(password)
                .name(name)
                .gender(gender)
                .birthday(birthday)
                .email(email)
                .build();
    }
}
