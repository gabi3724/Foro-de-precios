package com.example.ForoPrecios.repository;

import com.example.ForoPrecios.model.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post,Long> {
    
    @Query(
            value = "SELECT * FROM Post p WHERE p.id_usuario = ?1",
            nativeQuery = true)
    List<Post> obtenerPostsDeUsuario(Long id_usuario);
    
    @Query(
            value = "SELECT * FROM Post p WHERE p.id_producto = :id_producto",
            nativeQuery = true)
    List<Post> obtenerPostsDeProdcuto(@Param("id_producto") Long id_producto);
   
    @Query(
            value = "SELECT * FROM Post p WHERE p.id_categoria = :id_categoria",
            nativeQuery = true)
    List<Post> obtenerPostsDeCategoria(@Param("id_categoria") Long id_categoria);
    
    @Query(
            value = "SELECT * FROM Post p WHERE p.id_local = :id_local", 
            nativeQuery = true)
    List<Post> obtenerPostsDeLocal(@Param("id_local") Long id_local);
    
}
