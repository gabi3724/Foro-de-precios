package com.example.ForoPrecios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_usuario;
    
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    
    /*@OneToMany(mappedBy = "usuario")
    private List<Post> posts;*/
    
    /*@OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;*/
    
}
