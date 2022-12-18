package com.example.creadible.User.web.dto;

import com.example.creadible.User.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Getter
@NoArgsConstructor
public class UserSignUpDto {
    @NotNull
    private String loginId;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private boolean gender;
    @NotNull
    private LocalDate birthday;
    @Email
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
