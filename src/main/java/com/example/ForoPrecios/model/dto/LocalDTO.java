package com.example.ForoPrecios.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LocalDTO {
    
    @NotEmpty(message = "El nombre del local no puede estar vacio")
    @Size(min=2, message = "El nombre debe tener minimo entre 2 caracteres")
    private String nombre;
    
    @NotEmpty(message = "La direccion no puede estar vacia")
    @Size(min=6, message = "La direccion debe tener minimo 6 caracteres")
    private String direccion;
    
}
