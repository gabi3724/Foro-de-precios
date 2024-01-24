package com.example.ForoPrecios.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ComentarioDTO {
    
    @NotEmpty(message = "Debe escribir algo")
    @Size(min=2, max=150, message = "El comentario debe tener entre 2 y 150 caracteres")
    private String texto;
    
    @NotEmpty(message = "El comentario debe tener una fecha")
    private LocalDateTime fecha;
    
}
