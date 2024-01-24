package com.example.ForoPrecios.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductoDTO {
    
    @NotEmpty(message = "El nombre del producto no puede estar vacio")
    @Size(min = 2, message = "El nombre debe tener como minimo dos caracteres")
    private String nombre;
    
    @NotEmpty(message = "La marca no puede estar vacia")
    @Size(min = 2, message = "La marca debe tener como minimo dos caracteres")
    private String marca;
    
}
