package com.example.creadible.Model.web;

import com.example.creadible.Model.service.impl.ModelServiceImpl;
import com.example.creadible.Model.web.dto.ModelCsvDto;
import com.example.creadible.Model.web.dto.ModelCsvResponseDto;
import com.example.creadible.User.web.dto.UserResponseDto;
import com.example.creadible.User.web.dto.UserSignUpDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "Model", description = "모델 API")
@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/model/")
public class ModelController {
    private final ModelServiceImpl modelService;
    @Operation(summary = "get data from XAI Model", description = "XAI로부터 데이터 가져오기")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UserSignUpDto.class)))})
    @PostMapping("/data")
    public ResponseEntity<String> learning(@RequestBody MultipartFile multipartFile) {
        return ResponseEntity.status(HttpStatus.OK).body("ho");
    }
}
