package com.example.ForoPrecios.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;

    /*@OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;*/

    /*@OneToMany(mappedBy = "usuario")
    private List<Post> posts;*/
    
}
