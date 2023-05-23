package com.example.recicla_ai.exceptions;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiErrors extends RuntimeException {

    @Getter
    private List<String> errors;
    public ApiErrors(String errorMessage) {
        errors = Arrays.asList(errorMessage);
    }
}
