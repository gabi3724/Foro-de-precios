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
    private Long id_post;
    private Double precio;
    private LocalDateTime fecha;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_local")
    private Local local;
    
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    @JsonIgnore // Evita que se serialice la relación desde Post a Comentario
    private List<Comentario> comentarios;

}
