package com.spring.springboot.dal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class CommonErrorResponseDto {
    private String message;
    private int status;
}
