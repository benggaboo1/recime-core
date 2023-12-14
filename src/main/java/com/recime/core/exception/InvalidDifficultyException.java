package com.recime.core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvalidDifficultyException extends RuntimeException {

    private String title;
    private String message;
}
