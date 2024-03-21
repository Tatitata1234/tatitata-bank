package com.example.tatitatabank.exception;

public class JaExisteException extends RuntimeException {
    public JaExisteException(String objeto) {
        super(objeto + " já cadastrado!");
    }
}
