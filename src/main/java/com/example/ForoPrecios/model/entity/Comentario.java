package com.example.ForoPrecios.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
