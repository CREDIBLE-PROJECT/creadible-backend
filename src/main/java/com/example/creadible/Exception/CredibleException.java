package com.example.creadible.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CredibleException extends RuntimeException{
    private final HttpStatus httpStatus;
    private final ExceptionResponse body;
    public CredibleException(HttpStatus httpStatus, ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.httpStatus = httpStatus;
        this.body = new ExceptionResponse(errorCode.getErrorCode(), errorCode.getMessage());
    }
    public CredibleException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.httpStatus = errorCode.getErrorCode();
        this.body = new ExceptionResponse(errorCode.getErrorCode(), errorCode.getMessage());
    }
}
