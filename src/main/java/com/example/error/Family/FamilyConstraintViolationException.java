package com.example.error.Family;

public class FamilyConstraintViolationException extends RuntimeException{

    public FamilyConstraintViolationException() {super("No se puede borrar familia vinculada con una subfamilia");}
}
