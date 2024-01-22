package com.example.ForoPrecios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
