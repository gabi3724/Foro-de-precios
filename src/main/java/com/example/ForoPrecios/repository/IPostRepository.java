package com.example.ForoPrecios.repository;

import com.example.ForoPrecios.model.entity.Post;

import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post,Long> {

    /*
    SELECT * FROM post p
    JOIN usuario u ON p.usuario_id = u.usuario_id
    WHERE u.usuario_id = ?;
     */
    List<Post> findByUsuarioUsuarioId(Long usuarioId);

    List<Post> findByProductoProductoId(Long productoId);

    List<Post> findByCategoriaCategoriaId(Long categoriaId);

    List<Post> findByLocalLocalId(Long localId);

    //List<Post> findByFechaLess(Instant time);

}
