package com.example.tatitatabank.exception;

public class NaoEncontradoException extends RuntimeException {
    public NaoEncontradoException(String objeto) {
        super(objeto + " não encontrado!");
    }
}
