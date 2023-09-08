package com.fincoop.associado.infra;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErroNotValid(MethodArgumentNotValidException ex) {

        var erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity tratarConstraintViolationException(ConstraintViolationException ex) {
        var errors = ex.getConstraintViolations();

        return ResponseEntity.badRequest().body(errors.stream().map(ConstraintViolation::getMessage));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    private record DadosErroValidacao(String campo, String mensagem) {
        public DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
