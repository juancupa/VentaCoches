package com.project.coches.project_coches.exception;

public class EmailValidationException extends RuntimeException {


    public EmailValidationException(){
        super("El Email no tiene el formato requerido.");
    }
}
