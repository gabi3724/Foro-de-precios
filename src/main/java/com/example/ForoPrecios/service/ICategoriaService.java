package com.example.ForoPrecios.service;

import com.example.ForoPrecios.model.Categoria;
import java.util.List;

public interface ICategoriaService {

    public Categoria findCategoria(Long id);
    public void saveCategoria(Categoria categoria);
    public void deleteCategoria(Long id);
    public List<Categoria> getCategorias();
    public void editCategoria(Categoria categoria);
    
}
