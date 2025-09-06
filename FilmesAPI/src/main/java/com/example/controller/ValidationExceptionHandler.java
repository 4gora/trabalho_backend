package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ValidationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        String mensagem;
        org.springframework.validation.FieldError fieldError = ex.getBindingResult().getFieldError();
        if (fieldError != null) {
            String defaultMessage = fieldError.getDefaultMessage();
            mensagem = defaultMessage != null ? defaultMessage : "Erro de validação desconhecido";
        } else {
            mensagem = "Erro de validação desconhecido";
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro de validação: " + mensagem);
    }
}
