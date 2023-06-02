package com.spring.springboot.controller;

import com.spring.springboot.dal.CommonErrorResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ErrorHandlerController {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<CommonErrorResponseDto> returnError(ResponseStatusException e) {

        return ResponseEntity
                .status(e.getStatus())
                .body(CommonErrorResponseDto.builder()
                        .message(e.getReason())
                        .status(e.getRawStatusCode())
                        .build());
    }
}
