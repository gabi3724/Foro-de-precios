package com.example.ForoPrecios.service;

import com.example.ForoPrecios.model.Categoria;
import com.example.ForoPrecios.repository.ICategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements ICategoriaService {
    
    @Autowired
    private ICategoriaRepository categoriaRepo;
    
    @Override
    public Categoria findCategoria(Long id) {
        return categoriaRepo.findById(id).orElse(null);
    }

    @Override
    public void saveCategoria(Categoria categoria) {
        categoriaRepo.save(categoria);
    }

    @Override
    public void deleteCategoria(Long id) {
        categoriaRepo.deleteById(id);
    }

    @Override
    public List<Categoria> getCategorias() {
        return categoriaRepo.findAll();
    }

    @Override
    public void editCategoria(Categoria categoria) {
        this.saveCategoria(categoria);
    }   
    
}
