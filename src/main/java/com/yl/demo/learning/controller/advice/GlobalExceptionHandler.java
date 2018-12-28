package com.yl.demo.learning.controller.advice;

import com.yl.demo.learning.exception.BadRequestException;
import com.yl.demo.learning.exception.ResourceNotFoundException;
import com.yl.demo.learning.response.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { ResourceNotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<?> handleBadRequestException(ResourceNotFoundException e) {

        return null;
        //return new ApiResponse(ex.getTimestamp(), ex.getStatus(), ex.getCode(), ex.getError(), ex.getMessage(), ex.getPath());
    }

    @ExceptionHandler(value = { BadRequestException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleISystemException(BadRequestException e) {

        return null;
        //return new ApiResponse(ex.getTimestamp(), ex.getStatus(), ex.getCode(), ex.getError(), ex.getMessage(), ex.getPath());
    }

}
