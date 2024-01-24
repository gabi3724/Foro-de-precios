package com.example.ForoPrecios.dto;

import com.example.ForoPrecios.model.Categoria;
import com.example.ForoPrecios.model.Local;
import com.example.ForoPrecios.model.Producto;
import com.example.ForoPrecios.model.Usuario;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDTO {
    
    @NotNull(message = "El post debe tener un precio")
    @Positive(message = "El precio debe ser positivo")
    private Double precio;
    
    @NotNull(message = "El post debe tener una fecha")
    private LocalDateTime fecha;
    
    @NotNull(message = "Debe tener un usuario")
    private Usuario usuario;
    
    @NotNull(message = "Debe tener un local")
    private Local local;
    
    @NotNull(message = "Debe tener un producto")
    private Producto producto;
    
    @NotNull(message = "Debe tener una categoria")
    private Categoria categoria;
    
}
