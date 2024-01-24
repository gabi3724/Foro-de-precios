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
public class Local {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_local;
    private String nombre;
    private String direccion;
    
}
