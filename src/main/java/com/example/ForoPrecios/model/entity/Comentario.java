package com.example.ForoPrecios.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Comentario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentarioId;
    private String texto;
    private LocalDateTime fecha;
    
    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;
    
}
