package com.example.ForoPrecios.controller;

import com.example.ForoPrecios.dto.CategoriaDTO;
import com.example.ForoPrecios.model.Categoria;
import com.example.ForoPrecios.service.ICategoriaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {
    
    @Autowired
    private ICategoriaService categoriaService;
    
    @GetMapping("/categorias/{id}")
    public Categoria getCategoria(@PathVariable Long id){
        return categoriaService.findCategoria(id);
    }
    
    @GetMapping("/categorias")
    public List<Categoria> getCategorias(){
        return categoriaService.getCategorias();
    }
    
    @PostMapping("/categorias/crear")
    public void crearCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO){
        Categoria categoria = Categoria.builder().nombre(categoriaDTO.getNombre()).build();
        categoriaService.saveCategoria(categoria);
    }
    
    @PutMapping("/categorias/editar/{id}")
    public void editarCategoria(@PathVariable Long id){
        categoriaService.editCategoria(null);
    }
    
    @DeleteMapping("/categorias/eliminar/{id}")
    public void eliminarCategoria(@PathVariable Long id){
        categoriaService.deleteCategoria(id);
    }
 
}