package com.example.ForoPrecios.repository;

import com.example.ForoPrecios.model.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocalRepository extends JpaRepository<Local,Long> {
    
}
