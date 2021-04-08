package com.example.error.Family;

public class FamilyInsertNameNotFoundException extends RuntimeException{

    public FamilyInsertNameNotFoundException() {
        super("No se puede insertar una familia sin nombre");
    }
}
