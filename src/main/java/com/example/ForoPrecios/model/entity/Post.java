package com.example.ForoPrecios.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private Double precio;
    private LocalDateTime fecha;
    
    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "localId")
    private Local local;
    
    @ManyToOne
    @JoinColumn(name = "productoId")
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "categoriaId")
    private Categoria categoria;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    @JsonIgnore // Evita que se serialice la relación desde Post a Comentario
    private List<Comentario> comentarios;

}
