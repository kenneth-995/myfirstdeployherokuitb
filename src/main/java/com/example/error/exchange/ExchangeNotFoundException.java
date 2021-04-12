package com.example.error.exchange;

public class ExchangeNotFoundException extends RuntimeException{
    public ExchangeNotFoundException(Long id) {
        super("No se ha encontrado el intercambio con ID: " + id);
    }

    public ExchangeNotFoundException() {
        super("No se han encontrado intercambios");
    }
}
