package com.example.ForoPrecios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_categoria;
    
    private String nombre;
    
    /*@OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    private List<Producto> productos;*/
    
}
