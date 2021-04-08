package com.example.error.Family;

public class FamilyNotFoundException extends RuntimeException{

    public FamilyNotFoundException(Long id) {
        super("No se ha encontrado la familia con ID: " + id);
    }

    public FamilyNotFoundException() {
        super("No se han encontrado familias");
    }
}
