package com.example.creadible.User.web;

import com.example.creadible.User.domain.entity.User;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Operation(summary = "credit score of user", description = "유저의 신용등급 확인")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UserScoreResponseDto.class)))})
    @GetMapping("/data")
    public ResponseEntity<UserScoreResponseDto> rank(String userName) {
        UserScoreResponseDto userScoreResponseDto = userService.calculate(userName);

        return ResponseEntity.status(HttpStatus.OK).body(userScoreResponseDto);
    }

    @Operation(summary = "login of user", description = "로그인")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UserLoginDto.class)))})
    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> signup(@Valid @RequestBody UserLoginDto loginDto, HttpServletRequest request, RedirectAttributes rttr) {
        HttpSession session = request.getSession();

        UserResponseDto userResponseDto = userService.login(loginDto);
        if(userResponseDto == null) {
            session.setAttribute("member",null);
            rttr.addFlashAttribute("msg",false);
        } else{
            session.setAttribute("member", userResponseDto);
        }
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

}
