package com.example.ForoPrecios.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoriaDTO {
    
    @NotEmpty(message = "El nombre no puede ser vacio") 
    @Size(min = 2, message = "El nombre debe tener al menos dos caracteres")
    private String nombre;
    
}
