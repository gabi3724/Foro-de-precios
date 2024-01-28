package com.example.ForoPrecios.controller;

import com.example.ForoPrecios.exception.ConflictException;
import com.example.ForoPrecios.exception.ResourceNotFoundException;
import com.example.ForoPrecios.model.dto.CategoriaDTO;
import com.example.ForoPrecios.model.entity.Categoria;
import com.example.ForoPrecios.service.ICategoriaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getCategoria(@PathVariable Long id){
        Categoria categoria = categoriaService.findCategoria(id);
        if(categoria == null){
            throw new ResourceNotFoundException("Categoria","id",id);
        } 
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }
    
    @GetMapping("/categorias")
    public ResponseEntity<?> getCategorias(){
        List<Categoria> categorias = categoriaService.getCategorias(); 
        if(categorias == null || categorias.isEmpty()){
            throw new ResourceNotFoundException("Categorias");
        }
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }
    
    @PostMapping("/categorias/crear")
    public ResponseEntity<?> crearCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO){
        //agregar validacion de unico
        Categoria categoria = categoriaService.obtenerCategoriaPorNombre(categoriaDTO.getNombre());
        if(categoria != null){
            throw new ConflictException("Ya existe una categoria con ese nombre");
        }
        categoria = Categoria.builder().nombre(categoriaDTO.getNombre()).build();
        try{
            categoriaService.saveCategoria(categoria);
            return new ResponseEntity<>(categoria, HttpStatus.CREATED);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    @PutMapping("/categorias/editar/{id}")
    public ResponseEntity<?> editarCategoria(@PathVariable Long id, @RequestBody @Valid CategoriaDTO categoriaDTO){
        //Mejorar esto
        Categoria categoria = categoriaService.findCategoria(id);
        if(categoria == null){
            throw new ResourceNotFoundException("Categoria","id",id); 
        }
        categoria.setId_categoria(id);
        categoria.setNombre(categoriaDTO.getNombre());
        try{
            categoriaService.editCategoria(categoria);
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    @DeleteMapping("/categorias/eliminar/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable Long id){
        Categoria categoria = categoriaService.findCategoria(id);
        if(categoria == null){
            throw new ResourceNotFoundException("Categoria","id",id); 
        }
        categoriaService.deleteCategoria(id);
        return new ResponseEntity<>("Categoria borrado exitosamente", HttpStatus.OK);
    }
    
}