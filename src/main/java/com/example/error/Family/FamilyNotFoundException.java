package com.example.error.Family;

import com.example.model.entity.Family;

public class FamilyNotFoundException extends RuntimeException{

    public FamilyNotFoundException(Long id) {
        super("No se ha encontrado la familia con ID: " + id);
    }

    public FamilyNotFoundException(String name) {
        super("No se ha encontrado la familia con nombre: " + name);
    }

    public FamilyNotFoundException() {
        super("No se han encontrado familias");
    }

}
