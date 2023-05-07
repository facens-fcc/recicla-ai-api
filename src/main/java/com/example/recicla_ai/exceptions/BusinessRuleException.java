package com.example.recicla_ai.exceptions;

public class BusinessRuleException extends RuntimeException{
    public BusinessRuleException(String errorMessage) {
        super(errorMessage);
    }
}
