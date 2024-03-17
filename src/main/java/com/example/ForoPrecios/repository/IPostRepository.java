package com.example.ForoPrecios.repository;

import com.example.ForoPrecios.model.entity.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post,Long> {
    //Obtener todos los posts de un usuario
    @Query(value = "SELECT * FROM Post p WHERE p.id_usuario = :id_usuario", nativeQuery = true)
    List<Post> obtenerPostsDeUsuario(@Param("id_usuario") Long id_usuario);
    //Obtener todos los posts de un determinado producto
    @Query(value = "SELECT * FROM Post p WHERE p.id_producto = :id_producto", nativeQuery = true)
    List<Post> obtenerPostsDeProdcuto(@Param("id_producto") Long id_producto);
    //Obtener todos los posts de una categoria
    @Query(value = "SELECT * FROM Post p WHERE p.id_categoria = :id_categoria", nativeQuery = true)
    List<Post> obtenerPostsDeCategoria(@Param("id_categoria") Long id_categoria);
    //Obtener todos los posts relacionados a un determinado lugar
    @Query(value = "SELECT * FROM Post p WHERE p.id_local = :id_local", nativeQuery = true)
    List<Post> obtenerPostsDeLocal(@Param("id_local") Long id_local);
}
