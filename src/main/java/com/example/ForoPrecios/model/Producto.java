package com.example.ForoPrecios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
@Entity
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_producto;
    private String nombre;
    private String marca;
    
    /*@ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;*/
    
}
