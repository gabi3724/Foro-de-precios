package com.example.ForoPrecios.repository;

import com.example.ForoPrecios.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByEmail(String email);

    @Modifying
    @Query("DELETE FROM Usuario u WHERE u.usuarioId = :id")
    int deleteUser(@Param("id") Long id);
    
}
