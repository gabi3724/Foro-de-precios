package com.example.ForoPrecios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Comentario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_comentario;
    private String texto;
    private LocalDateTime fecha;
    
    /*@ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;*/
    
    /*@ManyToOne
    @JoinColumn(name = "id_post")
    private Post post;*/
    
}
