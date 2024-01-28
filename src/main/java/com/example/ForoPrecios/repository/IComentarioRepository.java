package com.example.ForoPrecios.repository;

import com.example.ForoPrecios.model.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario,Long> {
    
}
