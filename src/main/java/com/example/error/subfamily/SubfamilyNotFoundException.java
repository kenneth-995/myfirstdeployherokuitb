package com.example.error.subfamily;

public class SubfamilyNotFoundException extends RuntimeException{

    public SubfamilyNotFoundException(Long id) {
        super("No se ha encontrado la subfamilia con ID: " + id);
    }

    public SubfamilyNotFoundException(String name) {
        super("No se ha encontrado la subfamilia con nombre: " + name);
    }

    public SubfamilyNotFoundException() {
        super("No se han encontrado subfamilias");
    }
}
