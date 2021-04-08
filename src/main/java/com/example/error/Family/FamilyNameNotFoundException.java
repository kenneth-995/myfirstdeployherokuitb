package com.example.error.Family;

public class FamilyNameNotFoundException extends RuntimeException{

    public FamilyNameNotFoundException() {
        super("No se puede insertar una familia sin nombre");
    }
}
