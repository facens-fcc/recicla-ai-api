package com.example.recicla_ai.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.recicla_ai.exceptions.ApiErrors;
import com.example.recicla_ai.exceptions.BusinessRuleException;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationControllerAdvice {
    @ExceptionHandler(BusinessRuleException.class)
    public ApiErrors handlerRegraNegocioException(BusinessRuleException exception) {
        return new ApiErrors(exception.getMessage());
    }
}
