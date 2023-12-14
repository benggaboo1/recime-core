package com.recime.core.common;

import com.recime.core.exception.ApiError;
import com.recime.core.exception.InvalidDifficultyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.recime.core.constants.RecimeConstants.*;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({ InvalidDifficultyException.class })
    public ResponseEntity<Object> handleInvalidDifficulty(InvalidDifficultyException e) {
        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, e.getMessage(), e.getTitle());

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({ MissingServletRequestParameterException.class })
    public ResponseEntity<Object> handleMissingRequestParameter(MissingServletRequestParameterException e) {
        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, MISSING_DIFFICULTY_PARAM, TITLE_OOPS);

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

   /* @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleGenericException(Exception e) {
        ApiError apiError =
                new ApiError(HttpStatus.UNPROCESSABLE_ENTITY, GENERIC_ERROR, TITLE_OOPS);

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }*/

}
