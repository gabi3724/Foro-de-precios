package com.example.ForoPrecios.advice;

import com.example.ForoPrecios.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    @Autowired
    IUsuarioService usuarioService;

    @Override
    public void initialize(Unique constraintAnnotation) {
        // No initialization needed
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Let other validators handle null values
        }  
        // Use repository to check if the value already exists in the database
        return !usuarioService.existeEmail((String) value);
    }
    
}