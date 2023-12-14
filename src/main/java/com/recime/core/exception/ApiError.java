package com.recime.core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiError extends RuntimeException{

    private HttpStatus status;
    private String message;
    private String title;

}