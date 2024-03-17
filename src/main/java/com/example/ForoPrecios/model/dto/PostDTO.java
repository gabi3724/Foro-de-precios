package com.example.ForoPrecios.model.dto;

import com.example.ForoPrecios.model.entity.Categoria;
import com.example.ForoPrecios.model.entity.Local;
import com.example.ForoPrecios.model.entity.Producto;
import com.example.ForoPrecios.model.entity.Usuario;
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
    
    @NotNull(message = "Debe tener un usuario")
    private Usuario usuario;
    
    @NotNull(message = "Debe tener un local")
    private Local local;
    
    @NotNull(message = "Debe tener un producto")
    private Producto producto;
    
    @NotNull(message = "Debe tener una categoria")
    private Categoria categoria;
    
}
