package com.example.ForoPrecios.model.dto;

import com.example.ForoPrecios.model.entity.Post;
import com.example.ForoPrecios.model.entity.Usuario;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ComentarioDTO {
    
    @NotEmpty(message = "Debe escribir algo")
    @Size(min=2, max=150, message = "El comentario debe tener entre 2 y 150 caracteres")
    private String texto;
    
    @NotNull(message = "El comentario debe tener asignado un post")
    private Post post;

    @NotNull(message = "El comentario debe tener asignado un usuario")
    private Usuario usuario;
    
}
