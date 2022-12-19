package com.example.creadible.User.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Getter
@NoArgsConstructor
public class UserLoginDto {
    @NotNull
    private String loginId;
    @NotNull
    private String password;
}
