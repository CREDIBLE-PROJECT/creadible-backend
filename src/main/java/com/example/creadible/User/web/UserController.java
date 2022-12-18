package com.example.creadible.User.web;

import com.example.creadible.User.service.impl.UserServiceImpl;
import com.example.creadible.User.web.dto.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "User", description = "유저 API")
@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/user/")
public class UserController {
    private final UserServiceImpl userService;

    @Operation(summary = "signup of user", description = "회원가입")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UserSignUpDto.class)))})
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(@Valid @RequestBody UserSignUpDto userSignUpDto) {
        UserResponseDto userResponseDto = userService.signUp(userSignUpDto);

        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }


}
