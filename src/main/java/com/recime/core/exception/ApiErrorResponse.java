package com.recime.core.exception;

import lombok.Data;

@Data
public class ApiErrorResponse {

    private String title;
    private String message;

}
