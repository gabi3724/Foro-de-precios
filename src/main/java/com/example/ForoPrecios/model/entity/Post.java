package com.example.ForoPrecios.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    
    /*
    @OneToMany(mappedBy = "post")
    private List<Comentario> comentarios;
    
    Features futuras
    private int me_gusta;
    private int no_me_gusta;
    */
    
}
