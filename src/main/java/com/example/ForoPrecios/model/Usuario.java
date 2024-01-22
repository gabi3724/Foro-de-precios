package com.example.ForoPrecios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
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
