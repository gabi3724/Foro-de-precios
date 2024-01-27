package com.example.ForoPrecios.controller;

import com.example.ForoPrecios.model.dto.ComentarioDTO;
import com.example.ForoPrecios.model.entity.Comentario;
import com.example.ForoPrecios.service.IComentarioService;
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
public class ComentarioController {
    
    @Autowired
    private IComentarioService comentarioService;
    
    @GetMapping("/comentarios/{id}")
    public Comentario getComentario(@PathVariable Long id){
        return comentarioService.findComentario(id);
    }
    
    @GetMapping("/comentarios")
    public List<Comentario> getComentarios(){
        return comentarioService.getComentarios();
    }
    
    @PostMapping("/comentarios/crear")
    public void crearComentario(@RequestBody @Valid ComentarioDTO comentarioDTO){
        Comentario comentario = Comentario.builder().texto(comentarioDTO.getTexto()).fecha(comentarioDTO.getFecha()).build();
        comentarioService.saveComentario(comentario);
    }
    
    @PutMapping("/comentarios/editar/{id}")
    public void editarComentario(@PathVariable Long id){
        comentarioService.editComentario(null);
    }
    
    @DeleteMapping("/comentarios/eliminar/{id}")
    public void eliminarComentario(@PathVariable Long id){
        comentarioService.deleteComentario(id);
    }
    
}