package com.example.ForoPrecios.repository;

import com.example.ForoPrecios.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria,Long> {
    
    @Query("SELECT c FROM Categoria c WHERE c.nombre=?1")
    Categoria obtenerCaregoriaPorNombre(String nombre);
    
}
