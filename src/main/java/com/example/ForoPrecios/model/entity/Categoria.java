package com.example.ForoPrecios.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_categoria;
    
    private String nombre;
    
    /*@OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    private List<Producto> productos;*/
    
}
