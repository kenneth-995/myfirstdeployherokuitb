package com.example.error.drug;

public class DrugNotFoundException extends RuntimeException{
    public DrugNotFoundException(Long id) {
        super("No se ha encontrado el farmaco con ID: " + id);
    }

    public DrugNotFoundException() {
        super("No se han encontrado farmacos");
    }
}
