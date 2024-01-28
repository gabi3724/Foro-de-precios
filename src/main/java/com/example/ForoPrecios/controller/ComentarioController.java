package com.example.ForoPrecios.controller;

import com.example.ForoPrecios.exception.ResourceNotFoundException;
import com.example.ForoPrecios.model.dto.ComentarioDTO;
import com.example.ForoPrecios.model.entity.Comentario;
import com.example.ForoPrecios.service.IComentarioService;
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
public class ComentarioController {
    
    @Autowired
    private IComentarioService comentarioService;
    
    @GetMapping("/comentarios/{id}")
    public ResponseEntity<?> getComentario(@PathVariable Long id){
        Comentario comentario = comentarioService.findComentario(id);
        if(comentario == null){
            throw new ResourceNotFoundException("Comentario","id",id);
        } 
        return new ResponseEntity<>(comentario, HttpStatus.OK);
    }
    
    @GetMapping("/comentarios")
    public ResponseEntity<?> getComentarios(){
        List<Comentario> comentarios = comentarioService.getComentarios(); 
        if(comentarios == null || comentarios.isEmpty()){
            throw new ResourceNotFoundException("Comentarios");
        }
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }
    
    @PostMapping("/comentarios/crear")
    public ResponseEntity<?> crearComentario(@RequestBody @Valid ComentarioDTO comentarioDTO){
        Comentario comentario = Comentario.builder().texto(comentarioDTO.getTexto()).fecha(comentarioDTO.getFecha()).build();
        try{
            comentarioService.saveComentario(comentario);
            return new ResponseEntity<>(comentario, HttpStatus.CREATED);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    @PutMapping("/comentarios/editar/{id}")
    public ResponseEntity<?> editarComentario(@PathVariable Long id, @RequestBody @Valid ComentarioDTO comentarioDTO){
        Comentario comentario = comentarioService.findComentario(id);
        if(comentario == null){
            throw new ResourceNotFoundException("Comentario","id",id); 
        }
        comentario.setId_comentario(id);
        comentario.setTexto(comentarioDTO.getTexto());
        comentario.setFecha(comentarioDTO.getFecha());
        try{
            comentarioService.editComentario(comentario);
            return new ResponseEntity<>(comentario, HttpStatus.OK);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    @DeleteMapping("/comentarios/eliminar/{id}")
    public ResponseEntity<?> eliminarComentario(@PathVariable Long id){
        Comentario comentario = comentarioService.findComentario(id);
        if(comentario == null){
            throw new ResourceNotFoundException("Comentario","id",id); 
        }
        comentarioService.deleteComentario(id);
        return new ResponseEntity<>("Comentario borrado exitosamente", HttpStatus.OK);
    }
    
}